package activities;

public class Car {
	
	String color = "Black", transmission = "Manual";
	int make = 2014, tyres, doors;
	
	public Car(int tyres, int doors) {
		this.tyres=tyres;
		this.doors=doors;
	}
	
	public void displayCharacteristics() {
		System.out.println("Color of the car: " + color);
		System.out.println("Transmission: " + transmission);
		System.out.println("Car make: " + make);
		System.out.println("Number of tyres: " + tyres);
		System.out.println("Number of doors: " + doors);
	}
	
	public void accelarate() {
		System.out.println("Car is moving forward");
	}
	
	public void brake() {
		System.out.println("Car has stopped");
	}

}
