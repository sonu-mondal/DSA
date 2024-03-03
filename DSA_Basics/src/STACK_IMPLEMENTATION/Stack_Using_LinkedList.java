package STACK_IMPLEMENTATION;

public class Stack_Using_LinkedList {
	public Node head;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void push(int x){
		
		Node node =new Node(x);
		node.setNext(head);
		head=node;
		
	}
	
	public int pop(){
		if(head==null) {
			return -1;
		}
		int popped=head.getData();
		head=head.getNext();
		return popped;
	}
	
	public int peek() {
		if(head==null) {
			return -1;
		}
		return head.getData();
	}
	
	public boolean isEmpty() {
		return head==null;
	}

	public static void main(String[] args) {
		Stack_Using_LinkedList stack=new Stack_Using_LinkedList();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		
		System.out.println("peeked element : "+stack.peek());
		System.out.println("Popped element : "+stack.pop());
		System.out.println("Popped element : "+stack.pop());
		System.out.println("Popped element : "+stack.pop());
		System.out.println("Popped element : "+stack.pop());
		System.out.println("Peeked element : "+stack.peek());
		System.out.println(stack.isEmpty());
	}

}
