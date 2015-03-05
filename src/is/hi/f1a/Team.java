package is.hi.f1a;

import java.util.ArrayList;

/**
 * Created by ArnþórHelgi on 3/4/2015.
 */
public class Team {
    private String name;
    private int wins;
    private int draws;
    private int losses;
    private ArrayList<Player> players;
    private int points;
    private int goalsScored;
    private int goalsConceded;

    public Team(String name/*, ArrayList<Player> players*/){
        this.players=players;
        this.name=name;
        wins=0;
        draws=0;
        losses=0;
        points=0;
        goalsConceded=0;
        goalsScored=0;
    }
    public int getWins(){
        return wins;
    }
    public int getDraws(){
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    public ArrayList<Player> calculateStartingTeam(){
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
