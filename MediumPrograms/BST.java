/*
Binary Search Tree Insertion and Sorting check using In-Order Traversal
*/

import java.util.*;
import java.lang.*;

public class BST{
    public static void main (String args[]) {
        
        // Step-1: Reading inputs and adding them to an AVL tree
        Scanner scanner = new Scanner (System.in);
        Node rootNode = new Node (scanner.nextInt()); // root node creation
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            rootNode = insertNodeToTree (rootNode, val);
        }
        
        // Step-2: pre-order traversal to check how tree was constructed
        printInOrderTraversal (rootNode);
    }
    
    public static void printInOrderTraversal (Node rootNode) {
        if (rootNode != null) {
            printInOrderTraversal (rootNode.leftChild);
            System.out.print (rootNode.value + "-");
            printInOrderTraversal (rootNode.rightChild);
        }
    }
    
    public static Node insertNodeToTree (Node rootNode, int val) {
        if (rootNode != null) {
            if (val < rootNode.value) {
                rootNode.leftChild = insertNodeToTree (rootNode.leftChild, val);
            } else if (val > rootNode.value) {
                rootNode.rightChild = insertNodeToTree (rootNode.rightChild, val);
            }
        } else {
            rootNode = new Node (val);
        }
        return rootNode;
    }
}

class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    
    public Node (int value) {
        this.value = value;
    }
}
