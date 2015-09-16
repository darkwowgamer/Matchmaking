package model;

import java.util.Set;

public class Match {

	private final Set<Player> team1;
	private final Set<Player> team2;

	public Match(Set<Player> team1, Set<Player> team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public Set<Player> getTeam1() {
		return team1;
	}

	public Set<Player> getTeam2() {
		return team2;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Team 1:\n");
		for (Player p : this.team1) {
			sb.append(p.getName());
			sb.append(" | Win Rate: ");
			sb.append(p.getWinRate());
			sb.append(" | Tier: ");
			sb.append(p.getTier());
			sb.append("\n");
		}
		sb.append("Team 2:\n");
		for (Player p : this.team2) {
			sb.append(p.getName());
			sb.append(" | Win Rate: ");
			sb.append(p.getWinRate());
			sb.append(" | Tier: ");
			sb.append(p.getTier());
			sb.append("\n");
		}
		return sb.toString();
	}
}
