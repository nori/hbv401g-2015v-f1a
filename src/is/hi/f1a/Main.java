package is.hi.f1a;

public class Main {

    public static void main(String[] args) throws Exception {
        FantasyFootballBackend fantasyFootballBackend = new FantasyFootballBackend();
        League league = fantasyFootballBackend.getLeague();
        System.out.println(league.getTeams());
        for (int i = 0; i < 90; i++) {
            System.out.println(i+1 + ". " + league.getGames().get(i).getHomeTeam().getName() + " : " + league.getGames().get(i).getAwayTeam().getName());
        }
    }
}
