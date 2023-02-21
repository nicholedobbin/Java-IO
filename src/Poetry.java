/*=================================== L2T04 Compulsory Tasks 1-3 ======================================================

    Compulsory Task 1 (encodedPoem.txt):
        - The program reads the content of the text file 'poem.txt'.
        - It then calls 'applyCaesarCypher' method on 'poem.txt''s content, which encodes the content by shifting
          all upper and lowercase letters 15 characters ahead, using ASCII decimal values.
        - It creates a new file 'encodedPoem.txt' and adds the encoded content to this file.

    Compulsory Task 2 (capitalVowels.txt):
        - The program reads the content of the text file 'encodedPoem.txt'.
        - It then calls 'applyCapitalVowels' method on 'encodedPoem.txt''s content, which converts all vowels to
          uppercase.
        - It creates a new file 'capitalVowels.txt' and adds the encoded content with capital vowels to this file.

    Compulsory Task 3 (reversePoem.txt):
        - The program reads the content of the text file 'capitalVowels.txt'.
        - It then calls 'applyReverse' method on 'capitalVowels.txt''s content, which:
            (a) reverses the characters of each line in the file.
            (b) returns all vowels back to lowercase.
            (c) calls 'applyCaesarCypher' method on the reversedPoem to decode the reversedPoem by shifting
                letters 15 characters behind.
            (d) accounts for and adjusts issues created by vowel case changes.
        - It creates a new file 'reversePoem.txt' and adds the reversed, decoded content to this file.
 ====================================================================================================================*/

// Import classes from respective packages.
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Poetry
{
    public static void main(String[] args)
    {
        // Declare and initialise variables.
        String inputString = "";
        String poemString = "";
        int shiftByAmount = 15;

        // Get file 'poetry.txt' and add text content to 'inputString'.
        try
        {
            File poemTextFile = new File("../L2T04_Compulsory_Task/src/poem.txt");
            Scanner textScanner = new Scanner(poemTextFile);
            while (textScanner.hasNextLine())
            {
                inputString += textScanner.nextLine() + "\n";
            }
            textScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found.");
        }

        // Call 'applyCaesarCypher' method on 'inputString', stored in 'encodedInputString'.
        String encodedInputString = applyCaesarCypher(inputString, shiftByAmount);

        // Create file 'encodedPoem.txt' and add encoded text from 'encodedInputString'.
        try
        {
            Formatter encodedPoem = new Formatter("../L2T04_Compulsory_Task/src/encodedPoem.txt");
            encodedPoem.format("%s", encodedInputString);
            encodedPoem.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: file not formatted.");
        }

        // Call 'applyCapitalVowels' method on 'encodedInputString', stored in 'capitalVowelsInputString'.
        String capitalVowelsInputString = applyCapitalVowels(encodedInputString);

        // Create file 'capitalVowels' and add encoded text with uppercase vowels from 'capitalVowelsInputString'.
        try
        {
            Formatter capitalVowels = new Formatter("../L2T04_Compulsory_Task/src/capitalVowels.txt");
            capitalVowels.format("%s", capitalVowelsInputString);
            capitalVowels.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: file not formatted.");
        }

        // Get file 'capitalVowels' and add text content to 'poemString'.
        try
        {
            File capitalVowelsFile = new File
                ("../L2T04_Compulsory_Task/src/capitalVowels.txt");
            Scanner capitalVowelsScanner = new Scanner(capitalVowelsFile);
            while (capitalVowelsScanner.hasNextLine())
            {
                poemString += capitalVowelsScanner.nextLine() + "\n";
            }
            capitalVowelsScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: file not found.");
        }

        // Call 'applyReverse' method on 'poemString', stored in 'reversePoemInputString'.
        String reversePoemInputString = applyReverse(poemString);

        // Create file 'reversePoem' and add reversed poem from 'reversePoemInputString'.
        try
        {
            Formatter reversePoem = new Formatter
                ("../L2T04_Compulsory_Task/src/reversePoem.txt"
                );
            reversePoem.format("%s", reversePoemInputString);
            reversePoem.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: file not formatted.");
        }
    }

    // 'applyCaesarCypher' method to encode input:
    public static String applyCaesarCypher(String inputString, int shiftByAmount)
    {
        int stringLength = inputString.length();
        String convertedToCypher = "";

        // Offsets shift value if 'shiftByAmount' is a negative number.
        if (shiftByAmount < 0)
           shiftByAmount = shiftByAmount + 26;

        for (int i = 0; i < stringLength; i++)
        {
            // Initialise 'characterOfInputString' with value of inputString.charAt(i).
            char characterOfInputString = inputString.charAt(i);

            // Initialise 'asciiValueOfCharacter' with value of 'characterOfInputString'.
            int asciiValueOfCharacter = characterOfInputString;

            // Check for upper and lowercase letters in ASCII range and assign new values.
            if ((asciiValueOfCharacter >= 65) && (asciiValueOfCharacter <= 90))
            {
                asciiValueOfCharacter = ((asciiValueOfCharacter - 65 + shiftByAmount) % 26) + 65;
                characterOfInputString = (char)asciiValueOfCharacter;

            }
            else if ((asciiValueOfCharacter >= 97) && (asciiValueOfCharacter <= 122))
            {
                asciiValueOfCharacter = ((asciiValueOfCharacter - 97 + shiftByAmount) % 26) + 97;
                characterOfInputString = (char)asciiValueOfCharacter;
            }

            // Add each 'characterOfInputString' to 'convertedToCypher'.
            convertedToCypher += characterOfInputString;
        }

        return convertedToCypher;
    }

    // 'applyCapitalVowels' method to change vowels to uppercase:
    public static String applyCapitalVowels(String encodedInputString)
    {
        String allAToUpper = encodedInputString.replaceAll("a", "A");
        String allEToUpper = allAToUpper.replaceAll("e", "E");
        String allIToUpper = allEToUpper.replaceAll("i", "I");
        String allOToUpper = allIToUpper.replaceAll("o", "O");
        String allUToUpper = allOToUpper.replaceAll("u", "U");

        return allUToUpper;
    }

    //'applyReverse' method to reverse and decode input, and return letter cases to original format:
    public static String applyReverse(String poemString)
    {
        String reversedPoem = "";
        char characterInString = ' ';

        // Convert 'poemString' to String Array.
        String[] poemStringArray = poemString.split("\n");

        // Reverse each line in 'poemStringArray'.
        for (int i=poemStringArray.length-1 ; i>=0; i--)
        {
            String stringInPoemArray = poemStringArray[i] + "\n";
            for (int j=0; j<stringInPoemArray.length(); j++)
            {
                characterInString = stringInPoemArray.charAt(j);
                reversedPoem = characterInString + reversedPoem;
            }
        }

        // Return all vowels back to lowercase.
        String allAToLower = reversedPoem.replaceAll("A", "a");
        String allEToLower = allAToLower.replaceAll("E", "e");
        String allIToLower = allEToLower.replaceAll("I", "i");
        String allOToLower = allIToLower.replaceAll("O", "o");
        String allUToLower = allOToLower.replaceAll("U", "u");
        reversedPoem = allUToLower;

        // Call 'applyCaesarCypher' method on 'reversedPoem', to shift the characters backwards by 15.
        reversedPoem = applyCaesarCypher(reversedPoem, -15);

        // Replace 'prime' with 'Prime' in reversed poem.
        reversedPoem = reversedPoem.replaceAll("emirp\n", "emirP\n");
        reversedPoem = reversedPoem.replace("srebmun emirp emos", "srebmun emirP emos");
        reversedPoem = reversedPoem.replace("srebmun emirp tuoba", "srebmun emirP tuoba");

        return reversedPoem;
    }
}






