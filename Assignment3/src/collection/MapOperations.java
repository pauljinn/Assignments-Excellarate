package collection;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.HashMap;
/**
 * A class to solve all question related to map.
 * @author amans
 *
 */
public class MapOperations {

	public static void main(String[] args) {
		Map<String,Integer> numberMapping = new HashMap<>();
		numberMapping.put("First",1);
		numberMapping.put("Second",2);
		numberMapping.put("Third", 3);
		/**
		 * Q9- Get Synchronized Map from Java HashnumberMapping
		 */
		System.out.println("*********QUESTION 9*********\n");
		
		//Method 1 using collections synchronized map.
		Map<String,Integer> syncMapOne = Collections.synchronizedMap(numberMapping);
		System.out.println("Synchronized map one " + syncMapOne);
		
		//Method 2 using concurrent map.
		
		Map<String,Integer> syncMapTwo = new ConcurrentHashMap<>(numberMapping);
		System.out.println("Synchronized map two " + syncMapTwo);
		
		/**
		 * Q13- Iterate through the values of Java HashMap
		 */
		System.out.println("\n*********QUESTION 13*********\n");
		
		System.out.println("Iterating over Hash Map...");
		for(Map.Entry<String, Integer> entry:numberMapping.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		/**
		 * Q14- Remove value from Java HashMap.
		 */
		System.out.println("\n*********QUESTION 14*********\n");
		
		//Remove the "first" key and it's value from the map.
		numberMapping.remove("First");
		System.out.println("Map after removing \"First\" " + numberMapping);

	}

}
