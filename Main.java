import java.util.Random;
import java.util.Scanner;

class Player {
    // Class for Player Info
    Scanner input = new Scanner(System.in);
    String name;

    void playerInfo(int playerNumber) {
        System.out.println("Enter the name of player " + playerNumber);
        name = input.next();

    }

}

class Umpire {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    int generatedRandomNumber;
    int playerGuess;
    int numberOfWinners = 0;

    void generateRandomNumber() {
        // Everytime the game will Generate a random number to be fare in the game
        generatedRandomNumber = rand.nextInt(11);

    }

    int numberGussedByPlayer() {
        playerGuess = input.nextInt();
        if (playerGuess <= 10 && playerGuess >= 0) {
            return 0;
        } else {
            System.out.println("Please re-enter the number in range 0-11");
            numberGussedByPlayer();
        }
        return 0;
    }

    String compare() {
        if (generatedRandomNumber == playerGuess) {
            numberOfWinners++;
            return "Youuu winn!!! Hurrayyyyy!!!";
        } else if (playerGuess < generatedRandomNumber) {
            return "your guess was on the lower side!";
        } else {
            return "your guess was on the higher side!";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Umpire class with compare function
        Umpire umpire = new Umpire();

        // Displaying the message
        System.out.println("Enter the number of players up for the challenge");

        // Taking number of player to make the game dynamic
        int TotalNumOfPlayers = input.nextInt();

        // Creating a player and checking for the condition
        for (int playerNumber = 1; playerNumber <= TotalNumOfPlayers; playerNumber++) {
            // Generating a random number everytime for seperate player and storing it in umpire class
            umpire.generateRandomNumber();

            // Making a player and getting the information from the player
            Player player = new Player();
            player.playerInfo(playerNumber);

            // Calling the umpire to listen to the number guessed by the player
            System.out.println("Please enter your guess in range of 0-11");
            umpire.numberGussedByPlayer();

            // Asking umpire to check if the number is correct
            String umpireAnswer = umpire.compare();

            // Printing out the results of individual players
            System.out.println();
            System.out.println("The guessed number was " + umpire.playerGuess);
            System.out.println("The Number generated was " + umpire.generatedRandomNumber);
            System.out.println();
            System.out.println(player.name + " " + umpireAnswer);
            System.out.println();
            if (!(playerNumber == TotalNumOfPlayers)) {
                System.out.println("Generating another random number for player number " +  (playerNumber + 1));
            } else {
                System.out.println("Thanks for playing! " + TotalNumOfPlayers + " Players Played today's game and " + umpire.numberOfWinners + " Won today's game");
                System.out.println();
                System.out.println("See you back soon!!!");
            }

        }
    }
}