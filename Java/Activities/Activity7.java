package activities;

public class Activity7 {

	public static void main(String[] args) {
		
		MountainBike bikeObj = new MountainBike(3, 0, 25);  
		System.out.println(bikeObj.bicycleDesc());
		bikeObj.speedUp(20);
		bikeObj.applyBrake(5);		
	}

}
