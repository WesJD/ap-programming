package utils;

import java.util.List;

import static java.lang.System.out;

public class PrintingUtils {
	
	public static <T> void printOrder(List<T> values) {
		for(int i=0; i < values.size(); i++) out.println((i + 1) + ". " + values.get(i));
	}

}
