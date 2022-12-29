package assignmentone;
import java.util.Scanner;

/**
 * Program to find the sum of all digits
 * @author amans
 *
 */
public class ProgOne {
	public static void main(String[] args) {
		//Taking Input
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		int[] number = new int[T];
		for(int t=0;t<T;t++) {
			number[t] = sc.nextInt();
			sc.nextLine();
		}
		System.out.println("Sum of digit of all numbers entered are: ");
		for(int i=0;i<number.length;i++) {
			System.out.print(findDigitSum(number[i]) + " ");
		}
		
	}
	
	public static int findDigitSum(int num) {
		int result = 0;
		int temp = num;
		while(temp!=0) {
			result += temp %10;
			temp = temp/10;
		}
		return result;
	}
}
