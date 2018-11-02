import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

class Node {
		int val;		
		Node next;
		Node(int val) {this.val = val; this.next = null;}

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

class Graph_Traverse {

		public static void main(String args[]) {

			System.out.print("\nEnter the number of vertices in the graph : ");
			Scanner sc = new Scanner(System.in);
			int v = sc.nextInt();

			Graph g = createGraph(v);
			
			printGraph(g);

			System.out.print("DFS traverse : ");
			boolean d[] = new boolean[v];
			DFSprint(g, 0, d);

			System.out.println("");

			System.out.print("\nBFS traverse : ");
			boolean b[] = new boolean[v];
			BFSprint(g, 0, b);
		}		

		public static void addEdge(Graph g, int s, int d) {

			Node temp = new Node(d);
			temp.next = g.L[s].head;
			g.L[s].head = temp;

			temp = new Node(s);
			temp.next = g.L[d].head;
			g.L[d].head = temp;
		}

		public static void printGraph(Graph g) {

			for(int i = 0; i < g.v; i++) { 
            
				System.out.println("Adjacency list of vertex "+ i); 
            			System.out.print("head"); 
            			listTraverse(g.L[i].head); 
            			System.out.println("\n"); 
        		}
		}

		public static Graph createGraph(int v) {

			Graph graph = new Graph(v);
			Random rand = new Random();
			int s, d, t;
			for(int i = 0; i < 2*v; i++) {

				s = rand.nextInt(v);
				d = rand.nextInt(v);
				if(s == d && s == v-1) d = v-2;
				else if(s == d) d = v-1;
				else d = d; 
				t = findNode(graph.L[s].head, d); 		
				if(t == 0) addEdge(graph, s, d);
			}

			return graph;
		}

		public static void listTraverse(Node n) {

			if(n == null) System.out.print("");
			else { System.out.print(" -> " + n.val); listTraverse(n.next); }
		}

		public static int findNode(Node n, int v) {

			if(n == null) return 0;
			else if(n.val == v) return 1;
			else return findNode(n.next, v);		
		}

		public static void DFSprint(Graph g, int v, boolean b[]){
						
			b[v] = true;
			System.out.print(v + " ");
			
			Node t = g.L[v].head;
			while(t != null) {

				if(b[t.val] != true) { DFSprint(g, t.val, b); }
				t = t.next;
			}
  			
		}

		public static void BFSprint(Graph g, int v, boolean b[]) {

			System.out.print(v + " ");
			b[v] = true;
			Node h = new Node(v);
			BFSListprint(g, g.L[v].head, h, b); 
			h = h.next;
			while(h != null) {
				
				BFSListprint(g, g.L[h.val].head, h, b); 
				h = h.next;
			}
		}

		public static void BFSListprint(Graph g, Node n, Node h, boolean b[]) {
			
			if(n == null || (n.next == null && b[n.val] == true)) System.out.print("");
			else if(n.next == null && b[n.val] != true) { b[n.val] = true; addToList(h, n.val); System.out.print(n.val + " "); }
			else if(b[n.val] == true) BFSListprint(g, n.next, h, b);
			else { b[n.val] = true; addToList(h, n.val); System.out.print(n.val + " "); BFSListprint(g, n.next, h, b); }
		}

		public static void addToList(Node n, int v) {

			if(n.next == null) n.next = new Node(v);
			else addToList(n.next, v);						
		}		

}
