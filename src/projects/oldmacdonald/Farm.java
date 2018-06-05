package projects.oldmacdonald;

public class Farm {
	
	private Animal[] a = new Animal[3];

	public Farm() {
		a[0] = new Cow("cow", "moo");
		a[1] = new Chicken("chick", "cluck", "chuck");
		a[2] = new Pig("pig", "oink");
		animalSounds();
	}

	public void animalSounds() {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].getType() + " goes " + a[i].getSound());
		}
	}

	public static void main(String[] args) {
		new Farm();
	}

}
