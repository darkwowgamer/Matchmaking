package playersSpliter;

import java.util.ArrayList;

import com.riotgames.interview.hongkong.matchmaking.Player;

public abstract class PlayersSpliter {
	// this method will split players into two consecutive parts and each part
	// represent a team
	public abstract ArrayList<Player> splitPlayer(int playerCount,
			ArrayList<Player> players);
}