/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and
ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.


Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true


Example 2:

Input: "race a car"
Output: false


Constraints:

    s consists only of printable ASCII characters.


*/

// main class
public class ValidPalindrome {

    // a method that checks if a sentence is palindrome or not (efficient, short for-loop version)
    public static boolean isPalindrome2(String s) {
        // replace entire string with regex and change each character to lowercase
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        // pointers i and j start at opposite ends of the string and iterate in opposite direction
        for (int i = 0, j = s.length()-1; i < j; ++i, --j) { // as long as pointers do not cross keep iterating them
            // if left pointer's char does not equal right pointer's char (if chars do not match)
            if (s.charAt(i) != s.charAt(j)) {
                // it is not a palindrome
                return false;
            }
        }
        // once the comparison is done, the string must be a palindrome (condition is true)
        return true;
    }
    
    
    // a method that checks if a sentence is palindrome or not (efficient while-loop version)
    public static boolean isPalindrome2(String s) {
        // replace entire string with regex and change each character to lowercase
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        // create 2 pointers
        int left = 0; // left pointer starting at the beginning of the string
        int right = s.length()-1; // right pointer start at the end of the string
        // while traversing the string
        while (left < right) {
            // if left pointer's char does not equal right pointer's char (if chars do not match)
            if (s.charAt(left) != s.charAt(right)) {
                // it is not a palindrome, false is returned
                return false;
            }
            // increment left pointer (move to next char)
            left++;
            // decrement right pointer (move to next char)
            right--;
        }
        // once the comparison is done, the string must be a palindrome (condition is true)
        return true;
    }


    // a method that checks if a sentence is palindrome or not (easy for-loop version)
    public static boolean isPalindrome3(String s) {
        // remove spaces from string and change to lower case
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase(); // (regex: "\\s", "")
        // create an empty string using StringBuilder
        StringBuilder reversed = new StringBuilder(); // String reversed = "";
        // traverse the string backwards using a for-loop
        for (int i = s.length() - 1; i >= 0; i--) {
            // append each character at i-th index
            reversed.append(s.charAt(i)); // reversed += str.charAt(i);
        }
        // check if condition holds true for a palindrome, if it does return true
        return reversed.toString().equals(s);
    }


    // a method that checks if a sentence is palindrome or not (short 'built-in methods' version)
    public static boolean isPalindrome3(String s) {
        // remove spaces from string and change to lower case
        s = s.toLowerCase().replaceAll("\\s", "");
        // check if condition holds true for a palindrome, if it does return true
        return s.equals(new StringBuilder(s).reverse().toString()); // use StringBuilder
    }


    // main method
    public static void main(String[] args) {
        System.out.println();
        // create a string
        String input1 = "A man, a plan, a canal: Panama"; // or "No lemon, no melon"
        // print the string
        System.out.println("is the following sentence '" + input1 + "' a Palindrome?");
        // invoke the method and print the boolean result
        System.out.println("answer: " + isPalindrome(input1)); // true
        // create a string
        System.out.println();
        String input2 = "race a car";
        // print the string
        System.out.println("is the following sentence '" + input2 + "' a Palindrome?");
        // invoke the method and print the boolean result
        System.out.println("answer: " + isPalindrome(input2)); // false
        System.out.println();
    }

}
