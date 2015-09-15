package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Player;

/**
 * This players picker will first sort the palyers, then it uses a maxDiff
 * representing the maximum difference allowed among players. Difference with
 * FastPlayersPicker is that if the last player to be picked doesn't satisfy
 * rateDiff, it will try next player as first picked player
 */
public class RangedPlayersPicker extends PlayersPicker {
	// maximum win rate difference allowed to form a team;
	private final double rateDiff = 0.2;

	@Override
	public List<Player> pickPlayers(int playerCount, List<Player> players) {
		Collections.sort(players);
		List<Player> matchedPlayers = new ArrayList<Player>();
		// @tries try how many times before stop
		int tries = players.size();
		while (tries-- > 0) {
			Random ran = new Random();
			int firstPlayerIndex = ran.nextInt(players.size() - playerCount);
			if (players.get(firstPlayerIndex).getWinRate() + rateDiff < players
					.get(firstPlayerIndex + playerCount - 1).getWinRate()) {
				continue;
			}
			for (int i = 0; i < playerCount; i++) {
				matchedPlayers.add(players.get(firstPlayerIndex + i));
			}
			players.removeAll(matchedPlayers);
			return matchedPlayers;
		}
		return null;
	}
}