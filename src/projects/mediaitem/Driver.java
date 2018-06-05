package projects.mediaitem;

import static java.lang.System.out;

public class Driver {
	
	private Driver() {
		final MediaItem item = new MediaItem("25", 52.5, 2015);
		final CD cd = new CD("21", 54.5, 2011, 11);
		final BookCD bookCd = new BookCD("Thinking fast and slow", 607, 2011, 9, "Daniel Kahneman", "Patrick Egan");
		out.println(item);
		out.println(cd);
		out.println(bookCd);
	}
	
	public static void main(String[] args) {
		new Driver();
	}

}
