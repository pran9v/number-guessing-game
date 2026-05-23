# Number Guessing Game

A command-line number guessing game built with Java and Spring Boot. The app picks a random number between 1 and 100 and challenges you to guess it within a limited number of attempts.

## Features

- **Three difficulty levels** – Easy, Medium, and Hard, each with a different number of attempts
- **Higher/lower hints** – after every wrong guess, the game tells you whether the answer is higher or lower
- **Attempt tracking** – your number of remaining chances is shown at the start of each round
- **Replay support** – after each round, choose to play again or exit

## Prerequisites

- Java 17+
- Maven (or use the included `mvnw` wrapper)

## Getting Started

### Clone the repository

```bash
git clone https://github.com/pran9v/number-guessing-game.git
cd number-guessing-game
```

### Run in development mode

```bash
./mvnw spring-boot:run
```

### Build the application

```bash
./mvnw clean package
```

### Run the packaged application

```bash
java -jar target/number-guessing-game-0.0.1-SNAPSHOT.jar
```

## Sample Output

```text
Welcome to the Number Guessing Game!
I'm thinking of a number between 1 and 100.

Please select the difficulty level:
1. Easy (10 chances)
2. Medium (5 chances)
3. Hard (3 chances)

1
You have 10 chances to guess the number.
50
Incorrect! The number is greater than 50
75
Incorrect! The number is less than 75
63
Congratulations! You guessed the correct number in 3 attempts.

Play again? (yes/no)
```

## Tech Stack

- **Java 17**
- **Spring Boot 3.5**

## How It Works

1. On startup, the app prompts you to select a difficulty level.
2. A random number between 1 and 100 is generated.
3. You enter guesses one at a time; the game responds with a hint after each wrong guess.
4. The round ends when you guess correctly or exhaust all your attempts.
5. You can then choose to start a new round or quit.

## Project Structure

```
src/
└── main/java/com/pranav/number_guessing_game/
    ├── NumberGuessingGameApplication.java  # Spring Boot entry point
    ├── CliRunner.java                      # Handles the game loop and user input
    └── CliService.java                     # Core game logic (difficulty, guesses, scoring)
```

## Inspiration

This project was built as a hands-on exercise from the [roadmap.sh backend projects](https://roadmap.sh/projects/number-guessing-game).
