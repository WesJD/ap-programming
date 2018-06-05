package review;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	private List<NumberHolder> holders = new ArrayList<>();
	
	private Test() {
		holders.add(new NumberHolder("bob"));
		holders.add(new NumberHolder("joe"));
		holders.add(new NumberHolder("mark"));
		holders.add(new NumberHolder("ben"));
		holders.add(new NumberHolder("ryan"));
		
		log();
		
		for(NumberHolder holder : holders) {
			if(holder.getName() == "mark") holder.increment();
		}
		
		log();
	}
	
	private void log() {
		holders.forEach(System.out::println);
		System.out.println("end --");
		System.out.println();
	}
	
	private class NumberHolder {
		
		private String name;
		private int value = 0;
		
		public NumberHolder(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void increment() {
			value++;
		}
		
		@Override
		public String toString() {
			return name + " has value " + value;
		}
		
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
