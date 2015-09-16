package tester;

import java.util.ArrayList;

import model.Match;
import model.MatchmakerImpl;
import controller.PlayersPicker.RangedPlayersPicker;
import controller.PlayersSpliter.HighLowPlayersSpliter;

public class MatchmakerTester {
	public static void main(String[] args) {
		MatchmakerImpl mm = new MatchmakerImpl(SampleData.getPlayers(),
				new RangedPlayersPicker(), new HighLowPlayersSpliter());
		System.out.println(mm.toString());
		ArrayList<Match> matches = new ArrayList<Match>();
		Match tmpMatch = mm.findMatch(5);
		while (tmpMatch != null) {
			System.out.println("Match No." + matches.size() + ":");
			System.out.println(tmpMatch.toString());
			matches.add(tmpMatch);
			tmpMatch = mm.findMatch(5);
		}
		System.out.println("Total matches found:" + matches.size());
	}
}