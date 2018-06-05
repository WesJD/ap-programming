package projects.mediaitem;

public class CD extends MediaItem {

	private final int tracks;

	public CD(String title, double playTime, int copyrightYear, int tracks) {
		super(title, playTime, copyrightYear);
		this.tracks = tracks;
	}

	public int getTracks() {
		return tracks;
	}
	
	@Override
	public String toString() {
		return "CD{super=" + super.toString() + ", tracks=" + tracks + "}";
 	}
	
}
