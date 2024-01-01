package LinkedList_Int;

public class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
	}
	
	
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}


	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
