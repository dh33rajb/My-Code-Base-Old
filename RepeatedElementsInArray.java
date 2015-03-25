/*
Find the count and print the repeated items in an array.

Input: [1, 3, 5, 7, 9, 2, 4, 3, 6, 7, 8, 10]

Output:
2 --> # of repeated elements
[3, 7] --> repeated items
*/

import java.util.*;
import java.lang.*;

public class RepeatedElementsInArray {
    public static void main (String args[]) {
        // Step-1: Read inputs
        Scanner s = new Scanner (System.in);
        List<Integer> input = new ArrayList<Integer>();
        while (s.hasNextInt()) {
            input.add(s.nextInt());
        }
        
        // Step-2: core logic
        Map<Integer, Integer> map = new HashMap <Integer, Integer> ();
        for (int i : input) {
            if (map.get(i) == null) {
                map.put (i, 1);
            } else {
                map.put (i, (map.get(i) + 1));
            }
        }
        
        // Step-3: Print results
        int count = 0;
        List<Integer> outputList = new ArrayList <Integer>();
        for (Map.Entry e : map.entrySet()) {
            if ((int)e.getValue() > 1) {
                count++;
                outputList.add((int)e.getKey());
            }
        }
        System.out.println ("Repeated item count = " + count);
        System.out.println ("Repeated items = " + outputList);
    }
}
