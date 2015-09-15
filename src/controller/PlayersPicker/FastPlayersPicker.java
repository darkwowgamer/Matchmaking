package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Player;

/**
 * This PlayerPicker will randomly pick the first player from players and use
 * the following players to make the match. The reason why this is called fast
 * is that as long as they are enough players, it can start the game and the
 * players matched together have consecutive ratings.
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
				- playerCount);
		for (int i = 0; i < playerCount; i++) {
			matchedPlayers.add(players.get(i + firstPlayerIndex));
		}
		// remove all picked players from players pool
		players.removeAll(matchedPlayers);
		return matchedPlayers;
	}
}