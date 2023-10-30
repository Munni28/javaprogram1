import java.util.Scanner;

//Factorial of given number
public class Factorial {

	public static void main(String[] args) {
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		a = sc.nextInt();
		int fact = 1;
		
		for(int i=1;i<=a;i++) {
			fact = fact*i;
		}
		System.out.println("The Factorial of "+a+"! is: "+fact);
	}

}

