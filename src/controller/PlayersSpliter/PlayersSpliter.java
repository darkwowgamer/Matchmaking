package controller.PlayersSpliter;

import java.util.ArrayList;

import model.Player;

public abstract class PlayersSpliter {
	// this method will split players into two consecutive parts and each part
	// represent a team
	public abstract ArrayList<Player> splitPlayer(int playerCount,
			ArrayList<Player> players);
}