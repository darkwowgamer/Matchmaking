package controller.PlayersSpliter;

import java.util.ArrayList;

import model.Player;

public class NaivePlayersSpliter extends PlayersSpliter {
	@Override
	public ArrayList<Player> splitPlayer(int playerCount,
			ArrayList<Player> players) {
		ArrayList<Player> splittedPlayers = new ArrayList<Player>();
		for (int i = 0; i < playerCount / 2; i++) {
			if (i % 2 == 0) {
				splittedPlayers.add(players.get(i));
			}
		}
		for (int i = 0; i < playerCount / 2; i++) {
			if (i % 2 != 0) {
				splittedPlayers.add(players.get(i));
			}
		}
		return splittedPlayers;
	}
}