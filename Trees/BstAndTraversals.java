/*
Binary search tree - traversals
--------------------------------
Given a sorted character set,
1. Represent the sorted data set as a binary tree. i.e. we need to have a root node, from where we can get to any node in the binary tree.
2. Print the in-order, pre-order and post-order traversals of the data set
Ex:
-- 
Input: 
11
A B C D E F G H I J K

Output:
In-order: A B C D E F G H I J K
Pre-order: F C A B D E I G H J K
Post-order: B A E D C H G K J I F
*/
import java.util.*;
import java.lang.*;
public class BstAndTraversals {
	private static Node rootNode;
	public static void main(String args[]) {
	    
		// Step-1: read input
		Scanner scanner = new Scanner(System. in );
		int inputSize = scanner.nextInt();
		char input[] = new char[inputSize];
		int count = 0;
		while (scanner.hasNext()) {
			input[count++] = (scanner.next()).charAt(0);
		}
		
		// Step-2: Construct a binary search tree out of an array using recursion
		rootNode = constructBST(rootNode, input, 0, input.length-1);
		
		// Step-3: In-Order Traversal print
		System.out.println("In order traversal of the BST: ");
		performInOrderTraversal(rootNode);
		
		// Step-4: Pre-order Traversal print
		System.out.println ("\nPre order traversal of the BST: ");
		performPreOrderTraversal(rootNode);
		
		// Step-4: Post-order Traversal print
		System.out.println ("\nPost order traversal of the BST: ");
		performPostOrderTraversal(rootNode);
		
	}
	public static Node constructBST(Node node, char input[], int startIndex, int endIndex) {
		int midIndex = (startIndex + endIndex) / 2;
		if (midIndex >= startIndex && midIndex <= endIndex) {
			node = new Node();
			node.value = input[midIndex];
			node.leftChild = constructBST(null, input, startIndex, midIndex - 1);
			node.rightChild = constructBST(null, input, midIndex + 1, endIndex);
		}
		return node;
	}
	
	public static void performInOrderTraversal(Node node) {
		if (node != null) {
			performInOrderTraversal(node.leftChild);
			System.out.print(node.value + " ");
			performInOrderTraversal(node.rightChild);
		}
	}
	
	public static void performPreOrderTraversal (Node node) {
	    if (node != null) {
	        System.out.print(node.value + " ");
	        performPreOrderTraversal(node.leftChild);
			performPreOrderTraversal(node.rightChild);
	    }
	}
	
	public static void performPostOrderTraversal (Node node) {
	     if (node != null) {
	        performPostOrderTraversal(node.leftChild);
			performPostOrderTraversal(node.rightChild);
			System.out.print(node.value + " ");
	    }
	}
}
class Node {
	public Node leftChild;
	public Node rightChild;
	public char value;
}
