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

    // a method that compares if two strings are equal when using backspace in a text editor
    public static boolean backspaceCompare(String S, String T) {
        //
        Stack<Character> stack = new Stack<>();
        //
        char[] sArray = S.toCharArray();
        //
        for (char ch : sArray) {
            //
            if (ch == '#') {
                //
                if (stack.size() > 0) {
                    stack.pop();
                }
            }
            //
            else {
                stack.push(ch);
            }
        }
        //
        String newS = String.valueOf(stack);
        // clear the stack so it can be re-used
        stack.clear();
        //
        char[] tArray = T.toCharArray();
        //
        for (char ch : tArray) {
            //
            if (ch == '#') {
                //
                if (stack.size() > 0) {
                    stack.pop();
                }
            }
            //
            else {
                stack.push(ch);
            }
        }
        //
        String newT = String.valueOf(stack);
        // check whether the strings match, return true if they do or false otherwise
        return newS.equals(newT);
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    // Solution 1: Build String [Accepted]
    public static boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String S) {
        //
        Stack<Character> ans = new Stack<>();
        //
        for (char ch : S.toCharArray()) {
            //
            if (ch != '#') {
                ans.push(ch);
            }
            //
            else if (!ans.empty()) {
                ans.pop();
            }
        }
        //
        return String.valueOf(ans);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    // Solution 2: Two-pointer Approach [accepted]
    public boolean backspaceCompare3(String S, String T) {
        //
        int i = S.length() - 1;
        int j = T.length() - 1;
        //
        int skipS = 0;
        int skipT = 0;
        //
        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            //
            while (i >= 0) { // Find position of next possible char in build(S)
                //
                if (S.charAt(i) == '#') {
                    skipS++; i--;
                }
                //
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }
                //
                else break;
            }
            //
            while (j >= 0) { // Find position of next possible char in build(T)
                //
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                }
                //
                else if (skipT > 0) {
                    skipT--; j--;
                }
                //
                else break;
            }
            // if two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            // if expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            //
            i--;
            j--;
        }
        //
        return true;
    }


    // main method
    public static void main(String[] args) {
        // create two strings
        String S1 = "ab#c", T1 = "ad#c";
        System.out.println();
        // print the original strings to the console
        System.out.println("S = " +S1 + ", " + "T = " + T1);
        System.out.println("are these strings equal after using backspace? ");
        // invoke method and print the result
        System.out.println("answer: " + backspaceCompare(S1, T1)); // true
        // create two strings
        String S2 = "ab##", T2 = "c#d#";
        System.out.println();
        // print the original strings to the console
        System.out.println("S = " +S2 + ", " + "T = " + T2);
        System.out.println("are these strings equal after using backspace? ");
        // invoke method and print the result
        System.out.println("answer: " + backspaceCompare(S2, T2)); // true
        // create two strings
        String S3 = "a##c", T3 = "#a#c";
        System.out.println();
        // print the original strings to the console
        System.out.println("S = " +S3 + ", " + "T = " + T3);
        System.out.println("are these strings equal after using backspace? ");
        // invoke method and print the result
        System.out.println("answer: " + backspaceCompare(S3, T3)); // true
        // create two strings
        String S4 = "a#c", T4 = "b";
        System.out.println();
        // print the original strings to the console
        System.out.println("S = " +S4 + ", " + "T = " + T4);
        System.out.println("are these strings equal after using backspace? ");
        // invoke method and print the result
        System.out.println("answer: " + backspaceCompare(S4, T4)); // false
    }

}
