/*
BST TREES
*/

import java.util.*;
import java.lang.*;

public class MyBST {
    public static void main (String args[]) {
        
        // Step-0: Initialization
        Node rootNode = null;
        
        // Step-1: Reading inputs from the console and inserting node to tree
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt()) {
            int nodeValue = scanner.nextInt();
            rootNode = insertNode (rootNode, nodeValue, 0);
        }
        
        // Step-3: Check if the nodes have been added properly.. this can be done by traversal
        printInOrderTraversal (rootNode);
        
    }
    
    public static void printInOrderTraversal (Node rootNode) {
        if (rootNode != null) {
            printInOrderTraversal (rootNode.leftChild);
            System.out.print (rootNode.value + "-" + rootNode.height + " ");
            printInOrderTraversal (rootNode.rightChild);
        }
    }
    
    public static Node insertNode (Node rootNode, int value, int height) {
        if (rootNode != null) {
            int childHeight = height + 1;
            if (value <= rootNode.value) {
                rootNode.leftChild = insertNode (rootNode.leftChild, value, childHeight);
            } else if (value > rootNode.value) {
                rootNode.rightChild = insertNode (rootNode.rightChild, value, childHeight);
            }
        } else {
            rootNode = new Node (value, height);
        }
        return rootNode;
    }
}

class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    public int height;
    
    public Node (int value, int height) {
        this.value = value;
        this.height = height;
    }
}
