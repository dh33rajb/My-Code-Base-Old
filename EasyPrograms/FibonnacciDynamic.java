/* fibonnacci dynamic programming
input : n
output: nth fibonnacci
*/

import java.util.*;
import java.lang.*;

public class FibonnacciDynamic {
    public static void main (String args[]) {
        
        // Step-1: Read inputs
        Scanner s = new Scanner (System.in);
        int n = s.nextInt();
        
        // Step-2: place data in memory
        
        int fib[] = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i=2; i<n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        
        // step-2: retrieve results 
        System.out.println (fib[n-1]);
    }
}
