/*

A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase
letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.

    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end,
    then add "ma".

    For example, the word "goat" becomes "oatgma".

    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.

    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.

Return the final sentence representing the conversion from S to Goat Latin.


Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"


Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


Notes:

    S contains only uppercase, lowercase and spaces. Exactly one space between each word.
    1 <= S.length <= 150.


*/

// main class
public class GoatLatin {

    // a method that checks if a character is a vowel
    public static boolean isVowel(Character ch) {
        // return true the character matches any of the vowels
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }


    // a method that converts a string to Goat Latin
    public static String toGoatLatin(String S) {
        // create an empty string
        String letter = "";
        // create a new StringBuilder
        StringBuilder strBuilder = new StringBuilder();
        // split the sentence into words
        String[] words = S.split(" ");
        // traverse the string of words
        for (String word : words) { // for each word in words
            // add one letter 'a' to the end of each word per its word index in the sentence, starting with 1
            letter += 'a'; // Java compiler converts this into a temporary StringBuilder
            // if a word doesn't begin with a vowel (or begins with a consonant)
            if (!isVowel(word.charAt(0))) {
                // remove the first letter and append it to the end
                word = word.substring(1) + word.charAt(0);
            }
            // append "ma" to the end of the word as well as the letter(s) and a a space
            strBuilder.append(word).append("ma").append(letter).append(' ');
        }
//        strBuilder.deleteCharAt(strBuilder.length()-1); // remove extra space

        // return the final sentence representing the conversion from S to Goat Latin
        return strBuilder.toString(); // convert StringBuilder back to String
    }


    // main method
    public static void main(String[] args) {
        System.out.println();
        // create a string
        String s1 = "I speak Goat Latin"; // "I speak Goat Latin"
        // print the string
        System.out.println("original string S: " + s1);
        // invoke the method and print the string in Goat Latin
        System.out.println("converted to Goat Latin: " + toGoatLatin(s1)); // "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        System.out.println();
        // create a string
        String s2 = "The quick brown fox jumped over the lazy dog"; // "The quick brown fox jumped over the lazy dog"
        // print the string
        System.out.println("original string S: " + s2);
        // invoke the method and print the string in Goat Latin
        System.out.println("converted to Goat Latin: " + toGoatLatin(s2)); // "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
    }
    
}
