package STACK_IMPLEMENTATION;

import java.util.Queue;

import java.util.LinkedList;

public class Stack_Using_2_Queues {
	
	Queue<Integer> queue1;
	Queue<Integer> queue2;
	
	public Stack_Using_2_Queues() {
		queue1=new LinkedList<Integer>();
		queue2=new LinkedList<Integer>();
	}
	
	public void push(int x) {
		while(!queue1.isEmpty()) {
			queue2.offer(queue1.poll());
		}
		queue1.offer(x);
		while(!queue2.isEmpty()) {
			queue1.offer(queue2.poll());
		}
	}
	
	public int pop() {
		if(queue1.isEmpty()) {
			return -1;
		}
		return queue1.poll();
	}
	
	public int top() {
		if(queue1.isEmpty()) {
			return -1;
		}
		return queue1.peek();
	}
	
	public boolean isEmpty() {
		return queue1.isEmpty();
	}


	public static void main(String[] args) {
		Stack_Using_2_Queues stack=new Stack_Using_2_Queues();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println("Popped element is : "+stack.pop());
		System.out.println("Popped element is : "+stack.pop());
		System.out.println("Popped element is : "+stack.pop());
		System.out.println("Popped element is : "+stack.pop());
		//System.out.println("Popped element is : "+stack.pop());
		//System.out.println("Popped element is : "+stack.pop());
		
		System.out.println("Popped element is : "+stack.top());

	}

}
