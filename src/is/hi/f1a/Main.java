package is.hi.f1a;

public class Main {

    public static void main(String[] args) throws Exception {
        FantasyFootballBackend fantasyFootballBackend = FantasyFootballBackend.getInstance();
        League league = fantasyFootballBackend.getLeague();
        System.out.println(league.getTeams());
//        for (int i = 0; i < 90; i++) {
//            System.out.println(i+1 + ". " + league.getGames().get(i).getHomeTeam().getName() + " : " + league.getGames().get(i).getAwayTeam().getName());
//        }
        league.playNextRound();
        for (int i = 0; i < 5; i++) {
            System.out.println(i+1 + ". " + league.getGames().get(i).getHomeTeam().getName() + " " + league.getGames().get(i).getHomeScore()
                    + " : " + league.getGames().get(i).getAwayScore() + " " + league.getGames().get(i).getAwayTeam().getName());
            for(GameEvent g : league.getGames().get(i).getGameEvents()) {
                System.out.println(g.toString());
            }
        }
    }
}
