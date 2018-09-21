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

class MergeSort {

			//main method
			public static void main(String args[]) {							
					
					LinkedList_Details ld = createList();
									
					System.out.print("\nValues in the list are : ");
					
					traverseList(ld.n);					

					Node h = mergeSort(ld.n);

					System.out.print("\nValues in the list after sorting are : ");
					
					traverseList(h);									
					
			}



			// method to create a linkedlist

			public static LinkedList_Details createList() {

					System.out.print("\nEnter min length of list : ");
					Scanner sc = new Scanner(System.in);
					int len = sc.nextInt(); //take min length of list 
					int i = 0; //loop counter variable
					int v; //list values will be assigned to this variable in loop

					Node head = null; //head node declaration
					Node temp = null; //temp node to keep track of node in loop

					//If we dont want to enter list values manually, we can generate random values
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
													v = rand.nextInt(100*len);
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

					do {
						System.out.print(n.val + " ");
						if(n.next == null) System.out.println("End of list");						
						n = n.next;
					} while(n != null);						
			}

			public static Node mergeSort(Node n) {

					Node a = n;
					Node b = findMid(n, n);

					if(n.next == null) return n;

					else {
						splitList(a, b); 
						a = mergeSort(a);
						b = mergeSort(b);					
						Node h = mergeList(a, a, b, b, 0); 
						return h;
					}	
		
			}

			public static Node findMid(Node n, Node m) {

					if(m == null || m.next == null) return n;
					else return findMid(n.next, m.next.next);
			}

			public static void splitList(Node a, Node b) {

					if(a.next == b) a.next = null;
					else splitList(a.next, b);
			}

			public static Node mergeList(Node h, Node a, Node b, Node c, int i) {

					if(a == null) { c.next = b; return h; }

					else if(b == null) { c.next = a; return h; }

					else if(i == 0) {
								if(a.val >= b.val) { h = b; c = b; return mergeList(h, a, b.next, c, ++i); }
								else { c = a; return mergeList(h, a.next, b, c, ++i); }
					}

					else {
						if(a.val >= b.val) { c.next = b; c = b; return  mergeList(h, a, b.next, c, i); }
						else { c.next = a; c = a; return mergeList(h, a.next, b, c, i); }
					}				
			}

}

			