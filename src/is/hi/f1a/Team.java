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
            else if(player.getPosition() == Player.Position.FORWARD && player.isAvailable())
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

        int[][] possibleSetups = new int[][]{
                {4, 4, 2, 2, 3, 1},
                {4, 5, 1, 2, 3, 1},
                {5, 4, 1, 3, 2, 1},
                {4, 3, 3, 2, 2, 2},
                {3, 5, 2, 2, 3, 1},
        };
        int random = (int) (Math.random()*possibleSetups.length);

        numDefs = possibleSetups[random][0];
        numMids = possibleSetups[random][1];
        numFors = possibleSetups[random][2];
        defSubs = possibleSetups[random][3];
        midSubs = possibleSetups[random][4];
        forSubs = possibleSetups[random][5];

        startingTeam.add(goalkeepers.get(0));
        for(int i = 0; i < numDefs; i++) {
            startingTeam.add(defenders.get(i));
        }
        for(int i = 0; i < numMids; i++) {
            startingTeam.add(midfielders.get(i));
        }
        for(int i = 0; i < numFors; i++) {
            startingTeam.add(forwards.get(i));
        }

        startingTeam.add(goalkeepers.get(1));
        for(int i = 0; i < defSubs; i++){
            startingTeam.add(defenders.get(i+numDefs-1));
        }
        for(int i = 0; i < midSubs; i++){
            startingTeam.add(midfielders.get(i+numMids-1));
        }
        for(int i = 0; i < forSubs; i++){
            startingTeam.add(forwards.get(i+numFors-1));
        }


        return startingTeam;
    }
}
