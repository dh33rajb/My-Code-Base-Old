/*
Find the interavls with overlaps
--------------------------------

Input: Two lists that contain sets of time slots

List 1 --> 9 - 10; 11.30 - 12.30; 13 - 14; 15-17; 17.30 - 18; 19-19.30; 20-21
List 2 --> 7-8; 9.30-12; 13-13.30; 14-15; 16-17.30; 17.30-18.30; 19.30-21

Output: a list that contains time slots that have conflicts

List --> 9.30-10; 11.30-12; 13-13.30; 17.30-18; 20-21
*/

import java.util.*;
import java.lang.*;

public class ConflictingIntervals {
    public static void main (String args[]) {
        
        List<Interval> firstList = new ArrayList <Interval> ();
        List<Interval> secondList = new ArrayList <Interval> ();
        
        // Step-1: Read inputs
        Scanner scanner = new Scanner (System.in);
        String[] firstInput = (scanner.nextLine()).split(";");
        String[] secondInput = (scanner.nextLine()).split(";");
        
        for (String s : firstInput) {
            String[] timeStrings = s.split ("-");
            Interval i = new Interval ();
            i.startTime = Float.valueOf(timeStrings[0].trim());
            i.endTime = Float.valueOf(timeStrings[1].trim());
            firstList.add (i);
            // System.out.println (i.startTime + " - " + i.endTime);
        }
        
        for (String s : secondInput) {
            String[] timeStrings = s.split ("-");
            Interval i = new Interval ();
            i.startTime = Float.valueOf(timeStrings[0].trim());
            i.endTime = Float.valueOf(timeStrings[1].trim());
            secondList.add (i);
            // System.out.println (i.startTime + " - " + i.endTime);
        }
        
        // Step-2: Merge the two lists
        List <Interval> mergedList = new ArrayList <Interval> ();
        mergedList.addAll (firstList);
        mergedList.addAll (secondList);
        
        // Step-3: sort the lists based on their start times
        
        Collections.sort (mergedList, new Comparator <Interval> () {
            @Override
            public int compare (Interval i1, Interval i2) {
                Float f1 = i1.startTime;
                Float f2 = i2.startTime;
                return f1.compareTo (f2);
            }
            });
    }
}

class Interval {
    public float startTime;
    public float endTime;
}
