package Linked_List_Topic;

public class LinkedList {
	
	public static Node array2LL(int[] arr) {
		Node head=new Node(arr[0]);
		Node mover=head;
		for(int i=1;i<arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover=temp;			
		}
		return head;
	}
	
	//length of a linked list
	public static int lengthOfLL(Node head) {
		Node temp=head;
		int count=0;
		while(temp!=null) {
			temp=temp.next;
			count++;
		}
		return count;
	}
	
	public static int searchElement(Node head, int key) {
		Node temp=head;
		while(temp!=null) {
			if(temp.data==key) {
				return 1;
			}
			else {
			temp=temp.next;
			}
		}
		return 0;
	}
	
	//Display LL data
	public static void Display(Node head){
		while(head!=null) {
			System.out.print(head.data+" -> ");
			head=head.next;
		}
	
	}
	
	//Delete the head of the LL
	public static Node deleteHead(Node head) {
		if(head==null) return head;
		head=head.next;
		return head;
	}
	//Delete the tail element of LL
	public static Node deleteTail(Node head) {
		Node temp=head;
		if(head==null || head.next==null) return null;
		while(head.next.next!=null){
			temp=temp.next;
			if(temp.next.next==null) {
				temp.next=null;
			}
			
		}
		return head;
	}
	
	
	

	public static void main(String[] args) {
//		int[] arr= {14,2,3,4,5};
////		Node y=new Node(arr[3]);
////		System.out.println(y.data);
////		System.out.println(y.next);
////		
//		//array to linked list.....
//		Node head=array2LL(arr);
//		System.out.println(head.data);
//		
//		//traversal to linked list
//		System.out.println("traversal to linked list");
//		Node temp=head;
//		while(temp!=null) {
//			System.out.print(temp.data+"->");
//			temp=temp.next;
//		}
//		
//		//length of a linked list
//		System.out.println();
//		int[] arr2= {23,45,78,90,2,44};
//		Node head1=array2LL(arr2);
//		System.out.println("length of a linked list : "+lengthOfLL(head1));
		
		//Deleting element in a LL
		System.out.println();
		int[] arr3= {23,3,45,54,67,78,9};
		Node head=array2LL(arr3);
		head=deleteHead(head);
		Display(head);
		//another head deletion
		Node head2=deleteHead(head);
		System.out.println();
		Display(head2);
		
		//Deleting the tail of the LL
		System.out.println();
		System.out.println("Tail deletion");
		int[] arr4= {12,34,1,20,50,45,89};
		Node head1=array2LL(arr4);
//		System.out.println("Before tail deletion");
//		Display(head1);
		head1=deleteTail(head1);
		System.out.println("After tail deletion");
		Display(head1);
		
		
		

	}

}
