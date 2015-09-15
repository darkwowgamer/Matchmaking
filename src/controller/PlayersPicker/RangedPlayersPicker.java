package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;

import model.Player;

//RangedPlayerPicker implements PlayerPicker,
//it will first sort the palyers, then it uses a maxDiff representing the maximum difference between players
public class RangedPlayersPicker extends PlayersPicker {
	// maximum win rate difference allowed to form a team;
	private final double maxDiff = 0.2;

	@Override
	public ArrayList<Player> pickPlayers(int playerCount,
			ArrayList<Player> players) {
		Collections.sort(players);
		ArrayList<Player> matchedPlayers = new ArrayList<Player>();
		for (int i = 0; i <= players.size() - 10; i++) {
			if (players.get(i).getWinRate() + maxDiff >= players.get(
					i + playerCount - 1).getWinRate()) {
				for (int j = i; j < i + 10; j++) {
					matchedPlayers.add(players.get(j));
				}
				players.removeAll(matchedPlayers);
				return matchedPlayers;
			}
		}
		return null;
	}
}