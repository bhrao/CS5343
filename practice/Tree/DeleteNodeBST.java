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

class DeleteNodeBST {

			//main method
			public static void main(String args[]) {							
					
					Node r = createTree();

					System.out.print("\nValues in the tree are : ");
							
					preorderTraverse(r);

					System.out.print("\nEnter a value from the list of nodes in the tree to delete : ");
					Scanner v = new Scanner(System.in);
					int i = v.nextInt();
					
					Node n = deleteNode(r, i);

					System.out.print("\nValues in the tree after deleting Node with value " + i + " are : ");
							
					if(r.val == i) preorderTraverse(n);
					else preorderTraverse(r);															
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

			public static Node searchBST(Node r, int v) {

					if(r == null) return null;
					else if(r.val == v) return r;
					else if(r.val > v) return searchBST(r.left, v);
					else return searchBST(r.right, v);
			}

			public static Node deleteNode(Node r, int v) {

					Node n = searchBST(r, v);
					Node p;
					if(n == null) { System.out.println("Given value does not exist in the tree"); return null; }
					else if(n.right == null && n.left == null) { n.parent = null; return null; }
					else if(n.right == null) { 
									p = replacewithpredecessor(n.left);
									if(p.left != null) { p.left.parent = p.parent; }
									p.parent.right = p.left;
									p.left = n.left;
									p.right = n.right;
									p.parent = n.parent;																		
									p.left.parent = p;
									p.right.parent = p;
									if(n.parent == null) p.parent = null;
									else if(n.parent.right == n) p.parent.right = p;
									else p.parent.left = p;
									return p;
									
					}
					else {
						p = replacewithSuccessor(n.right);
						if(p.right != null) { p.right.parent = p.parent; }
						p.parent.left = p.right;
						p.right = n.right;
						p.left = n.left;
						p.parent = n.parent;											
						p.right.parent = p;
						p.left.parent = p;
						if(n.parent == null) p.parent = null;
						else if(n.parent.right == n) p.parent.right = p;
						else p.parent.left = p;
						return p;
					}
					
			}

			public static Node replacewithSuccessor(Node n) {

					if(n.left == null) return n;
					else return replacewithSuccessor(n.left);
			}

			public static Node replacewithpredecessor(Node n) {

					if(n.right == null) return n;
					else return replacewithpredecessor(n.right);
			}

			public static void preorderTraverse(Node r) {

					if(r == null) System.out.print("");
					else {
						System.out.print(r.val + " ");
						preorderTraverse(r.left);
						preorderTraverse(r.right);
					}				
			}
}

			