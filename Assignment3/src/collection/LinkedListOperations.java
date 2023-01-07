package collection;

import java.util.LinkedList;

public class LinkedListOperations {

	public static void main(String[] args) {
		/**
		 * Q15 - Add elements at beginning and end of LinkedList.
		 */
		System.out.println("*********QUESTION 15*********\n");
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(2);
		linkedList.add(4);
		
		//Adding at last of linked list.
		linkedList.addLast(10);
		
		//Adding at begining of linked list.
		linkedList.addFirst(1);
		
		//Printing the final linked list.
		System.out.println("Linked list " + linkedList);

	}

}
