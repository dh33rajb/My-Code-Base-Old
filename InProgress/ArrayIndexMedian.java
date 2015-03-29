// ##### WORK IN PROGRESS ##### //

/*
2) Given an array as input find the output array that has median of each sub array whose index starts from 0 to i(i = 1,2...array.length-1). 
*/

import java.util.*;
import java.lang.*;

public class ArrayIndexMedian {
    public static void main (String args[]) {
        List<Integer> inputList = new ArrayList <Integer> ();
        
        // Step-1: read inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt ()) {
            inputList.add (scanner.nextInt());
        }
        
        // Step-2: core logic
        for (int i=0; i < inputList.size(); i++) {
            float median = 0;
            if (i%2 != 0) {
                // even number.. as indexes start from 0
                int middleIndexOne = (i / 2);
                int middleIndexTwo = middleIndexOne + 1;
                median = (inputList.get (middleIndexOne) + inputList.get (middleIndexTwo));
                median = median /2;
            }
            else {
                int middleIndex = i / 2;
                median = inputList.get (middleIndex);
            }
            System.out.println ("Median up until index " + i + " is: " + median);
        }
    }
}
