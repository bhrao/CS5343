import java.util.Scanner;
import java.util.Arrays;

class PrefixAvg {

	public static void main(String args[]) {

		// taking String array input from user 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Please enter length of String array"); 

		int length = sc.nextInt(); 

		// create a String array to save user input 

		String[] input = new String[length]; 

		// loop over array to save user input 

		System.out.println("Please enter array elements"); 

		for (int i = 0; i < length; i++) 
			{ 
				String userInput = sc.next(); 
				input[i] = userInput; 
			}

		int s = 0, A = 0;

		for (int j = 0; j < length; j++)
			{
				s = s + Integer.parseInt(input[j]);
				A = s / (j+1);
			}

		System.out.println("Prefix Avg is " + A);
				
				
	}
}

