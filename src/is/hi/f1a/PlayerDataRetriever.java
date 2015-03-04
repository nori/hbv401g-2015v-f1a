package is.hi.f1a;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by arnor on 3/4/15.
 */
public class PlayerDataRetriever {
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
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    private static class JSONPlayer {
        String web_name;
        String type_name;
        String team_name;
        int goals_conceded;
        int goals_scored
        int yellow_cards;
        int red_cards;
        int assists;
        int clean_sheets;
        int own_goals;
        int minutes;
    }

    public static void parsePlayer(String playerJsonString) {
        Gson gson = new Gson();
        JSONPlayer p = gson.fromJson(playerJsonString, JSONPlayer.class);
        /*
        Player player = new Player(p.web_name,
                typeToPosition(p.type_name),
                p.goals_scored,
                p.assists,
                p.clean_sheets,
                p.own_goals,
                p.yellow_cards,
                p.red_cards,
                p.minutes,
                )
                */
        //System.out.println(player.web_name);
    }

    public static Player.Position typeToPosition(String type) {
        if(type.equals("Defender")) {
            return Player.Position.DEFENDER;
        }

        return Player.Position.GOALKEEPER;
    }
}
