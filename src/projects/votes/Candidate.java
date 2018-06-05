package projects.votes;

public class Candidate {
	
	private final String name;
	private final int index;
	private int popularVotes;
	private int votes;
	private boolean currentWiner = false;
	
	public Candidate(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public void addPupularVote() {
		popularVotes += 1;
	}
	
	public void addVote() {
		votes += 1;
	}
	
	public void setCurrentWinner(boolean currentWiner) {
		this.currentWiner = currentWiner;
	}
	
	public String getName() {
		return name;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getPopularVotes() {
		return popularVotes;
	}
	
	public int getVotes() {
		return votes;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(name)
			.append(" - Total Votes: ")
			.append(votes)
			.append(", Popular Votes: ")
			.append(popularVotes);
		if(currentWiner) sb.append(" (WINNER)");
		return sb.toString();
	}
	
}
