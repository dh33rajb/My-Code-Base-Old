/* fibonnacci using dynamic programming
*/

import java.util.*;
import java.lang.*;

public class FibonnacciDynamic {
    public static void main (String args[]) {
        
        // Step-1: Read inputs from console
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        
        // Step-2: Core logic
        int [] fib = new int [2];
        fib[0] = 0;
        fib[1] = 1;
        
        for (int i=2; i <= n; i++) {
            System.out.print (fib[1] + " ");
            int f = fib[0] + fib[1];
            fib[0] = fib [1];
            fib[1] = f;
        }
    }
}
