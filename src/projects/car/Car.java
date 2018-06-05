package projects.car;

public class Car {
	
	private int initialOdometer;
	private int endingOdometer;
	private double totalGallons;
	
	public Car(int initialOdometer) {
		this.initialOdometer = initialOdometer;
		this.totalGallons = 0;
	}
	
	public void fillUp(int endingOdometer, double gallonsFilled) {
		this.endingOdometer = endingOdometer;
		totalGallons = gallonsFilled;
	}
	
	public double calculateMpg() {
		final double ret = ((endingOdometer - initialOdometer) / totalGallons);
		initialOdometer = endingOdometer;
		return ret;
	}

}
