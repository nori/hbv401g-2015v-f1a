package is.hi.f1a;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Game game;
    private Team homeTeam;
    private Team awayTeam;
    private List<Player> home;
    private List<Player> away;
    private List<Player> homeBench;
    private List<Player> awayBench;
    private int homeSub = 0;
    private int awaySub = 0;

    public Simulation(Game game) {
        this.game = game;
        this.awayTeam = this.game.getHomeTeam();
        this.homeTeam = this.game.getAwayTeam();
        this.home = homeTeam.calculateStartingTeam();
        this.homeBench = home.subList(11, 18);
        this.home = home.subList(0, 11);
        this.away = awayTeam.calculateStartingTeam();
        this.awayBench = away.subList(11, 18);
        this.away = away.subList(0, 11);
        this.away = awayTeam.calculateStartingTeam();
        game.setStartingTeamHome(home);
        game.setStartingTeamAway(away);
    }

    public void simulate(){
        //throw new UnsupportedOperationException("Not implemented yet");
        double priceFact = (homeTeam.getPrice()-awayTeam.getPrice())/(homeTeam.getPrice()+awayTeam.getPrice());
        int goalChance = 3;
        double extra = 0;
        if (Math.abs(priceFact) > 0.3)  {
            goalChance++;
        }
        if (Math.abs(priceFact) > 0.5)  {
            goalChance++;
        }
        if (Math.abs(priceFact) > 0.7)  {
            goalChance++;
        }
        for(int i = 1; i <= 90 + extra; i++) {
            double random = Math.random();
            if(random<goalChance/90){
                double teamRandom = Math.random() + priceFact*2;
                if(teamRandom > 0.5) {
                    calculateGoals(home, i);
                    game.setHomeScore(game.getHomeScore() + 1);
                } else {
                    calculateGoals(away, i);
                    game.setAwayScore(game.getAwayScore() + 1);
                }
                extra += 0.5;
            }
            if(random<2/90) {
                double teamRandom = Math.random();
                if(teamRandom > 0.5) {
                    calculateYellowCards(home, i);
                } else {
                    calculateYellowCards(away, i);
                }
                extra += 0.1;
            }
            if(random<1/900) {
                double teamRandom = Math.random();
                if(teamRandom > 0.5) {
                    calculateRedCards(home, i);
                } else {
                    calculateRedCards(away, i);
                }
                extra += 0.5;
            }
            if(random<1/900) {
                double teamRandom = Math.random();
                if(teamRandom > 0.5) {
                    calculateInjuries(home, i);
                } else {
                    calculateInjuries(away, i);
                }
                extra += 0.5;
            }
            if(random<1/1500) {
                double teamRandom = Math.random();
                if(teamRandom > 0.5) {
                    calculateOwnGoals(home, i);
                    game.setAwayScore(game.getAwayScore() + 1);
                } else {
                    calculateOwnGoals(away, i);
                    game.setHomeScore(game.getHomeScore() + 1);
                }
                extra += 1.0;
            }
            int timeRemaining = 90-i;
            if(i > 45 && random < (3-homeSub)/timeRemaining) {
                calculateSubstitution(home, homeBench, i);
                extra += 0.2;
            }
            if(i > 45 && random < (3-awaySub)/timeRemaining) {
                calculateSubstitution(away, awayBench, i);
                extra += 0.2;
            }
        }

    }
    public void calculateGoals(List<Player> team, int minute) {
        ArrayList<Player> tempTeamGoal = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.MIDFIELDER) {
                tempTeamGoal.add(player);
            }
            if(player.getPosition() == Player.Position.FORWARD) {
                tempTeamGoal.add(player);
                tempTeamGoal.add(player);
                if(player.getPrice()>= 8) {
                    tempTeamGoal.add(player);
                }
            }
            if(player.getPrice()>= 7) {
                tempTeamGoal.add(player);
            }
            if(player.getPrice()>= 10) {
                tempTeamGoal.add(player);
            }
        }
        for(int i = 0;i<tempTeamGoal.size();i++){
            if(tempTeamGoal.get(i).getPosition()== Player.Position.GOALKEEPER) {
                tempTeamGoal.remove(i);
                i--;
            }
        }
        int rand = ((int)(Math.random()))*tempTeamGoal.size();
        GameEvent gameEvent = new GameEvent(minute,tempTeamGoal.get(rand), GameEvent.Event.GOAL);
        game.addGameEvent(gameEvent);
        //calculate assist:
        ArrayList<Player> tempTeamAssist = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.MIDFIELDER||player.getPosition() == Player.Position.FORWARD) {
                tempTeamAssist.add(player);
            }
            if(player.getPrice()>= 7) {
                tempTeamAssist.add(player);
            }
            if(player.getPrice()>= 10) {
                tempTeamAssist.add(player);
            }
        }
        for(int i = 0;i<tempTeamAssist.size();i++){
            if(tempTeamAssist.get(i).getPosition()== Player.Position.GOALKEEPER) {
                tempTeamAssist.remove(i);
                i--;
            }
            if(tempTeamAssist.get(i)==tempTeamGoal.get(rand)) {
                tempTeamGoal.remove(i);
                i--;
            }
        }

        double r = Math.random();
        rand = ((int)r)*tempTeamAssist.size();
        if(r<0.8) {
            gameEvent = new GameEvent(minute, tempTeamAssist.get(rand), GameEvent.Event.ASSIST);
            game.addGameEvent(gameEvent);
        }
    }

    public void calculateYellowCards(List<Player> team, int minute) {
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.DEFENDER) {
                tempTeam.add(player);
            }
            if (player.getGames()!=0){
                if (player.getYellowCards()/player.getGames() > 0.5) {
                    tempTeam.add(player);
                }
            }
        }
        int rand = ((int)(Math.random()))*tempTeam.size();
        GameEvent gameEvent = new GameEvent(minute,tempTeam.get(rand), GameEvent.Event.YELLOW_CARD);

        game.addGameEvent(gameEvent);
    }


    public void calculateRedCards(List<Player> team, int minute) {
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.DEFENDER) {
                tempTeam.add(player);
            }
            if (player.getGames()!=0){
                if (player.getRedCards()/player.getGames() > 0.2) {
                    tempTeam.add(player);
                }
            }
        }
        int rand = ((int)(Math.random()))*tempTeam.size();
        GameEvent gameEvent=new GameEvent(minute,tempTeam.get(rand), GameEvent.Event.RED_CARD);

        game.addGameEvent(gameEvent);
    }
    public void calculateInjuries(List<Player> team, int minute) {
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        for(Player player:team) {
            if(player.getInjuryProne() > 0.7) {
                tempTeam.add(player);
            }
            if(player.getInjuryProne() > 0.9) {
                tempTeam.add(player);
            }
            if(player.getPosition() == Player.Position.DEFENDER || player.getPosition() == Player.Position.MIDFIELDER || player.getPosition() == Player.Position.FORWARD) {
                tempTeam.add(player);
            }
        }
        int rand = ((int)(Math.random()))*tempTeam.size();
        GameEvent gameEvent = new GameEvent(minute, tempTeam.get(rand), GameEvent.Event.INJURY);
        game.addGameEvent(gameEvent);
    }
    public void calculateOwnGoals(List<Player> team, int minute) {
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.DEFENDER) {
                tempTeam.add(player);
            }
            if (player.getGames()!=0){
                if (player.getOwnGoals()/player.getGames() > 0.2) {
                    tempTeam.add(player);
                }
            }
        }
        int rand = ((int)(Math.random()))*tempTeam.size();
        GameEvent gameEvent=new GameEvent(minute,tempTeam.get(rand), GameEvent.Event.OWN_GOAL);
        game.addGameEvent(gameEvent);
    }
    //COMMENT
    public void calculateSubstitution(List<Player> team, List<Player> bench,  int minute) {
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        ArrayList<Player> tempBench = new ArrayList<Player>(bench);
        for( int i = 0; i < tempTeam.size(); i++) {
            if(tempTeam.get(i).getPosition() == Player.Position.GOALKEEPER) {
                tempTeam.remove(i);
                i--;
            }
        }
        int rand = (int) (Math.random()*tempTeam.size());
        GameEvent gameEvent = new GameEvent(minute, tempTeam.get(rand), GameEvent.Event.SUBSTITUTION_OFF);
        game.addGameEvent(gameEvent);
        for( int i = 0; i < tempBench.size(); i++) {
            if(tempBench.get(i).getPosition() == Player.Position.GOALKEEPER) {
                tempBench.remove(i);
                i--;
            }
        }
        for( int i = 0; i < tempBench.size(); i++) {
            if(tempBench.get(i).getPosition() != tempTeam.get(rand).getPosition()) {
                tempBench.remove(i);
                i--;
            }
        }
        if (tempBench.size()==0){
            tempBench=new ArrayList<Player>(bench);
            for( int i = 0; i < tempBench.size(); i++) {
                if(tempBench.get(i).getPosition() == Player.Position.GOALKEEPER) {
                    tempBench.remove(i);
                    i--;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < tempBench.size(); i++) {
            if(tempBench.get(i).getPrice() > tempBench.get(max).getPrice()) {
                max = i;
            }
        }
        gameEvent = new GameEvent(minute, tempBench.get(max), GameEvent.Event.SUBSTITUTION_ON);
        game.addGameEvent(gameEvent);
        for(int i=0;i<team.size();i++){
            if(team.get(i)==tempTeam.get(rand)){
                team.remove(i);
                break;
            }
        }
        team.add(tempBench.get(max));
        for(int i=0;i<bench.size();i++){
            if(bench.get(i)==tempBench.get(max)){
                bench.remove(i);
                break;
            }
        }
    }
}
