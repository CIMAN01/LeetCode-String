/*

You are given a string representing an attendance record for a student.

The record only contains the following three characters:

    'A' : Absent.
    'L' : Late.
    'P' : Present.

A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:

Input: "PPALLP"
Output: True

Example 2:

Input: "PPALLL"
Output: False


*/


// main class
public class StudentAttendanceRecord {

    // a method that checks a students record and returns whether student should be rewarded or not
    public static boolean checkRecord(String s) {
        // create variables to keep count of records
        int absent = 0;
        int late = 0;
        // traverse the string (record)
        for (int i = 0; i < s.length(); i++) {
            // count how many times the student was absent
            if (s.charAt(i) == 'A') {
                absent++;
            }
            // count how many times the student was late
            else if (s.charAt(i) == 'L') {
                late++;
            }
        }
        // if student has more than one A (absence) or more than two continuous L's (late marks)
        if (absent > 1 || late > 2) {
            // if so, student should not be rewarded (false is returned)
            return false;
        }
        // otherwise student has a good record and should be rewarded (true is returned)
        return true;
    }


    // main method
    public static void main(String[] args) {
        System.out.println();
        // create a string
        String input1 = "PPALLP"; // "PPALLP"
        // print the string
        System.out.println("should student with the record '" + input1 + "' be rewarded?");
        // invoke the method and print the boolean result
        System.out.println("answer: " + checkRecord(input1)); // true
        // create a string
        System.out.println();
        String input2 = "PPALLL"; // "PPALLL"
        // print the string
        System.out.println("should student with the record '" + input2 + "' be rewarded?");
        // invoke the method and print the boolean result
        System.out.println("answer: " + checkRecord(input2)); // false
        System.out.println();
    }

}
