import java.util.Scanner;
import java.util.Random;
import java.lang.Math;


// creating a node class gives us access Node data structure
class Node {

		int val;
		Node parent;
		Node left;
		Node right;
		Node(int v) {this.val = v; this.parent = null; this.left = null; this.right = null;}

	}

class LinkedNode {

			int val;
			LinkedNode next;
			Node tNode;
			LinkedNode(int v) { this.val = v; this.next = null; this.tNode = null; }
}

class BSTBFS {

				//main method
				public static void main(String args[]) {							
					
					Node r = createTree();

					System.out.print("Values in the tree are by preOrder : ");

					preorderTraverse(r);

					System.out.print("\nValues in the tree are by BFS : ");
						
					bfs(r);					
				}



			// method to create a linkedlist

			public static Node createTree() {

					System.out.println("\nChoose one option:\n1. Enter min height of tree \n2. Enter min number of nodes of tree");
					Scanner sc = new Scanner(System.in);
					int input = sc.nextInt(); //take input chosen
					int node_count = 0;

					if(input == 1) {
								System.out.print("Enter min height of tree : ");
								int tree_ht = sc.nextInt();
								node_count = power(2, tree_ht+1) - 1;
					}
					
					else {
						System.out.print("Enter min number of nodes of tree : ");
						node_count = sc.nextInt();
					}

					 
					int i = 0; //loop counter variable
					int v; //list values will be assigned to this variable in loop
					int dir = 0;

					Node root = null; //head node declaration					
					Random rand = new Random();

					//If we dont want to enter list values manually, we can generate random values
					System.out.println("\nDo you want enter your own values for the tree? if Yes, enter 1 \nif No, enter 0");					
					int rd_val = sc.nextInt();
					
					while (i <= node_count) {

								if( i == node_count) {
											System.out.println("\nYou have created a tree of " + node_count + " nodes, with tree height of " + Math.ceil((Math.log(node_count+1)/Math.log(2)) - 1)); 
											System.out.println("Do you still want to extend tree length?");
											System.out.println("if Yes, enter the number of nodes by which you want to extend the tree");
											System.out.println("if No, enter 0");
										
											int ext_len = sc.nextInt();
											node_count = node_count + ext_len;

								}								

								if(i < node_count){									
	
										if(rd_val == 0) {														 
													v = rand.nextInt(10*node_count);
										}

										else {
											System.out.println("Enter a value for the tree node");											
											v = sc.nextInt();
										} 
		
										if(root == null) { root = new Node(v); }
			
										else {									
											insertNode(root, v);
										}																		
								}

								i++;
					}										

					return root;
			}
			
			public static void insertNode(Node r, int v) {
					
					if(r.val == v) System.out.println("\nNode value " + v + " repeated. Discarding duplicate values ");

					else if(r.val <= v) {
								if(r.right == null) { r.right = new Node(v); r.right.parent = r; }
								else insertNode(r.right, v);
					}

					else {
						if(r.left == null) { r.left = new Node(v); r.left.parent = r; }
						else insertNode(r.left, v);
					}
			}		

			public static int power(int n, int p) {

					if(p == 0) return 1;

					if(p % 2 != 0) return n * power(n, p/2) * power(n, p/2);

					else return power(n, p/2) * power(n, p/2);
			}

			public static void bfs(Node r) {

					LinkedNode temp = new LinkedNode(r.val);
					temp.tNode = r;
					LinkedNode l = null;

					while(temp != null) {							 	

						System.out.print(temp.val + " ");
						l = lastLinkedNode(temp);
						
						if(temp.tNode.left != null && temp.tNode.right != null) {								
								l.next = new LinkedNode(temp.tNode.left.val);
								l.next.tNode = temp.tNode.left;
								l.next.next = new LinkedNode(temp.tNode.right.val);
								l.next.next.tNode = temp.tNode.right;
								temp = temp.next;								
						}
						
						else if(temp.tNode.right != null && temp.tNode.left == null) {
								l.next = new LinkedNode(temp.tNode.right.val);
								l.next.tNode = temp.tNode.right;
								temp = temp.next;
						}

						else if(temp.tNode.right == null && temp.tNode.left != null) {
								l.next = new LinkedNode(temp.tNode.left.val);
								l.next.tNode = temp.tNode.left;
								temp = temp.next;
						}

						else temp = temp.next;
					}
			}

			public static void preorderTraverse(Node r) {

					if(r == null) System.out.print("");
					else {
						System.out.print(r.val + " ");
						preorderTraverse(r.left);
						preorderTraverse(r.right);
					}				
			}

			public static LinkedNode lastLinkedNode(LinkedNode n) {

					if(n.next == null) return n;
					else return lastLinkedNode(n.next);
			}			
				
}

			