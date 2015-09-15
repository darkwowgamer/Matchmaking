package controller.PlayersPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Player;

public class TierRangedPlayerPicker extends PlayersPicker {
	private final double rateDiff = 0.2;
	// maximum allowed tier difference among players
	private final int tierDiff = 1;

	@Override
	public List<Player> pickPlayers(int playerCount, List<Player> players) {
		Collections.sort(players);
		List<Player> matchedPlayers = new ArrayList<Player>();
		int tries = players.size();
		while (tries-- > 0) {
			Random ran = new Random();
			int firstPlayerIndex = ran.nextInt(players.size() - playerCount);
			if (players.get(firstPlayerIndex).getWinRate() + rateDiff < players
					.get(firstPlayerIndex + playerCount - 1).getWinRate()) {
				continue;
			}
			int minTier = players.get(firstPlayerIndex).getTier();
			int maxTier = minTier;
			int i = 0;
			for (; i < playerCount; i++) {
				int curTier = players.get(firstPlayerIndex + i).getTier();
				minTier = curTier < minTier ? curTier : minTier;
				maxTier = curTier > maxTier ? curTier : maxTier;
				matchedPlayers.add(players.get(firstPlayerIndex + i));
				if (maxTier - minTier > tierDiff) {
					break;
				}
			}
			if (i == playerCount) {
				for (int j = 0; j < playerCount; j++) {
					matchedPlayers.add(players.get(firstPlayerIndex + j));
				}
			}
		}
		return null;
	}
}