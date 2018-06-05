package projects.oldmacdonald;

import java.util.concurrent.ThreadLocalRandom;

public class Chicken implements Animal {

	private String type;
	private String[] sounds;

	public Chicken(String type, String... sounds) {
		this.type = type;
		this.sounds = sounds;
	}

	@Override
	public String getSound() {
		return sounds[ThreadLocalRandom.current().nextInt(sounds.length)];
	}

	@Override
	public String getType() {
		return type;
	}
	
}
