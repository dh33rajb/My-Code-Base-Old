/*
Binary search tree - traversals
--------------------------------
Given a sorted character set,

1. Represent the sorted data set as a binary tree. i.e. we need to have a root node, from where we can get to any node in the binary tree.
2. Print the in-order, pre-order and post-order traversals of the data set

Ex:
--
Input: A B C D E F G H I J K

Output:

In-order: A B C D E F G H I J K
Pre-order: F D B A C E J G I H K
Post-order: A C B E D H I G K J F
*/

import java.util.*;
import java.lang.*;

public class BstAndTraversals {
    
    private static Node rootNode;
    
    public static void main (String args[]) {
        // Step-1: read input
        Scanner scanner = new Scanner (System.in);
        int inputSize = scanner.nextInt();
        char input [] = new char[inputSize];
        int count=0;
        while (scanner.hasNext()) {
            input[count++] = (scanner.next()).charAt(0);
        }

        // Step-2: Construct a binary search tree out of an array using recursion
        rootNode = constructBST(rootNode, input, 0, input.length);
        
        // Step-3: In-Order Traversal print
        System.out.println ("In order traversal of the BST: ");
        performInOrderTraversal (rootNode);
    }
    
    public static Node constructBST (Node node, char input [], int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;
        System.out.println (midIndex);
        if (midIndex > startIndex && midIndex < endIndex ) {
            node = new Node();
            node.value =  input[midIndex];
            node.leftChild = constructBST (null, input, 0, midIndex-1);
            node.rightChild = constructBST (null, input, midIndex+1, endIndex);
        }
        return node;
    }
    
    public static void performInOrderTraversal(Node node) {
        if (node != null) {
            performInOrderTraversal(node.leftChild);
            System.out.print (node.value + " - ");
            performInOrderTraversal(node.rightChild);
        } else {
            return;
        }
    }
}

class Node {
    public Node leftChild;
    public Node rightChild;
    public char value;
}
