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

class CheckPalindrome {

			//main method
			public static void main(String args[]) {							
					
					LinkedList_Details ld = createList();
									
					System.out.print("\nValues in the list are : ");
					
					traverseList(ld.n);

					Node t = checkPalindrome(ld.n, findMid(ld.n, ld.n));
	
					if(t == null) System.out.println("Given list is not a palindrome");
					else System.out.println("Given list is a palindrome");
					
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

			public static Node checkPalindrome(Node h, Node m) {
					
					if(m.next == null) { 
								if(m.val == h.val) return h.next;
								else return null;
					}

					else { 
						h = checkPalindrome(h, m.next);
						if(h == null || m.val != h.val) return null;
						else return h.next;						
					}
			}

			public static Node findMid(Node h, Node t) {

					if(t == null || t.next == null) return h;
					else return findMid(h.next, t.next.next);
			}
		
}

			