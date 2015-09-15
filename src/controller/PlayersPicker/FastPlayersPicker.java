package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Player;

//this PlayerPicker will randomly pick the first player from players and use the following players to make the match.
//the reason why this is called fast is that as long as they are enough players, it can start the game and the players matched together have consecutive ratings
public class FastPlayersPicker extends PlayersPicker {
	@Override
	public ArrayList<Player> pickPlayers(int playerCount,
			ArrayList<Player> players) {
		Collections.sort(players);
		ArrayList<Player> matchedPlayers = new ArrayList<Player>();
		Random randomGenerator = new Random();
		int firstPlayerIndex = randomGenerator.nextInt(players.size()
				- playerCount);
		for (int i = firstPlayerIndex; i < playerCount; i++) {
			matchedPlayers.add(players.get(i));
		}
		players.removeAll(matchedPlayers);
		return matchedPlayers;
	}
}