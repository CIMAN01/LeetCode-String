/*

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's
strstr() and Java's indexOf().


*/

// main class
public class ImplementStrStr {

    // a method that checks if needle is substring of haystack
    public static int strStr(String haystack, String needle) {
        // create variables to store each length of the strings
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        // if needle is an empty string, return a 0
        if (needleLen == 0) { // or needle.isEmpty()
            return 0;
        }
        // string haystack cannot be smaller than string needle, return -1 if it is
        if (haystackLen < needleLen) {
            return -1;
        }
        // loop from start to end and for every index in the given string check whether the sub-string can be formed from that index
        for (int i = 0; i < haystackLen; i++) { // can be further optimized with i <= haystackLen - needleLen;
            // create variable j outside inner for-loop to be used for comparison
            int j;
            // run inner loop checking for sub-string for every index
            for (j = 0; j < needleLen; j++) {
                // check if characters match between the two strings at specific indexes
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    // and break out of current inner loop if they do not match
                    break; // no need to keep iterating if first pair of characters do not match
                }
            }
            // if j-th index equals the length of needle, return the i-th index
            if (j == needleLen) {
                return i; // this is the starting index of the substring
            }
        }
        // if we reached this return statement, it means we did not find a match
        return -1;
    }


    // a method that checks if needle is substring of haystack (using substring)
    public static int strStr2(String haystack, String needle) {
        // create variables to store each length of the strings
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        // string haystack cannot be smaller than string needle, return -1 if it is
        if (haystackLen < needleLen) {
            return -1;
        }
        // if needle is an empty string, return a 0
        if (needleLen == 0) {
            return 0;
        }
        // traverse the difference of the two strings
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            // check if needle is a substring of haystack
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i; // if a match is found, return the i-th index where the substring begins
            }
        }
        // if we reached this return statement, it means we did not find a match
        return -1;
    }

    // a method that checks if needle is substring of haystack (using indexOf())
    public static int strStr3(String haystack, String needle) {
        // string haystack cannot be smaller than string needle, return -1 if it is
        if (haystack.length() < needle.length()) {
            return -1;
        }
        // if needle is an empty string, return a 0
        if (needle.length() == 0) {
            return 0;
        }

//        // if the string contains the substring
//        if (haystack.contains(needle)) {
//            // return the first index where the substring begins
//            return haystack.indexOf(needle);
//        }
//        // if we reached this return statement, it means we did not find a match
//        return -1;

        // if the substring if found in the string, the first index of where substring starts will be returned
        return haystack.indexOf(needle); // if no substring is found, a -1 will be returned instead
    }

    // main method
    public static void main(String[] args) {
        // create two strings
        String haystack1 = "hello", needle1 = "ll";
        System.out.println();
        // print the original strings to the console
        System.out.println("haystack = " + haystack1 + ", " + "needle = " + needle1);
        // invoke method and print the result
        System.out.println("output: " + strStr(haystack1, needle1)); // 2
        // create two strings
        String haystack2 = "aaaaa", needle2 = "bba";
        System.out.println();
        // print the original strings to the console
        System.out.println("haystack = " + haystack2 + ", " + "needle = " + needle2);
        // invoke method and print the result
        System.out.println("output: " + strStr(haystack2, needle2)); // -1
    }

}
