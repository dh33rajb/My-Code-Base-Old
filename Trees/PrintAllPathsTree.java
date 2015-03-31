/*
Print all paths in a tree

Height = longest path from root node to leaf child

1. we create a binary search tree, for sake of better learning
2. we then compute paths of tree... we use DFS

Ex:

*/

import java.util.*;
import java.lang.*;

public class PrintAllPathsTree {
    public static void main (String args[]) {
        
        // Step-0: Initialization
        Node rootNode = null;
                
        // Step-1: Read inputs from console
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt ()) {
            int val = scanner.nextInt();
            rootNode = insertIntoTree (rootNode, val, 0);
        }
        
        // Step-2: printing the in-order traversal for verifying functionality
        // printInOrderTraversal (rootNode);
        
        // Step-3: Print all paths
        printAllPaths (rootNode, new ArrayList<Integer> ());
    }
    
    public static void printAllPaths (Node rootNode, List <Integer> pathList) {
        if (rootNode != null) {
            pathList.add (rootNode.value);
            if (rootNode.leftChild == null && rootNode.rightChild == null) {
                System.out.println (pathList);
            } 
            else {
                if (rootNode.leftChild != null) {
                    List<Integer> tempList = new ArrayList <Integer> ();
                    tempList.addAll (pathList);
                    printAllPaths (rootNode.leftChild, tempList);
                } if (rootNode.rightChild != null) {
                    List<Integer> tempList = new ArrayList <Integer> ();
                    tempList.addAll (pathList);
                    printAllPaths (rootNode.rightChild, tempList);
                }
            }
        }
    }
    
    public static void printInOrderTraversal (Node rootNode) {
        if (rootNode != null) {
            printInOrderTraversal (rootNode.leftChild);
            System.out.println ("Node value: " + rootNode.value + " Node depth: " + rootNode.depth + " Node height: " + rootNode.height);
            printInOrderTraversal (rootNode.rightChild);
        }
    }
    
    public static Node insertIntoTree (Node rootNode, int value, int depth) {
        if (rootNode != null) {
            int val = rootNode.value;
            int leftHeight = 0;
            int rightHeight = 0;
            if (value <= val) {
                rootNode.leftChild = insertIntoTree (rootNode.leftChild, value, depth+1);
                leftHeight = rootNode.leftChild.height + 1;
            } else {
                rootNode.rightChild = insertIntoTree (rootNode.rightChild, value, depth+1);
                rightHeight = rootNode.rightChild.height + 1;
            }
            if (rightHeight >= leftHeight)
                rootNode.height = Math.max (rootNode.height, rightHeight);
            else
                rootNode.height = Math.max (rootNode.height, leftHeight);
        } else {
            rootNode = new Node (value, depth);
            rootNode.height = 0;
        }
        return rootNode;
    }
}

class Node {
    public int value;
    public int height;
    public int depth;
    public Node leftChild;
    public Node rightChild;
    
    public Node (int value, int depth) {
        this.value = value;
        this.depth = depth;
    }
}
