package playerPicker;

import java.util.ArrayList;

import com.riotgames.interview.hongkong.matchmaking.Player;

//PlayerPicker is used to pick players for a match.
//different picking strategy can be applied to different implementation.
//no matter what picking strategy is taken, the result arraylist should follow logical order so that players can be splitted
public abstract class PlayerPicker {
	public abstract ArrayList<Player> pickPlayers(int playerCount,
			ArrayList<Player> players);
}