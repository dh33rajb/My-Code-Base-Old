/*
Find if a Binary Tree is Balanced or not?

Examples: https://www.cs.auckland.ac.nz/software/AlgAnim/AVL.html
*/

import java.util.*;
import java.lang.*;

public class IsBinaryTreeBalanced {
    private static Node rootNode1;
    private static Node rootNode2; 
    private static boolean result;
    public static void main (String args[]) {
        
        // Step-1: Create two instances of Binary Trees.. 1) AVL 2) Not AVL for test purpose
        rootNode1 = getAvlTree ();
        rootNode2 = getNonAvlTree();
        
        // Step-2: Verify Tree construction
        printInOrderTraversal (rootNode1);
        System.out.println();
        printInOrderTraversal (rootNode2);
        System.out.println ();
        
        // Step-3: Find height of each node in a tree and save it in height variable of the Node class
        findHeightOfNodes (rootNode1, 0);
        findHeightOfNodes (rootNode2, 0);
        
        System.out.println ("Height of tree 1 & 2: " + rootNode1.height + ", " + rootNode2.height);
        
        // Step-4: see if for any particular node, the |(leftChild.value) - (rightChild.value)| > 1.
        // Note: I could have written the height logic in Step-3 itself, but I wanted it to be independent and I get more learning this way
        result = false;
        doesLeftRightHeightVaries (rootNode1);
        if (result)
            System.out.println ("The given tree-1 is not balanced");
        else
            System.out.println ("The given tree-1 is balanced");
            
        result = false;
        doesLeftRightHeightVaries (rootNode2);
        if (result)
            System.out.println ("The given tree-2 is not balanced");
        else
            System.out.println ("The given tree-2 is balanced");
    }
    
    public static void doesLeftRightHeightVaries (Node rootNode) {
        if (rootNode!= null) {
            int leftHeight = 0;
            int rightHeight = 0;
            if (rootNode.leftChild!= null) {
                leftHeight = rootNode.leftChild.height;
                doesLeftRightHeightVaries (rootNode.leftChild);
            }
            if (rootNode.rightChild!= null) {
                rightHeight = rootNode.rightChild.height;
                doesLeftRightHeightVaries (rootNode.rightChild);
            }
            if (Math.abs (leftHeight - rightHeight) > 1) {
                result = true;
            }
        }
    }
    
    public static int findHeightOfNodes (Node rootNode, int height) {
        if (rootNode!= null) {
            if (rootNode.leftChild == null && rootNode.rightChild == null) {
                // this is a leaf node
                rootNode.height = 0;
                // System.out.println ("Node & height: " + rootNode.value + " " + height);
                return ++height;
            } else {
                int leftHeight = 0;
                int rightHeight = 0;
                if (rootNode.leftChild != null) {
                    leftHeight = rootNode.leftChild.height = findHeightOfNodes (rootNode.leftChild, height);
                }
                if (rootNode.rightChild != null) {
                    rightHeight = rootNode.rightChild.height = findHeightOfNodes (rootNode.rightChild, height);
                }
                rootNode.height = Math.max (leftHeight, rightHeight);
                // System.out.println ("Node & height: " + rootNode.value + " " + Math.max (leftHeight, rightHeight));
                return Math.max (++leftHeight, ++rightHeight);
            }
        } return height;
    }
    
    public static void printInOrderTraversal(Node rootNode) {
        if (rootNode != null) {
            printInOrderTraversal (rootNode.leftChild);
            System.out.print (rootNode.value + " ");
            printInOrderTraversal (rootNode.rightChild);
        }
    }
    
    public static Node getAvlTree () {
        Node rootNode = new Node ();
        rootNode.value = 12;
        
        rootNode.leftChild = new Node ();
        rootNode.leftChild.value = 8;
        
        rootNode.leftChild.leftChild = new Node ();
        rootNode.leftChild.leftChild.value = 5;
        
        rootNode.leftChild.leftChild.leftChild = new Node ();
        rootNode.leftChild.leftChild.leftChild.value = 4;
        
        rootNode.leftChild.rightChild = new Node ();
        rootNode.leftChild.rightChild.value = 11;
        
        rootNode.rightChild = new Node ();
        rootNode.rightChild.value = 18;
        
        rootNode.rightChild.leftChild = new Node ();
        rootNode.rightChild.leftChild.value = 17;
        
        return rootNode;
    }
    
    public static Node getNonAvlTree () {
        Node rootNode = new Node ();
        rootNode.value = 12;
        
        rootNode.leftChild = new Node ();
        rootNode.leftChild.value = 8;
        
        rootNode.leftChild.leftChild = new Node ();
        rootNode.leftChild.leftChild.value = 5;
        
        rootNode.leftChild.leftChild.leftChild = new Node ();
        rootNode.leftChild.leftChild.leftChild.value = 4;
        
        rootNode.leftChild.leftChild.leftChild.leftChild = new Node ();
        rootNode.leftChild.leftChild.leftChild.leftChild.value = 2;
        
        rootNode.leftChild.leftChild.rightChild = new Node ();
        rootNode.leftChild.leftChild.rightChild.value = 7;
        
        rootNode.leftChild.rightChild = new Node ();
        rootNode.leftChild.rightChild.value = 11;
        
        rootNode.rightChild = new Node ();
        rootNode.rightChild.value = 18;
        
        rootNode.rightChild.leftChild = new Node ();
        rootNode.rightChild.leftChild.value = 17;
        
        return rootNode;
    }
}

class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    public int height;
}
