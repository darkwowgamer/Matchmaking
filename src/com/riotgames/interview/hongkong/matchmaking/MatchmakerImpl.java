package com.riotgames.interview.hongkong.matchmaking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import playerPicker.PlayerPicker;
import playersSpliter.PlayersSpliter;

/**
 * The matchmaking implementation that you will write.
 */
public class MatchmakerImpl implements Matchmaker {
	private ArrayList<Player> players;
	private PlayerPicker playerPicker;
	private PlayersSpliter playersSpliter;

	public MatchmakerImpl(PlayerPicker playerPicker,
			PlayersSpliter playersSpliter) {
		this.playerPicker = playerPicker;
		this.playersSpliter = playersSpliter;
	}

	public Match findMatch(int playersPerTeam) {
		int playerCount = playersPerTeam * 2;
		if (playerCount > players.size()) {
			return null;
		}
		ArrayList<Player> matchedPlayers = playerPicker.pickPlayers(
				playerCount, players);
		if (matchedPlayers == null) {
			return null;
		}
		matchedPlayers = playersSpliter
				.splitPlayer(playerCount, matchedPlayers);
		Set<Player> team1 = new HashSet<Player>();
		Set<Player> team2 = new HashSet<Player>();
		for (int i = 0; i < playerCount; i++) {
			if (i < playersPerTeam) {
				team1.add(matchedPlayers.get(i));
			} else {
				team2.add(matchedPlayers.get(i));
			}
		}
		return new Match(team1, team2);
	}

	// I made a trade off here.
	// 1. Should I make this new player into the player pool ASAP so that if
	// this one can join a match which it satifies the win rate difference.
	// 2. Or should I making this new player wating in a new player pool until
	// there are not enough players to make a match from the old player pool,
	// because others arrived here early than this one and it should be arranged
	// after them.
	// If I don't take win rate difference into consideration, the 2nd one is
	// better. But it might create unfair match. As for the 1st one, there is a
	// chance that a player might need to wait until enough similar win rate
	// players joined the game.
	public void enterMatchmaking(Player player) {
		if (!players.contains(player)) {
			players.add(player);
		}
	}

	public static void main(String[] args) {
		// MatchmakerImpl t = new MatchmakerImpl();
		// t.findMatch(5);
	}
}