package com.pranav.number_guessing_game;

import org.springframework.stereotype.Service;

@Service
public class CliService {

    private int difficulty;
    private int answer;

    public CliService() {
        System.out.println(
            """
            Welcome to the Number Guessing Game!
            I'm thinking of a number between 1 and 100.
            """
        );
    }

    public boolean handleDifficulty(int difficulty) {
        if (difficulty > 3 || difficulty < 1) {
            System.out.println("Please enter a valid difficulty level");
            return false;
        }
        this.difficulty = difficulty;
        return true;
    }

    public void randomNumGen() {
        answer = (int) (Math.random() * 100) + 1;
    }

    public String checkAttempt(
        int attemptedAnswer,
        int remainingAttempts,
        int totalAttempts
    ) {
        String response = "";
        if (attemptedAnswer == answer) response =
            "Congratulations! You guessed the correct number in " +
            (totalAttempts - remainingAttempts + 1) +
            " attempts.";
        else if (attemptedAnswer > answer) {
            response = "Incorrect! The number is less than " + attemptedAnswer;
        } else {
            response =
                "Incorrect! The number is greater than " + attemptedAnswer;
        }
        if (!response.contains("Congratulations") && remainingAttempts == 1) {
            response =
                "Ahh, you've exhausted all your chances. The correct guess is: " +
                answer;
        }
        return response;
    }

    public int getTotalAttempts() {
        if (difficulty == 3) return 3;
        else if (difficulty == 2) return 5;
        else return 10;
    }

    public boolean isContinuePlaying(String response) {
        return response.equalsIgnoreCase("yes");
    }
}
