package is.hi.f1a;

public class Player {
    public enum Position {
        GOALKEEPER,
        DEFENDER,
        MIDFIELDER,
        FORWARD
    }

    private String name;
    private Position position;
    private int goals;
    private int assists;
    private int cleanSheet;
    private int goalsConceded;
    private int ownGoals;
    private int yellowCards;
    private int redCards;
    private int minutes;
    private double injuryProne;
    private int injuryLength;
    private int totalPoints;
    private int recentPoints;
    private int games;
    private int skill;
    private int originalPrice;
    private int price;
    private Team team;
    private String photo;

    public Player(String name, Position position, int goals, int assists, int cleanSheet, int ownGoals,
                  int yellowCards, int redCards, int minutes,
                  int totalPoints, int price, int goalsConceded, String photo) {
        this.name = name;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        this.cleanSheet = cleanSheet;
        this.ownGoals = ownGoals;
        this.yellowCards = 0;
        this.redCards = 0;
        this.minutes = minutes;
        this.totalPoints = totalPoints;
        this.originalPrice = price;
        this.price = price;
        this.skill = price;
        this.goalsConceded = goalsConceded;
        this.photo = "http://cdn.ismfg.net/static/plfpl/img/shirts/photos/" + photo;
    }

    public Player(String name, Position position, int goals, int assists, int cleanSheet, int ownGoals,
                  int yellowCards, int redCards, int minutes,
                  int totalPoints, int skill, int goalsConceded) {
        this(name, position, goals, assists, cleanSheet, ownGoals, yellowCards, redCards, minutes, totalPoints, skill, goalsConceded, "");
    }

    public void calculateSkill(ISkillCalculation SkillCalculation, double avgPoints, double avgSkill) {
        skill = SkillCalculation.calculateSkill(this, avgPoints, avgSkill);
    }

    public String toString() {
        return name;
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

    public boolean isAvailable(boolean resetCards) {
        if(yellowCards == 5) {
            if(resetCards) yellowCards = 0;
            return false;
        }
        else if(redCards == 1) {
        	if(resetCards) redCards = 0;
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

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void playerBought() {
        price += 0.1*originalPrice;
    }

    public void playerSold() {
        price -= 0.1*originalPrice;
    }
}