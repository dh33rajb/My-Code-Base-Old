/*
Shell of a tree --> Print the shell nodes of a binary tree
                        or
Example Tree: http://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/pix/tree1.bmp
*/

import java.util.*;
import java.lang.*;

public class ShellNodesOfTree {
    public static void main (String args[]) {
        
        // Step-1: Create a binary tree manually
        Node rootNode = createBinaryTree();
        rootNode.level = 1;
        
        // Step-2: Level order traversal
        printLevelOrderTraversal (rootNode);
    }
    
    public static void printLevelOrderTraversal (Node rootNode) {
        Node lastEnteredNode = rootNode;
        Queue <Node> queue = new LinkedList <Node> ();
        queue.add (rootNode);
        while (queue.size() > 0) {
            Node poppedNode = queue.poll ();
            if (poppedNode.leftChild != null) {
                poppedNode.leftChild.level = poppedNode.level + 1;
                if (lastEnteredNode.level != poppedNode.leftChild.level) {
                    System.out.print (lastEnteredNode.value + " - " + poppedNode.leftChild.value + " - ");
                }
                lastEnteredNode = poppedNode.leftChild;
                queue.add (poppedNode.leftChild);
            }
            if (poppedNode.rightChild != null) {
                poppedNode.rightChild.level = poppedNode.level + 1;
                if (lastEnteredNode.level != poppedNode.rightChild.level)
                   System.out.print (lastEnteredNode.value + " - " + poppedNode.rightChild.value + " - ");
                lastEnteredNode = poppedNode.rightChild;
                queue.add (poppedNode.rightChild);
            }
            // System.out.print (poppedNode.value + " ");
        }
    }
    
    public static Node createBinaryTree () {
        Node rootNode = new Node();
        rootNode.value = 8;
        
        rootNode.leftChild = new Node();
        rootNode.leftChild.value = 5;
        
        rootNode.leftChild.leftChild = new Node();
        rootNode.leftChild.leftChild.value = 9;
        
        rootNode.leftChild.rightChild = new Node();
        rootNode.leftChild.rightChild.value = 7;
        
        rootNode.leftChild.rightChild.leftChild = new Node();
        rootNode.leftChild.rightChild.leftChild.value = 1;
        
        rootNode.leftChild.rightChild.rightChild = new Node();
        rootNode.leftChild.rightChild.rightChild.value = 12;
        
        rootNode.leftChild.rightChild.rightChild.leftChild = new Node();
        rootNode.leftChild.rightChild.rightChild.leftChild.value = 2;
        
        rootNode.rightChild = new Node();
        rootNode.rightChild.value = 4;
        
        rootNode.rightChild.rightChild = new Node();
        rootNode.rightChild.rightChild.value = 11;
        
        rootNode.rightChild.rightChild.leftChild = new Node();
        rootNode.rightChild.rightChild.leftChild.value = 3;
        
        return rootNode;
    }
}

class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    public int level;
}
