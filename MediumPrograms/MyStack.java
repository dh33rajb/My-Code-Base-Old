/*
Stack:
------
Implement a stack that supports a. Push, b. Pop and c. minPeak functions

Input: elements in a stack
Output: push, pop and minPeak functions

Ex:
Input:
1   3   4   0   2   8   6   9   5   10

Output:
minPeak for first run after all insert: 0
*/

import java.util.*;
import java.lang.*;

public class MyStack {
    
    private static int stackSize;
    
    private static List <Integer> stack;
    
    private static Stack <Integer> minStack;
    
    public static void main (String args[]) {
        Scanner scanner = new Scanner (System.in);
        stackSize = 0;
        stack = new ArrayList <Integer> ();
        minStack = new Stack <Integer> ();
        
        while (scanner.hasNextInt()) {
            push(stack, scanner.nextInt());
        }
        
        for (int i=0; i < 15; i++) {
            pop();
            minPeak();
        }
    }
    
    public static void push (List<Integer> stack, int i) {
        
        System.out.println ("Pushed --> " + i);
        // MinStack Op: add i to minStack if i is the lowest eleemnt seen up until now
        if (minStack.size() > 0) {
            if (i < minStack.peek())
                minStack.add (i);
        } else {
            minStack.add (i);
        }
        
        // Stack Op: push the element into the stack
        if (stack.size() > stackSize) {
            stack.set (stackSize, i);
        } else {
            stack.add(i);
            stackSize++;
        }
        
    }
    
    public static int pop () {
        // Stack Op: remove eleemnt from stack
        if (stackSize > 0) {
            int removableIndex = --stackSize;
            int poppableValue = stack.get(removableIndex);
            
            // MinStack Op: remove top elemnt from minStack if top eleemnt of min stack == item being removed from stack
            if (minStack.size() > 0 && poppableValue == minStack.peek())
                minStack.pop();
            System.out.println ("Popped --> " + poppableValue);
            return poppableValue;
        } else {
            System.out.println ("Popped --> " + -1);
            return -1;
        }
        
    }
    
    public static int minPeak () {
        if (minStack.size() > 0) {
            int poppedItem = (int) minStack.peek();
            System.out.println ("Min Peak --> " + poppedItem);
            return poppedItem;
        } else {
            System.out.println ("Min Peak --> " + -1);
            return -1;
        }
    }
}
