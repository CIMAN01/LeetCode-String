/*

Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting
some (can be none) of the characters without disturbing the relative positions of the remaining
characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:

If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one
by one to see if T has its subsequence. In this scenario, how would you change your code?


Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true


Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

    0 <= s.length <= 100
    0 <= t.length <= 10^4
    Both strings consists only of lowercase characters.


*/


// main class
public class IsSubsequence {

    // a method that takes a string s and a string t, and check if s is subsequence of t
    public static boolean isSubsequence(String s, String t) {
        // base cases
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        // create two pointers, one for each string
        int i = 0; // i is the pointer for s
        int j = 0; // j is the pointer for t
        // traverse both strings and compare character of s and t at i and j indexes
        while (i < s.length() && j < t.length()) { // while there are chars in both strings
            // compare chars, and if there is a match (if both are the same)
            if (s.charAt(i) == t.charAt(j)) {
                // increment both pointer i and j
                i++;
//              j++; // this line is only needed if using an if-else statement
            }
            // else just increment pointer j for t
            j++;
            // repeat while loop until either pointer reaches the last character of the string
        }
        // check if i-th pointer reaches the end of s string, and return whether or not
        return i == s.length(); // all characters from s string matches the ones in t string
    }


    // main method
    public static void main(String[] args) {
        System.out.println();
        // create a string
        String s1 = "abc"; // s = "abc", t = "ahbgdc"
        String t1 = "ahbgdc";
        // print the strings
        System.out.println("s = " + s1 + " and" + " t = " + t1);
        // invoke the method and print the result
        System.out.println("is s is subsequence of t? " + isSubsequence(s1, t1)); // true
        System.out.println();
        // create a string
        String s2 = "axc"; // s = "axc", t = "ahbgdc"
        String t2 = "ahbgdc";
        // print the strings
        System.out.println("s = " + s2 + " and" + " t = " + t2);
        // invoke the method and print the result
        System.out.println("is s is subsequence of t? " + isSubsequence(s2, t2)); // false
        System.out.println();
        String s3 = "ace"; // "aec" is false
        String t3 = "abcde";
        // print the strings
        System.out.println("s = " + s3 + " and" + " t = " + t3);
        // invoke the method and print the result
        System.out.println("is s is subsequence of t? " + isSubsequence(s3, t3)); // true
    }

}
