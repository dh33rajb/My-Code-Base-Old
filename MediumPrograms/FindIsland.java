/*

*/

import java.util.*;
import java.lang.*;

public class FindIsland {
    public static void main (String args[]) {
        
        // Step-1: Initalize input matrix
        int [][] input = {  {1, 0, 0, 0, 0, 0},
                            {1, 0, 1, 1, 1, 1},
                            {0, 0 ,0, 0, 0, 0},
                            {1, 1, 1, 0, 1, 1},
                            {1, 1, 1, 0, 1, 1},
                            {0, 0, 0, 0, 1, 1}
        };
    
        // Step-2: Core logic
        int finalCount=0;
        for (int i=0; i < input.length; i++) {
            for (int j=0; j < input[i].length; j++) {
                if (input[i][j] == 1) {
                    if ((i==0 || input [i-1][j] == 0) && (j==0 || input[i][j-1]==0))
                        finalCount++;
                }
            }
        }
        System.out.println (finalCount++);
    }
}
