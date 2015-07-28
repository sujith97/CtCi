package org.home.practise.CtCi.library.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.home.practise.CtCi.library.BinaryTreeNode;

public class BinaryTreeUtil {

	/**
	 * Prints the InOrder traversal from the given node.
	 * @param binaryTreeNode the node from where InOrder Traversal has to be made.
	 */
	public static void printInOrder(final BinaryTreeNode<?> binaryTreeNode) {
		System.out.print("In Order: ");
		inOrder(binaryTreeNode);
	}
	
	/**
	 * 
	 * @param binaryTreeNode
	 */
	private static void inOrder(final BinaryTreeNode<?> binaryTreeNode) {
		if (binaryTreeNode != null) {
			inOrder(binaryTreeNode.getLeftChild());
			System.out.print(binaryTreeNode.getNodeValue() + "    ");
			inOrder(binaryTreeNode.getRightChild());
		}
	}
	
	/**
	 * 
	 * @param inOrder
	 * @param preOrder
	 * @return
	 */
	public <T> BinaryTreeNode<T> generateBinaryTree(final T[] inOrder, final T[] preOrder) {
		return generateTree(new ArrayList<T>(Arrays.asList(inOrder)), new ArrayList<T>(Arrays.asList(preOrder)));
	}
	
	/**
	 * Generates a binary tree from in-order and pre-order lists.
	 * @param inOrder the inorder for the binary tree.
	 * @param preOrder the preorder for the binary tree.
	 * @return the root of the Binary Tree.
	 */
	private <T> BinaryTreeNode<T> generateTree(final List<T> inOrder, final List<T> preOrder) {
		if (inOrder.isEmpty() || preOrder.isEmpty()) {
			return null;
		} else {
			final BinaryTreeNode<T> currentNode = new BinaryTreeNode<T>();
			int i = 0;
			for(; i < inOrder.size(); i++) {
				if (preOrder.get(0) == inOrder.get(i)) {
					break;
				}
			}
			currentNode.setNodeValue(preOrder.get(0));
			currentNode.setLeftChild(generateTree(inOrder.subList(0, i), preOrder.subList(1, i + 1)));
			currentNode.setRightChild(generateTree(inOrder.subList(i + 1, inOrder.size()), preOrder.subList(i + 1, preOrder.size())));
			return currentNode;
		}
	}
}
