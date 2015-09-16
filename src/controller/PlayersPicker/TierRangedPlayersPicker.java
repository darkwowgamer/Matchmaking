package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Player;

/**
 * This players picker pick players based on their rating and tier, this require
 * an extra instance variable "tier". The difference between this one and
 * RangedPlayersPicker is that if a candidate player's tier differs more than
 * tierDiff wih the first picked player, it will be passed.
 */
public class TierRangedPlayersPicker extends PlayersPicker {
	private final double rateDiff = 0.05;
	// maximum allowed tier difference between first picked player and others
	private final int tierDiff = 1;

	@Override
	public List<Player> pickPlayers(int playerCount, List<Player> players) {
		// first sort players according to their rate(can be win rate or other
		// criteria)
		Collections.sort(players);
		// @matchedPlayers used to store result;
		List<Player> matchedPlayers = new ArrayList<Player>();
		// @tries try how many times before stop
		int tries = players.size();
		while (tries-- > 0 && players.size() - playerCount >= 0) {
			Random ran = new Random();
			// randomly pick the first player, at least playerCount number of
			// players available to pick
			int firstPlayerIndex = ran
					.nextInt(players.size() - playerCount + 1);
			Player firstPlayer = players.get(firstPlayerIndex);
			// minimum allowed tier
			int minTier = players.get(firstPlayerIndex).getTier() - tierDiff;
			// maximum allowed tier
			int maxTier = players.get(firstPlayerIndex).getTier() + tierDiff;
			int index = 0;
			// while loop will stop until enough players are picked or no more
			// players to pick
			while (matchedPlayers.size() < playerCount
					&& firstPlayerIndex + index < players.size()) {
				Player curPlayer = players.get(firstPlayerIndex + index++);
				// break if the rate difference can't be satisfied
				if (firstPlayer.getWinRate() + rateDiff < curPlayer
						.getWinRate()) {
					break;
				}
				int curTier = curPlayer.getTier();
				// continue if current player can't satisfy the min/max tier
				if (curTier < minTier || curTier > maxTier) {
					continue;
				}
				matchedPlayers.add(curPlayer);
			}
			if (matchedPlayers.size() == playerCount) {
				// remove all picked players from players pool
				players.removeAll(matchedPlayers);
				return matchedPlayers;
			} else {
				matchedPlayers.clear();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("TierRangedPlayersPicker | " + "Rate Difference: " + rateDiff
				+ " | Tier Difference: " + tierDiff);
		return sb.toString();
	}
}