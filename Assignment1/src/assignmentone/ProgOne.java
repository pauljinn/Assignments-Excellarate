package assignmentone;
import java.util.Scanner;

/**
 * Program to find the sum of all digits
 * @author amans
 *
 */
public class ProgOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Taking number of test cases.
		int T = sc.nextInt();
		sc.nextLine();
		//Creating an array of numbers whose size equivalent to number of test cases.
		int[] number = new int[T];
		//Taking numbers from user.
		for(int t=0;t<T;t++) {
			number[t] = sc.nextInt();
			sc.nextLine();
		}
		//Printing output.
		System.out.println("Output");
		for(int i=0;i<number.length;i++) {
			System.out.println(findDigitSum(number[i]) + " ");
		}
		
	}
	
	/**
	 * A utility function to find the number of digit in number.
	 * @param num
	 * @return number of digits.
	 */
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
