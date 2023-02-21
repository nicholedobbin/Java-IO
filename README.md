# **Java Text I_O.**

## **IFS L2T04 - External Data Sources — Files**

## **Description**
This is a Java program that demonstrates input-output functionality by reading a text file, performing various 
operations on the text found, and outputting the result of these operations in a new text file.

The [Poetry.java](src/Poetry.java) program takes the [poem.txt](src/poem.txt) file as input and does the following:
1. Encodes the 'poem.txt' file using a Caesar cipher (see applyCaesarCypher method), and outputs the encoded poem to 
a file called 'encodedPoem.txt'. 
2. Modifies the encoded poem so that every vowel is changed to a capital letter, and outputs the modified poem to a file
called 'capitalVowels.txt'.
3. Modifies the encoded 'capitalVowels.txt' poem so that each line of the poem is reversed, then decodes the Caesar
cipher (ensuring capital vowels go back to their original letters) to reveal the original poem, and save the reversed, 
decoded poem to a file called 'reversedPoem.txt'.

<hr>

## **Installation, Setup and Usage**
1. Clone the repo and open with your preferred IDE 
(e.g. [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=mac)).
2. Open the [Poetry.java](src/Poetry.java) file in the IDE and click on 'Run'.

## **Credits**
Made by [Nichole Dobbin](https://github.com/nicholedobbin), for my [HyperionDev](https://www.hyperiondev.com/) 
course.

## **References**
Iterating and reversing strings in Java:
*   https://www.geeksforgeeks.org/reverse-a-string-in-java/
*   https://codippa.com/java-iterate-string-characters/

Replacing characters in string:
*   https://www.javatpoint.com/java-string-replaceall
*   https://www.geeksforgeeks.org/java-program-to-replace-all-line-breaks-from-strings/
