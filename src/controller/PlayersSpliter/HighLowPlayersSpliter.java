package controller.PlayersSpliter;

import java.util.ArrayList;
import java.util.List;

import model.Player;

/**
 * Since the players are all in order, put the first and the last player in the
 * arraylist together, the second and the second to last together, and so on.
 * Fianlly, return the result.
 */
public class HighLowPlayersSpliter extends PlayersSpliter {
	@Override
	public List<Player> splitPlayer(int playerCount, List<Player> players) {
		List<Player> splittedPlayers = new ArrayList<Player>();
		for (int i = 0; i < playerCount / 2; i++) {
			splittedPlayers.add(players.get(i));
			splittedPlayers.add(players.get(players.size() - i - 1));
		}
		return splittedPlayers;
	}
}