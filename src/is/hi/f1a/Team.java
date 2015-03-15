package is.hi.f1a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    private void priceSort(ArrayList<Player> players)
    {
        Collections.sort(players, new Comparator<Player>() {
            public int compare(Player p1, Player p2) {
                if (p1.getPrice() > p2.getPrice()) {
                    return 1;
                } else if (p2.getPrice() > p1.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
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
        priceSort(goalkeepers);
        priceSort(defenders);
        priceSort(midfielders);
        priceSort(forwards);

        int numDefs = 4;
        int numMids = 4;
        int numFors = 2;
        int defSubs = 2;
        int midSubs = 3;
        int forSubs = 1;

        double random = Math.random();

        if(random<=0.2){
            numDefs = 4;
            numMids = 4;
            numFors = 2;
            defSubs = 2;
            midSubs = 3;
            forSubs = 1;
        }
        else if(random>0.2 && random<=0.4){
            numDefs = 4;
            numMids = 5;
            numFors = 1;
            defSubs = 2;
            midSubs = 3;
            forSubs = 1;
        }
        else if(random>0.4 && random<=0.6) {
            numDefs = 5;
            numMids = 4;
            numFors = 1;
            defSubs = 3;
            midSubs = 2;
            forSubs = 1;
        }
        else if(random>0.6 && random<=0.8) {
            numDefs = 4;
            numMids = 3;
            numFors = 3;
            defSubs = 2;
            midSubs = 2;
            forSubs = 2;
        }
        else if(random>0.8) {
            numDefs = 3;
            numMids = 5;
            numFors = 2;
            defSubs = 2;
            midSubs = 3;
            forSubs = 1;
        }

        startingTeam.add(bestPlayer(goalkeepers));
        goalkeepers.remove(bestPlayer(goalkeepers));
        for(int i = 0; i < numDefs; i++) {
            Player tmp = bestPlayer(defenders);
            startingTeam.add(tmp);
            defenders.remove(tmp);
        }
        for(int i = 0; i < numMids; i++) {
            Player tmp = bestPlayer(midfielders);
            startingTeam.add(tmp);
            midfielders.remove(tmp);
        }
        for(int i = 0; i < numFors; i++) {
            Player tmp = bestPlayer(forwards);
            startingTeam.add(tmp);
            forwards.remove(tmp);
        }

        startingTeam.add(bestPlayer(goalkeepers));
        for(int i = 0; i < defSubs; i++){
            Player tmp = bestPlayer(defenders);
            startingTeam.add(tmp);
            defenders.remove(tmp);
        }
        for(int i = 0; i < midSubs; i++){
            Player tmp = bestPlayer(midfielders);
            startingTeam.add(tmp);
            midfielders.remove(tmp);
        }
        for(int i = 0; i < forSubs; i++){
            Player tmp = bestPlayer(forwards);
            startingTeam.add(tmp);
            forwards.remove(tmp);
        }


        return startingTeam;
    }
}
