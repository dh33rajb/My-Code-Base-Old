
// ########## OBSELETE ######## I am gonna chnage this question and restructure the code later

// ##### Check this instead:  IsAvlTree.java #######

/*
Find if a Binary Tree is balanced

Unbalanced BST: http://upload.wikimedia.org/wikipedia/commons/f/f7/Binary_tree.svg

Logic:
------

1. Find the height of the tree using DFS

2. Find the total number of nodes in a tree

3. Check for total number of given nodes, what the technical height should be.. if (n==even) height = n/2 ||| if (n==odd) height = (n+1)/2
*/

import java.util.*;
import java.lang.*;

public class IsBinaryTreeBalanced {
    private static int maxHeightOfTree;
    private static int verticesCount;
    public static void main (String args[]) {
        maxHeightOfTree = 1;
        verticesCount=0;
        // Step-1: create an unbalanced binary tree
        Node rootNode = initializeBinTree ();
        
        // Step-2: In-order traversal to validate tree creation
        printInOrderTraversal(rootNode);
        
        // Step-3: Find the maximum height of the tree
        findMaxHeightOfTree (rootNode, maxHeightOfTree);
        System.out.println ("maxHeightOfTree: " + maxHeightOfTree + "Vertices count: " + verticesCount);
        
        // Step-4: final checks
        /*if ((verticesCount % 2 != 0) && maxHeightOfTree > (verticesCount + 1)/4)
            System.out.println ("Unbalanced BST");
        else if ((verticesCount % 2 == 0) && maxHeightOfTree > (verticesCount)/4)
            System.out.println ("Unbalanced BST");
        else
            System.out.println ("Balanced BST");*/
            
        int expectedVal = (int) Math.ceil (Math.log (verticesCount+1) / Math.log (2));
        System.out.println ("Max current height: " + maxHeightOfTree + "Max expected val: " + expectedVal);
        
    }
    
    public static void findMaxHeightOfTree (Node rootNode, int height) {
        // System.out.println ("Node val: " + rootNode.value + "; height: " + height);
        if (rootNode != null) {
            if (rootNode.leftChild==null && rootNode.rightChild == null) { // implies we have come to the leaf node
                if (maxHeightOfTree < height) {
                    // System.out.println ("**Node val: " + rootNode.value + "; height: " + height);
                    maxHeightOfTree = height;
                }
            } else {
                int ht = ++height;
                if (rootNode.leftChild!=null)
                    findMaxHeightOfTree (rootNode.leftChild, ht);
                if (rootNode.rightChild!=null)
                    findMaxHeightOfTree (rootNode.rightChild, ht);
            }
        }
        
    }
    
    public static Node printInOrderTraversal (Node rootNode) {
        if (rootNode!=null) {
            printInOrderTraversal (rootNode.leftChild);
            // System.out.print (rootNode.value + " ");
            verticesCount++;
            printInOrderTraversal (rootNode.rightChild);
        }
        return rootNode;
    }
    
    public static Node initializeBinTree() {
        Node rootNode = new Node ();
        rootNode.value = 2;
        rootNode.leftChild = new Node ();
        rootNode.leftChild.value = 7;
        rootNode.leftChild.leftChild = new Node ();
        rootNode.leftChild.leftChild.value = 2;
        rootNode.leftChild.rightChild = new Node ();
        rootNode.leftChild.rightChild.value = 6;
        rootNode.leftChild.rightChild.leftChild = new Node ();
        rootNode.leftChild.rightChild.leftChild.value = 5;
        rootNode.leftChild.rightChild.rightChild = new Node ();
        rootNode.leftChild.rightChild.rightChild.value = 11;
        rootNode.rightChild = new Node ();
        rootNode.rightChild.value = 5;
        rootNode.rightChild.rightChild = new Node ();
        rootNode.rightChild.rightChild.value = 9;
        rootNode.rightChild.rightChild.leftChild = new Node ();
        rootNode.rightChild.rightChild.leftChild.value = 4;
        
        return rootNode;
    }
}

class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
}
