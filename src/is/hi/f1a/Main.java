package is.hi.f1a;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, world. How are you?");

        String json = PlayerDataRetriever.readUrl("http://fantasy.premierleague.com/web/api/elements/6/");
        PlayerDataRetriever.parsePlayer(json);
        System.out.println(json);
    }
}
