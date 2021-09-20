package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random indexGen = new Random();
		
		System.out.println("Enter numbers:");
		
		while(scan.hasNextInt()) {
			list.add(scan.nextInt());
		}
		
		Integer[] number = list.toArray(new Integer[0]);
		int index = indexGen.nextInt(number.length);
		
		System.out.println("Index value: " + index);
		System.out.println("Value generated at index: " + number[index]);
		
		scan.close();

	}

}
