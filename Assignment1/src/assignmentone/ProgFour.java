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
		//A list to store numbers.
		List<Integer> ls = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ls.add(sc.nextInt());
			sc.nextLine();
		}
		sc.close();
		System.out.println("Output");
		//Calling our utility function to reverse each number in the list.
		List<Integer> reverse = reverseEachNumber(ls);
		reverse.forEach(System.out::println);

	}
	
	/**
	 * Utility function to reverse each number present in list.
	 * @param ls
	 * @return
	 */
	public static List<Integer> reverseEachNumber(List<Integer> ls) {
		//Using stream map to loop through each number in list and mapping to it's reverse
		//By first converting the number to a String Buffer and then using StrinBuffer API
		//reverse() to reverse the number. Finally converting the number back to integer
		//and storing it to a list of integers.
		List<Integer> res = ls.stream()
				.map((number) -> Integer.parseInt(String.valueOf(new StringBuffer(number.toString()).reverse())))
				.collect(Collectors.toList());
		return res;
	}

}
