// ##### INCOMPLETE... A small mistake in logic exists.. work in progress..

/*
AVL TREES
*/

import java.util.*;
import java.lang.*;

public class MyAVLTree {
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
                
                // Avl Logic - Case 1
                if (rootNode.leftChild.leftChild != null && rootNode.rightChild == null) {
                    System.out.println ("LL->" + rootNode.leftChild.leftChild.value);
                    int grandParValue = rootNode.value;
                    int parValue = rootNode.leftChild.value;
                    int childValue = rootNode.leftChild.leftChild.value;
                    
                    List<Integer> list = new ArrayList <Integer> (Arrays.asList (new Integer [] {grandParValue, parValue, childValue}));
                    Collections.sort (list);
                    System.out.println (list);
                    
                    rootNode.value = list.get (1);
                    rootNode.leftChild.value = list.get (0);
                    rootNode.rightChild = new Node (list.get (2), rootNode.leftChild.height);
                    
                    rootNode.leftChild.leftChild = null;
                    
                }
                
                // Avl Logic - Case 2
                else if (rootNode.leftChild.rightChild != null && rootNode.rightChild == null) {
                    System.out.println ("LR->" + rootNode.leftChild.rightChild.value);
                    int grandParValue = rootNode.value;
                    int parValue = rootNode.leftChild.value;
                    int childValue = rootNode.leftChild.rightChild.value;
                    
                    List<Integer> list = new ArrayList <Integer> (Arrays.asList (new Integer [] {grandParValue, parValue, childValue}));
                    Collections.sort (list);
                    
                    rootNode.value = list.get (1);
                    rootNode.leftChild.value = list.get (0);
                    rootNode.rightChild = new Node (list.get (2), rootNode.leftChild.height);
                    
                    rootNode.leftChild.rightChild = null;
                }
                
            } else if (value > rootNode.value) {
                rootNode.rightChild = insertNode (rootNode.rightChild, value, childHeight);
                
                // Avl Logic - Case 3
                if (rootNode.rightChild.leftChild != null && rootNode.leftChild == null) {
                    System.out.println ("RL->" + rootNode.rightChild.leftChild.value);
                    int grandParValue = rootNode.value;
                    int parValue = rootNode.rightChild.value;
                    int childValue = rootNode.rightChild.leftChild.value;
                    
                    List<Integer> list = new ArrayList <Integer> (Arrays.asList (new Integer [] {grandParValue, parValue, childValue}));
                    Collections.sort (list);
                    
                    rootNode.value = list.get (1);
                    rootNode.rightChild.value = list.get (2);
                    rootNode.leftChild = new Node (list.get (0), rootNode.rightChild.height);
                    
                    rootNode.rightChild.leftChild = null;
                    
                }
                
                // Avl Logic - Case 4
                else if (rootNode.rightChild.rightChild != null && rootNode.leftChild == null) {
                    System.out.println ("RR->" + rootNode.rightChild.rightChild.value);
                    int grandParValue = rootNode.value;
                    int parValue = rootNode.rightChild.value;
                    int childValue = rootNode.rightChild.rightChild.value;
                    
                    List<Integer> list = new ArrayList <Integer> (Arrays.asList (new Integer [] {grandParValue, parValue, childValue}));
                    Collections.sort (list);
                    
                    rootNode.value = list.get (1);
                    rootNode.rightChild.value = list.get (2);
                    rootNode.leftChild = new Node (list.get (0), rootNode.rightChild.height);
                    
                    rootNode.rightChild.rightChild = null;
                    
                }
                
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
