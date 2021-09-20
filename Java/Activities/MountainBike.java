package activities;

public class MountainBike extends Bicycle {
	
	public int seatHeight;
	
	public MountainBike(int seatHeight,int gears, int currentSpeed) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
	}

	public void seatHeaight(int newValue) {
		seatHeight = newValue;
	}
	
	public String bicycleDesc() {
		return (super.bicycleDesc() + " \nSeat height: " + seatHeight);
	}
	
	
}
