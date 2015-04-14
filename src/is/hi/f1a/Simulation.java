package is.hi.f1a;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Game game;
    private Team homeTeam;
    private Team awayTeam;
    private ArrayList<Player> home;
    private ArrayList<Player> away;
    private ArrayList<Player> homeBench;
    private ArrayList<Player> awayBench;
    private int homeSub = 0;
    private int awaySub = 0;

    public Simulation(Game game) {
        this.game = game;
        this.awayTeam = this.game.getHomeTeam();
        this.homeTeam = this.game.getAwayTeam();
        this.home = homeTeam.calculateStartingTeam();
        this.homeBench = new ArrayList<Player>(home.subList(11, home.size()));
        this.home = new ArrayList<Player>(home.subList(0, 11));
        this.away = awayTeam.calculateStartingTeam();
        this.awayBench = new ArrayList<Player>(away.subList(11, away.size()));
        this.away = new ArrayList<Player>(away.subList(0, 11));
        this.away = awayTeam.calculateStartingTeam();
        System.out.println("Simulating game " + homeTeam.getName() + " vs " + awayTeam.getName());
        System.out.println("HomeBench size: " + homeBench.size() + " awayBench size: " + awayBench.size());
        game.setStartingTeamHome(home);
        game.setStartingTeamAway(away);
        homeTeam.updateInjuryLength();
        awayTeam.updateInjuryLength();
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
            double skiptip = 0;
            if(random<goalChance/90.0) {
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
            random = Math.random();
            if(random<2/90.0) {
                double teamRandom = Math.random();
                if(teamRandom > 0.5) {
                    calculateYellowCards(home, i);
                } else {
                    calculateYellowCards(away, i);
                }
                extra += 0.1;
            }
            random = Math.random();
            if(random<1/900) {
                double teamRandom = Math.random();
                if(teamRandom > 0.5) {
                    calculateRedCards(home, homeBench, i);
                } else {
                    calculateRedCards(away, awayBench, i);
                }
                extra += 0.5;
            }
            random = Math.random();
            if(random<1/900.0) {
                double teamRandom = Math.random();
                if(teamRandom > 0.5) {
                    Player substitute = calculateInjuries(home, i);
                    calculateSubstitutionInjury(substitute,home,homeBench, i);
                } else {
                    Player substitute = calculateInjuries(away, i);
                    calculateSubstitutionInjury(substitute,away,awayBench, i);
                }
                extra += 0.5;
            }
            random = Math.random();
            if(random<1/1500.0) {
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
            random = Math.random();
            double timeRemaining = 90 - i + 0.1;
            if(i > 45 && random < (3-homeSub)/timeRemaining) {
                calculateSubstitution(home, homeBench, i);
                extra += 0.2;
                homeSub++;
            }
            random = Math.random();
            if(i > 45 && random < (3-awaySub)/timeRemaining) {
                calculateSubstitution(away, awayBench, i);
                extra += 0.2;
                awaySub++;
            }
        }

    }
    public void calculateGoals(List<Player> team, int minute) {
        ArrayList<Player> tempTeamGoal = new ArrayList<Player>(team);
        for(Player player : team){
            if(player.getPosition() == Player.Position.MIDFIELDER) {
                tempTeamGoal.add(player);
            }
            if(player.getPosition() == Player.Position.FORWARD) {
                tempTeamGoal.add(player);
                tempTeamGoal.add(player);
                if(player.getSkill() >= 8) {
                    tempTeamGoal.add(player);
                }
            }
            if(player.getSkill() >= 7) {
                tempTeamGoal.add(player);
            }
            if(player.getSkill() >= 10) {
                tempTeamGoal.add(player);
            }
        }
        for(int i = 0; i < tempTeamGoal.size(); i++){
            if(tempTeamGoal.get(i).getPosition()== Player.Position.GOALKEEPER) {
                tempTeamGoal.remove(i);
                i--;
            }
        }
        int rand = (int) (Math.random()*tempTeamGoal.size());
        GameEvent gameEvent = new GameEvent(minute,tempTeamGoal.get(rand), GameEvent.Event.GOAL);
        game.addGameEvent(gameEvent);
        //calculate assist:
        ArrayList<Player> tempTeamAssist = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.MIDFIELDER||player.getPosition() == Player.Position.FORWARD) {
                tempTeamAssist.add(player);
            }
            if(player.getSkill()>= 7) {
                tempTeamAssist.add(player);
            }
            if(player.getSkill()>= 10) {
                tempTeamAssist.add(player);
            }
        }

        for(int i = 0; i < tempTeamAssist.size(); i++) {
            if(tempTeamAssist.get(i).getPosition() == Player.Position.GOALKEEPER) {
                tempTeamAssist.remove(i);
                i--;
            } else if(tempTeamAssist.get(i) == tempTeamGoal.get(rand)) {
                tempTeamAssist.remove(i);
                i--;
            }
        }

        double r = Math.random();
        rand = (int) (r*tempTeamAssist.size());
        if(r < 0.8) {
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

    public void calculateRedCards(List<Player> team, ArrayList<Player> bench, int minute) {
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        ArrayList<Player> tempBench = new ArrayList<Player>(bench);
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
        for(int i = 0; i < team.size(); i++) {
            if (team.get(i) == tempTeam.get(rand)) {
                team.remove(i);
                i--;
            }
        }
        if(tempTeam.get(rand).getPosition() == Player.Position.GOALKEEPER){
            tempTeam = new ArrayList<Player>(team);
            for(int i = 0; i < tempBench.size();i++){
                if(tempBench.get(i).getPosition()!=tempTeam.get(rand).getPosition()){
                    tempBench.remove(i);
                    i--;
                }
            }
            if(tempBench.size()==0){
                tempBench=new ArrayList<Player>(bench);
            }
            int max=0;
            for(int i =0;i<tempBench.size();i++){
                if(tempBench.get(i).getSkill()>tempBench.get(max).getSkill()){
                    max=i;
                }
            }
            gameEvent = new GameEvent(minute, tempBench.get(max), GameEvent.Event.SUBSTITUTION_ON);
            game.addGameEvent(gameEvent);
            int rand1 = (int)(Math.random())*tempTeam.size();
            gameEvent = new GameEvent(minute, tempTeam.get(rand1), GameEvent.Event.SUBSTITUTION_OFF);
            game.addGameEvent(gameEvent);
            for(int i=0;i<team.size();i++){
                if(team.get(i)==tempTeam.get(rand1)){
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
    public Player calculateInjuries(List<Player> team, int minute) {
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
        return tempTeam.get(rand);
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
    public void calculateSubstitutionInjury(Player substitute, ArrayList<Player> team, ArrayList<Player> bench, int minute) {
        ArrayList<Player> tempBench = new ArrayList<Player>(bench);
        GameEvent gameEvent = new GameEvent(minute, substitute, GameEvent.Event.SUBSTITUTION_OFF);
        game.addGameEvent(gameEvent);
        for( int i = 0; i < tempBench.size(); i++) {
            if(tempBench.get(i).getPosition() != substitute.getPosition()) {
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
            if(tempBench.get(i).getSkill() > tempBench.get(max).getSkill()) {
                max = i;
            }
        }
        gameEvent = new GameEvent(minute, tempBench.get(max), GameEvent.Event.SUBSTITUTION_ON);
        game.addGameEvent(gameEvent);
        for(int i=0;i<team.size();i++){
            if(team.get(i)==substitute){
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
    //COMMENT
    public void calculateSubstitution(List<Player> team, ArrayList<Player> bench, int minute) {
        System.out.println("Bench size: " + bench.size());
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
            if(tempBench.get(i).getPosition() != tempTeam.get(rand).getPosition()) {
                tempBench.remove(i);
                i--;
            }
        }
        if (tempBench.size() == 0){
            tempBench = new ArrayList<Player>(bench);
            for( int i = 0; i < tempBench.size(); i++) {
                if(tempBench.get(i).getPosition() == Player.Position.GOALKEEPER) {
                    tempBench.remove(i);
                    i--;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < tempBench.size(); i++) {
            if (tempBench.get(i).getSkill() > tempBench.get(max).getSkill()) {
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
        int i = 0;
        for(; i<bench.size(); i++){
            if(bench.get(i)==tempBench.get(max)){
                break;
            }
        }
        bench.remove(i);
    }
}
