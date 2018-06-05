package review;

public class StarPrint {
	
	private StarPrint() {
		for(int i=0; i < 6; i++) {
			for(int x=0; x <= i; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i < 11; i++) {
			for(int x=0; x < 11-i; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i < 6; i++) {
			final int delta = 6 - i;
			final int stars = 2 * delta;
			for(int x=0; x < 12-stars; x++) {
				System.out.print(" ");
			}
			for(int x=0; x < stars; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new StarPrint();
	}

}
