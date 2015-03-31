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
                System.out.println ("Step-1: " + rootNode.value + "-" + val);
                rootNode.leftChild = insertNodeToTree (rootNode.leftChild, val);
                if (rootNode.leftChild.leftChild != null && rootNode.rightChild==null) {
                    System.out.println ("11111");
                    Node grandPar = rootNode;
                    Node par = rootNode.leftChild;
                    Node child = rootNode.leftChild.leftChild;
                    List <Node> list = new ArrayList <Node> ();
                    list.add (grandPar); list.add (par); list.add (child);
                    Collections.sort (list, new Comparator<Node> () {
                        @Override
                        public int compare (Node n1, Node n2) {
                            Integer i1 = n1.value;
                            Integer i2 = n2.value;
                            return i1.compareTo (i2);
                        }
                    });
                    rootNode = list.get (1);
                    rootNode.leftChild = list.get (0);
                    rootNode.rightChild = list.get (2);
                    rootNode.leftChild.leftChild = null;
                }
                if (rootNode.leftChild.rightChild != null && rootNode.rightChild==null) {
                    System.out.println ("22222");
                    Node grandPar = rootNode;
                    Node par = rootNode.leftChild;
                    Node child = rootNode.leftChild.rightChild;
                    List <Node> list = new ArrayList <Node> ();
                    list.add (grandPar); list.add (par); list.add (child);
                    Collections.sort (list, new Comparator<Node> () {
                        @Override
                        public int compare (Node n1, Node n2) {
                            Integer i1 = n1.value;
                            Integer i2 = n2.value;
                            return i1.compareTo (i2);
                        }
                    });
                    rootNode = list.get (1);
                    rootNode.leftChild = list.get (0);
                    rootNode.rightChild = list.get (2);
                    rootNode.leftChild.rightChild = null;
                } 
            } else if (val > rootNode.value) {
                System.out.println ("Step-2: " + rootNode.value + "-" + val);
                rootNode.rightChild = insertNodeToTree (rootNode.rightChild, val);
                if (rootNode.rightChild.leftChild != null && rootNode.leftChild==null) {
                    System.out.println ("33333");
                    Node grandPar = rootNode;
                    Node par = rootNode.rightChild;
                    Node child = rootNode.rightChild.leftChild;
                    List <Node> list = new ArrayList <Node> ();
                    list.add (grandPar); list.add (par); list.add (child);
                    Collections.sort (list, new Comparator<Node> () {
                        @Override
                        public int compare (Node n1, Node n2) {
                            Integer i1 = n1.value;
                            Integer i2 = n2.value;
                            return i1.compareTo (i2);
                        }
                    });
                    rootNode = list.get (1);
                    rootNode.rightChild = list.get (0);
                    rootNode.leftChild = list.get (2);
                    rootNode.rightChild.leftChild = null;
                } 
                if (rootNode.rightChild.rightChild != null && rootNode.leftChild==null) {
                    System.out.println ("44444");
                    Node grandPar = rootNode;
                    Node par = rootNode.rightChild;
                    Node child = rootNode.rightChild.rightChild;
                    List <Node> list = new ArrayList <Node> ();
                    list.add (grandPar); list.add (par); list.add (child);
                    Collections.sort (list, new Comparator<Node> () {
                        @Override
                        public int compare (Node n1, Node n2) {
                            Integer i1 = n1.value;
                            Integer i2 = n2.value;
                            return i1.compareTo (i2);
                        }
                    });
                    rootNode = list.get (1);
                    rootNode.rightChild = list.get (0);
                    rootNode.leftChild = list.get (2);
                    rootNode.rightChild.rightChild = null;
                } 
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
