/*

Given two strings S and T, return if they are equal when both are typed into empty text editors.

# means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true

Explanation: Both S and T become "ac".


Example 2:

Input: S = "ab##", T = "c#d#"
Output: true

Explanation: Both S and T become "".


Example 3:

Input: S = "a##c", T = "#a#c"
Output: true

Explanation: Both S and T become "c".


Example 4:

Input: S = "a#c", T = "b"
Output: false

Explanation: S becomes "c" while T becomes "b".


Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.


Follow up:

    Can you solve it in O(N) time and O(1) space?


*/

import java.util.Stack;

// main class
public class BackspaceStringCompare {

    // below is a longer solution using only one method

    // a method that compares if two strings are equal when using backspace in a text editor (longer version)
    public static boolean backspaceCompare(String S, String T) {
        ///////////////////////////////////////////////////////////////////////////////////////////////
        // create two new strings based on backspaces of the input strings and then compare the two //
        /////////////////////////////////////////////////////////////////////////////////////////////
        // create a new stack
        Stack<Character> stack = new Stack<>();
        // convert the first input string to an array of characters
        char[] sArray = S.toCharArray();
        // for each current character in the array
        for (char ch : sArray) {
            // if current character contains a backspace
            if (ch == '#') {
                // if the stack size is greater than zero
                if (!stack.empty()) { // stack.size() > 0
                    // remove or pop the top of the stack
                    stack.pop();
                }
            }
            // otherwise add or push the current character to the top of the stack
            else {
                stack.push(ch);
            }
        }
        // convert the stack back to a string and store in a separate variable
        String newS = String.valueOf(stack);
        // clear the stack so it can be re-used
        stack.clear();
        ///////////////////////////////////////////////////////////////
        // repeat the the above steps for a the second input string //
        /////////////////////////////////////////////////////////////
        // convert the second input string to an array of characters
        char[] tArray = T.toCharArray();
        // traverse the array
        for (char ch : tArray) {
            // if a backspace is found
            if (ch == '#') {
                // if stack size is greater than 0
                if (!stack.empty()) { // stack.size() > 0
                    // pop the stack
                    stack.pop();
                }
            }
            // else push the character onto the stack
            else {
                stack.push(ch);
            }
        }
        // convert stack to a string
        String newT = String.valueOf(stack);
        ////////////////////////////////////////////////////////////////////////////////////////
        // once the two new strings have been created, last step is to do a match comparison //
        //////////////////////////////////////////////////////////////////////////////////////
        // check whether the strings match, return true if they do or false otherwise
        return newS.equals(newT);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    // below is shorter solution using a two method approach

    // a method that compares if two strings are equal when using backspace in a text editor (shorter version)
    public static boolean backspaceCompare2(String S, String T) {
        // build a new string s by invoking build() method passing in S as argument
        String s = build(S);
        // build a new string t by invoking build() method passing in T as argument
        String t = build(T);
        // check new strings s and t for equality, return true if they match or false if they don't
        return s.equals(t); // can also use     return build(S).equals(build(T));
    }

    // a method that builds a new string from an existing one given backspace criteria
    public static String build(String S) {
        // create a new stack of characters
        Stack<Character> stack = new Stack<>();
        // convert the string to an array of characters
        char[] chars = S.toCharArray();
        // for every current character in the array (traverse the string)
        for (char ch : chars) { // for (char ch : S.toCharArray())
            // if character does not contain a backspace
            if (ch != '#') {
                // push the current character onto the stack
                stack.push(ch);
            }
            // otherwise if the stack is not empty
            else if (!stack.empty()) {
                // pop the top of the stack
                stack.pop();
            }
        }
        // return the stack in string format
        return String.valueOf(stack);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////


    // main method
    public static void main(String[] args) {
        // create two strings
        String S1 = "ab#c", T1 = "ad#c";
        System.out.println();
        // print the original strings to the console
        System.out.println("S = " + S1 + ", " + "T = " + T1);
        System.out.println("are these strings equal after using backspace? ");
        // invoke method and print the result
        System.out.println("answer: " + backspaceCompare(S1, T1)); // true
        // create two strings
        String S2 = "ab##", T2 = "c#d#";
        System.out.println();
        // print the original strings to the console
        System.out.println("S = " + S2 + ", " + "T = " + T2);
        System.out.println("are these strings equal after using backspace? ");
        // invoke method and print the result
        System.out.println("answer: " + backspaceCompare(S2, T2)); // true
        // create two strings
        String S3 = "a##c", T3 = "#a#c";
        System.out.println();
        // print the original strings to the console
        System.out.println("S = " + S3 + ", " + "T = " + T3);
        System.out.println("are these strings equal after using backspace? ");
        // invoke method and print the result
        System.out.println("answer: " + backspaceCompare(S3, T3)); // true
        // create two strings
        String S4 = "a#c", T4 = "b";
        System.out.println();
        // print the original strings to the console
        System.out.println("S = " + S4 + ", " + "T = " + T4);
        System.out.println("are these strings equal after using backspace? ");
        // invoke method and print the result
        System.out.println("answer: " + backspaceCompare(S4, T4)); // false
    }

}
