/*

Given a string S, return the "reversed" string where all characters that are not a letter stay
in the same place, and all letters reverse their positions.


Example 1:

Input: "ab-cd"
Output: "dc-ba"


Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"


Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:

    S.length <= 100
    33 <= S[i].ASCIIcode <= 122
    S doesn't contain \ or "


Hint:

This problem is exactly like reversing a normal string except that there are certain characters
that we have to simply skip.

That should be easy enough to do if you know how to reverse a string using the two-pointer approach.


*/

// main class
public class ReverseOnlyLetters {

    // a separate boolean method that check if a character is a letter
    public static boolean isLetterOnly(char ch) {
        // change input character to lower-case
        ch = Character.toLowerCase(ch);
        // check the character input ch against given range of letters:
        //     Alphabet A to Z (caps) ||     Alphabet a to z
        // return true if the argument passed in matches any of the letters
        return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
    }


    // a method that takes in a string and reverses only the letters (shorter faster version)
    public static String reverseOnlyLetters(String S) {
        // handling base case of an empty string
        if (S == null || S.length() == 0) {
            return S;
        }
        // convert string to an array of characters and store it in a new variable
        char[] ch = S.toCharArray();
        // create two pointers
        int left = 0; // left pointer starting at the beginning of the string/array
        int right = ch.length - 1; // right pointer starting at the end of the string/array
        // while traversing the string/array of characters
        while (left < right) { // left < right means we have not yet reached the end of the array
            // if the current character is not a letter (for the left pointer)
            if (!isLetterOnly(ch[left])) {
                left++; // move on the the next one
            }
            // if the current character is not a letter (for the right pointer)
            else if (!isLetterOnly(ch[right])) {
                right--; // move on to the next one
            }
            // if the current character is a letter
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

    // a method that reverses a string without affecting special characters (longer easier version)
    public static String reverseOnlyLetters2(String str) {
        // create an array of characters with a length equal to the input String
        char[] arr = new char[str.length()];
        // iterate over the input String and add each character to the array
        for (int i = 0; i <= str.length()-1; i++) {
            arr[i] = str.charAt(i);
        }
        // loop through array i start at first index and j start at last index
        for (int i = 0, j = str.length()-1; i < j;) {
            // if i and j indexes are both letters we reverse them:
            if (isLetterOnly(arr[i]) && isLetterOnly(arr[j])) {
                // put that i-th index into a temporary variable
                char temp = arr[i];
                // replace i-th index with j-th index
                arr[i] = arr[j];
                // replace j-th index with original i-th index
                arr[j] = temp;
                // move to the next character
                i++; // move index i to right by incrementing it
                j--; // and move index j to left by decrementing it
            }
            // if i-th index is not a letter
            else if (!isLetterOnly(arr[i])) {
                // skip to the next character
                i++; // move index i to the right by incrementing it
            }
            // if j-th index is a special character
            else if (!isLetterOnly(arr[j])) {
                // skip to the next character
                j--; // move index j to the left by decrementing it
            }
        }
        // create a new empty string using StringBuilder
        StringBuilder reverse = new StringBuilder(); // String reverse = "";
        // traverse the array
        for (int i = 0; i <= arr.length-1; i++) { // or use "i < arr.length" instead
            // and concatenate or add each character to the String
            reverse.append(arr[i]); // reverse += arr[i];
        }
        // return the reversed String
        return reverse.toString();
    }


    // main method
    public static void main(String[] args) {
        System.out.println();
        // create a string
        String str1 = "ab-cd"; // "ab-cd"
        // print the string
        System.out.println("original string: " + str1);
        // invoke the method and print the resulting string
        System.out.println("string with only letters reversed: " + reverseOnlyLetters(str1)); // "dc-ba"
        System.out.println();
        // create a string
        String str2 = "a-bC-dEf-ghIj"; // "a-bC-dEf-ghIj"
        // print the string
        System.out.println("original string: " + str2);
        // invoke the method and print the resulting string
        System.out.println("string with only letters reversed: " + reverseOnlyLetters(str2)); // "j-Ih-gfE-dCba"
        System.out.println();
        // create a string
        String str3 = "Test1ng-Leet=code-Q!"; // "Test1ng-Leet=code-Q!"
        // print the string
        System.out.println("original string: " + str3);
        // invoke the method and print the resulting string
        System.out.println("string with only letters reversed: " + reverseOnlyLetters(str3)); // "Qedo1ct-eeLg=ntse-T!"
        System.out.println();
    }

}
