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

class Create_Graph {

		public static void main(String args[]) {

			System.out.print("Enter the number of vertices in the graph : ");
			Scanner sc = new Scanner(System.in);
			int v = sc.nextInt();

			Graph g = createGraph(v);
			
			printGraph(g);
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
				t = findNode(graph.L[s].head, d);			
				if(t == 0) addEdge(graph, s, d);
			}

			return graph;
		}

		public static void listTraverse(Node n) {

			if(n.next == null) System.out.print(" -> " + n.val);
			else { System.out.print(" -> " + n.val); listTraverse(n.next); }
		}

		public static int findNode(Node n, int v) {

			if(n == null) return 0;
			else if(n.val == v) return 1;
			else return findNode(n.next, v);		
		}

}
