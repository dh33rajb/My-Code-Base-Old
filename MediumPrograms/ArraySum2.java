/*
Given a value k and an array, design an efficient algorithm that should output the number of pairs that sum up to k.

This is Implementation 2 of the code I wrote in Implementation 1 - ArraySum.java

Reference: http://stackoverflow.com/questions/4720271/find-a-pair-of-elements-from-an-array-whose-sum-equals-a-given-number

Note: The idea of using Hash Maps to reach the solution has been referenced above, but my implementation is not as in above link. It kind of looks better and neater :)

Ex:
Input:
20
1 9 3 2 10 22 44 2 6 19 21 09 5 7 1 15 13
Output:
[1, 19]
[5, 15]
[7, 13]
*/

import java.util.*;
import java.lang.*;

public class ArraySum2 {
    public static void main (String args[]) {
        
        // Step-1: Initialize variables
        int numberK = 0;
        List <Integer> inputList = new LinkedList <Integer> ();
        Map <Integer, Integer> map = new HashMap <Integer, Integer> ();
        
        // Step-2: Read inputs from console
        Scanner scanner = new Scanner (System.in);
        numberK = scanner.nextInt ();
        while (scanner.hasNextInt ()) {
            int nextInt = scanner.nextInt();
            inputList.add (nextInt);
            if (map.get (nextInt) == null)
                map.put (nextInt, 1);
            else
                map.put (nextInt, (map.get (nextInt) + 1));
        }

        // Step-3: Core logic
        for (int i : inputList) {
            if (i != (numberK - i )) {
                if (map.get (numberK - i) != null && map.get (i) > 0 && map.get (numberK - i) > 0) {
                    map.put (i, (map.get(i) - 1));
                    map.put ((numberK - i), (map.get(numberK - i) - 1));
                    System.out.println (i + " - " + (numberK-i));
                }
            } else {
                if (map.get (i) > 1) {
                    map.put (i, (map.get (i) - 2));
                    System.out.println (i + " - " + i);
                }
            }
        }
    }
}
