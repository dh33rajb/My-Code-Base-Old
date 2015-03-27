/*
Implement HashSet in Java

HashSet:
-------
1. Do not allow duplicate elements.
2. Allow at most Null element. // ignoring this for sake of simplicity
*/

import java.util.*;
import java.lang.*;

public class MyHashSet {
    public static void main (String args[]) {
        Map <Integer, Integer> hashMap = new HashMap <Integer, Integer> ();
        List <Integer> hashSet = new ArrayList <Integer> ();
        
        // Step-1: Reading inputs
        Scanner scanner = new Scanner (System.in);
        List<Integer> inputList = new ArrayList <Integer> ();
        while (scanner.hasNextInt())
            inputList.add (scanner.nextInt());
        // System.out.println (inputList);
        
        // Step-2: Core logic
        for (int i : inputList) {
            if (hashMap.get (i) == null) {
                hashSet.add (i);
                hashMap.put (i, 0);
            }
        }
        
        // Step-3: Print results
        System.out.println (hashSet);
        
    }
}
