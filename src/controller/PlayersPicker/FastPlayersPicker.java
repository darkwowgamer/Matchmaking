package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Player;

/**
 * Based on RangedPlayersPicker, this picker uses tierDiff to define maximum
 * allowed tier difference, which I think is also used in LoL so that Platinum
 * players can't be matched with Master players no matter what their MMR is.
 */
public class FastPlayersPicker extends PlayersPicker {
	@Override
	public List<Player> pickPlayers(int playerCount, List<Player> players) {
		// first sort players according to their rate(can be win rate or other
		// criteria)
		Collections.sort(players);
		// @matchedPlayers used to store result;
		List<Player> matchedPlayers = new ArrayList<Player>();
		Random randomGenerator = new Random();
		// randomly pick the first player, at least playerCount number of
		// players available to pick
		int firstPlayerIndex = randomGenerator.nextInt(players.size()
				- playerCount + 1);
		for (int i = 0; i < playerCount; i++) {
			matchedPlayers.add(players.get(i + firstPlayerIndex));
		}
		// remove all picked players from players pool
		players.removeAll(matchedPlayers);
		return matchedPlayers;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FastPlayersPicker");
		return sb.toString();
	}
}