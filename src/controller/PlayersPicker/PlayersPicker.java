package controller.PlayersPicker;

import java.util.List;

import model.Player;

/**
 * Abstract class of players picker.
 * 
 * PlayerPicker is used to pick players for a match. Different picking strategy
 * can be applied to different implementation. No matter what picking strategy
 * is taken, players should be arranged in the arraylist based on their rating
 * so that spliter can work on this.
 * 
 * Note: returned players are sorted in rating order, no matter what rating
 * criterion is taken.
 */
public abstract class PlayersPicker {
	public abstract List<Player> pickPlayers(int playerCount,
			List<Player> players);

	public abstract String toString();
}