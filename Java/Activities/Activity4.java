package activities;

public class Activity4 {

	public static void insertionSort(int[] array) {
		
		int i,j,key,length;
		length = array.length;
		
		for(i=1;i<length;i++) {
			key = array[i];
			j = i-1;
			
			while(j >= 0 && key <= array[j]) {
				array[j+1] = array[j];
				j-=1;
			}
			array[j+1] = key;	
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] numbers = {10,3,9,1,12,0,5,1,2};
		
		System.out.println("Before Sorting Array:");
		for (int number : numbers) {
			System.out.print(number + " ");
		}
		
		System.out.println("\n");
		
		insertionSort(numbers);
		
		System.out.println("After Sorting Array:");
		for (int element : numbers) {
			System.out.print(element + " ");
		}

	}

}
