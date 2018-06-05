package utils;

public class Pair<T, F> {
	
	private final T one;
	private final F two;
	
	public Pair(T one, F two) {
		this.one = one;
		this.two = two;
	}

	public T getOne() {
		return one;
	}

	public F getTwo() {
		return two;
	}
	
	public static <T, F> Pair<T, F> of(T one, F two) {
		return new Pair<T, F>(one, two);
	}

}
