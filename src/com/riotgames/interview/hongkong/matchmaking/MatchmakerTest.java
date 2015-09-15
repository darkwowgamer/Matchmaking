package com.riotgames.interview.hongkong.matchmaking;

import model.MatchmakerImpl;
import controller.PlayersPicker.TierRangedPlayersPicker;
import controller.PlayersSpliter.HighLowPlayersSpliter;

public class MatchmakerTest {
	public static void main(String[] args) {
		MatchmakerImpl mm = new MatchmakerImpl(SampleData2.getPlayers(),
				new TierRangedPlayersPicker(), new HighLowPlayersSpliter());
		mm.findMatch(5);
	}
}