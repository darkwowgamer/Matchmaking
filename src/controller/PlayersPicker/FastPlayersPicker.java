package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Player;

//this PlayerPicker will randomly pick the first player from players and use the following players to make the match.
//the reason why this is called fast is that as long as they are enough players, it can start the game and the players matched together have consecutive ratings
public class FastPlayersPicker extends PlayersPicker {
	@Override
	public List<Player> pickPlayers(int playerCount, List<Player> players) {
		Collections.sort(players);
		List<Player> matchedPlayers = new ArrayList<Player>();
		Random randomGenerator = new Random();
		int firstPlayerIndex = randomGenerator.nextInt(players.size()
				- playerCount);
		for (int i = 0; i < playerCount; i++) {
			matchedPlayers.add(players.get(i + firstPlayerIndex));
		}
		players.removeAll(matchedPlayers);
		return matchedPlayers;
	}
}