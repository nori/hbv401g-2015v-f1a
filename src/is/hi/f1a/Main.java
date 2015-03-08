package is.hi.f1a;

public class Main {

    public static void main(String[] args) throws Exception {
        FantasyFootballBackend fantasyFootballBackend = new FantasyFootballBackend();
        League league = fantasyFootballBackend.getLeague();
        System.out.println(league.getTeams());
        for (int i = 0; i < 45; i++) {
            System.out.println(i + ". " + league.getGames().get(i).getHomeTeam().getName() + " : " + league.getGames().get(i).getAwayTeam().getName());
        }
    }
}
