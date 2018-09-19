import java.util.Scanner;

class Fibonacci {

			public static void main(String args[]) {

					// Enter the number to find fibonacci value for

					System.out.println("Enter the number to find fibonacci value for ");

					Scanner sc = new Scanner(System.in);
					int num = sc.nextInt();

					System.out.println(num + "th Fibonacci value is " + FibVal(num));

					
			}

			public static int FibVal(int i) {

					
					if(i == 0) return 0;

					if(i == 1) return 1;

					else return FibVal(i-1) + FibVal(i-2);

			}

}