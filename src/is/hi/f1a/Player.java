package is.hi.f1a;

/**
 * Created by Tomas on 04/03/2015.
 */
public class Player {
    private String name;
    private enum Position {
        GOALKEEPER,
        DEFENDER,
        MIDFIELDER,
        FORWARD
    };
    private Position position;
    private int goals;
    private int assists;
    private int cleanSheet;
    private int ownGoals;
    private int yellowCards;
    private int redCards;
    private int minutes;
    private double injuryProne;
    private int injuryLength;
    private int totalPoints;
    private int recentPoints;
    private int games;
    private int price;
    private Team team;

    public Player(String name, Position position, int goals, int assists, int cleanSheet, int ownGoals,
                  int yellowCards, int redCards, int minutes, boolean available, double injuryProne,
                  int injuryLength, int totalPoints, int recentPoints, int games, int price, Team team) {

        this.name = name;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        this.cleanSheet = cleanSheet;
        this.ownGoals = ownGoals;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.minutes = minutes;
        this.injuryProne = injuryProne;
        this.injuryLength = injuryLength;
        this.totalPoints = totalPoints;
        this.recentPoints = recentPoints;
        this.games = games;
        this.price = price;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(int cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

    public int getOwnGoals() {
        return ownGoals;
    }

    public void setOwnGoals(int ownGoals) {
        this.ownGoals = ownGoals;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public boolean isAvailable() {
        if(yellowCards == 5) {
            yellowCards = 0;
            return false;
        }
        else if(redCards == 1) {
            redCards = 0;
            return false;
        }
        else if(injuryLength > 0) {
            return false;
        }
        else {
            return true;
        }

    }


    public double getInjuryProne() {
        return injuryProne;
    }

    public void setInjuryProne(double injuryProne) {
        this.injuryProne = injuryProne;
    }

    public int getInjuryLength() {
        return injuryLength;
    }

    public void setInjuryLength(int injuryLength) {
        this.injuryLength = injuryLength;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getRecentPoints() {
        return recentPoints;
    }

    public void setRecentPoints(int recentPoints) {
        this.recentPoints = recentPoints;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}