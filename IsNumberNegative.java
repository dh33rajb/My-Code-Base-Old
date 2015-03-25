/*
Find if a number is a negative number.

Logic:
------
Find the most significant bit.. if 1, -ve; else, +ve
*/

import java.util.*;
import java.lang.*;

public class IsNumberNegative {
    public static void main (String args[]) {
        // Step-1: Reading inputs
        Scanner s = new Scanner (System.in);
        int input = s.nextInt();
        
        // Step-2: Core logic
        int minInt = Integer.MIN_VALUE;
        int binaryAndValue = input & minInt;
        int shiftedValue =  binaryAndValue>>31;
        
        int finalValue = shiftedValue & 1;
        
        if (finalValue == 1)
            System.out.println ("-ve");
        else
            System.out.println ("+ve");
    }
}
