package playerPicker;

import java.util.ArrayList;
import java.util.Random;

import com.riotgames.interview.hongkong.matchmaking.Player;

//totally random picking players to make a match.
//difference with FastPlayerPicker is that this one don't sort the arraylist
public class NaivePlayerPicker extends PlayerPicker {
	public ArrayList<Player> pickPlayers(int playerCount,
			ArrayList<Player> players) {
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