import java.util.Scanner;

class PowerN {

		public static void main (String args[]) {

			// take the number you want calculate power for
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the number");

			int n = sc.nextInt();

			// take the value of power you want to raise the number by
			System.out.println("Enter the power value:");

			int p = sc.nextInt();

			System.out.println("Value of " + n + " power " + p + " is " + Power(n, p)); 

		}

		public static int Power(int i, int j) {

			if(j == 0) return 1;

			if(j % 2 != 0) return i * Power(i, j/2) * Power(i, j/2);

			else return Power(i, j/2) * Power(i, j/2);

		}

}