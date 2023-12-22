package Linked_List_Topic;

public class Node {

	public int data;
	public Node next;
	Node()
    {
        this.data = 0;
        this.next = null;
    }
	
	Node(int data, Node next){
		this.data=data;
		this.next=next;
	}
	
	Node(int data1){
		this.data=data1;
		this.next=null;
	}
}
