# Guess-the-Number-Game
An interactive console-based Java "Guess the Number" game featuring custom input validation, dynamic score calculation based on binary search efficiency, multiple-round sessions, and achievement tracking.
# DecodeLabs Guess the Number Game (Java)

An interactive, robust, and mathematically scored **Guess the Number** game built in Java. The game challenges players to find a randomly generated secret number within a specific range, utilizing a dynamic scoring algorithm that rewards strategic guessing (like Binary Search).

## 🚀 Features

* **Dynamic Scoring Algorithm:** Score calculation is optimized around the theoretical limit of Binary Search (7 attempts for a 1-100 range). Guessing within 7 attempts awards maximum points, with logical deductions for subsequent tries.
* **Session & Round Management:** Play up to 5 rounds per session with full tracking of totals and averages.
* **Robust Input Validation:** Prevents crashes from invalid inputs (e.g., entering letters) and guides the user to remain within the 1-100 range using strict exception handling.
* **Achievement System:** Rates the player's overall performance at the end of the tournament (e.g., *Outstanding Performance*, *Great Job*, *Well Done*) based on their final average score.
* **Clean Terminal UI:** Structured visual banners, round headers, and a clear scoreboard display.

## 📊 Game Parameters

* **Number Range:** 1 to 100
* **Max Attempts per Round:** 10
* **Max Rounds per Session:** 5
* **Target Efficiency:** $\le 7$ guesses for a perfect score (100 points).

## 🛠️ How It Works

The game engine utilizes Java's `Random` class to generate secret integers and manages the game flow through structured helper methods:
* **`getValidatedInput()`**: Uses a `try-catch` block to handle `InputMismatchException` and out-of-range numbers cleanly.
* **`calculateScore()`**: Applies conditional scoring tiers depending on the number of attempts used.
* **`displayFinalScore()`**: Computes the average score and evaluates final milestone achievements.

## 🎮 How to Run

1. Make sure you have **JDK 8 or higher** installed.
2. Compile the file:
   ```bash
   javac DecodeLabs_Java_P1.java
   
