/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2juegos;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author alumneM
 */
public class test {
    
    /**
 * Validates the User's Row and Column values input. This method checks to
 * ensure only numerical characters were entered. It also ensures the the
 * numerical value entered is between and or equal to the supplied minValue
 * and maxValue.
 *
 * @param minVal      (Integer) The minium Allowable integer value to be
 *                    entered.
 * @param maxVal      (Integer) The maximum allowable integer value to be
 *                    entered.
 * @param inputString (String) String representation of the integer value
 *                    supplied.
 *
 * @return (Boolean) True if the entry is valid and false if it is not.
 */
private static boolean validateUserRowColInput(int minVal, int maxVal, String inputString) {
    String LS = System.lineSeparator();
    if (inputString.equals("")) {
        System.out.println("Invalid Entry! You must supply a numerical "
                + "value from " + minVal + " to " + maxVal + ".");
        return false;
    }
    if (inputString.equalsIgnoreCase("q") || inputString.equalsIgnoreCase("quit")) {
        System.out.println("We hope you had fun. Bye Bye");
        System.exit(0);
    }
    if (!inputString.matches("\\d+")) {
        System.out.println("Invalid input supplied (" + inputString + ")! "
                + "You can not supply alpha characters, only" + LS 
                + "numerical values are allowed!. Please try again...");
        return false;
    }
    int num = Integer.parseInt(inputString);
    if (num < minVal || num > maxVal) {
        System.out.println("Invalid input supplied (" + inputString + ")! "
                + "The numerical value you supply can not be" + LS + "less "
                + "than " + minVal + " and no greater than " + maxVal + ". "
                + "Please try again...");
        return false;
    }
    return true;
}
    
    
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);      // Declare Scanner (here for sake of this demo)
        String LS = System.lineSeparator();         // System line Separator. 
        boolean play = true;                        // Play flag
        int size = 8;                               // 8 is used for sake of this demo
        String range = "(0 to " + (size - 1) + ")"; // Range so we don't have to keep typing it.
        String[] rowCol;                            // Array to hold Row and Column string numerical values
        String border1 = String.join("", Collections.nCopies(72, "-")); // Text Border 1 (-)
        String border2 = String.join("", Collections.nCopies(42, "=")); // Text Border 2 (=)

while (play) {
    String input = "";  // Input from scanner goes in this variable
    rowCol = new String[4]; // Initialize Array
    // Declare & init int variables to hold input integer values (if desired)
    // Un-comment the below line if you want this...
    // int row_1 = -1, col_1 = -1, row_2 = -1, col_2 = -1; 

    // Inform of what is required...
    System.out.println(border1);
    System.out.println("Please enter the numerical values for FIRST and "
            + "SECOND Rows and Columns." + LS + "Follow the provided prompts. "
            + "You can Enter 'q' or 'quit' at any time to" + LS + "end the game.");
    System.out.println(border1);

    // Get Input from User
    for (int i = 0; i < rowCol.length; i++) {
        // Set up current prompt...
        String prompt = LS;
        switch (i) {
            case 0:
                prompt += "Enter First Row Value " + range + ": ";
                break;
            case 1:
                prompt += "Enter First Column Value " + range + ": ";
                break;
            case 2:
                prompt += "Enter Secomd Row Value " + range + ": ";
                break;
            case 3:
                prompt += "Enter Second Column Value " + range + ": ";
                break;
        }

        input = "";     // Clear input variable
        // Get the actual input from User and validate.
        while (input.equals("")) {
            System.out.print(prompt);       // Display prompt
            input = scan.nextLine();        // Get keyboard input from User

            // Validate input...
            if (!validateUserRowColInput(0, (size - 1), input)) {
                input = ""; // Input was invalid so clear input variable
                continue;   // Re-prompt the User for proper input
            }
            rowCol[i] = input;  // All is good so add input to Array element at index i.
        }
    }

    // Display what was provided.
    System.out.println(border2);
    System.out.println("Row 1/Column 1  = " + rowCol[0] + "/" + rowCol[1] + LS
            + "Row 2/Column 2  = " + rowCol[2] + "/" + rowCol[3]);
    System.out.println(border2 + LS);
}
    }
    
}
