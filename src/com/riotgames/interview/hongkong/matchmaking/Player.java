package com.riotgames.interview.hongkong.matchmaking;

/**
 * <p>
 * Representation of a player.
 * </p>
 * <p>
 * As indicated in the challenge description, feel free to augment the Player
 * class in any way that you feel will improve your final matchmaking solution.
 * <strong>Do NOT remove the name, wins, or losses fields.</strong> Also note
 * that if you make any of these changes, you are responsible for updating the
 * {@link SampleData} such that it provides a useful data set to exercise your
 * solution.
 * </p>
 */
public class Player implements Comparable<Player> {

	// removed final keyword since these variables change after ever match and
	// player can change their name in LoL
	private String name;
	private long wins;
	private long losses;
	// win rate
	private double winRate;

	public Player(String name, long wins, long losses) {
		this.name = name;
		this.wins = Math.abs(wins);
		this.losses = Math.abs(losses);
		if (this.wins + this.losses == 0 || this.wins > Integer.MAX_VALUE
				|| this.losses > Integer.MAX_VALUE) {
			this.winRate = 0.5;
		} else {
			this.winRate = (double) this.wins / (this.wins + this.losses);
		}
	}

	public Player(double winRate) {
		this.winRate = winRate;
	}

	public String getName() {
		return name;
	}

	public long getWins() {
		return wins;
	}

	public long getLosses() {
		return losses;
	}

	public double getWinRate() {
		return winRate;
	}

	@Override
	public int compareTo(Player o) {
		double rst = this.getWinRate() - o.getWinRate();
		if (rst == 0) {
			return 0;
		} else if (rst > 0) {
			return 1;
		} else {
			return -1;
		}
	}
}
