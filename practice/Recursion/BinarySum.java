import java.util.Scanner;
import java.util.Arrays;

class BinarySum {

			public static void main(String args[]) {

					// specify the length of array
					System.out.println("Enter the length of array:");					

					Scanner sc = new Scanner(System.in);
					int array_len = sc.nextInt();

					// collect array values and store them 

					int[] array_val = new int[array_len];
					System.out.println("Enter the array values");

					for(int i = 0; i < array_len; i++) {

										int array_input = sc.nextInt();
										array_val[i] = array_input;

									   }

					System.out.println("Sum of the values in array is " + Sum(array_val, 0, array_len));

			}

			public static int Sum (int A[], int i, int j) {

					if(j == 1) return A[i];

					if(j % 2 == 0) return Sum(A, i, j/2) + Sum(A, i + (j/2), j/2);

					else return Sum(A, i, (j-1) / 2) + Sum(A, i + ((j-1) / 2), (j+1) / 2);

			}

}
									