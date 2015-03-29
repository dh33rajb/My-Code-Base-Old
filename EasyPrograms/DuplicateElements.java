/*
Finding duplicate entry in an integer array. Next there were variations of this where I had to find duplicate entry only if it was within some index range, and next if the values were not actually duplicate but within some range of values.
*/

import java.util.*;
import java.lang.*;

public class DuplicateElements {
    public static void main (String args[]) {
        
        List<Integer> inputList = new LinkedList <Integer> ();
        
        // Step-1: Read inputs from console
        Scanner scanner = new Scanner (System.in);
        int indexRangeStart = scanner.nextInt ();
        int indexRangeEnd = scanner.nextInt();
        while (scanner.hasNextInt()) {
            inputList.add (scanner.nextInt());
        }
        
        // Step-2: Core logic
        Map <Integer, Boolean> map = new HashMap <Integer, Boolean> ();
        int count = 0;
        for (int i : inputList) {
            if (map.get (i) == null) {
                map.put (i, true);
            } else {
                if (count >= indexRangeStart && count < indexRangeEnd)
                    System.out.println ("We have a duplicate for: " + i);
            }
            count++;
            
            /*if (i >= indexRangeStart && i < indexRangeEnd) {
                System.out.println (i);
            }*/
        }
        
    }
}
