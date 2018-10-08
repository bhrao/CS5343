import java.util.Scanner;
import java.util.Random;
import java.lang.Math;


// creating a node class gives us access Node data structure
class Node {

		int val;
		Node parent;
		Node left;
		Node right;
		int ht;
		Node(int v) {this.val = v; this.parent = null; this.left = null; this.right = null; this.ht = 0;}

	}

class AVLTree {

			//main method
			public static void main(String args[]) {							
					
					Node r = createTree();

					System.out.print("\nValues in the tree are : ");
							
					preorderTraverse(r);																				
			}



			// method to create a BST
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
													v = rand.nextInt(100*node_count);
										}

										else {
											System.out.println("Enter a value for the tree node");											
											v = sc.nextInt();
										} 
		
										if(root == null) { root = new Node(v); }
			
										else {									
											root = insertNode(root, root, root, v);
										}																		
								}

								i++;
					}										

					return root;
			}
			
			public static Node insertNode(Node r, Node mR, Node t, int v) {
					
					if(r.val == v) { System.out.println("\nNode value " + v + " repeated. Discarding duplicate values "); return mR; }

					else if(r.val <= v) {
								if(r.right == null) { 
											r.right = new Node(v); 
											r.right.parent = r;											
											updateHeight(r.right);
											t = checkBalance(r);
											return rebalance(t, mR);
 								}
								else return insertNode(r.right, mR, t, v);
					}

					else {
						if(r.left == null) { 
									r.left = new Node(v); 
									r.left.parent = r;
									updateHeight(r.left);								 									 
									t = checkBalance(r);
									return rebalance(t, mR);
						}
						else return insertNode(r.left, mR, t, v);
					}
			}		

			public static int power(int n, int p) {

					if(p == 0) return 1;

					if(p % 2 != 0) return n * power(n, p/2) * power(n, p/2);

					else return power(n, p/2) * power(n, p/2);
			}
			
			public static void preorderTraverse(Node r) {

					if(r == null) System.out.print("");
					else {
						System.out.print(r.val + " ");
						preorderTraverse(r.left);
						preorderTraverse(r.right);
					}				
			}

			public static Node checkBalance(Node r) {

					if(r == null) return null;
					else if(r.right != null && r.left != null) {
						
						if(Math.abs(r.left.ht - r.right.ht) > 1) return r;
						else return checkBalance(r.parent);
					}

					else if(r.right == null && r.left != null) {
						
						if(r.left.ht == 1) return r;
						else return checkBalance(r.parent);
					}

					else if(r.right != null && r.left == null) {
						
						if(r.right.ht == 1) return r; 
						else return checkBalance(r.parent);
					}

					else return checkBalance(r.parent);
			}

			public static Node rebalance(Node t, Node mR) {

					if(t != null && t == mR) {
									if((t.right == null && t.left.right == null) 
										|| (t.right != null && t.left != null && t.right.ht < t.left.ht && t.left.right == null)
										|| (t.right != null && t.left != null && t.right.ht < t.left.ht && t.left.right.ht <= t.left.left.ht)) singleRotationLeft(t);
									else if((t.right == null && t.left.left == null)
										|| (t.right != null && t.left != null && t.right.ht < t.left.ht && t.left.left == null)
										|| (t.right != null && t.left != null && t.right.ht < t.left.ht && t.left.left.ht < t.left.right.ht)) doubleRotationLeft(t); 
									else if((t.left == null && t.right.left == null) 
										|| (t.left != null && t.right != null && t.left.ht < t.right.ht && t.right.left == null)
										|| (t.left != null && t.right != null && t.left.ht < t.right.ht && t.right.left.ht <= t.right.right.ht)) singleRotationRight(t);
									else if((t.left == null && t.right.right == null) 
										|| (t.left != null && t.right != null && t.left.ht < t.right.ht && t.right.right == null)
										|| (t.left != null && t.right != null && t.left.ht < t.right.ht && t.right.right.ht < t.right.left.ht)) doubleRotationRight(t);
									else System.out.println(" not in any rotation \n"); 
																																
									return mR.parent;
					}

					else if(t != null && t != mR) {
									if((t.right == null && t.left.right == null) 
										|| (t.right != null && t.left != null && t.right.ht < t.left.ht && t.left.right == null)
										|| (t.right != null && t.left != null && t.right.ht < t.left.ht && t.left.right.ht <= t.left.left.ht)) singleRotationLeft(t);
									else if((t.right == null && t.left.left == null)
										|| (t.right != null && t.left != null && t.right.ht < t.left.ht && t.left.left == null)
										|| (t.right != null && t.left != null && t.right.ht < t.left.ht && t.left.left.ht < t.left.right.ht)) doubleRotationLeft(t); 
									else if((t.left == null && t.right.left == null) 
										|| (t.left != null && t.right != null && t.left.ht < t.right.ht && t.right.left == null)
										|| (t.left != null && t.right != null && t.left.ht < t.right.ht && t.right.left.ht <= t.right.right.ht)) singleRotationRight(t);
									else if((t.left == null && t.right.right == null) 
										|| (t.left != null && t.right != null && t.left.ht < t.right.ht && t.right.right == null)
										|| (t.left != null && t.right != null && t.left.ht < t.right.ht && t.right.right.ht < t.right.left.ht)) doubleRotationRight(t);
									else System.out.println(" not in any rotation \n");
																																	
									return mR;
					}
							
					else return mR;
			}

			public static void singleRotationLeft(Node r) {
					
					r.left.parent = r.parent;						
					if(r.parent != null) {
								if(r.parent.right != null && r.parent.right == r) r.parent.right = r.left;
								else r.parent.left = r.left;
					}
					r.parent = r.left;												
					if(r.parent.right != null) { r.left = r.parent.right; r.parent.right.parent = r; r.parent.right = r; }
					else { r.left = null; r.parent.right = r; }

					r.ht = r.ht - 2;
					updateHeight(r);
					
			}

			public static void singleRotationRight(Node r) {
					
					r.right.parent = r.parent;						
					if(r.parent != null) {
								if(r.parent.right != null && r.parent.right == r) r.parent.right = r.right;
								else r.parent.left = r.right;
					}
					r.parent = r.right;												
					if(r.parent.left != null) { r.right = r.parent.left; r.parent.left.parent = r; r.parent.left = r; }
					else { r.right = null; r.parent.left = r; }

					r.ht = r.ht - 2;
					updateHeight(r);
					
			}

			public static void doubleRotationLeft(Node r) {
					
					r.left = r.left.right;
					if(r.left.left != null) { 
									r.left.parent.right = r.left.left; 
									r.left.parent.parent = r.left;
									r.left.left.parent = r.left.parent;
									r.left.left = r.left.parent;
									r.left.parent = r;

									r.left.parent = r.parent;						
									if(r.parent != null) {
												if(r.parent.right != null && r.parent.right == r) r.parent.right = r.left;
												else r.parent.left = r.left;
									}
									r.parent = r.left;																		
									if(r.parent.right != null) { r.left = r.parent.right; r.parent.right.parent = r; r.parent.right = r; }
									else { r.left = null; r.parent.right = r; }											
					}
					else {						 
						r.left.parent.right = null;
						r.left.parent.parent = r.left;							
						r.left.left = r.left.parent;
						r.left.parent = r;
						
						r.left.parent = r.parent;						
						if(r.parent != null) {
									if(r.parent.right != null && r.parent.right == r) r.parent.right = r.left;
									else r.parent.left = r.left;
						}
						r.parent = r.left;																		
						if(r.parent.right != null) { r.left = r.parent.right; r.parent.right.parent = r; r.parent.right = r; }
						else { r.left = null; r.parent.right = r; }
					}

					r.ht = r.ht - 2;
					r.parent.left.ht = r.parent.left.ht - 1;
					updateHeight(r);										
					
			}

			public static void doubleRotationRight(Node r) {
					
					r.right = r.right.left;
					if(r.right.right != null) { 
									r.right.parent.left = r.right.right; 
									r.right.parent.parent = r.right;
									r.right.right.parent = r.right.parent;
									r.right.right = r.right.parent;
									r.right.parent = r;

									r.right.parent = r.parent;						
									if(r.parent != null) {
												if(r.parent.left != null && r.parent.left == r) r.parent.left = r.right;
												else r.parent.right = r.right;
									}
									r.parent = r.right;
									if(r.parent.left != null) { r.right = r.parent.left; r.parent.left.parent = r; r.parent.left = r; }
									else { r.right = null; r.parent.left = r; }											
					}
					else {
						r.right.parent.left = null; 
						r.right.parent.parent = r.right;							
						r.right.right = r.right.parent;
						r.right.parent = r;
							
						r.right.parent = r.parent;						
						if(r.parent != null) {
									if(r.parent.left != null && r.parent.left == r) r.parent.left = r.right;
									else r.parent.right = r.right;
						}
						r.parent = r.right;												
						if(r.parent.left != null) { r.right = r.parent.left; r.parent.left.parent = r; r.parent.left = r; }
						else { r.right = null; r.parent.left = r; }
					}

					r.ht = r.ht - 2;
					r.parent.right.ht = r.parent.right.ht - 1;
					updateHeight(r);
					
			}

			public static void updateHeight(Node r) {

					if(r == null) System.out.print("");
					else if(r.left != null && r.right != null) { r.ht = max(r.left.ht, r.right.ht) + 1; updateHeight(r.parent); }
					else if(r.left == null && r.right != null) { r.ht = r.right.ht + 1; updateHeight(r.parent); } 
					else if(r.left != null && r.right == null) { r.ht = r.left.ht + 1; updateHeight(r.parent); }
					else { r.ht = 0; updateHeight(r.parent); }
			}

			public static int max(int a, int b) {

					if(a > b) return a;
					else return b;
			}
			
}

			