package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tester.SampleData;
import controller.PlayersPicker.FastPlayersPicker;
import controller.PlayersPicker.PlayersPicker;
import controller.PlayersSpliter.NaivePlayersSpliter;
import controller.PlayersSpliter.PlayersSpliter;

/**
 * To make a match making work, following things should be provided: 1. palyers:
 * players pool. 2. playersPicker: the picking strategy is written this object.
 * 3. playersSplitter: after players are picked and stored in list, this
 * indicate how to arrange them into two teams.
 */
public class MatchmakerImpl implements Matchmaker {
	// used a arraylist to hold players pool
	private List<Player> players;
	// players picker object used to pick players for match
	private PlayersPicker playersPicker;
	// players spliter object used to split picked players in to two teams
	private PlayersSpliter playersSpliter;

	// if no parameter is given, use FastPlayerPicker and NaivePlayerSpliter as
	// default
	public MatchmakerImpl() {
		this.players = SampleData.getPlayers();
		this.playersPicker = new FastPlayersPicker();
		this.playersSpliter = new NaivePlayersSpliter();
	}

	// use given parameters
	public MatchmakerImpl(List<Player> players, PlayersPicker playersPicker,
			PlayersSpliter playersSpliter) {
		this.players = players;
		this.playersPicker = playersPicker;
		this.playersSpliter = playersSpliter;
	}

	/*
	 * try to find a match using given players number and players picker and
	 * players splitter
	 */
	public Match findMatch(int playersPerTeam) {
		int playerCount = playersPerTeam * 2;
		if (playerCount > players.size() || playersPerTeam == 0) {
			return null;
		}
		// @matchedPlayers picked players for a match
		List<Player> matchedPlayers = playersPicker.pickPlayers(playerCount,
				players);
		// if not enough players satisfy match rule, return null
		if (matchedPlayers == null) {
			return null;
		}
		// split the players into two half
		matchedPlayers = playersSpliter
				.splitPlayer(playerCount, matchedPlayers);
		Set<Player> team1 = new HashSet<Player>();
		Set<Player> team2 = new HashSet<Player>();
		// arrange first half players to team 1, second half to team 2
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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Players Count: " + this.players.size() + "\n");
		sb.append("Picker: " + this.playersPicker.toString() + "\n");
		sb.append("Splitter: " + this.playersSpliter.toString() + "\n");
		return sb.toString();
	}
}