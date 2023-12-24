package LinkedList;

public class LinkedList {
	private Node head;
	private Node tail;
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	//adding element at end of linked list
//	algo: create the node with the given data
	//check list is empty or not if empty make the node as the head and tail node
	//else make the link of the node refer to the node
	//make the tail refer to the node
	public void addAtEnd(String data) {
		Node node=new Node(data);
		if(this.head==null) {
			this.head=this.tail=node;
		}
		this.tail.setNext(node);
		this.tail=node;
	}
	
	//Adding elemnt to the beginning of the linked list
//	algo: create the node with the given data
	//check list is empty or not if empty make the node as the head and tail node
	//else add the node to the beginning of the head
	//make the node as the head node
	public void addAtBeginning(String data) {
		Node node=new Node(data);
		if(this.head==null) {
			this.head=this.tail=node;
		}
		node.setNext(this.head);
		this.head=node;
	}
	
	
	//Displaying linkedlist data
	public void display() {
		Node temp=this.head;
		while(temp!=null) {
			System.out.print(temp.getData()+" -> ");
			temp=temp.getNext();
			}
	}
	
	//Length of linked list
		public int length() {
			int countLength=0;
			if(this.head==null) return countLength;
			Node temp=this.head;
			while(temp!=null) {
				countLength++;
				temp=temp.getNext();
			}
			return countLength;			
		}
		
		//Search element is LL
		public String searchElement(String key) {
			Node temp=this.head;
			while(temp!=null) {
				if(temp.getData().equals(key)) {
					return "present";
				}
				else {
					temp=temp.getNext();
				}
			}
			return "not present";
		}
		
		//searcg/finding an element in a LL
		public Node find(String key) {
			Node temp=this.head;
			while(temp!=null) {
				if(temp.getData().equals(key)) {
					return temp;
				}
				else {
					temp=temp.getNext();			
				}
			}
			return null;
		}
		
	
	
	
	public static void main(String args[]) {
		LinkedList list=new LinkedList();
		list.addAtEnd("Kolkata");
		list.addAtEnd("Mumbai");
		list.addAtEnd("Delhi");
		list.addAtEnd("Bangalore");
		list.addAtEnd("Hyderabad");
		list.addAtEnd("Chennai");
		
		System.out.println("Added the element to the linkedlist");
		System.out.println("Displaying the linked list element");
		list.display();
		
		System.out.println();
		System.out.println("Length of linked list is : "+list.length());
		
		System.out.println();
		System.out.println("Adding the data to the beginning of the linked list");
		list.addAtBeginning("Lotus");
		list.addAtBeginning("Rose");
		list.display();
		
		System.out.println();
		System.out.println("The key is : "+list.searchElement("Chennai"));
		
		
	}

}
