/*

Find All Palindrome Substrings

Input String = aabbbaa

Palindrome substring = aa bb bbb abbba aabbbaa bb aa

Hint: find substrings

 */


// main class
class Practice { // PalindromeSubStrings

    // a method that
    public static int findPalindromesInSubString(String input, int j, int k) {
        //
        int count = 0;
        //
        for (; j >= 0 && k < input.length(); --j, ++k) {
            //
            if (input.charAt(j) != input.charAt(k)) {
                break;
            }
            //
            System.out.println(input.substring(j, k+1));
            //
            count++;
        }
        //
        return count;
    }

    // a method that
    public static int findAllPalindromeSubstrings(String input) {
        //
        int count = 0;
        //
        for(int i = 0 ; i < input.length() ; ++i) {
            //
            count+= findPalindromesInSubString(input, i-1, i+1);
            //
            count+= findPalindromesInSubString(input, i, i+1);
        }
        //
        return count;
    }

    // main method
    public static void main(String[] args) {
        //
        String str = "aabbbaa";
        //
        int count = findAllPalindromeSubstrings(str);
        //
        System.out.println("Total palindrome substrings: " + count);
    }

}