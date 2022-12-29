package assignmentone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Reverse each number in list.
 * 
 * @author amans
 *
 */
public class ProgFour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Number of Integers
		int N = sc.nextInt();
		sc.nextLine();
		List<Integer> ls = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ls.add(sc.nextInt());
			sc.nextLine();
		}
		sc.close();
		System.out.println("Output");
		List<Integer> reverse = reverseEachNumber(ls);
		reverse.forEach(System.out::println);

	}
	
	
	//Utility function to reverse each number present in list.
	public static List<Integer> reverseEachNumber(List<Integer> ls) {
		List<Integer> res = ls.stream()
				.map((number) -> Integer.parseInt(String.valueOf(new StringBuffer(number.toString()).reverse())))
				.collect(Collectors.toList());
		return res;
	}

}
