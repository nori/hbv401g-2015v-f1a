package is.hi.f1a;

import java.util.*;

/**
 * Created by arnor on 3/4/15.
 */
public class League {
    private ArrayList<Team> teams;
    private ArrayList<Game> games;
    private int currentRound;
    private Simulation simulation;

    public League() {
        //throw new UnsupportedOperationException("Not implemented yet");
        this.games=new ArrayList<Game>();
    }

    public void createSchedule() {
        //throw new UnsupportedOperationException("Not implemented yet");
        Team arsenal =new Team("Arsenal");
        Team chelsea = new Team("Chelsea");
        Team manchesterCity = new Team("Manchester City");
        Team manchesterUnited = new Team("Manchester United");
        Team southampton = new Team("Southampton");
        Team liverpool = new Team("Liverpool");
        Team tottenham = new Team("Tottenham");
        Team swansea = new Team("Swansea");
        Team westHam = new Team("West Ham");
        Team stoke = new Team("Stoke");
        ArrayList<Team> lid = new ArrayList<Team>(Arrays.asList(arsenal,chelsea,manchesterCity,manchesterUnited,southampton,liverpool,tottenham,swansea,westHam,stoke));
        ArrayList<Game> tempGames=new ArrayList<Game>();
        for(int i=0;i<9;i++) {
            for (int j = i+1; j < 10; j++) {
                Game leikur=new Game(lid.get(i),lid.get(j));
                tempGames.add(leikur);
            }
        }

        int teljari=0;
        int j=0;
        int k=0;
        boolean m=true;
        ArrayList<Team> tempTeams = new ArrayList<Team>();
        List<Integer> indexArray=new ArrayList<Integer>();
        while(m) {
            Collections.shuffle(tempGames);
            mainloop:
            for (int i = 0; i < 9; i++) {
                while (teljari != 5) {
                    if (tempTeams.indexOf(tempGames.get(j).getHomeTeam()) == -1 && tempTeams.indexOf(tempGames.get(j).getAwayTeam()) == -1) {
                        tempTeams.add(tempGames.get(j).getHomeTeam());
                        tempTeams.add(tempGames.get(j).getAwayTeam());
                        indexArray.add(j);
                        teljari++;
                    }

                    j++;
                    if (j >= tempGames.size() && indexArray.size() < 5) {
                        k++;
                        j = k;
                        indexArray.clear();
                        tempTeams.clear();
                        teljari = 0;
                        if (k >= tempGames.size()-3) {
                            k=0;
                            j=0;
                            games.clear();
                            tempGames.clear();
                            for(int n=0;n<9;n++) {
                                for (int q = n+1; q < 10; q++) {
                                    Game leikur=new Game(lid.get(n),lid.get(q));
                                    tempGames.add(leikur);
                                }
                            }
                            Collections.shuffle(tempGames);
                            break mainloop;

                        }
                    }
                }
                for (int l = 0; l < 5; l++) {
                    games.add(tempGames.get(indexArray.get(l).intValue()));
                }
                for (int l = 0; l < 5; l++) {
                    tempGames.remove(indexArray.get(l).intValue() - l);

                }
                indexArray.clear();
                teljari = 0;
                k = 0;
                j = 0;
                tempTeams.clear();
            }
            if(games.size()==45){
                m=false;
            }
        }
    }

    public void playNextRound() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Team getTeam(String team) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void addTeam(Team team) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
