WHAT I CHANGED
1.	Players.java:
	1>	Each Player should have a rating associated with it. So there's a standard that can be used to
	evaluate Player's level.
	2>	Player now has two more instance variable fields: winRates and tier.
	winRate is calculated by wins / (wins + losses).
	tier is randomly assigned from [0, 8) based on SampleData.java, representing Bronze to Challenger. 
	But this is optional when it comes to making match.
	3>	Player class implements compareTo method so that it can be sorted. While I used winRate here, 
	I think MMR used in LoL is better. But since when it comes to compare numbers, they have the same
	effect so I didn't add the MMR field.
2.	SampleData.java:
	1>	Extract data from the original files and add new field "tier" into every entry.
3.	Match.java:
	1>	Implement toString() method so that match result can be showed as string

WHAT I ADDED
1.	Abstract class PlayersPicker and its inherited classes FastPlayersPicker, RangedPlayersPicker and
	TierRangedPlayersPicker:
	1>	This is where the picking strategy reside, different concrete classes implemented different
	strategies.
	2>	The MatchmakerImpl Object can get different results by using different pickers.
	3>	Any new picking strategy can be tested by implement the abstract class without modifing other parts.
	4>	Picked players are returned in a sorted list, the order is based on their rating, I used winRate
	here.
	4>	FastPlayersPicker:
		This picker This PlayerPicker will randomly pick the first player from sorted players and use the
	following players to make the match. The reason why this is called fast is that as long as they are
	enough players, it can start the game and the players matched together have consecutive ratings.
	5> 	RangedPlayersPicker: 
		This picker uses a maxDiff representing the maximum difference allowed among players. Difference 
	with FastPlayersPicker is that if the last player to be picked doesn't satisfy rateDiff, it will 
	try next randomly picked player as first picked player.
	6>	TierRangedPlayersPicker:
		Based on RangedPlayersPicker, this picker uses tierDiff to define maximum allowed tier difference, 
	which I think is also used in LoL so that Platinum players can't be matched with Master players no 
	matter what their MMR is.
	7>	More sofisticated picking strategy can be implemented by taking more factors into consideration 
	such as MMR, role preference, recent wins/losses etc.
	8>	Also, with waiting time increase, players become impatient. We can consider to "loose" our 
	restriction according to waiting time so that they wouldn't quit because of this.
2.	Abstract class PlayersSpliter and its inherited classes HighLowPlayersSpliter and NaivePlayersSpliter: 
	1>	After players are picked, they are stored in a sorted list, a way of arranging them into 
	two teams need to be choosen to make sure the game is even.
	2>	The reason why the splitting strategy is implemented as a seperate is that new strategy can be 
	tried out without changing other parts.
	3>	NaivePlayersSpliter:
		Interleaving given players and return the result.
	4>	HighLowPlayersSpliter:
		Since the players are all in order, put the first and the last player in the arraylist together, 
	the second and the second to last together, and so on. The reason why doing this is try to minimize 
	total rating between teams. Fianlly, return the result.
	5>	More sofisticated splitting strategy can be implemented based on sofisticated Math formulas such as 
	to minimize their square deviation etc.

3.	MatchmakerTester:
	1> Used to test MatchmakerImpl.
	2> Create output to console.