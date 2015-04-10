package is.hi.f1a;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnor on 3/4/15.
 */
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private List<Player> startingTeamHome;
    private List<Player> startingTeamAway;
    private int homeScore;
    private int awayScore;
    private ArrayList<GameEvent> gameEvents;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public List<Player> getStartingTeamHome() {
        return startingTeamHome;
    }

    public void setStartingTeamHome(List<Player> startingTeamHome) {
        this.startingTeamHome = startingTeamHome;
    }

    public List<Player> getStartingTeamAway() {
        return startingTeamAway;
    }

    public void setStartingTeamAway(List<Player> startingTeamAway) {
        this.startingTeamAway = startingTeamAway;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {

        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public void addGameEvent(GameEvent gameEvent) {
        gameEvents.add(gameEvent);
    }

    public ArrayList<GameEvent> getGameEvents() {
        return gameEvents;
    }
}
