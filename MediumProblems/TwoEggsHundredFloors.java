/*
2 Eggs 100 Floors Problem:
--------------------------
*/

import java.util.*;
import java.lang.*;

public class TwoEggsHundredFloors {
    public static void main (String args[]) {

        // Step-1: Set inputs
        int numOfFloors = 100;
        int thresholdFloor = 13;
        int jumpGap = 14; // and reducing
        
        // Step-2: Core logic
        int jumpCount = 0;
        int i=0;
        int iteratorLimit = numOfFloors;
        boolean firstBreakFlag = false;
        while (true) {
            if (i < thresholdFloor) {
                if (!firstBreakFlag)
                    i = i + jumpGap--;
                else
                    i++;
                jumpCount++;
                System.out.println ("Jumped to floor: " + i);
            } else if (i > thresholdFloor) {
                i = i - (jumpGap + 1);
                firstBreakFlag = true;
                System.out.println ("Retracted back to floor: " + i);
            } else {
                System.out.println ("Reached the threshold floor: " + i + ", with jump count: " + jumpCount);
                break;
            }
        }
        
    }
}
