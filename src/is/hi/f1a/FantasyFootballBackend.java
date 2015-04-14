package is.hi.f1a;

import java.util.ArrayList;

public class FantasyFootballBackend {
	
	private static final FantasyFootballBackend game = new FantasyFootballBackend();
			
    private League league;

    public static FantasyFootballBackend getInstance() {
		return game;
	}
    
    private FantasyFootballBackend() {
        restart();
    }

    public void restart() {
        ArrayList<Team> teams = null;
        try {
            teams = DataRetriever.getTeams();
            DataRetriever.addPlayers(teams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        league = new League(teams);
    }

    public League getLeague() {
        return league;
    }

    private void nextRound() {
        league.playNextRound();
    }
}
