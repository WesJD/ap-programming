package projects.mediaitem;

public class BookCD extends CD {

	private final String author;
	private final String narrator;
	
	public BookCD(String title, double playTime, int copyrightYear, int tracks, 
			String author, String narrator) {
		super(title, playTime, copyrightYear, tracks);
		this.author = author;
		this.narrator = narrator;
	}

	public String getAuthor() {
		return author;
	}

	public String getNarrator() {
		return narrator;
	}
	
	@Override
	public String toString() {
		return "BookCD{super=" + super.toString() + ", author=" + author + ", narrator=" + narrator + "}";
	}
	
}
