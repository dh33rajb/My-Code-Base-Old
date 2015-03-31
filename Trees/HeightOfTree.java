/*
Height of a Tree

Height = longest path from root node to leaf child

1. we create a binary search tree, for sake of better learning
2. we then gauge the height of the tree

Ex:

Input:
9 8 7 6 5 4 3 2 1

Output:
Node value: 1 Node depth: 8Node height: 0
Node value: 2 Node depth: 7Node height: 1
Node value: 3 Node depth: 6Node height: 2
Node value: 4 Node depth: 5Node height: 3
Node value: 5 Node depth: 4Node height: 4
Node value: 6 Node depth: 3Node height: 5
Node value: 7 Node depth: 2Node height: 6
Node value: 8 Node depth: 1Node height: 7
Node value: 9 Node depth: 0Node height: 8
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
            System.out.println ("Node value: " + rootNode.value + " Node depth: " + rootNode.depth + "Node height: " + rootNode.height);
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
                leftHeight = rootNode.leftChild.height;
            } else {
                rootNode.rightChild = insertIntoTree (rootNode.rightChild, value, depth+1);
                rightHeight = rootNode.rightChild.height;
            }
            if (leftHeight >= rightHeight)
                rootNode.height = leftHeight + 1;
            else
                rootNode.height = rightHeight + 1;
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
