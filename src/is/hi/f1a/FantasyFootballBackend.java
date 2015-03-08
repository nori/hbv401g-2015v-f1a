package is.hi.f1a;

import java.util.ArrayList;

public class FantasyFootballBackend {
    private League league;

    public FantasyFootballBackend() throws Exception {
        ArrayList<Team> teams = DataRetriever.getTeams();
        DataRetriever.addPlayers(teams);

        league = new League(teams);
    }

    public League getLeague() {
        return league;
    }

    private void nextRound() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
