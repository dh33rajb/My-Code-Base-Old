// ##### WORK IN PROGRESS... #####

/*
Balance a Binary Search tree
        or
Height balance a Binary Search Tree
        or
Make an AVL tree out of a Binary Search tree

Theory: http://www.youtube.com/watch?v=5C8bLQBjcDI && http://www.youtube.com/watch?v=YKt1kquKScY

Example: http://jriera.webs.ull.es/Docencia/avl_handout.pdf (This is just about the perfect example)

*/

import java.util.*;
import java.lang.*;

public class BuildAvlTree {
    public static void main (String args[]) {
        List<Integr> inputNodesList = new ArrayList <Integer>();
        // Step-1: read from scanner the nodes we need to insert
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNextInt())
            inputNodesList.add (scanner.nextInt());
        System.out.println (inputNodesList);
        
        // Step-2: Insertion such that 1) Tree remains a BST and 2) Tree is at all times Height Balanced
        
    }
}
