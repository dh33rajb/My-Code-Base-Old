/*
Height of a Tree

Height = longest path from root node to leaf child

1. we create a binary search tree, for sake of better learning
2. we then gauge the height of the tree

Ex:

Input:
2 4 0 1 8 6 7 3 9

Output:
Node value: 0 Node depth: 1 Node height: 1
Node value: 1 Node depth: 2 Node height: 0
Node value: 2 Node depth: 0 Node height: 4
Node value: 3 Node depth: 2 Node height: 0
Node value: 4 Node depth: 1 Node height: 3
Node value: 6 Node depth: 3 Node height: 1
Node value: 7 Node depth: 4 Node height: 0
Node value: 8 Node depth: 2 Node height: 2
Node value: 9 Node depth: 3 Node height: 0
*/

import java.util.*;
import java.lang.*;

public class HeightOfTree {
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
        printInOrderTraversal (rootNode);
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
