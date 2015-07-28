package org.home.practise.CtCi.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePrinter {

	public <E extends Comparable<?>> void printNode(BinaryTreeNode<E> root) {
		int maxLevel = BinaryTreePrinter.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private <E extends Comparable<?>> void printNodeInternal(
			List<BinaryTreeNode<E>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BinaryTreePrinter.printWhitespaces(firstSpaces);

		List<BinaryTreeNode<E>> newNodes = new ArrayList<BinaryTreeNode<E>>();
		for (BinaryTreeNode<E> node : nodes) {
			if (node != null) {
				System.out.print(node.getNodeValue());
				newNodes.add(node.getLeftChild());
				newNodes.add(node.getRightChild());
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BinaryTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BinaryTreePrinter.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines
							+ i + 1);
					continue;
				}

				if (nodes.get(j).getLeftChild() != null)
					System.out.print("/");
				else
					BinaryTreePrinter.printWhitespaces(1);

				BinaryTreePrinter.printWhitespaces(i + i - 1);

				if (nodes.get(j).getRightChild() != null)
					System.out.print("\\");
				else
					BinaryTreePrinter.printWhitespaces(1);

				BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <E extends Comparable<?>> int maxLevel(BinaryTreeNode<E> node) {
		if (node == null)
			return 0;

		return Math.max(BinaryTreePrinter.maxLevel(node.getLeftChild()),
				BinaryTreePrinter.maxLevel(node.getRightChild())) + 1;
	}

	private static <E> boolean isAllElementsNull(List<E> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}
}
