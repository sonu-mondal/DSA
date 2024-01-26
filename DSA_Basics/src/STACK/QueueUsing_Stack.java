package STACK;

import java.util.Stack;

public class QueueUsing_Stack {
	Stack<Integer> first;
	Stack<Integer> second;
	public QueueUsing_Stack() {
		first=new Stack<>();
		second=new Stack<>();
	}

	public void add(int x) {
		first.push(x);
	}
	
	public int remove() {
		while(!first.isEmpty()) {
			second.push(first.pop());
		}
		int removed=second.pop();
		while(!second.isEmpty()) {
			first.push(second.pop());
		}
		return removed;
	}
	
	public int peek() {
		while(!first.isEmpty()) {
			second.push(first.pop());
		}
		int peeked=second.peek();
		while(!second.isEmpty()) {
			first.push(second.pop());
		}
		return peeked;
	}
	
	public boolean empty() {
		return first.isEmpty();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
