// ##### WORK IN PROGRESS ##### //
/*
2 EGGS 100 FLOORS PROBLEM:
--------------------------
Suppose that there is a building with 100 floors. You are given 2 identical eggs. The most interesting property of the eggs is that every egg has it’s own “threshold” floor. Let’s call that floor N. What this means is that the egg will not break when dropped from any floor below floor N, but the egg will definitely break from any floor above floor N, including floor N itself.
For example, if the property of the eggs is that N equals 15, those eggs will always break on any floor higher than or equal to the 15th floor, but those eggs will never break on any floor below floor 15. The same holds true for the other egg since they are identical.
These are very strong eggs, because they can be dropped multiple times without breaking as long as they are dropped from floors below their “threshold” floor, floor N. But once an egg is dropped from a floor above it’s threshold floor
Here is the puzzle: What strategy should be taken in order to minimize the number of egg drops used to find floor N (the threshold floor) for the egg? Also, what is the minimum number of drops for the worst case using this strategy?
Remember that you are given 2 identical eggs which both have the same exact threshold floor.
*/

import java.util.*;
import java.lang.*;

public class TwoEggsHundredFloors {
    public static void main (String args[]) {
        
        // Step-1: set inputs
        int floors = 100;
        int threshold = 13;
        int gap = 14;
        boolean flag = false;
        
        // Step-2: core logic
        int jumpsTaken = 0;
        int jump = 0;
        while (jump <= 100) {
            if (jump+gap < threshold) {
                jump = jump + gap;
                System.out.println ("Jumped to: " + jump);
                if (!flag)
                    gap --;
            } else if (jump+gap > threshold) {
                jump = jump - (gap + 1);
                gap = 1;
                flag=true;
            } else {
                jump=jump+gap;
                System.out.println ("Jumped to: " + jump);
                System.out.println ("Total jumps taken: " + jumpsTaken);
                break;
            }
            jumpsTaken++;
        }
        
    }
}
