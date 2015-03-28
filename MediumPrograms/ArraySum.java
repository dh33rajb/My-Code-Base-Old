// ####### WORK IN PROGRESS.... ####### //

/*
Given a value k and an array, design an efficient algorithm that should output the number of pairs that sum up to k.

Core logic:
-----------
1. Sort the list..

2. Keep two pointers... start one from first eleemnt, start second from last element

if (sum < numberK).. increase i... if (sum > numberK).. decrease j...
*/

import java.util.*;
import java.lang.*;

public class ArraySum {
    public static void main (String[] args) {
        // Step-1: Read inputs
        List <Integer> inputList = new LinkedList <Integer> ();
        Scanner scanner = new Scanner (System.in);
        int numberK = scanner.nextInt();
        while (scanner.hasNextInt())
            inputList.add (scanner.nextInt());
        
        // Step-2: Sort the input list - O(n log n)
        Collections.sort (inputList);
        
        // Step-3: Core logic
        int i = 0; int j = inputList.size()-1; 
        List <Integer> outputList = new LinkedList <Integer> ();
        int sum = 0;
        boolean flag = false;
        while (i != j) {
            sum = inputList.get (i) + inputList.get (j);
            if (sum == numberK) {
                System.out.println (outputList);
                outputList = new LinkedList<Integer>();
            } if (sum > numberK) {
                sum = sum - inputList.get (j);
                flag = true;
                j--;
            } else {
                flag = false;
                outputList.add (inputList.get (i));
                outputList.add(inputList.get (j));
                i++;
            }
        }
    }
}
