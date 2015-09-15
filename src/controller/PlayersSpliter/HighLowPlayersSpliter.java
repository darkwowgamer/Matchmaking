package controller.PlayersSpliter;

import java.util.ArrayList;

import model.Player;

//since the players are all in order, put the first and the last player in the arraylist together, the second and the second to last together, and so on
public class HighLowPlayersSpliter extends PlayersSpliter {
	@Override
	public ArrayList<Player> splitPlayer(int playerCount,
			ArrayList<Player> players) {
		ArrayList<Player> splittedPlayers = new ArrayList<Player>();
		for (int i = 0; i < playerCount; i++) {
			splittedPlayers.add(players.get(i));
			splittedPlayers.add(players.get(players.size() - i - 1));
		}
		return splittedPlayers;
	}
}