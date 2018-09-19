import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class TertiarySearch {

			public static void main(String args[]) {

						System.out.print("\nEnter the length of Array : ");
						Scanner sc = new Scanner(System.in);
						int len = sc.nextInt();

						int[] s = createArray(len);
						Arrays.sort(s);
						System.out.println("\nGiven array is " + Arrays.toString(s));

						System.out.print("\nEnter a value to search in the array : ");
						int v = sc.nextInt();

						int array_index = bSearch(s, 0, len, v);
						if(array_index == -1) System.out.println("\nValue not in the list");
						else System.out.println("\nGiven value " + v + " is at index " + array_index);
						
			}

			public static int[] createArray(int len) {
											
						Scanner sc = new Scanner(System.in);						

						//create an array to save user input 
						int[] s = new int[len];
						int v;

						System.out.println("\nDo you want enter your own values for the list? if Yes, enter 1 \nif No, enter 0");					
						int rd_val = sc.nextInt();
						
						if(rd_val == 0) {	
									for (int i = 0; i < len; i++) {
													Random rand = new Random(); 
													v = rand.nextInt(1000);													
													s[i] = v;
									}																					
						}

						else {
							for (int i = 0; i < len; i++) {
											System.out.println("\nEnter a value for the list");									
											v = sc.nextInt();
											s[i] = v;
							} 
						}						

						return s;
			}

			public static int bSearch(int[] A, int l_idx, int h_idx, int v) { 
						
						int mid1 = l_idx + ((h_idx - l_idx + 1)/3);
						int mid2 = l_idx + (2 * (h_idx - l_idx + 1)/3);

						if(l_idx > h_idx) return -1;

						else if(A[mid1] == v) return mid1;
						else if(A[mid2] == v) return mid2;
						
						else if(A[mid1] > v) return bSearch(A, l_idx, mid1-1, v);
						else if(A[mid2] > v) return bSearch(A, mid1+1, mid2-1, v);
						else return bSearch(A, mid2+1, h_idx, v);						
							
			}

}
