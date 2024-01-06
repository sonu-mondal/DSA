package LinkedList_Int;

import LinkedList_Int.*;

public class LinkedList {
	private Node head;
	private Node tail;//advantage of taking tail is that when we need to add an element at the last of LL 
	//then that we can do in the O(1) complexity i.e constant time , if tail is not there then we need
	//to traverse to last element then need to insert so in that case TC is O(n)
	
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
	//else make the link/next of the tail refer to the node
	//make the tail refer to the node or make the node as the tail node
	public void addAtEnd(int data) {
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
	public void addAtBeginning(int data) {
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
		System.out.println("null");
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
		public String searchElement(int key) {
			Node temp=this.head;
			while(temp!=null) {
				if(temp.getData()==(key)) {
					return "present";
				}
				else {
					temp=temp.getNext();
				}
			}
			return "not present";
		}
		
		//search/finding an element in a LL
		public Node find(int key) {
			Node temp=this.head;
			while(temp!=null) {
				if(temp.getData()==(key)) {
					return temp;
				}
				else {
					temp=temp.getNext();			
				}
			}
			return null;
		}
		
		//inserting an element in LL
		//create node with the given data
		//check if LL is empty or not if empty make the node as the head and tail node
		//else point the earlier nodeBefores next element as the next element of the node.
		//and set the nodeBefores next as the node
		//if nodeBefore is the tail then make the node as the tail
		// if node not found print message
		
		public void insert(int data, int dataBefore) {
			Node node=new Node(data);
			if(this.head==null) {
				this.head=this.tail=node;
			}
			else {
				Node nodeBefore=this.find(dataBefore);
				if(nodeBefore!=null) {
					node.setNext(nodeBefore.getNext());
					nodeBefore.setNext(node);
					if(nodeBefore==this.tail) {
						this.tail=node;
					}
				}
				else {
					System.out.println("Node not found");
				}
				
			}
		}
		
		//or another way to insert element at a paticular index
		public void insert1(int data, int index) {
			Node node=new Node(data);
			if(index==0) {
				addAtBeginning(data);
				
			}
			else if(index==length()) {
				addAtEnd(data);
			}
			else {
							
			Node temp=this.head;
			for(int i=1;i<index;i++) {
				temp=temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
			}
			
		}
		
		//return the reference of a node if we provide the index position
		public Node get(int index) {
			Node node=head;
			for(int i=0;i<index;i++) {
				node=node.getNext();
			}
			return node;
		}
		
		//Delete first element of LL
		public int deleteFirst() {
			if(this.head==null) {
				this.tail=null;
			}
			int value=this.head.getData();
			head=head.getNext();
			return value;
		}
		
		//Delete last element of LL
		public int deleteLast() {
			if(this.head==null) {
				this.tail=null;
			}
			if(length()<=1) {
				return deleteFirst();
			}
			int temp=this.tail.getData();
			Node previousElement=this.head;
			while(previousElement.getNext().getNext()!=null) {
				previousElement=previousElement.getNext();
			}
			previousElement.setNext(null);
			tail=previousElement;
			return temp;
		}
		
		//or 2nd method to delete last element of LL
		public int deleteLast1() {
			if(length()<=1) {
				return deleteFirst();
			}
			Node secondLast=get(length()-2);
			int value=tail.getData();
			this.tail=secondLast;
			tail.setNext(null);
			return value;
		}
		
		//Delete element at particular index
		public int deleteAtIndex(int index) {
			int element=head.getData();
			Node temp=this.head;
			Node next=null;
			Node previous=null;
			if(index==0) {
				deleteFirst();
			}
			else if(index==length()) {
				deleteLast();
			}
			else {
				for(int i=1;i<index;i++) {
					temp=temp.getNext();
				}
			}
			previous=temp;
			temp=temp.getNext();
			next=temp.getNext();
			previous.setNext(next);
			return temp.getData();
		}
		
		//or 2nd method to delete at particular index element 
		
		public int deleteAtIndex1(int index) {
			if(index==0) {
				return deleteFirst();
			}
			if(index==length()) {
				return deleteLast();
			}
					
			Node previous=get(index-1);
			int value=previous.getNext().getData();
			previous.setNext(previous.getNext().getNext());
			return value;
			
		}
		
		//Deleting element when value is given ...............................
		
		public Node deleteWithValue(Node head, int val) {
			Node dummyhead=new Node(0);
			dummyhead.setNext(head);
			Node current=dummyhead;
			
			while(current.next!=null) {
				if(current.getNext().getData()==val) {
					current.setNext(current.getNext().getNext());	
				}
				else {
					current=current.getNext();
				}
			}
			
			return dummyhead.getNext();
			
		}
		
		//reverse ll
		public Node reverseLinkedList(Node head) {
			Node current=this.head;
			Node previous=null;
			Node nxt=null;
			while(current!=null) {
				nxt=current.getNext();
				current.next=previous;
				previous=current;
				current=nxt;
			}
			return previous;
		}
		
		//Reverse only a part of linked list 
		public Node reverseBetween(Node head, int left, int right) {
			Node dummy=new Node(0);
			dummy.next=head;
			
			Node previous=dummy;
			Node current=head;
			for(int i=0;i<left-1;i++) {
				previous=previous.next;
				current=current.next;
			}
			
			Node currentFixed=current;
			
			Node previousNull=null;
			for(int j=0;j<=right-left;j++) {
				Node next=current.next;
				current.next=previousNull;
				previousNull=current;
				current=next;
			}
			
			//noe making the before left and after left nodes connection
			previous.next=previousNull;
			currentFixed.next=current;
			
			
			return dummy.next;
		}
		
			
		
		
		
		
		//inserting element using recusrion
		public void insertUsingRecursion(int data, int index) {
			//head=... because we need to update the head if ant element is inserted at 0th position 
			//or else the head remain as it was
			head=insertUsingRecursion(data, index, this.head);
		}
		
		private Node insertUsingRecursion(int data, int index, Node node) {
			if(index==0) {//index=0 means if we moved to position where we need to insert the data
				//otherwise we will move to next index and decrement the index value till it become 0
				Node newNode=new Node(data, node);
				return newNode;				
			}
			node.setNext(insertUsingRecursion(data, index-1, node.getNext()));
			return node;
		}
		
		//## Remove duplicates from the LL
		public void removeDuplicates() {
			Node node=this.head;
			while(node.getNext()!=null) {
				if(node.getData()==(node.getNext().getData())) {
					node.setNext(node.getNext().getNext());
				}
				else {
					node=node.getNext();
				}
				if(node.getNext()==null) {
					tail=node;
					tail.setNext(null);
				}
			}
		}
		
//Merging two LL
//we will compare the head of both list data whichever is less we will add it to our newly list
//how we will add: so we created tail which points to dummyHead so whichever list value is less
// we make tails next point to that node and then move list by 1 position and tail by one position
// at end suppose 2 list have unequal length so the left elements which is already in sorted we will 
// add to our list by making tails next point to that node
		public static LinkedList merge(Node list1, Node list2) {
			LinkedList dummyHead=new LinkedList();
			Node tail=dummyHead.head;
			while(list1!=null && list2!=null) {
				if(list1.getData()<list2.getData()) {
					tail.setNext(list1);
					list1=list1.getNext();
					tail=tail.getNext();
				}
				else {
					tail.setNext(list2);
					list2=list2.getNext();
					tail=tail.getNext();
				}
			}
			if(list1!=null) {
				tail.setNext(list1);
			}
			else {
				tail.setNext(list2);
			}
			return dummyHead;
			
		}
		
		//Detect cycle in linked list
		public static boolean detectCycle(Node head) {
			Node fast=head;
			Node slow=head;
			while(fast!=null && fast.next!=null ) {
				slow=slow.next;
				fast=fast.next.next;
				if(fast==slow) {
					return true;
				}
			}
			return false;
		}
		
		//Find the length of the cycle present in Linked list
		//concept is that when fast==slow then we keep fast as it is , we move slow by one position 
		//and will keep moving slow untill it again become equal to fast and will keep incrementing the 
		//count variable that will give me length of the cycle
		public static int findLengthOfCycle(Node head) {
			Node fast=head;
			Node slow=head;
			while(fast!=null && fast.next!=null) {
				slow=slow.next;
				fast=fast.next.next;
				if(fast==slow) {
					int count=0;
					do{
						slow=slow.next;
						count++;
					}
					while(slow!=fast);
					return count;
				}
			}
			return 0;
		}
		
		//Return start point of the cycle in LL
		
		
		
		
		
		
//		A happy number is a number defined by the following process:
//
//			Starting with any positive integer, replace the number by the sum of the squares of its digits.
//			Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a 
//			cycle which does not include 1.
//			Those numbers for which this process ends in 1 are happy.
//			Return true if n is a happy number, and false if not.
// 
//			Example 1:
//
//			Input: n = 19
//			Output: true
//			Explanation:
//			12 + 92 = 82
//			82 + 22 = 68
//			62 + 82 = 100
//			12 + 02 + 02 = 1
//			Example 2:
//
//			Input: n = 2
//			Output: false
		
		//Happy Number problem
		 public boolean isHappy(int n) {
		        int slow=n;
		        int fast=n;
		        do {
		        	slow=squareOfNumber(slow);//moving one times
		        	fast=squareOfNumber(squareOfNumber(fast));//moving two times
		        }while(slow!=fast);
		        if(slow==1) {
		        	return true;
		        }
		        return false;
		    }
		 
		 private int squareOfNumber(int num) {
			 int rem=0;
			 int sum=0;
			 while(num!=0) {
				 rem=num%10;
				 sum+=rem*rem;
				 num=num/10;
				 
			 }
			 return sum;
		 }
		 
		 //Finding the middle of the linked list
		 public Node findMidNode(Node head) {
			 Node slow=this.head;
			 Node fast=this.head;
			 while(fast!=null && fast.next!=null) {
				 slow=slow.getNext();
				 fast=fast.getNext().getNext();
			 }
			 return slow;
		 }
		

	public static void main(String[] args) {
//		LinkedList list=new LinkedList();
//		list.addAtEnd(1);
//		list.addAtEnd(3);
//		list.addAtEnd(34);
//		list.addAtEnd(8);
//		list.addAtEnd(6);
//		list.addAtEnd(90);
//		
//		System.out.println("Added the element to the linkedlist");
//		System.out.println("Displaying the linked list element");
//		list.display();
//		
//		System.out.println();
//		System.out.println("Length of linked list is : "+list.length());
//		
//		System.out.println();
//		System.out.println("Adding the data to the beginning of the linked list");
//		list.addAtBeginning(78);
//		list.addAtBeginning(5);
//		list.display();
//		
//		System.out.println();
//		System.out.println("The key is : "+list.searchElement(5));
//		
//		System.out.println();
//		System.out.println("Inserting element in LL");
//		list.insert(17,8);
//		list.display();
//		
//		System.out.println();
//		System.out.println("Inserting element in LL when index is given");
//		list.insert1(77, list.length());
//		list.insert1(777, 0);
//		list.insert1(7777, 5);
//		list.display();
//		
//		System.out.println();
//		System.out.println("Deleteing the first element");
//		System.out.println("first deleted element is : "+ list.deleteFirst());
//		System.out.println("List after deleting first element");
//		list.display();
//		
//		System.out.println();
//		System.out.println("Deleteing the last element");
//		System.out.println("Last deleted element is : "+ list.deleteLast());
//		System.out.println("List after deleting Last element");
//		list.display();
////		list.deleteLast();
////		list.display();
//		
//		//2nd method to delete last element of LL
//		System.out.println();
//		System.out.println("- 2nd method- Deleteing the last element");
//		System.out.println("Last deleted element is : "+ list.deleteLast1());
//		System.out.println("List after deleting Last element");
//		list.display();
//		
//		System.out.println();
//		System.out.println("Deleteing the particular index element");
//		System.out.println("Element deleted is : "+ list.deleteAtIndex(5));
//		System.out.println("List after deleting element");
//		list.display();
////		list.deleteAtIndex(0);
////		list.display();
////		list.deleteAtIndex(list.length());
////		list.display();
////		list.deleteAtIndex(2);
////		list.display();
////		
//		//2nd method
//		System.out.println();
//		System.out.println("-2nd method- Deleteing the particular index element");
//		System.out.println("Element deleted is : "+ list.deleteAtIndex1(5));
//		System.out.println("List after deleting element");
//		list.display();
//		
//		
//		//Inserting using recursion
//		System.out.println();
//		System.out.println("Insert operation using recursion");
//		list.insertUsingRecursion(656, 0);
//		list.display();
//		
//		//Creating another list to perform remove duplicate operation
//		//given list is in sorted order
//		LinkedList list2=new LinkedList();
//		list2.addAtEnd(22);
//		list2.addAtEnd(22);
//		list2.addAtEnd(33);
//		list2.addAtEnd(33);
//		list2.addAtEnd(44);
//		list2.addAtEnd(44);
//		list2.addAtEnd(44);
//		list2.addAtEnd(55);
//		
//		
//		System.out.println();
//		System.out.println("List before removing duplicates");
//		list2.display();
//		System.out.println("List after removing the duplicates");
//		list2.removeDuplicates();
//		list2.display();
		
		
		//Merging two sorted linked list
//		LinkedList ll1=new LinkedList();
//		LinkedList ll2=new LinkedList();
//		ll1.addAtEnd(1);
//		ll1.addAtEnd(4);
//		ll1.addAtEnd(10);
//
//		ll2.addAtEnd(3);
//		ll2.addAtEnd(8);
//		ll2.addAtEnd(18);
//		ll2.addAtEnd(100);
//		
//		System.out.println();
//		System.out.println("List1");
//		ll1.display();
//		System.out.println();
//		System.out.println("List2");
//		ll2.display();
//		System.out.println("List after merging");
//		LinkedList list1=merge(ll1.head, ll2.head);
		//list1.display();
		
		//delete when value is given
		LinkedList ll3=new LinkedList();
		ll3.addAtEnd(1);
		ll3.addAtEnd(4);
		ll3.addAtEnd(10);
		ll3.addAtEnd(123);
		ll3.addAtEnd(47);
		ll3.addAtEnd(19);
//		System.out.println();
//		System.out.println("before deleting ");
//		ll3.display();
//		System.out.println("after deleting");
//		ll3.deleteWithValue(ll3.getHead(), 1);
//		ll3.display();
		
		System.out.println("Before reversing");
		ll3.display();
		System.out.println();
		System.out.println("After reversing");
		ll3.reverseLinkedList(ll3.head);
		ll3.display();
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
