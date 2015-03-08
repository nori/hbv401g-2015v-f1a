package is.hi.f1a;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team {
    private String name;
    private int wins;
    private int draws;
    private int losses;
    private ArrayList<Player> players;
    private int points;
    private int goalsScored;
    private int goalsConceded;

    public Team(String name){
        this.name = name;
        wins = 0;
        draws = 0;
        losses = 0;
        points = 0;
        goalsConceded = 0;
        goalsScored = 0;
        players = new ArrayList<Player>();
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
    public String toString() {
        return name + ". Player count: " + players.size();
    }

    public ArrayList<Player> getPlayers() {
        return players;
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

    //Finds the "best" player (highest price) from an array of players
    private Player bestPlayer(ArrayList<Player> players) {
        int tmp = 0;
        for(int i = 1; i < players.size(); i++) {
            if(players.get(i).getPrice()>= players.get(tmp).getPrice()){
                tmp = i;
            }
        }

        return players.get(tmp);
    }
    //Calculates the best starting team
    public ArrayList<Player> calculateStartingTeam() {
        ArrayList<Player> startingTeam = new ArrayList<Player>();
        ArrayList<Player> goalkeepers = new ArrayList<Player>();
        ArrayList<Player> defenders = new ArrayList<Player>();
        ArrayList<Player> midfielders = new ArrayList<Player>();
        ArrayList<Player> forwards = new ArrayList<Player>();

        for(Player player : players) {
            if(player.getPosition() == Player.Position.GOALKEEPER && player.isAvailable())
                goalkeepers.add(player);
            else if(player.getPosition() == Player.Position.DEFENDER && player.isAvailable())
                defenders.add(player);
            else if(player.getPosition() == Player.Position.MIDFIELDER && player.isAvailable())
                midfielders.add(player);
            else
                forwards.add(player);
        }

        startingTeam.add(bestPlayer(goalkeepers));
        for(int i = 0; i < 4; i++) {
            Player tmp = bestPlayer(defenders);
            startingTeam.add(tmp);
            defenders.remove(tmp);
        }
        for(int i = 0; i < 4; i++) {
            Player tmp = bestPlayer(midfielders);
            startingTeam.add(tmp);
            defenders.remove(tmp);
        }
        for(int i = 0; i < 2; i++) {
            Player tmp = bestPlayer(forwards);
            startingTeam.add(tmp);
            defenders.remove(tmp);
        }

        return startingTeam;
    }
}
