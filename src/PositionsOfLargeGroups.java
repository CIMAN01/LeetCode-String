/*

In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of
every large group.

The final answer should be in lexicographic order.


Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.


Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.


Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]


*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// main class
public class PositionsOfLargeGroups {
    /*

    Process:

    We scan through the string to identify the start and end of each group. If the size of the group is
    at least 3, we add it to the answer.

    Algorithm:

    Maintain pointers i, j with i <= j. The i pointer will represent the start of the current group,
    and we will increment j forward until it reaches the end of the group.

    We know that we have reached the end of the group when j is at the end of the string,
    or S[j] != S[j+1]. At this point, we have some group [i, j]; and after, we will update i = j+1,
    the start of the next group.

    */

    // a method that finds the starting and ending positions of every large group of characters
    public static List<List<Integer>> largeGroupPositions(String S) {
        // create a new ArrayList of an ArrayList
        List<List<Integer>> answer = new ArrayList<>();
        // i represents the start of the current group
        int i = 0;
        //  scan through the string to identify the start and end of each group
        for (int j = 0; j < S.length(); j++) { // ++j
            // we have reached the end of the group when j is at the end of the string or S[j] != S[j+1]
            if (j == S.length() - 1 || S.charAt(j) != S.charAt(j + 1)) {
                // if the size of the group is at least 3, we add it to the answer
                if (j + 1 - i >= 3) { // the difference between starting and ending points determines the size
                    // here, [i, j] represents a group, where i is the starting point and j is the ending point
                    answer.add(Arrays.asList(i, j)); // Arrays.asList(new Integer[]{i, j})
                }
                // update i, the start of the next group
                i = j + 1;
            }
        }
        // answer should return an array of arrays with starting and ending indexes
        return answer;
    }


    // a method that returns the starting and ending indexes of the largest group of characters in a string
    public static String returnLargestGroup(String S) {
        // create variables and initialize them
        int count = 0; // create a count variable to keep track of similar character occurrences
        String temp = ""; // empty temp string variable
        String group = ""; // empty group of characters (string variable)
        // outer loop for pointer i (left most pointer)
        for (int i = 0; i < S.length(); i++) {
            // inner loop for pointer j (j will be the pointer one index to the right of pointer i)
            for (int j = 1; j < S.length(); j++) {
                // if pointer i and j are equal to each (similar characters)
                if (S.charAt(i) == S.charAt(j)) {
                    count++; // increment count
                    temp += S.charAt(i); // add matching characters
                }
            }
            // if the count is equal or larger than three
            if (count >= 3) {
                // assign the temp string to the group string that is to be returned
                group = temp;
            }
            // overwrite/reset temp string
            temp = "";
            // reset count
            count = 0;
        }
        // create an array of size two
        int[] array = new int[2];
        // find the first occurrence (index) of substring group found in the string S
        array[0] = S.indexOf(group); // assign first occurrence index to to first slot in the array
        // find the last character in the group and assign it to variable ch
        char ch = group.charAt(group.length() - 1); // last character in group
        // find the last occurrence (index) of the substring group found in the string S
        array[1] = S.lastIndexOf(ch); // assign last occurrence index to to second slot in  the array
        // return the largest group of characters
        return Arrays.toString(array);
    }


    // main method
    public static void main(String[] args) {
        // create a string
        String input1 = "abbxxxxzzy";
        // print the original string to the console
        System.out.println();
        System.out.println("input = " + input1); // Input: "abbxxxxzzy"
        // invoke the method and print the output
        System.out.println("output = " + largeGroupPositions(input1)); // Output: [[3,6]]
        // create a string
        String input2 = "abc";
        // print the original string to the console
        System.out.println();
        System.out.println("input = " + input2); // Input: "abc"
        // invoke the method and print the output
        System.out.println("output = " + largeGroupPositions(input2)); // []
        // create a string
        String input3 = "abcdddeeeeaabbbcd";
        // print the original string to the console
        System.out.println();
        System.out.println("input = " + input3); // Input: "abcdddeeeeaabbbcd"
        // invoke the method and print the output
        System.out.println("output = " + largeGroupPositions(input3)); // [[3,5],[6,9],[12,14]]
        ///////////////////////////////////////////////////////////////////////////////////////
        // testing second method that return just an array of starting and ending indexes ////
        //////////////////////////////////////////////////////////////////////////////////////
        // create a string
        String inputOne = "abbxxxxzzy";
        // print the original string to the console
        System.out.println();
        System.out.println("input = " + input1); // Input: "abbxxxxzzy"
        // invoke the method and print the output
        System.out.println("output = " + returnLargestGroup(inputOne)); // output: [3,6]
    }

}
