/*
Sorting and Searching using AVL trees.

*/

import java.util.*;
import java.lang.*;

public class MyAvlTree{
    public static void main (String args[]) {
        
        // Step-1: Reading inputs and adding them to an AVL tree
        Scanner scanner = new Scanner (System.in);
        Node rootNode = new Node (scanner.nextInt()); // root node creation
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            rootNode = insertNodeToTree (rootNode, val);
        }
        
        // Step-2: pre-order traversal to check how tree was constructed
        printPreOrderTraversal (rootNode);
    }
    
    public static void printPreOrderTraversal (Node rootNode) {
        if (rootNode != null) {
            System.out.print (rootNode.value + "-");
            printPreOrderTraversal (rootNode.leftChild);
            printPreOrderTraversal (rootNode.rightChild);
        }
    }
    
    public static Node insertNodeToTree (Node rootNode, int val) {
        if (rootNode != null) {
            if (val < rootNode.value) {
                rootNode.leftChild = insertNodeToTree (rootNode.leftChild, val);
                
                if (rootNode.leftChild.leftChild != null) {
                    Node grandPar = rootNode;
                    Node par = rootNode.leftChild;
                    Node child = rootNode.leftChild.leftChild;
                    List <Node> list = new ArrayList <Node> (new Comparator<Node> () {
                        @Override
                        public int compare (Node n1, Node n2) {
                            return n1.value.compare (n2.value);
                        }
                    });
                    rootNode = list.get (1);
                    rootNode.leftChild = list.get (0);
                    rootNode.rightChild = list.get (2);
                } 
            } else if (val > rootNode.value) {
                rootNode.rightChild = insertNodeToTree (rootNode.rightChild, val);
            } 
        }
        else {
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
