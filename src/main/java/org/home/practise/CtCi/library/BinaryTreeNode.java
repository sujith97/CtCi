package org.home.practise.CtCi.library;

/**
 * A Binary Tree Node.
 * @author sujithrb
 *
 * @param <T> the type of this node.
 */
public class BinaryTreeNode<T> {

	private T nodeValue;
	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;
	
	/**
	 * @return the nodeValue
	 */
	public T getNodeValue() {
		return nodeValue;
	}
	/**
	 * @param nodeValue the nodeValue to set
	 */
	public void setNodeValue(T nodeValue) {
		this.nodeValue = nodeValue;
	}
	/**
	 * @return the leftChild
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	/**
	 * @return the rightChild
	 */
	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}
	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
}
