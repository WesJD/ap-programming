package projects;

import static java.lang.System.out;

public class Recursion {
	
	private Recursion() {
		out.println(fibonacci(4));
		out.println(triange(4));
		out.println(array220(new int[] {2, 21, 211}, 0));
		out.println(g(g(2)));
		out.println(reverse("free response questions are easy"));
	}
	
	private int fibonacci(int index) {
		if(index <= 0) return 0;
		else if(index == 1) return 1;
		else return fibonacci(index - 2) + fibonacci(index - 1);
	}
	
	private int triange(int rows) {
		if(rows <= 0) return 0;
		else if(rows == 1) return 1;
		else return triange(rows - 1) + rows;
	}
	
	private boolean array220(int[] nums, int index) {
		if(index < 0 || index >= nums.length || index + 1 >= nums.length) return false;
		else if(nums[index + 1] == nums[index] * 10) return true;
		else return array220(nums, index + 1);
	}
	
	public int f(int n) {
		if(n == 0) return 1;
		return f(n-1) + g(n-1);
	}
	
	public int g(int n) {
		if(n == 0) return 1;
		return g(n-1) + f(n);
	}
	
	private String reverse(String input) {
		int index = input.indexOf(' ');
		if(index != -1) return reverse(input.substring(index + 1)) + " " +  input.substring(0, index);
		else return input;
	}
	
 	public static void main(String[] args) {
		new Recursion();
	}

}
