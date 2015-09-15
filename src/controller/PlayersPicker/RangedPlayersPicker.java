package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Player;

//RangedPlayerPicker implements PlayerPicker,
//it will first sort the palyers, then it uses a maxDiff representing the maximum difference between players
public class RangedPlayersPicker extends PlayersPicker {
	// maximum win rate difference allowed to form a team;
	private final double rateDiff = 0.2;

	@Override
	public ArrayList<Player> pickPlayers(int playerCount,
			ArrayList<Player> players) {
		Collections.sort(players);
		ArrayList<Player> matchedPlayers = new ArrayList<Player>();
		int tries = players.size();
		while (tries-- > 0) {
			Random ran = new Random();
			int firstIndex = ran.nextInt(players.size() - 10);
			if (players.get(firstIndex).getWinRate() + rateDiff >= players.get(
					firstIndex + playerCount - 1).getWinRate()) {
				for (int i = firstIndex; i < firstIndex + 10; i++) {
					matchedPlayers.add(players.get(i));
				}
				players.removeAll(matchedPlayers);
				return matchedPlayers;
			}
		}
		return null;
	}
}