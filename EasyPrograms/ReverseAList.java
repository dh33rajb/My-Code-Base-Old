/*
Reverse a linked list

Logic: Recursion
*/

import java.util.*;
import java.lang.*;

public class ReverseAList {
    
    private static List <Integer> inputList;
    private static List <Integer> outputList;
    private static int counter;

    public static void main (String args[]) {
        // Step-1: Initialization
        inputList = new LinkedList <Integer> ();
        outputList = new LinkedList <Integer> ();
        counter = 0;
        
        // Step-2: Read inputs from console
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            inputList.add (scanner.nextInt());
        }
        
        // Step-3: recursively form an outputList that is reverse of inputList
        reverseList (inputList);
        System.out.println (outputList);
    }
    
    public static void reverseList (List <Integer> inputList) {
        if (counter==inputList.size())
            return;
        else {
            counter++;
            reverseList (inputList);
            outputList.add (inputList.get(--counter));
        }
    }
}
