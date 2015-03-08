package is.hi.f1a;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Team> teams = DataRetriever.getTeams();
        DataRetriever.addPlayers(teams);
        System.out.println(teams);

        League league = new League(teams);
        league.createSchedule();
//        for (int i = 0; i < 45; i++) {
//            System.out.println(i + ". " + league.getGames().get(i).getHomeTeam().getName() + " : " + league.getGames().get(i).getAwayTeam().getName());
//        }
        
    }
}
