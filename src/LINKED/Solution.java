package LINKED;
import java.util.ArrayList;
import java.util.List;



class ListNode {
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

	

}

public class Solution {
	


	 public static void printList(ListNode.Node head) 
	    { 
	        ListNode.Node n = head; 
	        while (n != null) { 
	            System.out.print(n.data + " "); 
	
	            n = n.next; 
	        } 
	    } 
	 
	 public static int reverse(ListNode.Node head) {
			List<Integer> reverse = null;
			ListNode.Node n = head; 
			reverse = new ArrayList<Integer>();
			while (n != null) {
				/// System.out.print(n.data + " ");
				reverse.add(n.data);
				n = n.next;
			}

			String rev = "";

			for (int i = reverse.size() - 1; i >= 0; i--) {
				rev = rev + String.valueOf(reverse.get(i));

			}

			int reversed = Integer.parseInt(rev);

			return reversed;
		}
	 
	 
	 public static void addNodeAtTheEnd(int data, ListNode.Node head) {
	    //    System.out.println("Add a node with data " + data + " at the end.");
			// Create a new node
			ListNode.Node newNode = new ListNode.Node(data);

			// Check if the list is empty
			if (head == null) {
				// Make the new node as head
				head = newNode;
			} else {
				ListNode.Node cur = head;
				// traverse to the end of the list
				while (cur.next != null) {
					cur = cur.next;
				}
				cur.next = newNode;
			}
		}
	 
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			
			
			ListNode llist = new ListNode();
			
			int result =  reverse(l1.head) + reverse(l2.head);
			
			
			 String s = String.valueOf(result);
			 
			 for (int i = s.length()-1; i >= 0; i--){
			//	 addNodeAtTheEnd(Integer.parseInt(String.valueOf(s.charAt(i))), llist.head);        
				    //Process char
				}
			 
			
			return llist;

		}
	 
	 
	 
	 



	
	public static void main(String[] args) {
		/* Start with the empty list. */
		ListNode llist = new ListNode();

		llist.head = new ListNode.Node(2);
		ListNode.Node second = new ListNode.Node(4);
		ListNode.Node third = new  ListNode.Node(3);

		llist.head.next = second;

		second.next = third;

		ListNode llist1 = new ListNode();

		llist1.head = new ListNode.Node(5);
		ListNode.Node second1 = new ListNode.Node(6);
		ListNode.Node third1 = new  ListNode.Node(4);

		llist1.head.next = second1;

		second1.next = third1;
		
	
	
		
		
		
	//	System.out.println(result);
	
		 
		
		
		
		printList(llist.head);
		
		
		printList(addTwoNumbers(llist, llist1).head);
		
		
		

		 
		

	
		 
		 

	}

}
