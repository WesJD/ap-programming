package review;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

import utils.ReaderUtils;

public class CollegeSelector {
	
	private final College[] colleges = new College[] {
			new College("Harvey Mudd (CA)", 1, SchoolSize.SMALL, Coast.WEST),
			new College("MIT (MA)", 1, SchoolSize.SMALL, Coast.EAST),
			new College("U of Wisconsin (WS)", 1, SchoolSize.LARGE, Coast.WEST),
			new College("Penn State (PA)", 1, SchoolSize.LARGE, Coast.EAST),
			new College("Denver University (CO)", 2, SchoolSize.SMALL, Coast.WEST),
			new College("Capital University (OH)", 2, SchoolSize.SMALL, Coast.EAST),
			new College("U of Oregon (OR)", 2, SchoolSize.LARGE, Coast.WEST),
			new College("Syracuse (NY)", 2, SchoolSize.LARGE, Coast.EAST)
	};
	
	private CollegeSelector() {
		final Scanner scanner = new Scanner(System.in);
		final int tier = ReaderUtils.readFromUser(
								scanner, 
								"How selective is the insitution? \nType a number 1-2 for tier types", 
								(input) -> {
									final int parsed = Integer.parseInt(input);
									if(parsed > 0 && parsed <= 2) return parsed;
									else throw new ReaderUtils.InvalidInput();
								});
		final SchoolSize size = ReaderUtils.readFromUser(
								scanner, 
								"What is the school size? \nSmall (s) [0-8000] or large (l) [8000+].",
								(input) -> {
									final SchoolSize ret = Arrays.stream(SchoolSize.values())
											.filter((s) -> isLogicallyInputted(s.toString(), input))
											.findFirst()
											.orElse(null);
									if(ret == null) throw new ReaderUtils.InvalidInput();
									else return ret;
								});
		final Coast coast = ReaderUtils.readFromUser(
								scanner, 
								"Where is the school located? \nEast (e) or west (w) ooast?",
								(input) -> {
									final Coast ret = Arrays.stream(Coast.values())
											.filter((c) -> isLogicallyInputted(c.toString(), input))
											.findFirst()
											.orElse(null);
									if(ret == null) throw new ReaderUtils.InvalidInput();
									else return ret;
								});
		
		final College college = Arrays.stream(colleges)
				.filter((school) -> school.isApplicable(tier, size, coast))
				.findFirst()
				.orElse(null);
		if(college == null) System.out.println("No college found for your preference!");
		else System.out.println("You should go to " + college.getName() + "!");
	}
	
	private boolean isLogicallyInputted(String toCheck, String fromInput) {
		final String check = toCheck.toLowerCase();
		final String input = fromInput.toLowerCase();
		return input.startsWith(check) || input.charAt(0) == check.charAt(0);
	}
	
	private static class College {
		
		private final String name;
		private final int tier;
		private final SchoolSize size;
		private final Coast coast;
		
		public College(String name, int tier, SchoolSize size, Coast coast) {
			this.name = name;
			this.tier = tier;
			this.size = size;
			this.coast = coast;
		}
		
		public String getName() {
			return name;
		}
		
		public boolean isApplicable(int tier, SchoolSize size, Coast coast) {
			return (this.tier == tier && this.size == size && this.coast == coast);
		}
		
	}
	
	private enum Coast {
		EAST,
		WEST
	}
	
	private enum SchoolSize {
		LARGE, 
		SMALL;
	}
	
	public static void main(String[] args) {
		new CollegeSelector();
	}

}
