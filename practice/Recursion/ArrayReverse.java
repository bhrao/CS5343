import java.util.Scanner;
import java.util.Arrays;

class ArrayReverse {

	public static void main (String args[]) {

		//taking array values from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter length of String array:");

		int length = sc.nextInt();

		//create an array to save user input 

		int[] s = new int[length];

		System.out.println("Enter the array values:");

		// loop over array to save user input

		for (int i = 0; i < length; i++) {

			int input = sc.nextInt();
			s[i] = input;
		}

		System.out.println("Given array is " + Arrays.toString(s));
		System.out.println("Reversed array is " + Arrays.toString(ArrayR(s, 0, length-1)));

	}

	public static int[] ArrayR (int[] s, int i, int j) {

		// take array along with index positions to swap

		int k;	
 
		if(i >= j) return s;

		else {
			k = s[i];
			s[i] = s[j];
			s[j] = k;
			return ArrayR(s, i+1, j-1); 
		     }

	}

}