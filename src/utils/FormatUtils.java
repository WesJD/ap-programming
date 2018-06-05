package utils;

public class FormatUtils {
	
	public static String repeat(String value, int times) {
		final StringBuilder sb = new StringBuilder();
		for(int i=0; i < times; i++) sb.append(value);
		return sb.toString();
	}
	
	public static <T> String getSpaces(T value, int allowedWidth) {
		return repeat(" ", allowedWidth - (value + "").length());
	}

}
