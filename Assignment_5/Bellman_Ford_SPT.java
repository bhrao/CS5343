import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

class Node {
		int val;
		int d;		
		Node next;
		Node(int val) {this.val = val; this.d = 0; this.next = null;}

	}

class LinkedList {			
			Node head;			
		}

class Graph {
		int v;
		LinkedList L[];
		
		Graph(int v) {
				this.v = v;
				L = new LinkedList[v];

				for(int i = 0; i < v ; i++){ 
                			L[i] = new LinkedList(); 
            			} 
		}
	}

class Bellman_Ford_SPT {

		public static void main(String args[]) {
			
			Scanner sc = new Scanner(System.in);
			int v = 10;

			System.out.print("\nChoose from the following : \n\n1. Edges with negative values but no negative cycle\n\n2. Edges with negative values and negative cycle");
			System.out.print("\n\nPlease enter a value from the above options : ");
			int c = sc.nextInt();

			Graph g = null;

			if(c == 1) g = createGraph_1(v);
			else g = createGraph_2(v);
			
			printGraph(g);

			System.out.print("\nShortest path tree of the given graph is : ");
			SPT(g);
								
		}		

		public static void addEdge(Graph g, int u, int v, int d) {

			Node temp = new Node(v);
			temp.d = d;
			temp.next = g.L[u].head;
			g.L[u].head = temp;

		}

		public static void listTraverse(Node n) {

			if(n == null) System.out.print("");
			else { System.out.print(" -> " + n.val); listTraverse(n.next); }
		}

		public static void printGraph(Graph g) {

			for(int i = 0; i < g.v; i++) { 
            
				System.out.println("Adjacency list of vertex "+ i); 
            			System.out.print("head"); 
            			listTraverse(g.L[i].head); 
            			System.out.println("\n"); 
        		}
		}

		public static Graph createGraph_1(int v) {

			Graph graph = new Graph(v);
			addEdge(graph, 0, 1, -1);
			addEdge(graph, 0, 2, 4);
			addEdge(graph, 1, 2, 3);			
			addEdge(graph, 1, 3, 2);
			addEdge(graph, 1, 4, 2);
			addEdge(graph, 3, 1, 1);
			addEdge(graph, 3, 2, 5);
			addEdge(graph, 2, 5, 8);
			addEdge(graph, 4, 3, -3);			
			addEdge(graph, 5, 7, 15);
			addEdge(graph, 5, 3, -9);
			addEdge(graph, 6, 3, -20);
			addEdge(graph, 6, 9, 9);
			addEdge(graph, 7, 8, 4);			
			addEdge(graph, 7, 6, 1);
			addEdge(graph, 9, 8, -13);
			addEdge(graph, 9, 2, 18);			
			addEdge(graph, 8, 3, 3);

			return graph;
		}

		public static Graph createGraph_2(int v) {

			Graph graph = new Graph(v);
			addEdge(graph, 0, 1, -1);
			addEdge(graph, 0, 2, 4);
			addEdge(graph, 1, 2, 3);			
			addEdge(graph, 1, 3, 2);
			addEdge(graph, 1, 4, 2);
			addEdge(graph, 3, 1, 1);
			addEdge(graph, 3, 2, 5);
			addEdge(graph, 2, 5, -8);
			addEdge(graph, 4, 3, -3);			
			addEdge(graph, 5, 7, 5);
			addEdge(graph, 5, 3, -9);
			addEdge(graph, 6, 3, -20);
			addEdge(graph, 6, 9, 9);
			addEdge(graph, 7, 8, 4);			
			addEdge(graph, 7, 6, 1);
			addEdge(graph, 9, 8, -13);
			addEdge(graph, 9, 2, 18);			
			addEdge(graph, 8, 3, 3);

			return graph;
		}

		public static void SPT(Graph g) {

			int[] d = new int[10];		//array containing distance values from source
			Arrays.fill(d, 9999);
			d[0] = 0; 
			int[] p = new int[10];		//array containing source vertex
			int tc = 1;
			Node temp = null;

			for(int j = 0; j < g.v && tc > 0; j++) {
			
				tc = 0;

				for(int i = 0; i < g.v; i++) {

					temp = g.L[i].head;					

					while(temp != null) {

						if(d[temp.val] == 9999) { d[temp.val] = d[i] + temp.d; p[temp.val] = i; temp = temp.next; tc++;}
						else if(d[temp.val] > d[i] + temp.d) { d[temp.val] = d[i] + temp.d; p[temp.val] = i; temp = temp.next; tc++;}
						else temp = temp.next;  
					
					}					
				
				}

				if(j == g.v - 1 && tc > 0) { System.out.print("Negative cycle detected in the graph\n"); }				
				else if( tc == 0) printSPT(p);
				else System.out.print("");
			}

			
		}

		public static void printSPT(int[] p) {

			for(int i = 0; i < p.length; i++) {

				System.out.println(p[i] + " -> " + i);
			}		
		}
		
}
