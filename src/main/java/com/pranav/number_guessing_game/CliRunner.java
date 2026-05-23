package com.pranav.number_guessing_game;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliRunner implements CommandLineRunner {

    private final CliService cliService;

    public CliRunner(CliService cliService) {
        this.cliService = cliService;
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);

        showDifficultyMenu();

        while (true) {
            int difficulty = sc.nextInt();
            if (!cliService.handleDifficulty(difficulty)) continue;

            cliService.randomNumGen();

            int totalAttempts = cliService.getTotalAttempts();
            System.out.println(
                "You have " + totalAttempts + " chances to guess the number."
            );

            int attempts = totalAttempts;
            while (attempts > 0) {
                int guess = sc.nextInt();

                String response = cliService.checkAttempt(
                    guess,
                    attempts,
                    totalAttempts
                );

                System.out.println(response);

                if (
                    response.contains("Congratulations") ||
                    response.contains("Ahh")
                ) break;

                attempts--;
            }

            System.out.println("Play again? (yes/no)");
            String userInput = sc.next();

            if (!cliService.isContinuePlaying(userInput)) {
                break;
            }

            showDifficultyMenu();
        }

        sc.close();
    }

    private void showDifficultyMenu() {
        System.out.println(
            """
            Please select the difficulty level:
            1. Easy (10 chances)
            2. Medium (5 chances)
            3. Hard (3 chances)
            """
        );
    }
}
