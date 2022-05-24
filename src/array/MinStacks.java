package array;

import java.util.Stack;

class MinStack {

	private Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		this.minStack = new Stack<>();
	}

	public void push(int x) {
		
		if (minStack.isEmpty()) {
			minStack.push(x);
		} else if (x < getMin()) {
			minStack.push(x);
		} else {
			int y = minStack.pop();
			minStack.push(x);
			minStack.push(y);
		}

	}

	public void pop() {
		minStack.pop();
	}

	public int top() {
		return minStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public void print() {
		System.out.println(minStack);
	}
}

public class MinStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
	

		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		obj.print();

	}

}
