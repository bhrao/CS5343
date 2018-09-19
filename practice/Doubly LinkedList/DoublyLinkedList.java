import java.util.Scanner;
import java.util.Random;


// creating a node class gives us access Node data structure
class Node {

		int val;
		Node next;
		Node prev;
		Node(int v) {this.val = v; this.next = null; this.prev = null;};

	}

class LinkedList_Details {
				static int len;
				static Node head;
				static Node tail;
				LinkedList_Details(int len, Node head, Node tail) { this.len = len; this.head = head; this.tail = tail;}
			}

class DoublyLinkedList {

			//main method
			public static void main(String args[]) {
					
					LinkedList_Details ld = createList();
									
					System.out.print("\nValues in the list are : ");
					
					traverseList(ld.head);

					sortList(ld.head, ld.len);

					//Node h = swapNodes(ld.head, ld.head, 0);	traverseList(h);					
					
			}



			// method to create a linkedlist

			public static LinkedList_Details createList() {

					System.out.println("Enter min length of list");
					Scanner sc = new Scanner(System.in);
					int len = sc.nextInt();
					int i = 0;
					int v;

					Node head = null;
					Node temp = null, temp1 = null;

					System.out.println("\nDo you want enter your own values for the list? if Yes, enter 1 \nif No, enter 0");
					Scanner rd_sc = new Scanner(System.in);
					int rd_val = rd_sc.nextInt();
					
					while (i <= len) {

								if( i == len) { 
										System.out.println("\nYou have created a list of " + len + " values."); 
										System.out.println("Do you still want to enter values in the list?");
										System.out.println("if Yes, enter the length by which you want to extend the list");
										System.out.println("if No, enter 0");

										Scanner li_sc = new Scanner(System.in);
										int ext_len = li_sc.nextInt();
										len = len + ext_len;

								}								

								if(i < len){									
	
										if(rd_val == 0) {										
													Random rand = new Random(); 
													v = rand.nextInt(1000);
												}

										else {
											System.out.println("Enter a value for the list");
											Scanner val_sc = new Scanner(System.in);
											v = val_sc.nextInt();
										} 
		
										if(head == null) { temp = new Node(v); head = temp; }
			
										else {									
											temp1 = temp;
											temp.next = new Node(v);									
											temp = temp.next;
											temp.prev = temp1;																									
										}																		
								}

								i++;
					}
					
					LinkedList_Details ld = new LinkedList_Details(len, head, temp);

					return ld;
			}



			//method to traverse a linkedlist

			public static void traverseList(Node n) {

					if(n == null) System.out.println("End of List");
					
					else { System.out.print(n.val + " "); traverseList(n.next);}

			}


			//method to sort a linkedlist

			public static void sortList(Node n, int l) {
					
					Node head = null;		
					int i = 0;					
					if (l == 0) { System.out.println("\nSorted list is : "); traverseList(n); }

					else {head = swapNodes(n, n, i); sortList(head, l - 1);}														
			}

			//method to swap nodes in a list

			public static Node swapNodes(Node head, Node current, int i) {

					if(current.next == null) return head;						

					else if(current.val > current.next.val) { 	
											if(current.next.next == null) {
															if(i == 0) {
																	current = current.next;
																	current.prev.next = null;
																	current.next = current.prev;
																	current.prev.prev = current;
																	current.prev = null;
																	return swapNodes(current, current.next, ++i);
															}

															else {
																Node temp = current.prev;
																current = current.next;	
																current.prev.next = null;		
																current.next = current.prev;		
																current.prev.prev = current;
																temp.next = current;
																current.prev = temp;
																return swapNodes(head, current.next, i);
															}
											}
											
											Node temp = current.prev;
											current = current.next;	
											current.prev.next = current.next;	
											current.next.prev = current.prev;	
											current.next = current.prev;		
											current.prev.prev = current;
											
											if(i == 0) {	
										  			current.prev = null; 
													return swapNodes(current, current.next, ++i);
											}

											else { 	
												temp.next = current; 			
												current.prev = temp; 			
												return swapNodes(head, current.next, i);
											}
										} 
					else return swapNodes(head, current.next, ++i);
																		

			}

}

			