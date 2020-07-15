/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
input string is valid.


An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.


Note that an empty string is also considered valid.


Example 1:

Input: "()"
Output: true


Example 2:

Input: "()[]{}"
Output: true


Example 3:

Input: "(]"
Output: false


Example 4:

Input: "([)]"
Output: false


Example 5:

Input: "{[]}"
Output: true

Hint1:

An interesting property about a valid parenthesis expression is that a sub-expression of a
valid expression should also be a valid expression.

(Not every sub-expression) e.g.

{ { } [ ] [ [ [ ] ] ] }  is VALID expression
          [ [ [ ] ] ]    is VALID sub-expression
  { } [ ]                is VALID


Hint2:

What if whenever we encounter a matching pair of parenthesis in the expression, we simply remove
it from the expression?

This would keep on shortening the expression. e.g.

{ { ( { } ) } }
      |_|

{ { (      ) } }
    |______|

{ {          } }
  |__________|

{                }
|________________|

VALID EXPRESSION!


Hint3:

The stack data structure can come in handy here in representing this recursive structure of the
problem. We can't really process this from the inside out because we don't have an idea about
the overall structure.

But, the stack can help us process this recursively i.e. from outside to inwards.


*/


import java.util.Stack;

// main class
public class ValidParentheses {

    // a method that determines if the given string of certain characters is valid or not
    public static boolean isValid(String s) {
        // declaring a new empty stack
        Stack<Character> stack = new Stack<>();
        // convert the strings into an array of chars
        char[] chars = s.toCharArray();
        // iterating over the entire string (array of chars)
        for (char ch : chars) {
            //  if the current char contains an opening parenthesis
            if (ch == '(' || ch == '{' || ch == '[') {
                // push opening parenthesis on top the stack
                stack.push(ch);
            }
            // in case of a closing bracket
            else {
                // check if the stack is empty
                if (stack.empty()) {
                    // in the case of valid parentheses, the stack cannot be be empty if a closing parenthesis is encountered
                    return false; // contains invalid parentheses
                }
                // if stack not empty, peek at the top of the stack
                char top = stack.peek();
                // if the top of the stack contains an opening parenthesis and the current ch contains a closing parenthesis
                if (top == '(' && ch == ')' || top == '{' && ch == '}' || top == '[' && ch == ']') {
                    // pop the top of the stack (opening parenthesis)
                    stack.pop();
                }
            }
        }
        // if the parentheses are valid,​then the stack will be empty once the input string finishes
        return stack.empty(); // check and return the status of the stack to determine the validity of the string
    }


    // main method
    public static void main(String[] args) {
        System.out.println();
        // create a string
        String s1 = "()"; // "()"
        // print the string
        System.out.println("string = " + s1);
        // invoke the method and print the result
        System.out.println("is valid? " + isValid(s1)); // true
        System.out.println();
        // create a string
        String s2 = "()[]{}"; // "()[]{}"
        // print the string
        System.out.println("string = " + s2);
        // invoke the method and print the result
        System.out.println("is valid? " + isValid(s2)); // true
        System.out.println();
        // create a string
        String s3 = "(]"; // "(]"
        // print the string
        System.out.println("string = " + s3);
        // invoke the method and print the result
        System.out.println("is valid? " + isValid(s3)); // false
        System.out.println();
        // create a string
        String s4 = "([)]"; // "([)]"
        // print the string
        System.out.println("string = " + s4);
        // invoke the method and print the result
        System.out.println("is valid? " + isValid(s4)); // false
        System.out.println();// create a string
        String s5 = "{[]}"; // "{[]}"
        // print the string
        System.out.println("string = " + s5);
        // invoke the method and print the result
        System.out.println("is valid? " + isValid(s5)); // true
        System.out.println();
    }

}
