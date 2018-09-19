import java.util.Scanner;

class Palindrome {
			public static void main(String args[]) {

					// take the input string to check whether if it is a palindrome
					System.out.println("Input the String to check:");
					Scanner sc = new Scanner(System.in);
					String s = sc.next();					

					System.out.println("Is the given string \"" + s + "\" a palindrome: " + check_string(s, 0, s.length() - 1));
			
			}

			public static boolean check_string(String s, int i, int j) {					

					if((j == 1) || (i > j)) return true;
				
					if(String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(j))) == false) return false;

					else return check_string(s, i+1, j-1);

			}

}  
					