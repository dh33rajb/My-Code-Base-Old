/*
 Min. no. of edits needed to balance a string of parentheses
*/

import java.util.*;
import java.lang.*;

public class BalanceParanthesis {
    public static void main (String args[]) {
        // Step-1: Reading inputs
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        char[] charArr = new char [input.length()];
        for (int i=0; i < input.length(); i++) {
            charArr[i] = input.charAt(i);
        }
        
        // Step-2: Core logic.. using stack
        Stack<Character> stack = new Stack <Character>();
        for (int i=0; i < charArr.length; i++) {
            char chr = charArr[i];
            // System.out.println ("char--> " + chr);
            if (stack.size() == 0) {
                // System.out.println ("push--> " + chr);
                stack.add (chr);
            }
            else {
                char topOfStack = stack.peek ();
                if ((topOfStack == '{' && chr == '}') || (topOfStack =='(' && chr == ')') || (topOfStack =='[' && chr == ']')) {
                    int  num = stack.pop();
                   // System.out.println ("pop--> " + num);
                }
                else if ((topOfStack == '{' ) && (chr == ')' || chr==']')) {
                    System.out.println ("Edit needed: " + '}');
                    int  num = stack.pop();
                    i--;
                } else if ((topOfStack == '(' ) && (chr == '}' || chr==']')) {
                    System.out.println ("Edit needed: " + ')');
                    int  num = stack.pop();
                    i--;
                } else if ((topOfStack == '[' ) && (chr == '}' || chr==')')) {
                    System.out.println ("Edit needed: " + ']');
                    int  num = stack.pop();
                    // System.out.println (stack);
                    i--;
                } else if (topOfStack == '}' || topOfStack == ')' || topOfStack == ']'){
                    System.out.println ("Remove needed: " + topOfStack);
                    stack.pop ();
                }
                else {
                    stack.push (chr);
                    // System.out.println ("push--> " + chr);
                }
            }
        }
    }
    
}
