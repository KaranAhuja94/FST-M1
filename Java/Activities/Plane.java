package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
	
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOff;
	private Date lastTimeLanded;
	
	public Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		passengers = new ArrayList<>();
	}
	
	public void onboard(String passenger) {
		passengers.add(passenger);
	}
	
	public Date takeOff() {
		lastTimeTookOff = new Date();
		return lastTimeTookOff;
	}
	
	public Date land() {
		this.lastTimeLanded = new Date();
		passengers.clear();
		return lastTimeLanded;
	}
	
	public Date getLastTimeLanded() {
		return land();
	}
	
	public List<String> getPassengers(){
		return passengers;
	}
}
