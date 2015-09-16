package controller.PlayersSpliter;

import java.util.List;

import model.Player;

/**
 * Abstract class of players spliter.
 * 
 * After required number of players have been picked, use this class to split
 * players into two teams.
 * 
 * Note: given players should be stored in rating order, no matter what rating
 * criterion is taken.
 */
public abstract class PlayersSpliter {
	public abstract List<Player> splitPlayer(int playerCount,
			List<Player> players);
}