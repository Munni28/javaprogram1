import java.util.Scanner;

//To print Factors of a given number 
public class NoOfFactors {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		n = sc.nextInt();
		int count = 0;
		for(int i=1;i<=n;i++) {
			if(n%i == 0) {
				count += 1;
			}
		}
		System.out.println("The no.of factors of "+n+" are: "+count);
	}

}
