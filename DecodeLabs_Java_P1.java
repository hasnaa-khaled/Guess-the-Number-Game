import java.util.Random;
import java.util.Scanner;
import java.util.*;
public class DecodeLabs_Java_P1{
    private static final int MIN_Range =1;
    private static final int MAX_Range =100;
    private static final int MAX_Attempts = 10;
    private static final int Max_Rounds = 5;


    private int totalScore;
    private int roundPlayed;
    private final Random rand = new Random();
    private final Scanner scan = new Scanner(System.in);


    public DecodeLabs_Java_P1() {
        this.totalScore = 0;
        this.roundPlayed = 0;
    }
    public static void main(String[]args){
        displayWelcomeBanner();
        DecodeLabs_Java_P1 game = new DecodeLabs_Java_P1();
        game.start();
        displayFarewellMessage();
    }
    public void start() {
        boolean playAgain;
        do {
            playRound();
            roundPlayed++;
            playAgain = askToPlayAgain();
        }while (playAgain && roundPlayed < Max_Rounds);
        displayFinalScore();
        scan.close();
    }



    public void playRound() {
        int secretNo = generateRandomNumber();
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        System.out.println("=================================");
        System.out.printf("Round %d Starts %n", roundPlayed + 1);
        System.out.printf("Guess the Number between %d and %d%n" , MIN_Range , MAX_Range);
        System.out.printf("You have %d attempts maximum%n" , MAX_Attempts);
        System.out.println("==================================");

        while(!hasGuessedCorrectly && attempts < MAX_Attempts) {
            int remainingAttempts = MAX_Attempts - attempts;
            System.out.printf("\n Attempts left: %d | Enter your guess: ", remainingAttempts);
            int userGuess = getValidatedInput();
            attempts++;
            if(userGuess == secretNo){
                handleCorrectly(attempts);
                hasGuessedCorrectly = true;}
            else if(userGuess < secretNo){
                System.out.println("It is too low!!!!");
            }else{
                System.out.println("It is too high!!!!");
            }
            }
        if (!hasGuessedCorrectly) {
            handleFailedRound(secretNo);
        }
    }
private  int generateRandomNumber(){
        int randomNumber = rand.nextInt(MAX_Range - MIN_Range+1) + MIN_Range;
        return randomNumber;
}
private  int getValidatedInput() {
        while(true) {
            try {
                int input = scan.nextInt();
                if(input < MIN_Range || input > MAX_Range ) {
                    System.out.printf("Please enter a number between %d and %d:", MIN_Range , MAX_Range);
                    continue;
                }
                return input;
            }catch(InputMismatchException e){
                System.out.println("Invalid Input ! Please enter a number between %d and %d");
                scan.next();
            }
}
    }
    private void handleCorrectly(int attempts) {
        int roundScore = calculateScore(attempts);
        totalScore += roundScore;
        System.out.println("Congratulations!");
        System.out.printf("You guessed correctly is %d attempt(s) !%n", attempts);
        System.out.printf("Round Score: %d points%n", roundScore);
        System.out.printf("Total Score: %d points%n", totalScore);

    }
    private void handleFailedRound(int secretNo) {
        System.out.println("Round Failed ! ");
        System.out.printf("You have used all attempts %n", MAX_Attempts);
        System.out.printf("Secret No: %d%n", secretNo);
        System.out.println("Good Luck Next Round!");

    }
    private int calculateScore(int attempts) {
        int optimalAttempts = 7;
        if(attempts <= optimalAttempts) {
            return 100;
        }else if(attempts <= MAX_Attempts) {
            return 100 - ((attempts - optimalAttempts) * 10);
        }
        return 0;
        }
        private boolean askToPlayAgain() {
        if (roundPlayed >= Max_Rounds) {
            System.out.println("You have reached the maximum number of attempts");
            return false;
        }
        System.out.println("Do you want to play again? (Yes or N0): ");
        String response = scan.next().toLowerCase();
        return response.equals("yes") || response.equals("y");
        }
        private void displayFinalScore() {
            System.out.println("Game Final Score :");
            System.out.println("==============================");
            System.out.printf("Round Played : %d%n", roundPlayed);
            System.out.printf("Total Score : %d%n", totalScore);
            if (roundPlayed >0 ) {
                double avgScore = (double) totalScore / roundPlayed;
                System.out.printf("Average Score per Round: %.2f%n", avgScore);
            }

            System.out.println("Achivements:");
            if(totalScore >= 400) {
                System.out.println("OutStanding Performance!");
            }else if(totalScore >= 300) {
                System.out.println("Great Job!");
            }else if(totalScore >= 200) {
                System.out.println("Well Done!");
            }else if(totalScore > 0) {
                System.out.println("Keep Practicing!");
            }
            System.out.println();
        }

        private static void displayWelcomeBanner() {
            System.out.println("===============================");
            System.out.println("  Welcome to D Labs Java P1! ");
            System.out.println("Instructions are:");
            System.out.println("• Guess the secret number between 1 and 100");
            System.out.println("• You'll get feedback if your guess is HIGH or Low");
            System.out.println("   •Maximum " + MAX_Attempts+ " attempts per round");
            System.out.println("   • Maximum " + Max_Rounds + " rounds per session");
            System.out.println("   • Score more points with fewer guesses!");
            System.out.println("   • Optimal binary search solves in ~7 guesses");
            System.out.println("===============================");

        }

    private static  void displayFarewellMessage() {
        System.out.println("Thank you for playing this game!");

    }
    }
