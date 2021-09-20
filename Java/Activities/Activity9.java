package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("John");
		myList.add("Reene");
		myList.add("Kristen");
		myList.add("Ram");
		myList.add("Kiara");
		
		System.out.println("Names:");
		for(String name:myList){
			System.out.println(name);
		}
		
		System.out.println("Third name in array list: " + myList.get(2));
		
		System.out.println("Is 'John' present in the array list: " + myList.contains("John"));
		
		System.out.println("Number of names in the array list: " + myList.size());
		
		myList.remove(2);
		
		System.out.println("Number of names in new array list: " + myList.size());
	}

}
