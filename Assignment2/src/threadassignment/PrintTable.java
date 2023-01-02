package threadassignment;

public class PrintTable {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Implementing a runnable interface run(). So, that it can be used to create
		 * and run thread using Thread class.
		 */
		Runnable printTwoTable = () -> {
			//Printing table of two.
			int count = 1;
			while (count <= 10) {
				System.out.println("2*" + count + "=" + 2 * count);
				count++;
			}
			System.out.println("");
		};

		Runnable printThreeTable = () -> {
			//Printing table of three.
			int count = 1;
			while (count <= 10) {
				System.out.println("3*" + count + "=" + 3 * count);
				count++;
			}
		};
		//This thread will print table of two.
		Thread printTableOfTwo = new Thread(printTwoTable);
		//This thread will print table of three.
		Thread printTableOfThree = new Thread(printThreeTable);
		
		//Starting our first thread.
		printTableOfTwo.start();
		
		/**
		 * Join() method ensure until this thread completes it's execution no new thread will start running.
		 * Hence, on console complete table of two will be printed then table of three will print.
		 */
		printTableOfTwo.join();
		
		//Starting our second thread.
		printTableOfThree.start();
	}

}
