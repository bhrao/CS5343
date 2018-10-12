import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.Random;

class CreateHeap {

			public static void main(String args[]) {

				System.out.print("\nEnter the length of integer array : ");
				Scanner sc = new Scanner(System.in);
				int len = sc.nextInt();

				int[] heapArray = new int[len];
				
				createArray(heapArray);

				System.out.println("\nValues in the array before converting to heap :");
				printArray(heapArray);

				convertToHeap(heapArray, (heapArray.length - 1)/2, 0);

				System.out.println("\nValues in the array after converting to heap :");				
				printArray(heapArray);

				System.out.print("\n\nEnter a value to insert in the converted heap : ");
				int v = sc.nextInt();

				heapArray = increaseArray(heapArray);

				insertValue(heapArray, v);

				System.out.println("\nValues in the array after inserting " + v + " in the heap :");				
				printArray(heapArray);

				System.out.print("\n\nEnter a value to delete from the heap : ");
				int d = sc.nextInt();

				int array_index = searchArray(heapArray, d);

				if(array_index == -1) System.out.println("Given value not in the array.");

				else {
					deleteValue(heapArray, d, array_index);
					System.out.println("\nValues in the array after deleting " + d + " in the heap :");				
					printArray(heapArray);
				}
							
			}

			public static void createArray(int[] h) {

				System.out.println("\nDo you want enter your own values for the list? if Yes, enter 1 \nif No, enter 0");
				Scanner a = new Scanner(System.in);
				int auto = a.nextInt();

				int i = 1;
				h[0] = h.length - 1;
				while (i < h.length) {
						
					if(auto == 1) {

						System.out.println("Enter the value " + i+1 + " of array");
						h[i] = a.nextInt();
						i++;
					}

					else {

						Random rand = new Random();
						h[i] = rand.nextInt(10*h.length);
						i++;
					}
				}
			}

			public static void printArray(int[] h) {

				for(int i = 1; i <= h[0]; i++) {

					System.out.print(h[i] + " ");
				}
			}

			public static void convertToHeap(int[] h, int i, int j) {

				if(i == 0) System.out.println("");
				else {

					if(((2 * i) + 1 ) <= h[0]) { 

						if(h[2*i] < h[(2*i) + 1] && h[2*i] < h[i]) { 

							j = h[2*i]; 
							h[2*i] = h[i]; 
							h[i] = j; 
							percolateDown(h, 2*i, 0);
							convertToHeap(h, --i, 0); 
						}

						else if(h[(2*i) + 1] < h[2*i] && h[(2*i) + 1] < h[i]) { 

							j = h[(2*i) + 1]; 
							h[(2*i) + 1] = h[i]; 
							h[i] = j;
							percolateDown(h, (2*i)+1, 0); 
							convertToHeap(h, --i, 0); 
						}

						else convertToHeap(h, --i, 0);
					}

					else { 
						if(h[2*i] < h[i]) { 
							
							j = h[2*i]; 
							h[2*i] = h[i]; 
							h[i] = j;
							percolateDown(h, 2*i, 0); 
							convertToHeap(h, --i, 0); 

						}
	
						else convertToHeap(h, --i, 0);						
					}
				}
			}

			public static void percolateDown(int[] h, int i, int j) {

				if((2*i) >= h.length && ((2*i) + 1) >= h.length) System.out.print("");

				else if((2*i) < h.length && ((2*i) + 1) >= h.length) {

					if(h[2*i] < h[i]) {

						j = h[2*i];
						h[2*i] = h[i];
						h[i] = j;
						percolateDown(h, 2*i, 0);
					}										
				}
				
				else {

					if(h[2*i] < h[(2*i) + 1] && h[2*i] < h[i]) { 

						j = h[2*i]; 
						h[2*i] = h[i]; 
						h[i] = j; 
						percolateDown(h, 2*i, 0); 
					}

					else if(h[(2*i) + 1] < h[2*i] && h[(2*i) + 1] < h[i]) { 

						j = h[(2*i) + 1]; 
						h[(2*i) + 1] = h[i]; 
						h[i] = j; 
						percolateDown(h, (2*i)+1, 0); 
					}

					else System.out.print("");
				}
			}

			public static int[] increaseArray(int[] h) {
	
				if(h[0] == h.length - 1) {

					int[] temp = new int[h.length + 1];
					for(int i = 0; i < h.length; i++) {
					
						temp[i] = h[i];
					}

					h = temp;
					return h;
				}
				
				else return h;				
			}

			public static void insertValue(int[] h, int v) {

				h[h[0]+1] = v;
				h[0] = h[0] + 1;
				percolateUp(h, h[0], 0);
			}

			public static void percolateUp(int[] h, int i, int j) {

				if(i == 1 || h[i] >= h[i/2]) System.out.print("");

				else { j = h[i]; h[i] = h[i/2]; h[i/2] = j; percolateUp(h, i/2, 0); }				
			}

			public static void deleteValue(int[] h, int v, int i) {				
				
				 
				h[i] = h[h[0]]; h[0] = h[0] - 1; percolateDown(h, i, 0);
			}

			public static int searchArray(int[] A, int v) { 
				
				int i = 0;		
				while(A[i] != v && i <= A[0]) {

					i++;
				}

				if(i <= A[0]) return i;
				else return -1;						
							
			}
			
}