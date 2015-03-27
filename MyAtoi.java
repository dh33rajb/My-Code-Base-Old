/*
Implement ATOI function of C
ATOI == Ascii to Integer
*/

import java.util.*;
import java.lang.*;

public class MyAtoi {
    public static void main (String args[]) {
        
        // Step-1: Read inputs
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine ();
        
        // Step-2: Core logic method
        int output = performAtoi (input);
        
        // Step-3: Display results
        System.out.println (output);
    }
    
    public static int performAtoi (String input) {
        int output = 0;
        for (int i=input.length()-1; i >= 0; i--) {
            int val = ( (int) Math.pow (10, (input.length()-1 - i)) * Character.getNumericValue(input.charAt(i)));
            output = output + val;
        }
        return output;
    }
}
