package projects.mediaitem;

public class MediaItem {
	
	private final String title;
	private final double playTime;
	private final int copyrightYear;
	
	public MediaItem(String title, double playTime, int copyrightYear) {
		this.title = title;
		this.playTime = playTime;
		this.copyrightYear = copyrightYear;
	}

	public String getTitle() {
		return title;
	}

	public double getPlayTime() {
		return playTime;
	}

	public int getCopyrightYear() {
		return copyrightYear;
	}
	
	@Override
	public String toString() {
		return "MediaItem{title=" + title + ", playTime=" + playTime + ", copyrightYear=" + copyrightYear + "}";
	}
	

}
