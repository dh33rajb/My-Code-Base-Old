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
        String[] inputArr = input.split ("");
        char[] charArr = new char [inputArr.length-1];
        int c=0;
        for (String st : inputArr) {
            if (!st.equals ("")) {
                charArr[c++] = st.trim().charAt(0);
            }
        }
        
        // Step-2: Core logic.. using stack
        Stack<Character> stack = new Stack <Character>();
        for (char chr : charArr) {
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
                else {
                    stack.push (chr);
                    // System.out.println ("push--> " + chr);
                }
            }
        }
        // System.out.println ("Stack size: " + stack.size());
        if (stack.size() == 0)
            System.out.println ("Parantehsis are balanced");
        else
            System.out.println ("Paranthesis are not balanced");
    }
    
}
