package review;

public class ArithmaticReview {
	
	private ArithmaticReview() {
		final int a1 = 2;
		final int a2 = 5;
		System.out.println(a1 + " * " + a2 + " = " + (a1 * a2));
		System.out.println(a1 + " / " + a2 + " = " + (a1 / a2));
		System.out.println(a1 + " % " + a2 + " = " + (a1 % a2));
		System.out.println(a1 + " + " + a2 + " = " + (a1 + a2));
		System.out.println(a1 + " - " + a2 + " = " + (a1 - a2));
		
		final double a3 = 10.8;
		final double a4 = 7.2;
		System.out.println(a3 + " * " + a4 + " = " + (a3 * a4));
		System.out.println(a3 + " / " + a4 + " = " + (a3 / a4));
		System.out.println(a3 + " % " + a4 + " = " + (a3 % a4));
		System.out.println(a3 + " + " + a4 + " = " + (a3 + a4));
		System.out.println(a3 + " - " + a4 + " = " + (a3 - a4));
		
		final boolean a = true;
		final boolean b = false;
		System.out.println("a && b = " + (a && b));
		System.out.println("a || b = " + (a || b));
		System.out.println("!a = " + !a);
		System.out.println("!b = " + !b);
	}
	
	public static void main(String[] args) {
		new ArithmaticReview();
	}

}