import java.util.Scanner;

class IsPrime {

			public static void main(String args[]) {

					//take the number input
					System.out.println("Enter the number to find if it is prime or not");
					Scanner sc = new Scanner(System.in);
					int n = sc.nextInt();
					System.out.println("Is " + n + " a prime number: " + is_prime(2, n));

			}

			public static boolean is_prime (int i, int n) {

					if((n == 0) || (n == 1)) return false;

					if((i * i) > n) return true;

					if((n % i) == 0) return false;

					else return is_prime(i+1, n);

			}

}
					
					