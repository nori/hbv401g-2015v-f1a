package is.hi.f1a;

import java.util.*;

public class League {
    private ArrayList<Team> teams;
    private ArrayList<Game> games;
    private int currentRound;
    private Simulation simulation;
    private PriceCalculation pCalc;

    public League(ArrayList<Team> teams) {
        this.games = new ArrayList<Game>();
        this.teams = teams;
        pCalc = new PriceCalculation();
        createSchedule();
    }

    private void createSchedule() {
        ArrayList<Game> tempGames = new ArrayList<Game>();

        for(int i = 0; i < teams.size()-1; i++) {
            for (int j = i+1; j < teams.size(); j++) {
                Game game = new Game (teams.get(i), teams.get(j));
                tempGames.add(game);
            }
        }

        int counter = 0;
        int j = 0;
        int k = 0;
        ArrayList<Team> tempTeams = new ArrayList<Team>();
        List<Integer> indexArray=new ArrayList<Integer>();
        int gameCount = teams.size()*(teams.size()-1)/2;
        int gamesPerRound = teams.size()/2;

        while(games.size() < gameCount) {
            Collections.shuffle(tempGames);
            mainloop:
            for (int i = 0; i < teams.size()-1; i++) {
                while (counter != gamesPerRound) {
                    if (tempTeams.indexOf(tempGames.get(j).getHomeTeam()) == -1 && tempTeams.indexOf(tempGames.get(j).getAwayTeam()) == -1) {
                        tempTeams.add(tempGames.get(j).getHomeTeam());
                        tempTeams.add(tempGames.get(j).getAwayTeam());
                        indexArray.add(j);
                        counter++;
                    }

                    j++;
                    if (j >= tempGames.size() && indexArray.size() < gamesPerRound) {
                        k++;
                        j = k;
                        indexArray.clear();
                        tempTeams.clear();
                        counter = 0;
                        if (k >= tempGames.size()-3) {
                            k=0;
                            j=0;
                            games.clear();
                            tempGames.clear();
                            for(int n = 0; n < teams.size()-1; n++) {
                                for (int q = n+1; q < teams.size(); q++) {
                                    Game leikur = new Game(teams.get(n), teams.get(q));
                                    tempGames.add(leikur);
                                }
                            }
                            Collections.shuffle(tempGames);
                            break mainloop;
                        }
                    }
                }
                for (int l = 0; l < gamesPerRound; l++) {
                    games.add(tempGames.get(indexArray.get(l).intValue()));
                }
                for (int l = 0; l < gamesPerRound; l++) {
                    tempGames.remove(indexArray.get(l) - l);
                }
                indexArray.clear();
                counter = 0;
                k = 0;
                j = 0;
                tempTeams.clear();
            }
        }
        //víxla öðrum hvjerjum leik
        for(int i=0;i<45;i=i+2) {
            Team homeTeam = new Team("");
            Team awayTeam = new Team("");
            homeTeam=games.get(i).getHomeTeam();
            awayTeam=games.get(i).getAwayTeam();
            Game game = new Game(awayTeam,homeTeam);
            games.set(i,game);
        }
        //bæta við seinni umferð
        for(int i=0;i<45;i++){
            Team homeTeam = new Team("");
            Team awayTeam = new Team("");
            homeTeam=games.get(i).getHomeTeam();
            awayTeam=games.get(i).getAwayTeam();
            Game game = new Game(awayTeam,homeTeam);
            games.add(game);
        }
    }

    public void playNextRound() {
        currentRound++;
        for(int i = (currentRound-1)*5; i < 5*currentRound; i++) {
            Simulation s = new Simulation(games.get(i));
            s.simulate();
        }
        //updatePoints();
        updateSkill();
    }

    private void updateSkill(){
        int sumPoints = 0;
        int sumSkill = 0;
        int count = 0;

        for(Team t: teams){
            for(Player p: t.getPlayers()){
                sumPoints += p.getRecentPoints();
                sumSkill += p.getPrice();
                count++;
            }
        }

        for(Team t: teams){
            for(Player p: t.getPlayers()){
                p.calculatePrice(pCalc, (double)sumPoints/count, (double)sumSkill/count);
            }
        }
    }

    public Team getTeam(String team) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
