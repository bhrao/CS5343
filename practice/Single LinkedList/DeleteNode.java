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

class DeleteNode {

			//main method
			public static void main(String args[]) {
					
					LinkedList_Details ld = createList();
									
					System.out.print("\nValues in the list are : ");
					
					traverseList(ld.n);

					System.out.print("Enter a value from the list to delete : ");
					Scanner sc = new Scanner(System.in);
					int val = sc.nextInt();

					if(ld.n == null) System.out.println("\nList is empty"); 
					else Delete_Node(ld.n, ld.n, val);					
					
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



			//method to Delete a Node in linkedlist

			public static void Delete_Node (Node h,Node t, int v) {

					if(t == null) System.out.println("\nEntered value is not in the list");

					else if(t.val == v) { 
								t = t.next; 
								System.out.print("\nList after deleting the given node is : ");
								traverseList(t); 								 
					}
	
					else if(t.next.val == v) { 
									t.next = t.next.next; 
									System.out.print("\nList after deleting the given node is : ");
									traverseList(h); 									
					}
					
					else Delete_Node(h, t.next, v);

			}

}