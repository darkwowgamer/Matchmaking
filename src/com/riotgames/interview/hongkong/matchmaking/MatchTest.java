package com.riotgames.interview.hongkong.matchmaking;

import model.MatchmakerImpl;
import controller.PlayersPicker.RangedPlayersPicker;
import controller.PlayersSpliter.HighLowPlayersSpliter;

public class MatchTest {

	public static void main(String[] args) {
		MatchmakerImpl mm = new MatchmakerImpl(SampleData.getPlayers(),
				new RangedPlayersPicker(), new HighLowPlayersSpliter());
		mm.findMatch(1);
	}
}