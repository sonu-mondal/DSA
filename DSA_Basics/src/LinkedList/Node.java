package LinkedList;

public class Node {
	String data;
	Node next;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(String data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Node(String data) {
		this.data=data;
	}
	
	
}
