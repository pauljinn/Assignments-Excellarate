package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * A class to solve all question related to list.
 * @author amans
 *
 */
public class ArrayListOperation {
	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<>();
		ls.add(10);
		ls.add(4);
		ls.add(8);
		ls.add(30);
		ls.add(1);
		System.out.println("Array list initially " + ls);
		/**
		 * Q1- Remove an element from specified index of Java Array List
		 */
		System.out.println("\n*********QUESTION 1*********\n");
		
		//Removing an element from index 0 from the list
		ls.remove(0);
		//Printing the new list.
		System.out.println("List after removal of element from index 0 " + ls);
		
		/**
		 * Q2-Copy all elements of Java Array List to an Object Array.
		 */
		System.out.println("\n*********QUESTION 2*********\n");
		
		//Copying all elements of array list using toArray() method of ArrayList.
		Object objectArray[] = ls.toArray();
		//Printing the copied array on console.
		System.out.print("Copied object array from list: ");
		Arrays.stream(objectArray).forEach((objectArrayElement)->System.out.print(objectArrayElement + " "));
		
		/**
		 * Q3-Create List from Java Object Array
		 */
		System.out.println("\n\n*********QUESTION 3*********\n");
		//Creating list from object array using asList().
		List<Object> objectList = Arrays.asList(objectArray);
		
		//Printing the new list on console.
		System.out.println("\nObject list from object array: "+ objectList);
		
		/**
		 * Q4-Copy Elements of One Java Array List to Another Java Array List
		 */
		System.out.println("\n*********QUESTION 4*********\n");
		
		//Copying all element of array list to another array list using stream().
		ArrayList<Integer> copyList = ls.stream().collect(Collectors.toCollection(ArrayList::new));
		
		//Printing the copied list.
		System.out.println("Copied array list is " + copyList);
		
		/**
		 * Q5-Find Minimum element of Java Array List
		 */
		System.out.println("\n*********QUESTION 5*********\n");
		
		//Using collections API min() to find minimum element in array list.
		int min = Collections.min(ls);
		System.out.println("Minimum element in array list is " + min);
		
		/**
		 * Q6-Find maximum element of Java HashSet.
		 */
		System.out.println("\n*********QUESTION 6*********\n");
		
		//Creating a new Hash Set from our array list.
		Set<Integer> set = new HashSet<>(ls);
		System.out.println("Hash Set initially " + set);
		
		//Finding the max element in hash set using collections API max()
		int max = Collections.max(set);
		System.out.println("Maximum value in Hash Set is " + max);
		
		/**
		 * Q7-Get Enumeration over Java Array List
		 */
		System.out.println("\n*********QUESTION 7*********\n");
		
		//Enumeration is an interface came before Iterator to enumerate over each element.
		Enumeration<Integer> e = Collections.enumeration(ls);
		//Enumerating and printing.
		System.out.print("Enumerated value ");
		while(e.hasMoreElements()) {
			System.out.print(e.nextElement() + " ");
		}
		
		/**
		 * Q8-Get Synchronized List from Java Array List.
		 */
		System.out.println("\n\n*********QUESTION 8*********\n");
		
		//Method One using synchronized list.
		List<Integer> syncLsOne = Collections.synchronizedList(ls);
		System.out.println("Synchronized list one " + syncLsOne);
		
		//Method two using using copyonwritearraylist.
		CopyOnWriteArrayList<Integer> syncLsTwo = new CopyOnWriteArrayList<>(ls);
		System.out.println("Synchrnized list two " + syncLsTwo);
		
		/**
		 * Q10-Reverse order of all elements of Java Array List.
		 */
		System.out.println("\n*********QUESTION 9*********\n");
		
		//Reversing the order of all element in list using reverse().
		Collections.reverse(ls);
		//Printing the reversed list.
		System.out.println("Reversed list " +ls);
		
		
		/**
		 * Q11-Shuffle elements of Java Array List
		 */
		System.out.println("\n*********QUESTION 10*********\n");
		
		System.out.println("List before shuffeling" + ls);
		//Using collections shuffle() we can shuffle the list.
		Collections.shuffle(ls);
		System.out.println("Shuffled list " + ls);
		
		
		/**
		 * Q12-Sort Java Array List in descending order using comparator. 
		 */
		System.out.println("\n*********QUESTION 10*********\n");
		
		System.out.println("Before sorting " + ls);
		//Using collections sort with a comparator whose implementation of compare(obj1,obj2) is provided using lambda expression.
		//We can also create a class or can use anonymous class here for providing the compare() implementation.
		Collections.sort(ls, (number1,number2)->number2-number1);
		
		System.out.println("After sorting in descending order" + ls);
		
		/**
		 * Q16- Add or insert an element to Array List using Java List Iterator.
		 */
		System.out.println("\n*********QUESTION 16*********\n");
		
		System.out.println("List initially " + ls);
		
		//Creating a list iterator.
		ListIterator<Integer> itr = ls.listIterator();
		
		//Iterating through each list element.
		while(itr.hasNext()) {
			//Adding 10 before each list element.
			itr.add(10);
			//Moving to next list element.
			itr.next();
		}
		
		System.out.println("List after adding 10 before each element using list iterator is " + ls);
		
		/**
		 * Q17-Traverse through Array List in reverse direction using Java List Iterator
		 */
		System.out.println("\n*********QUESTION 17*********\n");
		
		System.out.println("List initially " + ls);
		
		//Creating a list iterator with index at size of our list so that previous() give size-1 element that is last element.
		itr = ls.listIterator(ls.size());
		System.out.println("Traversing list in reverse direction...");
		//Iterating in backward direction.
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
		
	}
	

}
