package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.PlayersPicker.FastPlayersPicker;
import controller.PlayersPicker.PlayersPicker;
import controller.PlayersSpliter.NaivePlayersSpliter;
import controller.PlayersSpliter.PlayersSpliter;

/**
 * The matchmaking implementation that you will write.
 */
public class MatchmakerImpl implements Matchmaker {
	// used a arraylist to hold players pool
	private ArrayList<Player> players;
	// players picker object used to pick players for match
	private PlayersPicker playersPicker;
	// players spliter object used to split picked players in to two teams
	private PlayersSpliter playersSpliter;

	// if no parameter is given, use FastPlayerPicker and NaivePlayerSpliter as
	// default
	public MatchmakerImpl() {
		this.playersPicker = new FastPlayersPicker();
		this.playersSpliter = new NaivePlayersSpliter();
	}

	// use given parameters
	public MatchmakerImpl(PlayersPicker playersPicker,
			PlayersSpliter playersSpliter) {
		this.playersPicker = playersPicker;
		this.playersSpliter = playersSpliter;
	}

	/*
	 * try to find a match using given players number and players picker and
	 * players splitter
	 */
	public Match findMatch(int playersPerTeam) {
		int playerCount = playersPerTeam * 2;
		if (playerCount > players.size()) {
			return null;
		}
		ArrayList<Player> matchedPlayers = playersPicker.pickPlayers(
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

	/*
	 * add a player into players pool
	 */
	public void enterMatchmaking(Player player) {
		if (!players.contains(player)) {
			players.add(player);
		}
	}
}