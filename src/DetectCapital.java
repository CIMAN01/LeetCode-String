/*

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.


Example 1:

Input: "USA"
Output: True


Example 2:

Input: "FlaG"
Output: False


Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.


*/

// main class
public class DetectCapital {

    // a method that the checks if a string uses capitals in the proper way
    public static boolean detectCapitalUse(String word) {
        // if string is empty, return false
        if (word.length() == 0) {
            return false;
        }
        // create a boolean variable for the first letter in the string, initialize to false
        boolean isFirstLetterCapital = false;
        // create a count variable for each casing
        int lowerCases = 0;
        int upperCases = 0;
        // traverse the string
        for (int i = 0; i < word.length(); i++) {
            // if the first character in the string is capital
            if (Character.isUpperCase(word.charAt(i)) && i == 0) {
                // update boolean condition to true
                isFirstLetterCapital = true;
                // increment count for upper cases
                upperCases++;
            }
            // if the current character is lower case
            else if (Character.isLowerCase(word.charAt(i))) {
                // increment count for lower cases
                lowerCases++;
            }
            // if the current character is upper case
            else if (Character.isUpperCase(word.charAt(i))) {
                // increment count for upper cases
                upperCases++;
            }
        }
        // if first letter is capital and the rest are lower cases, return true
        if (isFirstLetterCapital && lowerCases == word.length()-1) { // word.length()-1 because first letter is already included
            return true;
        }
        // if all the letters are lower cases, return true
        else if (lowerCases == word.length()) {
            return true;
        }
        // if all letters are upper cases return true, return false otherwise
        else {
            return upperCases == word.length();
        }
    }


    // a method that the checks if a string uses capitals in the proper way
    public boolean detectCapitalUse2(String word) {
        // assign the length of word to variable len
        int len = word.length();
        // if length is equal to one, return true
        if (len == 1) {
            return true;
        }
        // case 1: if all letters are capital - make sure first two indexes contain capital letters
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            // traverse the word
            for (int i = 2; i < len; i++) {
                // is lowercase is found at i-th index, return false
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        // the other two cases
        else {
            // traverse the word
            for (int i = 1; i < len; i++) {
                // if any uppercase letters found at i-th index, return false
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        // if we pass one of the cases, true is returned
        return true;
    }


    // a method that the checks if a string uses capitals in the proper way (short/regex version)
    public static boolean detectCapitalUse3(String word) {
        // if string is empty, return false
        if (word == null) {
            return false;
        }
        // search the string for matching criteria using regex, return true if criteria is met
        return word.matches("[A-Z]*|.[a-z]*");
        // '*' means 0 or more of whatever precedes it
        // '|' means "or"
        // '.' matches any character
    }


    // main method
    public static void main(String[] args) {
        System.out.println();
        // create a string
        String str1 = "USA"; // "USA"
        // print the string
        System.out.println("original string: " + str1);
        // invoke the method and print the result
        System.out.println("correct use of Capital letters? " + detectCapitalUse(str1)); // true
        System.out.println();
        // create a string
        String str2 = "FlaG"; // "FlaG"
        // print the string
        System.out.println("original string: " + str2);
        // invoke the method and print the result
        System.out.println("correct use of Capital letters? " + detectCapitalUse(str2)); // false
        System.out.println();
    }

}
