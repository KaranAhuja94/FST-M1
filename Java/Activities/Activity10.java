package activities;

import java.util.HashSet;
import java.util.Iterator;

public class Activity10 {
	
	public static void main(String[] args) {
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("Apple");
		hs.add("Pear");
		hs.add("Kiwi");
		hs.add("Watermellon");
		hs.add("Banana");
		hs.add("Strawberry");
		
		System.out.println("Size of hash set: " + hs.size());
		
		hs.remove("Kiwi");
		
		if(hs.remove("Blueberry"))
			System.out.println("Blueberry removed from the hash set");
		else
			System.out.println("Blueberry is not present in the hash set");
		
		System.out.println("Is 'Apple' present in the hash set: " + hs.contains("Apple"));
		
		System.out.println("Updated hash set:");
		Iterator<String> iterator = hs.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
}
