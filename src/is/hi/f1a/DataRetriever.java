package is.hi.f1a;

import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataRetriever {
    private static final String NOT_FOUND = "NOT FOUND";

    public static ArrayList<Team> getTeams() throws Exception {
        String rankingJson;
        String fileLocation = "cache/teams.json";
        File cacheFile = new File(fileLocation);
        if(cacheFile.isFile()) {
            // read file
            rankingJson = new String(Files.readAllBytes(cacheFile.toPath()));
        } else {
            // download
            String seasonsJson = DataRetriever.readUrl("http://www.football-data.org/soccerseasons/");
            int id = DataRetriever.latestSeason(seasonsJson);
            rankingJson = DataRetriever.readUrl("http://www.football-data.org/soccerseasons/" + id + "/ranking");
            PrintWriter out = new PrintWriter(fileLocation);
            out.println(rankingJson);
            out.close();
        }

        return DataRetriever.parseTeams(rankingJson);
    }

    public static void addPlayers(ArrayList<Team> teams) throws Exception {
        String baseUrl = "http://fantasy.premierleague.com/web/api/elements/";
        // i = 685
        boolean finished = false;
        for(int i = 1; i <= 700 && !finished; i++) {
            String fileLocation = Paths.get("cache", "players",
                    i + ".json").toString();
            File cacheFile = new File(fileLocation);
            String playerJson;
            if(cacheFile.isFile()) {
                // read file
                playerJson = new String(Files.readAllBytes(cacheFile.toPath()));
            } else {
                // download
                playerJson = DataRetriever.readUrl(baseUrl + i);
                if(playerJson.contains(NOT_FOUND)) {
                    finished = true;
                } else {
                    PrintWriter out = new PrintWriter(fileLocation);
                    out.println(playerJson);
                    out.close();
                }
            }

            if(!finished) {
                DataRetriever.parsePlayer(playerJson, teams);
            }
        }
    }

    public static String readUrl(String urlString) throws Exception{
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } catch(FileNotFoundException e) {
            return NOT_FOUND;
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    private static class JSONPlayer {
        String web_name;
        String type_name;
        String team_name;
        String photo;
        int goals_conceded;
        int goals_scored;
        int yellow_cards;
        int red_cards;
        int assists;
        int clean_sheets;
        int own_goals;
        int minutes;
        int total_points;
        int now_cost;
    }

    private static class JSONRanking {
        ArrayList<JSONTeam> ranking;
    }

    private static class JSONTeam {
        String team;
    }

    private static class JSONSeason {
        int id;
        String league;
        String year;
    }

    public static int latestSeason(String seasonsJsonString) {
        Gson gson = new Gson();
        JSONSeason[] seasons = gson.fromJson(seasonsJsonString, JSONSeason[].class);
        int latestId = -1;
        int latestYear = -1;

        for(JSONSeason s : seasons) {
            // PL = Premier league
            if(s.league.equals("PL")) {
                int year = Integer.parseInt(s.year);
                if(year > latestYear) {
                    latestYear = year;
                    latestId = s.id;
                }
            }
        }

        return latestId;
    }

    public static ArrayList<Team> parseTeams(String rankingJson) {
        Gson gson = new Gson();
        JSONRanking ranking = gson.fromJson(rankingJson, JSONRanking.class);
        ArrayList<Team> teams = new ArrayList<Team>();
        for(int i = 0; i < 10 && i < ranking.ranking.size(); i++) {
            JSONTeam team = ranking.ranking.get(i);
            teams.add(new Team(team.team));
        }
        return teams;
    }

    public static void parsePlayer(String playerJsonString, ArrayList<Team> teams) {
        Gson gson = new Gson();
        JSONPlayer p = gson.fromJson(playerJsonString, JSONPlayer.class);

        Player player = new Player(p.web_name,
                typeToPosition(p.type_name),
                p.goals_scored,
                p.assists,
                p.clean_sheets,
                p.own_goals,
                p.yellow_cards,
                p.red_cards,
                p.minutes,
                p.total_points,
                p.now_cost,
                p.goals_conceded,
                p.photo);

        Team team = getTeam(teams, p.team_name);
        if(team != null) {
            team.addPlayer(player);
        }

    }

    public static Team getTeam(ArrayList<Team> teams, String teamName) {
        for(Team t : teams) {
            if(t.getName().contains(transformTeamName(teamName))) {
                return t;
            }
        }

        return null;
    }

    // The APIs use different names for teams, fix broken cases here
    public static String transformTeamName(String teamName) {
        if(teamName.equals("Man Utd")) {
            teamName = "Manchester United";
        } else if(teamName.equals("Man City")) {
            teamName = "Manchester City";
        } else if(teamName.equals("Spurs")) {
            teamName = "Tottenham";
        }
        return teamName;
    }

    public static Player.Position typeToPosition(String type) {
        if(type.equals("Defender")) {
            return Player.Position.DEFENDER;
        } else if(type.equals("Forward")) {
            return Player.Position.FORWARD;
        } else if(type.equals("Midfielder")) {
            return Player.Position.MIDFIELDER;
        }

        return Player.Position.GOALKEEPER;
    }
}
