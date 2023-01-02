package exceptionassignment;

import java.util.List;

public class NullPointerExceptionExample {
	public static void main(String[] args) {
		NullPointerExceptionExample obj = null;
		/**
		 * Whenever we call a class method on a null object then it cause NPE because
		 * there is no object of that class exist through which we can call that class
		 * method
		 */
		try {
			System.out.println("*****NPE EXAMPLE ONE******");
			obj.NpeExampleOne();
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		obj = new NullPointerExceptionExample();
		try {
			System.out.println("*****NPE EXAMPLE TWO******\n");
			obj.NpeExampleTwo();
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("\n");
		}

		try {
			System.out.println("*****NPE EXAMPLE THREE******\n");
			obj.NpeExampleThree();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	/**
	 * When the object is null from which this method is called then it cause NPE.
	 */
	public void NpeExampleOne() {
		System.out.println("This is a class to show the Null Pointer Exception");
	}

	/**
	 * When wrapper object is null and it's used inside an if to check for a
	 * condition then it cause NPE..
	 */
	public void NpeExampleTwo() {
		// Using a boolean wrapper and storing null in it.
		Boolean flag = null;
		// When we try to check for null value if IF this will cause NPE.
		if (flag) {
			System.out.println("Hello");
		} else {
			System.out.println("Bye");
		}
	}

	/**
	 * When a collection object is null and it's used for further operation like
	 * displaying it's item then it cause NPE..
	 */
	public void NpeExampleThree() {
		List<String> nameList = null;
		nameList.forEach(System.out::println);

	}
}
