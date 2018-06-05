package projects.votes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import utils.PrintingUtils;
import static java.lang.System.out;

public class VoteCounter {
	
	private final List<Candidate> candidates = Arrays.asList(
			new Candidate("Jessica", 0),
			new Candidate("James", 1),
			new Candidate("Joan", 2),
			new Candidate("Jacob", 3)
	);
	
	private VoteCounter() {
		try(Scanner in = new Scanner(new File("vote.txt"))) {
			final List<String> lines = new ArrayList<>();
			while(in.hasNextLine()) lines.add(in.nextLine());
			
			int validVotes = 0;
			for(int i=0; i < lines.size(); i++) {
				final String line = lines.get(i);
				final String[] values = line.split("  ");
				
				final List<Candidate> toVoteFor = new ArrayList<>();
				int totalVotes = 0;
				for(int j=0; j < values.length; j++) {
					final String element = values[j];
					final int value = Integer.parseInt(element);
					if(value == 1) {
						final Candidate candidate = candidates.get(j);
						toVoteFor.add(candidate);
						candidate.addPupularVote();
						totalVotes++;
					}
				}
				
				if(totalVotes < 3) {
					toVoteFor.forEach(Candidate::addVote);
					validVotes++;
				}
			}
			
			out.println("Out of " + lines.size() + " total votes, " + validVotes + " were valid.");
			
			out.println();
			
			out.println("Candidates, sorted by total votes:");
			candidates.sort((first, second) -> -Integer.compare(first.getVotes(), second.getVotes()));
			markWinner();
			PrintingUtils.printOrder(candidates);
			
			out.println();
			
			out.println("Candidates, sorted by total popular votes:");
			candidates.sort((first, second) -> -Integer.compare(first.getPopularVotes(), second.getPopularVotes()));
			markWinner();
			PrintingUtils.printOrder(candidates);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	private void markWinner() {
		for(int i=0; i < candidates.size(); i++) candidates.get(i).setCurrentWinner(i == 0);
	}
	
	public static void main(String[] args) {
		new VoteCounter();
	}

}
