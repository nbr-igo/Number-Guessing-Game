import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class numberGuessing {
    private final Scanner scanner; // Scanner used to read user input from the console
    private final Random random; // Random used to generate computer's number

    public numberGuessing() {
        this.scanner = new Scanner(System.in); // Setup scanner for console input
        this.random = new Random(); // Setup random generator for the game
    }

    private void wannaPlay() { //Method: Asking Player if they want to Play 
        System.out.println("Would you like to Play: Number Guessing? {YES-NO}");//Asking for User Input
        String playAgain =scanner.nextLine().toUpperCase();//Store user input in Uppercase format

        while(!playAgain.equals("YES") && !playAgain.equals("NO")){//Validate Inputs
            System.out.println("Please enter a valid response {YES-NO}");
            playAgain =scanner.nextLine().toUpperCase();
        }

        if(playAgain.equals("YES")) {//Start game on "Yes"
            startGame();
        } else {
            System.out.println("Program Terminated");//Program End
        }
    }

    private void startGame(){//Game start
        System.out.println("Insert the minimum range");//Minimum range
        int minimum = numberGuarantee();// Validating input for minimum is a number
        System.out.println("Insert the maximum range");//Maximum range
        int maximum = numberGuarantee();//Validating input for maximum is a number

        int[] computerOptions = IntStream.rangeClosed(minimum,maximum).toArray();//Creating array within the ranges specified
        int computerNumber = computerOptions[(random.nextInt(computerOptions.length))];

        System.out.println("The computer has guess a number from " + minimum + " to " + maximum);
        System.out.println("Guess the number:");

        int playerNumber = numberGuarantee();//Validating User input is a number
        
        while (playerNumber != computerNumber){
            compareNumber(playerNumber,computerNumber);//Comparing computer and users number
            playerNumber = numberGuarantee();//Validating Next User Input
        }

        if(playerNumber == computerNumber){//Number guessed correctly
            System.out.println("Great Guess you have guessed the computers number");
        }
        anotherRound();
    }

    private int numberGuarantee(){//Mehtod: Making sure inputs are numbers 
            while (!scanner.hasNextInt()) {//Was the given input a number??
            scanner.nextLine(); // Discard the invalid input
            System.out.println("Please enter a number: ");//Asking for Valid Input
        }
        int itsANumber = scanner.nextInt();//Valid input assigned to itsANumber
        scanner.nextLine();//Cleaning buffer
        return itsANumber;//Returning Valid input
    }

    private void compareNumber(int playerNumber, int computerNumber){//Comparing User Input(Number) to Computer Guess(Number)
        if(playerNumber < computerNumber){
            System.out.println("higher");
        }
        else {
            System.out.println("lower");
        }
    }

    private void anotherRound(){//Method: To Play Again

        System.out.println("\nWould you like to play Again? {YES-NO}");
        String playAgain = scanner.nextLine().toUpperCase();

        while(!playAgain.equals("YES") && !playAgain.equals("NO")){//Validate inputs
                System.out.println("Please enter a valid response {YES-NO}");
                playAgain =scanner.nextLine().toUpperCase();
            }

            if(playAgain.equals("YES")){//Restart Game if Input is Yes
                startGame();
            } else {
                System.out.println("Thanks for Playing, See You Next Time");//Program End
            }
    }    

     public static void main(String[] args) throws Exception { //Start of Game
        numberGuessing game = new numberGuessing();
        game.wannaPlay(); //Call method: Asking user If they want to play
    }
}
