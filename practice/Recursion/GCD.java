import java.util.Scanner;

class GCD {

		public static void main(String args[]) {

				// Enter the numbers to find GCD
				System.out.println("Enter the numbers to find GCD");
				Scanner sc = new Scanner(System.in);
				int m = sc.nextInt();
				int n = sc.nextInt();

				System.out.println("GCD of numbers " + m + ", " + n + " is " + gcd_val(m, n));

		}

		public static int gcd_val(int i, int j) {

				if(i == 0) return j;

				if(j == 0) return i;

				if(i > j) return gcd_val(j, (i%j));

				else return gcd_val(i, j % i);

		}

}