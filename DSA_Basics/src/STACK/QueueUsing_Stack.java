package STACK;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

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
	Queue<Integer> queue=new ConcurrentLinkedQueue<>();
	queue.add(1);
	queue.add(3);
	queue.add(3);
	

	}

}
