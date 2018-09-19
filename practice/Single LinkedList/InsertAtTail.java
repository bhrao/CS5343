import java.util.Scanner;
import java.util.Random;


// creating a node class gives us access Node data structure
class Node {

		int val;
		Node next;
		Node(int v) {this.val = v; this.next = null;};

	}

class LinkedList_Details {
				static int len;
				static Node n;
				LinkedList_Details(int len, Node n) { this.len = len; this.n = n;}
			}

class InsertAtTail {

			//main method
			public static void main(String args[]) {
					
					LinkedList_Details ld = createList();
									
					System.out.print("\nValues in the list are : ");
					
					traverseList(ld.n);

					System.out.print("Enter a value to insert in the list : ");
					Scanner sc = new Scanner(System.in);
					int val = sc.nextInt();
					 
					Insert_Node(ld.n, ld.n, val);					
					
			}



			// method to create a linkedlist

			public static LinkedList_Details createList() {

					System.out.println("Enter min length of list");
					Scanner sc = new Scanner(System.in);
					int len = sc.nextInt();
					int i = 0;
					int v;

					Node head = null;
					Node temp = null;

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
											temp.next = new Node(v);									
											temp = temp.next;																									
										}																		
								}

								i++;
					}
					
					LinkedList_Details ld = new LinkedList_Details(len, head);

					return ld;
			}

			
			//method to traverse a linkedlist

			public static void traverseList(Node n) {

					if(n == null) System.out.println("End of List");
					
					else { System.out.print(n.val + " "); traverseList(n.next);}

			}



			//method to Insert a Node at the head in linkedlist

			public static void Insert_Node (Node h, Node n, int v) {

					if(h == null) { 
							Node t = new Node(v); 
							System.out.print("\nGiven list is empty, after inserting new list is : "); 
							traverseList(t); 
					}

					else if(n.next == null) {
									Node t = new Node(v);
									n.next = t;
									System.out.print("After inserting value at tail new list is : "); 
									traverseList(h);
					}
					
					else Insert_Node(h, n.next, v);

			}

}