/*
Given an array as input find the output array that has median of each sub array whose index starts from 0 to i(i = 1,2...array.length-1).

*/

import java.util.*;
import java.lang.*;

public class ArrayIndexMedian {
    public static void main (String args[]) {
        
        // Step-1: Initializations
        List <Integer> inputList = new ArrayList <Integer> ();
        
        // Step-2: Read the inputs
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            inputList.add (scanner.nextInt());
        }
        
        // Step-3: Core logic
        for (int i=1; i < inputList.size(); i++) {
            List <Integer> list = new ArrayList <Integer> ();
            for (int j=0 ; j < i; j++) {
                list.add (inputList.get (j));
            }
            float median = returnMedian (list);
            System.out.println (median);
        }
    }
    
    public static float returnMedian (List <Integer> list) {
        System.out.println (list);
        Collections.sort (list);
        if ((list.size()-1) % 2 != 0) {
            // even elements
            int middleIndexOne = (list.size()-1) / 2;
            int middleIndexTwo = middleIndexOne + 1;
            System.out.println ("--> "+middleIndexOne + "-" + middleIndexTwo);
            int sum = (list.get (middleIndexOne) + list.get (middleIndexTwo));
            float median = (float) sum / 2;
            return median;
        } else {
            // odd elements
            int middleIndex = (list.size()-1) / 2;
            System.out.println ("--> "+middleIndex);
            float median = list.get (middleIndex);
            return median;
        }
    }
}
