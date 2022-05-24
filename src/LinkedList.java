import java.util.ArrayList;
import java.util.List;

// A simple Java program to introduce a linked list 
class LinkedList {
	Node head; // head of list

	/*
	 * Linked list Node. This inner class is made static so that main() can access
	 * it
	 */
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		} // Constructor
	}
	
	
	

	 public void printList() 
	    { 
	        Node n = head; 
	        while (n != null) { 
	            System.out.print(n.data + " "); 
	
	            n = n.next; 
	        } 
	    } 


	 
	 public int reverse() 
	    { 
		    List<Integer>  reverse = null;
	        Node n = head; 
	        reverse = new ArrayList<Integer>();
	        while (n != null) { 
	        ///    System.out.print(n.data + " "); 
	            reverse.add(n.data);    
	            n = n.next; 
	        }
	       
	        String rev = "";
	        
	       
	        for( int i= reverse.size()-1; i>=0; i --) {	             	
	        	rev = rev + String.valueOf(reverse.get(i));
	 
	        }	        
	        
	        int reversed = Integer.parseInt(rev);
	            
			return  reversed ; 
	    } 
	 
	 public LinkedList addTwoNumbers( LinkedList l1,  LinkedList l2) {
		return l2;        
	    }
	 
	 public void addNodeAtTheEnd(int data) {
	        System.out.println("Add a node with data " + data + " at the end.");
			// Create a new node
			Node newNode = new Node(data);

			// Check if the list is empty
			if (this.head == null) {
				// Make the new node as head
				this.head = newNode;
			} else {
				Node cur = this.head;
				// traverse to the end of the list
				while (cur.next != null) {
					cur = cur.next;
				}
				cur.next = newNode;
			}
		}
	 
	/* method to create a simple linked list with 3 nodes */
	public static void main(String[] args) {
		/* Start with the empty list. */
		LinkedList llist = new LinkedList();

		

		LinkedList llist1 = new LinkedList();

		llist1.head = new Node(5);
		Node second1 = new Node(6);
		Node third1 = new Node(4);

		llist1.head.next = second1;

		second1.next = third1;
		
	//	 llist.printList(); 
	//	 llist1.printList(); 
		
		
		llist.addNodeAtTheEnd(4);
		llist.addNodeAtTheEnd(5);
		
		llist.printList(); 
		 
		 
		
	//	System.out.print(llist1.reverse());
		
		int result =  llist.reverse() + llist1.reverse();
		
		
	//	System.out.print(result);
		
		/*
		 * for(int d : llist.reverse()) { System.out.print(d); }
		 */
		
	
		 
		 

	}
}
