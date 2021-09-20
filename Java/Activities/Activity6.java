package activities;

public class Activity6 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Plane planeObj = new Plane(10);
		
		planeObj.onboard("John");
		planeObj.onboard("Kim");
		planeObj.onboard("Kiara");
		
		System.out.println("Take-Off time: " + planeObj.takeOff());
		
		System.out.println("Passenger List: " + planeObj.getPassengers());
		
		Thread.sleep(5000);
		
		System.out.println("Time of landing: " + planeObj.getLastTimeLanded());
	}
	
}
