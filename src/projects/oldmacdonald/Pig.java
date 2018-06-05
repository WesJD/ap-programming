package projects.oldmacdonald;

public class Pig implements Animal {

	private String myType;
	private String mySound;

	public Pig(String type, String sound) {
		myType = type;
		mySound = sound;
	}

	@Override
	public String getSound() {
		return mySound;
	}

	@Override
	public String getType() {
		return myType;
	}
	
}
