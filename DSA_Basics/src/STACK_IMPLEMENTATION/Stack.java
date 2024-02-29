package STACK_IMPLEMENTATION;
//Stack implementation using Array.........................................................

public class Stack {
	private int top;
	private int maxSize;
	private int[] arr;
	
	Stack(int maxSize){
		this.top=-1;
		this.maxSize=maxSize;
		this.arr=new int[maxSize];
		
	}
	
	//checking if the stack is full or not
	public boolean isFull(){
		if(top>=maxSize-1) {
			return true;
		}
		return false;
	}
	
	//checking if the stack is empty or not
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}
	
	//*************stack push operation****************
	public boolean push(int data){
		if(isFull()) {
			return false;
		}
		else {
		arr[++top]=data;
		return true;
		}
	}
	
	//*************stack peek operation****************
	public int peek() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return arr[top];
		
	}
	
	//*************stack pop operation****************
	public int pop() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int retrived=arr[top];
		top--;
		return retrived;
	}
	
	//displaying all elements of stack
	public void dispaly() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}
		for(int i=top;i>=0;i--) {
			System.out.println(arr[i]);
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Stack stack=new Stack(7);
//		System.out.println("Pushing element to stack");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(10);
		
		System.out.println("Displaying stack elements");
		stack.dispaly();
		
		System.out.println("Stack peep operation :"+stack.peek());
		
		System.out.println("Stacks popped element is : "+stack.pop());
		System.out.println("Stacks popped element is : "+stack.pop());
		
		System.out.println("Stack elements after popped operation : ");
		stack.dispaly();
	}

}












