package activities;

public class Activity2 {
	
	public static void main(String[] args) {
		
		int[] array = {10,77,10,54,-11,10};
		int length = array.length;
		int value = 30, sum = 0;
		
		for(int i = 0; i < length; i++) {
			if(array[i] == 10)
				sum += array[i];
		}
		
		if(sum == value)
			System.out.println("Sum of all 10's is exactly " + sum);
		else
			System.out.println("Sum of all 10's is not eqaul to 30");
	}
	
	
}
