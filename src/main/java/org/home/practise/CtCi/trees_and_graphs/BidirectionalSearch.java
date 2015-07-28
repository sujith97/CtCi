package org.home.practise.CtCi.trees_and_graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.home.practise.CtCi.library.GraphNode;

public class BidirectionalSearch<T> {
	
	private Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
	
	private Map<GraphNode<T>, Boolean> visited = new HashMap<GraphNode<T>, Boolean>();
	
	public boolean hasRoute(final GraphNode<T> node1, final GraphNode<T> node2) {
		return doBfs(node1, node2);
	}
	
	private boolean doBfs(final GraphNode<T> currentQueueNode, final GraphNode<T> nodeToBeCompared) {
		visited.put(currentQueueNode, true);
		if (currentQueueNode.equals(nodeToBeCompared)) {
			return true;
		}
		for (final GraphNode<T> child : currentQueueNode.getAdjacencyList()) {
			if (visited.get(child) == null) {
				queue.add(child);
			}
		}
		if (!queue.isEmpty()) {
			return doBfs(queue.remove(), nodeToBeCompared);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		final GraphNode<Integer> graphNode1 = new GraphNode<Integer>();
		graphNode1.setValue(new Integer("1"));
		
		final GraphNode<Integer> graphNode2 = new GraphNode<Integer>();
		graphNode2.setValue(new Integer("2"));
		
		final GraphNode<Integer> graphNode3 = new GraphNode<Integer>();
		graphNode3.setValue(new Integer("3"));
		
		final GraphNode<Integer> graphNode4 = new GraphNode<Integer>();
		graphNode4.setValue(new Integer("4"));
		
		final GraphNode<Integer> graphNode5 = new GraphNode<Integer>();
		graphNode5.setValue(new Integer("5"));
		
		/*
		 * 1 ----> 2
		 * 2 ----> 3
		 * 3 ----> 1
		 * 3 ----> 4
		 * 3 ----> 5
		 * 4 ----> 5
		 * 5 ----> 4
		 */
		graphNode1.getAdjacencyList().add(graphNode2);
		graphNode2.getAdjacencyList().add(graphNode3);
		graphNode3.getAdjacencyList().add(graphNode1);
		graphNode3.getAdjacencyList().add(graphNode4);
		graphNode3.getAdjacencyList().add(graphNode5);
		graphNode4.getAdjacencyList().add(graphNode5);
		graphNode5.getAdjacencyList().add(graphNode4);
		
		final BidirectionalSearch<Integer> bs = new BidirectionalSearch<Integer>();
		System.out.println(bs.hasRoute(graphNode4, graphNode5));
	}

}
