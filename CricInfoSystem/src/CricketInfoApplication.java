import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cricket.Ball;
import cricket.Innings;
import cricket.Match;
import cricket.MatchService;
import cricket.Over;
import cricket.Player;
import cricket.ScoreCard;
import cricket.Team;
import cricket.TeamScore;

public class CricketInfoApplication {

	public static void main(String[] args) {

		MatchService matchService = MatchService.getInstance();

		Player rohith = new Player("Rohith", "Batsman");
		Player dorababu = new Player("Rohith", "Batsman");
		Player moulika = new Player("Moulika", "Bowler");

		Player rohith2 = new Player("Rohith", "Batsman");
		Player dorababu2 = new Player("Rohith", "Batsman");
		Player moulika2 = new Player("Moulika", "Bowler");

		List<Player> players1 = new ArrayList<>();
		List<Player> players2 = new ArrayList<>();

		players1.add(rohith);
		players1.add(dorababu);
		players1.add(moulika);

		players2.add(rohith2);
		players2.add(dorababu2);
		players2.add(moulika2);

		Team t1 = new Team("T1", players1);
		Team t2 = new Team("T2", players2);

		List<Team> teams = new ArrayList<>();
		teams.add(t1);
		teams.add(t2);

		Ball ball1 = new Ball(moulika2.getPlayerId(), rohith.getPlayerId(), 1, 1, "That's a single");
		Ball ball2 = new Ball(moulika2.getPlayerId(), dorababu.getPlayerId(), 1, 2, "That's a single");
		Ball ball3 = new Ball(moulika2.getPlayerId(), rohith.getPlayerId(), 1, 3, "That's a single");
		Ball ball4 = new Ball(moulika2.getPlayerId(), dorababu.getPlayerId(), 1, 4, "That's a single");
		Ball ball5 = new Ball(moulika2.getPlayerId(), rohith.getPlayerId(), 4, 5, "That's a 4!!!!!");
		Ball ball6 = new Ball(moulika2.getPlayerId(), rohith.getPlayerId(), 1, 6, "That's a single");

		List<Ball> balls = new ArrayList<>();
		balls.add(ball1);
		balls.add(ball2);
		balls.add(ball3);
		balls.add(ball4);
		balls.add(ball5);
		balls.add(ball6);

		Over over = new Over(1, balls);

		List<Over> overs = new ArrayList<Over>();
		overs.add(over);

		Innings innings1 = new Innings("I1", overs, t1.getTeamId(), t2.getTeamId());

		List<Innings> innings = new ArrayList<Innings>();
		innings.add(innings1);

		HashMap<String, TeamScore> scores = new HashMap<>();
		TeamScore score1 = new TeamScore(0, 0);
		TeamScore score2 = new TeamScore(0, 0);
		scores.put("T1", score1);
		scores.put("T1", score2);

		ScoreCard scoreCard = new ScoreCard("s1", scores, innings);
		scoreCard.updateScore("T1", 3);

		Match match1 = new Match("M1", teams, scoreCard, "Rawal Pindi", "Ind vs Pak");

		matchService.addMatch(match1);

		Match match = matchService.getMatch("M1");
		ScoreCard scoreCardOfMatch = match.getScoreCard();
		List<Innings> inningsOfMatch = scoreCardOfMatch.getInnings();
		for (Innings eachInningsOfMatch : inningsOfMatch) {
			List<Over> oversOfMatch = eachInningsOfMatch.getOvers();
			for (Over eachOver : oversOfMatch) {
				System.out.println("Over - " + eachOver.getOverNumber());
				List<Ball> ballsOfMatch = eachOver.getBalls();
				for (Ball eachBall : ballsOfMatch) {
					System.out.println("Ball - " + eachBall.getBallNumber() + " result -" + eachBall.getResult()
							+ " Bowler -" + eachBall.getBowler() + " Batsman -" + eachBall.getBatsman() + " Comment - "
							+ eachBall.getComment());
				}
			}
		}

	}

}