/*
Print the outer nodes of a tree.. i.e. Left nodes of left child and right nodes of right child
*/

import java.util.*;
import java.lang.*;

public class OuterNodesOfTree {
    private static Set <Integer> set = new LinkedHashSet <Integer> ();
    public static void main (String args[]) {
        // Step-1: Create a binary tree
        Node rootNode = getAnotherBinaryTree ();
        
        // Step-2: Trverse and print top view of binary tree
        printTopView (rootNode, true, true);
        
        System.out.println (set);
    }

    public static void printTopView (Node rootNode, boolean leftFlag, boolean rightFlag) {
        if (rootNode!=null) {
            if (leftFlag) {
                printTopView (rootNode.leftChild, true, false);
                set.add (rootNode.value);
            }
            if (rightFlag) {
                set.add (rootNode.value);
                printTopView (rootNode.rightChild, false, true);
            }
        }
    }
    
    /*
               1
            /    \
           2      3
          /  \   / \
         4    5 6   7
    
    */
    public static Node getBinaryTree () {
        Node rootNode = new Node (1);
        rootNode.leftChild = new Node (2);
        rootNode.rightChild = new Node (3);
        
        rootNode.leftChild.leftChild = new Node (4);
        rootNode.leftChild.rightChild = new Node (5);
        
        rootNode.rightChild.leftChild = new Node (6);
        rootNode.rightChild.rightChild = new Node (7);
        
        return rootNode;
    }
    
    /*
            1
           /  \
          2    3
           \
            4
             \
              5
               \
                6*/
    */
    public static Node getAnotherBinaryTree () {
        Node rootNode = new Node (1);
        rootNode.leftChild = new Node (2);
        rootNode.rightChild = new Node (3);
        
        rootNode.leftChild.rightChild = new Node (4);
        rootNode.leftChild.rightChild.rightChild = new Node (5);
        rootNode.leftChild.rightChild.rightChild.rightChild = new Node (6);
        
        return rootNode;
    }
}

class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    public int level;
    public Node (int val) {
        this.value = val;
    }
}
