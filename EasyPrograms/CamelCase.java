/*
Given a sentence, how would you transform each word to start with a capital letter. 
*/

import java.util.*;
import java.lang.*;

public class CamelCase {
    public static void main (String args[]) {
        // Step-1: read inputs from console
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine ();
        
        // Step-2: Core logic
        boolean flag=true;
        String output = "";
        for (char c : input.toCharArray()) {
            int val = c;
            if (c == ' ') {
                flag=true;
                output = output + c;
            } else if (flag && val >=97 && val<=122) {
                val = c - 32;
                char chr = (char) val;
                output = output + chr;
                flag=false;
            } else {
                output = output + c;
            }
        }
        System.out.println (output);
    }
}
