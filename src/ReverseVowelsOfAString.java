/*

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"

Example 2:

Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".

*/


// main class
public class ReverseVowelsOfAString {

    // a separate boolean method that check if a character is a vowel
    public static boolean IsVowel (char ch) {
        // change input character to lower-case
        ch = Character.toLowerCase(ch);
        // return true if the argument passed in matches any of the vowels
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }


    // a method that takes a string as input and reverses only the vowels
    public static String reverseVowels(String s) {
        // handling base case of an empty string
        if (s == null || s.length() == 0) {
            return s;
        }
        // convert string to an array of characters and store it in a new variable
        char[] ch = s.toCharArray();
        // create two pointers
        int left = 0; // left pointer starting at the beginning of the string/array
        int right = ch.length - 1; // right pointer starting at the end of the string/array
        // while traversing the string/array of characters
        while (left < right) { // left < right means we have not yet reached the end of the array
            // if the current character is not a vowel (for the left pointer)
            if (!IsVowel(ch[left])) {
                left++; // move on the the next one
            }
            // if the current character is not a vowel (for the right pointer)
            else if (!IsVowel(ch[right])) {
                right--; // move on to the next one
            }
            // if the current character is a vowel
            else {
                // swap the characters at those positions
                char swap = ch[left];
                ch[left] = ch[right];
                ch[right] = swap;
                // move on to the next characters (increment both pointers)
                left++;
                right--;
            }
        }
        // once all characters are in proper order, add them to a new string and return the string
        return new String(ch);
    }


    // main method
    public static void main(String[] args) {
        System.out.println();
        // create a string
        String str1 = "hello"; // "hello"
        // print the string
        System.out.println("original string: " + str1);
        // invoke the method and print the resulting string
        System.out.println("string with only vowels reversed: " + reverseVowels(str1)); // "holle"
        System.out.println();
        // create a string
        String str2 = "leetcode"; // "leetcode"
        // print the string
        System.out.println("original string: " + str2);
        // invoke the method and print the resulting string
        System.out.println("string with only vowels reversed: " + reverseVowels(str2)); // "leotcede"
        System.out.println();
    }

}
