/*
Given a list of characters, find the first character that has a duplicate.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCharacter {
    public static void main (String args[]) {
        
        // Step-0: Initialization
        Map <Character, Boolean> map = new HashMap <Character, Boolean>();
        
        
        // Step-1: Read input
        Scanner scanner = new Scanner (System.in);
        String inputStr = scanner.nextLine();
        
        char [] inputArr = inputStr.toCharArray();
        
        // Step-2: Core logic
        for (char c : inputArr) {
            if (map.get (c) == null) {
                map.put (c, true);
            } else {
                System.out.println ("Character '" + c + "' is the first repeated character.");
                break;
            }
        }
        
    }
}
