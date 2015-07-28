package org.home.practise.CtCi.library;

import java.util.LinkedList;
import java.util.List;

public class GraphNode<T> {

	private T value;
	private List<GraphNode<T>> adjacencyList;
	
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new Integer(this.getValue().toString());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.value.equals(((GraphNode) obj).value);
	}

	/**
	 * @return the adjacencyList
	 */
	public List<GraphNode<T>> getAdjacencyList() {
		if (adjacencyList == null) {
			adjacencyList = new LinkedList<GraphNode<T>>();
		}
		return adjacencyList;
	}
	
	/**
	 * @param adjacencyList the adjacencyList to set
	 */
	public void setAdjacencyList(List<GraphNode<T>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
}
