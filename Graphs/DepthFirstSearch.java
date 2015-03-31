/*
Graphs - Code 3: DETECT A CYCLE IN A GRAPH (DIRECT APPLICATION OF DEPTH FIRST SEARCH)
--------------------------------------------------------------------------------------
Depth first search of a graph. --> DFS uses Stack datastructure --> We use Adjacency List representation --> No recursion in DFS

Cyclic Graph: http://www.geeksforgeeks.org/wp-content/uploads/DFS.jpg

Acyclic graph: http://upload.wikimedia.org/wikipedia/commons/3/39/Directed_acyclic_graph_3.svg


Input: 
Line 1: List of vertices
Next lines: edge connections

Ex:
2    3   5   7   8   9   10  11
5   11
11  10
11  2
11  9
7   11 
7   8
3   8
3   10
*/

import java.util.*;
import java.lang.*;

public class DepthFirstSearch {
    
    private static Map <Integer, List<Integer>> graph;
    private static Map <Integer, Boolean> visitedVerticesMap; // this is used to check if a vertex has been visited by the DFS algorithm
    private static boolean doesCycleExist;
    
    public static void main (String args[]) {
        
        // Step-1: Reading inputs & Initialization
        graph = new HashMap <Integer, List<Integer>> ();
        visitedVerticesMap = new HashMap <Integer, Boolean>();
        doesCycleExist = false;
        
        Scanner scanner = new Scanner (System.in);
        
        String [] vertices = scanner.nextLine().split("\\s+");
        for (String s : vertices) {
            visitedVerticesMap.put (Integer.valueOf(s), false);
        }
        while (scanner.hasNext()) {
            String [] edges = scanner.nextLine().split ("\\s+");
            addEdge(Integer.valueOf(edges[0]), Integer.valueOf(edges[1]));
        }
        
        // print the Adjacency list
        /*for (Map.Entry e : graph.entrySet()) {
            System.out.println (e.getKey() + "-->" + e.getValue());
        }*/

        // Step-2: DFS Algorithm
        
        // Step-2.1: we need to consider each node as "source" node to test cycle
        
        for (Map.Entry verticesEntry : visitedVerticesMap.entrySet()) {
            Map <Integer, Boolean> tempMap = visitedVerticesMap;
            Stack<Integer> dfsStack = new Stack<Integer> ();
            int currentSourceVertex = (int) verticesEntry.getKey();
            dfsStack.push (currentSourceVertex); // starting node == 2.. so we start out DFS from here
            tempMap.put(currentSourceVertex, true);
            
            // core DFS
            while (dfsStack.size() > 0) {
                int topOfStack = dfsStack.peek();
                System.out.print (topOfStack + "-->");
                List<Integer> outEdges = graph.get (topOfStack);
                int flag=0;
                if (outEdges!= null) {
                    for (int o : outEdges) {
                        if (tempMap.get (o) == false) {
                            dfsStack.push (o);
                            tempMap.put (o, true);
                            flag=1;
                            break;
                        } else {
                            doesCycleExist = true;
                        }
                    }
                }
                if (flag==0) {
                    dfsStack.pop ();
                }
            }
            System.out.println();
        }
        if (doesCycleExist)
            System.out.println ("Cyclic graph");
        else
            System.out.println ("Acyclic graph");
        
    }
    
    public static void addEdge (int i, int j) {
        List <Integer> outEdges = null;
        if (graph.get(i) == null)
            outEdges = new LinkedList <Integer> ();
        else
            outEdges = graph.get(i);
        outEdges.add (j);
        graph.put (i, outEdges);
    }
}
