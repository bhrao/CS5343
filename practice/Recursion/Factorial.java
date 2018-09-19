import java.util.Scanner;

class Factorial {

	public static void main(String args[]) {

		// taking number input from user
		Scanner sc = new Scanner(System.in); 
		System.out.println("Please enter a number for which you need factorial value:");
		int n = sc.nextInt();

		System.out.print("Factorial value of " + n + " is " + Fact(n));

	}

	public static int Fact(int n) {

		if(n == 0) return 1;

		else return n * Fact(n-1);

	}	

}