package org.home.practise.CtCi.trees_and_graphs;

import org.home.practise.CtCi.library.BinaryTreeNode;
import org.home.practise.CtCi.library.util.BinaryTreeUtil;

public class SubTree<T> {

	public boolean isSubTree(final BinaryTreeNode<T> largeTree, final BinaryTreeNode<T> smallTree) {
		return false;
	}
	
	public static void main(String[] args) {
		final BinaryTreeUtil binaryTreeUtil = new BinaryTreeUtil();
		
		/**
		 *     A       
		 *	  / \   
	 	 *	 /   \  
		 *	 B   C   
		 *	/ \ /   
		 *  D E F
		 *  
		 */
		final BinaryTreeNode<Character> largeTree = binaryTreeUtil
				.generateBinaryTree(new Character[] {'D', 'B', 'E', 'A', 'F', 'C'}, new Character[] {'A', 'B', 'D', 'E', 'C', 'F'});
		
		/**
		 *	 B
		 *	/ \ 
		 *  D E
		 *  
		 */
		final BinaryTreeNode<Character> smallTree = binaryTreeUtil
				.generateBinaryTree(new Character[]{'D', 'B', 'E'}, new Character[]{'B', 'D', 'E'});
		
//		final BinaryTreePrinter tree = new BinaryTreePrinter();
//		tree.printNode(largeTree);
		
		final SubTree<Character> subTree = new SubTree<Character>();
		
		System.out.println(subTree.isSubTree(largeTree, smallTree));
		
	}
}
