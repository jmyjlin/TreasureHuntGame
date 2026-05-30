// imports
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // creates a game board (displays it)
    public static char[][] newGameBoard() {
        // number of rows in board
        int rows = 6;
        // number of columns in board
        int columns = 5;

        // declares a 2D array for the board
        char[][] twoDArray = new char[rows][columns];

        // fills up the board with empty space characters
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                // sets each element to a blank space character
                twoDArray[i][j] = ' ';
            }
        }

        // number of S characters
        int sCount = 3;
        // number of Y characters
        int yCount = 2;
        // number of * characters
        int asterikCount = 1;
        // randomly place these special characters on the board
        while (sCount > 0 || yCount > 0 || asterikCount > 0) {
            // random row index
            int randomRow = (int)(Math.random() * rows);
            // random column index
            int randomColumn = (int)(Math.random() * columns);
            // only put if the element is empty (has a blank space character)
            if (twoDArray[randomRow][randomColumn] == ' ') {
                // place S until we've used the maximum allowed
                if (sCount > 0) {
                    twoDArray[randomRow][randomColumn] = 'S';
                    sCount--;
                    // place Y until we've used the maximum allowed
                } else if (yCount > 0) {
                    twoDArray[randomRow][randomColumn] = 'Y';
                    yCount--;
                    // place * until we've used the maximum allowed
                } else {
                    twoDArray[randomRow][randomColumn] = '*';
                    asterikCount--;
                }
            }
        }

        //        // prints board
        //        // nested while loops
        //        // n = row counter
        //        // k = column counter
        //        int n = 0, k = 0;
        //        // loops through each
        //        while (n != twoDArray.length) {
        //            // loops through each column in row
        //            while (k != twoDArray[n].length) {
        //                // print character (separated by space)
        //                System.out.print(twoDArray[n][k] + " ");
        //                // increment column counter
        //                k++;
        //            }
        //            // reset column counter
        //            k = 0;
        //            // increment row counter
        //            n++;
        //            // blank line (for readability purposes)
        //            System.out.println("");
        //        }

        // returns the randomized 2D array
        return twoDArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        // allows user to play multiple times
        while (playAgain) {
            // vars to describe board size and special characters for text
            int displayRows = 6;
            int displayColumns = 5;
            int sCount = 3;
            int yCount = 2;
            int asterikCount = 1;

            // tell user the board size and special characters
            System.out.println("The game board is " + displayRows + " x " + displayColumns + ".");
            System.out.println("There are " + sCount + " S characters, " + yCount + " Y characters, and " + asterikCount + " asterisk symbol.");

            // readability purposes
            System.out.println();

            // creates new random game board
            char[][] board = newGameBoard();
            // creates a boolean 2D array to track guesses
            boolean[][] guessedBoard = new boolean[displayRows][displayColumns];
            // tracks number of strikes user has (strike = repeated guess)
            int strikes = 0;

            // asks user what character they want to find first
            System.out.print("Character you are looking for (S/Y/*): ");

            // reads first character that user inputs
            char focusedChar = scanner.next().charAt(0);

            // makes sure user enters a valid choice
            boolean isValidFocused = false;
            if (focusedChar == 'S' || focusedChar == 'Y' || focusedChar == '*') {
                // valid focused character
                isValidFocused = true;
            } else {
                // valid focused character
                isValidFocused = false;
            }
            // loops until user enters a valid focused character
            while (!isValidFocused) {
                // tells user to enter a valid choice
                System.out.println("Please enter a valid choice.");
                System.out.println();
                // tells user to enter a choice
                System.out.print("Character you are looking for (S/Y/*): ");
                // choice input
                focusedChar = scanner.next().charAt(0);
                // if the input is S, Y, or *
                if (focusedChar == 'S' || focusedChar == 'Y' || focusedChar == '*') {
                    // valid choice
                    isValidFocused = true;
                } else {
                    // invalid choice
                    isValidFocused = false;
                }
            }

            // checks if focused character is found
            boolean found = false;

            // keeps looping until found or user quits
            while (!found) {
                // tell user to enter a row
                System.out.print("Enter row (0-5): ");
                // row input
                int row = scanner.nextInt();
                // checks if row is valid or not
                boolean isValidRow = false;
                // if row is greater than or equal to 0 AND row is less than or equal to 5
                if (row >= 0 && row <= 5) {
                    // valid row
                    isValidRow = true;
                } else {
                    // invalid row
                    isValidRow = false;
                }
                // loops until a valid row is inputted
                while (!isValidRow) {
                    // tells user to enter a valid row
                    System.out.println("Please enter a valid row between 0 and 5.");
                    System.out.println();
                    // tells user to enter row
                    System.out.print("Enter row (0-5): ");
                    // row input
                    row = scanner.nextInt();

                    // if row is greater than or equal to 0 AND row is less than or equal to 5
                    if (row >= 0 && row <= 5) {
                        // valid row
                        isValidRow = true;
                    } else {
                        // invalid row
                        isValidRow = false;
                    }
                }
                // tell user to enter a column
                System.out.print("Enter column (0-4): ");

                // column input
                int column = scanner.nextInt();

                // checks if column is valid or not
                boolean isValidColumn = false;

                // if row is greater than or equal to 0 AND row is less than or equal to 4
                if (column >= 0 && column <= 4) {
                    // valid column
                    isValidColumn = true;
                } else {
                    // invalid column
                    isValidColumn = false;
                }
                // loops until a valid column is inputted
                while (!isValidColumn) {
                    // tells user to enter a valid column
                    System.out.println("Please enter a valid column between 0 and 4.");
                    System.out.println();
                    // tells user to enter a column
                    System.out.print("Enter column (0-4): ");
                    // column input
                    column = scanner.nextInt();

                    // if row is greater than or equal to 0 AND row is less than or equal to 4
                    if (column >= 0 && column <= 4) {
                        // valid column
                        isValidColumn = true;
                    } else {
                        // invalid column
                        isValidColumn = false;
                    }
                }

                // checks if user already guessed this position
                if (guessedBoard[row][column]) {
                    // increase strike count
                    strikes++;
                    // tells user they already guessed at this position
                    System.out.println("You already guessed that location.");
                    // shows them their amount of strikes at the moment
                    System.out.println("Strikes: " + strikes + "/3");

                    // if user hits 3 strikes
                    if (strikes == 3) {
                        // game over
                        // display game over message
                        System.out.println("You have 3 strikes.");
                        // breaks out of loop
                        break;
                    }

                    // lets user quit the game if focused character not found yet
                    if (!found) {
                        // display quit message
                        System.out.print("Press q to quit or any other key to continue: ");
                        // quit option input
                        String quit = scanner.next();

                        // if user inputs q (can be upper/lowercase (case doesn't matter))
                        if (quit.equalsIgnoreCase("q")) {
                            // exits the loop (game over)
                            break;
                        }
                    }

                    // continues through loop
                    continue;
                }

                // marks this position as guessed
                guessedBoard[row][column] = true;

                // gets character at the position
                char position = board[row][column];

                // checks if guessed position is the same as the focused character
                // if the position does have the focused character
                if (position == focusedChar) {
                    // display correct message
                    System.out.println("Correct! You've found the character.");
                    // sets found to true
                    found = true;
                    // otherwise if the position doesn't have focused character
                    // and doesn't have any special character
                } else if (position == ' ') {
                    // display wrong (but has special char) message
                    System.out.println("Wrong! No special character here.");
                    // otherwise if the position doesn't have the focused character
                    // but has another special character
                } else {
                    // display wrong (no special char) message
                    System.out.println("Wrong! You've found " + position + ".");
                }

                // lets user quit the game if focused character not found yet
                if (!found) {
                    // display quit message
                    System.out.print("Press q to quit or any other key to continue: ");
                    // quit option input
                    String quit = scanner.next();

                    // if user inputs q (can be upper/lowercase (case doesn't matter))
                    if (quit.equalsIgnoreCase("q")) {
                        // exits the loop (game over)
                        break;
                    }
                }
            }
            // readability
            System.out.println();
            // display game over message
            System.out.println("Game Over!");

            // display play again message
            System.out.print("Would you like to play again? (Y/N): ");
            // play again option input
            String playAgainAnswer = scanner.next();

            // if user inputs y (can be upper/lowercase (case doesn't matter))
            if (playAgainAnswer.equalsIgnoreCase("Y")) {
                // play again
                playAgain = true;
            } else {
                // don't play again (exit program)
                playAgain = false;
            }
        }
    }
}
