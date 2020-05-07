/*
purpose: to practice the implementation of different methods that do different things
*/

public class Bicycle {

	private int cadence;   
	private int speed;   
	private int gear;   
	public void changeCadence(int newValue) {      
		cadence = newValue;   }   
	public void changeGear(int newValue) {       
		gear = newValue;   }   
	public void speedUp(int increment) {      
		speed = speed + increment;      }   
	public void applyBrakes(int decrement) {     
		speed = speed - decrement;   }   
	public void printStates() {      
		System.out.println(cadence + " " + speed + " " + gear);   
}
}