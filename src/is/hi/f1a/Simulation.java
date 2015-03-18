package is.hi.f1a;

import java.util.ArrayList;

public class Simulation {
    private Game game;
    private Team homeTeam;
    private Team awayTeam;
    private ArrayList<Player> home;
    private ArrayList<Player> away;

    public Simulation(Game game) {
        this.game = game;
        this.awayTeam = this.game.getHomeTeam();
        this.homeTeam = this.game.getAwayTeam();
        this.home = homeTeam.calculateStartingTeam();
        this.away = awayTeam.calculateStartingTeam();
    }
    public ArrayList<GameEvent> simulate(){

    }
    public void calculateGoals() {
        throw new UnsupportedOperationException("Not, implemented yet");
    }

    public void calculateInjuries() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Player calculateCards(ArrayList<Player> team) {
        //throw new UnsupportedOperationException("Not implemented yet");
        ArrayList<Player> tempTeam=team;
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
        return tempTeam.get(rand);
    }
}
