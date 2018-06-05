package projects.oldmacdonald;

public class Cow implements Animal {
	
	private String myType;
	private String mySound;

	public Cow(String type, String sound) {
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
