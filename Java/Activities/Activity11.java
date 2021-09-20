package activities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Activity11 {
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> colours = new HashMap<Integer, String>();
		colours.put(1, "Red");
		colours.put(2, "White");
		colours.put(3, "Brown");
		colours.put(4, "Blue");
		colours.put(5, "Green");
		
		System.out.println("Elements in hash map:");
		Set<Entry<Integer, String>> setObj = colours.entrySet(); 
		Iterator<Entry<Integer, String>> iterator = setObj.iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, String> meObj = iterator.next();
			System.out.println("Key: " + meObj.getKey() + " & " + "Value: " + meObj.getValue());
		}
		
		System.out.println("Removing 'Key: 4' from the hash map");
		colours.remove(4);
		
		System.out.println("Is 'Green' present in the hash map: " + colours.containsValue("Green"));
		
		System.out.println("Size of hash map: " + colours.size());
		
	}
	
}
