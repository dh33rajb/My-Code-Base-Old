/*
Given a value k and an array, design an efficient algorithm that should output the number of pairs that sum up to k.

Note: The below logic is my own. I have also looked for online resources for better solutions and I stumbled across this.. The Hash logic is good, will give that a shot in part 2.
http://stackoverflow.com/questions/4720271/find-a-pair-of-elements-from-an-array-whose-sum-equals-a-given-number

Core logic: O (n log n)
--------------------------
1. Sort the list..

2. Keep two pointers... start one from first element, start second from last element

if (sum < numberK).. increase i... if (sum > numberK).. decrease j...

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

public class ArraySum {
    public static void main (String[] args) {
        
        // Step-1: Read inputs from console
        Scanner scanner = new Scanner (System.in);
        int numberK = scanner.nextInt ();
        List <Integer> inputList = new LinkedList <Integer> ();
        while (scanner.hasNextInt()) {
            inputList.add (scanner.nextInt());
        }
        
        // Step-2: Sort eh inputList --> O (n log n)
        Collections.sort (inputList);
        
        // Step-3: core logic
        List <Integer> outputList = new LinkedList <Integer> ();
        
        int i = 0; 
        int j = inputList.size()-1;
        int sum = 0;
        while (i < j) {
            sum = inputList.get (i) + inputList.get (j);
            if (sum == numberK) {
                outputList.add (inputList.get (i));
                outputList.add (inputList.get (j));
                System.out.println (outputList);
                outputList = new LinkedList <Integer> ();
                i++;
                j--;
            } else if (sum < numberK) {
                i++;
            } else if (sum > numberK) {
                j--;
            }
        }
        
    }
}
