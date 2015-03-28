/*
Conflicting intervals -2
*/

import java.util.*;
import java.lang.*;

public class ThreadConflictingTimes {
    public static void main (String args[]) {
        
        List <ThreadClass> threadOneList = new ArrayList <ThreadClass> ();
        List <ThreadClass> threadTwoList = new ArrayList <ThreadClass> ();
        
        // Step-1: Read inputs from console & populating our variables
        Scanner scanner = new Scanner (System.in);
        String[] line1 = scanner.nextLine().split (";");
        String[] line2 = scanner.nextLine().split (";");
        
        String inputTime = scanner.nextLine();
        
        for (String s : line1 ) {
            ThreadClass tc = new ThreadClass();
            String[] timeSplit = s.split ("-");
            tc.startTime = timeSplit[0].trim ();
            tc.endTime = timeSplit[1].trim();
            threadOneList.add (tc);
        }
        
        for (String s : line2 ) {
            ThreadClass tc = new ThreadClass();
            String[] timeSplit = s.split ("-");
            tc.startTime = timeSplit[0].trim ();
            tc.endTime = timeSplit[1].trim();
            threadTwoList.add (tc);
        }
        
        // Step-2: Add the elements of these two lists in a single list such that the lists are sorted based on start times
        List <ThreadClass> allThreadList = new ArrayList <ThreadClass> ();
        int i = 0; int j = 0;
        while (i < threadOneList.size() && j < threadTwoList.size()) {
            String threadOneStartTime = threadOneList.get (i).startTime;
            String threadTwoStartTime = threadTwoList.get (j).startTime;
            // System.out.println ("i>j " + i + "> " + j);
            if (threadOneStartTime.compareTo(threadTwoStartTime) < 0) {
                allThreadList.add (threadOneList.get (i));
                i++;
            } else if (threadOneStartTime.compareTo(threadTwoStartTime) > 0) {
                allThreadList.add (threadTwoList.get (j));
                j++;
            } else {
                String threadOneEndTime = threadOneList.get (i).endTime;
                String threadTwoEndTime = threadTwoList.get (j).endTime;
                if (threadOneEndTime.compareTo(threadTwoEndTime) <= 0) {
                    allThreadList.add (threadOneList.get (i));
                    i++;
                } else if (threadOneEndTime.compareTo(threadTwoEndTime) > 0) {
                    allThreadList.add (threadTwoList.get (j));
                    j++;
                }
            }
        }
        
        while (i < threadOneList.size()) {
            allThreadList.add (threadOneList.get (i++));
        }
        while (j < threadTwoList.size()) {
            allThreadList.add (threadTwoList.get (j++));
        }
        // Step-3: Now find the threads running at a particular time
        
        for (ThreadClass t : allThreadList) {
            if (inputTime.compareTo (t.startTime) >=0 && inputTime.compareTo (t.endTime) < 0) {
                System.out.println ("Thread running between " + t.startTime + "-" + t.endTime + " counts.");
            }
        }
    }
}

class ThreadClass {
    // Defining variables as public and not using private with getters and setters for sake of simplicity in demonstration
    public String startTime;
    public String endTime;
}

