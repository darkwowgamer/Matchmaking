package tester;

import java.util.ArrayList;

import model.Match;
import model.MatchmakerImpl;
import controller.PlayersPicker.TierRangedPlayersPicker;
import controller.PlayersSpliter.HighLowPlayersSpliter;

public class MatchmakerTester {
	public static void main(String[] args) {
		MatchmakerImpl mm = new MatchmakerImpl(SampleData.getPlayers(),
				new TierRangedPlayersPicker(), new HighLowPlayersSpliter());
		ArrayList<Match> matches = new ArrayList<Match>();
		Match tmpMatch = mm.findMatch(5);
		while (tmpMatch != null) {
			System.out.println("Match number " + matches.size() + ":");
			System.out.println(tmpMatch.toString());
			matches.add(tmpMatch);
			tmpMatch = mm.findMatch(5);
		}
		System.out.println("Found match number:" + matches.size());
	}
}