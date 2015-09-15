package controller.PlayersSpliter;

import java.util.ArrayList;
import java.util.List;

import model.Player;

/**
 * Interleaving given players and return the result.
 */
public class NaivePlayersSpliter extends PlayersSpliter {
	@Override
	public List<Player> splitPlayer(int playerCount, List<Player> players) {
		List<Player> splittedPlayers = new ArrayList<Player>();
		for (int i = 0; i < playerCount / 2; i++) {
			splittedPlayers.add(players.get(i * 2));
		}
		for (int i = 0; i < playerCount / 2; i++) {
			splittedPlayers.add(players.get(i * 2 + 1));
		}
		return splittedPlayers;
	}
}