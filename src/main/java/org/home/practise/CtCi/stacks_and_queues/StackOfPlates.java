package org.home.practise.CtCi.stacks_and_queues;

import java.util.ArrayList;
import java.util.List;

public class StackOfPlates {

	private List<Integer> stacks = new ArrayList<Integer>();
	private List<Integer> stackData = new ArrayList<Integer>();
	
	private int currentStack = 0;

	public void push(int value) {
		if (stacks.isEmpty()) {
			stacks.add(0, 0);
		}
		
		int currentStackTop = stacks.get(currentStack);
		currentStackTop += 1;
		
		if (currentStackTop % 10 == 0) {
			currentStack += 1;
			stacks.add(currentStack, currentStackTop - 1);
		} else {
			stacks.set(currentStack, currentStackTop - 1);
		}
		
		stackData.add(currentStackTop - 1, value);
	}
	
	public void display() {
		System.out.println("Number of stacks: " + stacks.size());
		int i = 1;
		for (Integer stackTop : stacks) {
			System.out.println("Stack " + i++ + ":");
			int stackTopTemp = stackTop.intValue();
			do {
				System.out.print(stackData.get(stackTopTemp--) + ", ");
			} while (stackTopTemp % 10 != 0);
			System.out.println(stackData.get(stackTopTemp));
		}
		
	}
	// [1, 2, 3 <-]
	public static void main(String[] args) {
		StackOfPlates stackOfPlates = new StackOfPlates();
		
		for (int i = 0; i < 25; i++) {
			stackOfPlates.push(i);
		}
		
		stackOfPlates.display();
	}

}
