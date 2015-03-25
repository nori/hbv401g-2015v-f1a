package is.hi.f1a;

public class GameEvent {
    private int minute;
    private Player player;
    public enum Event {
        GOAL,
        OWN_GOAL,
        YELLOW_CARD,
        RED_CARD,
        SUBSTITUTION_ON,
        SUBSTITUTION_OFF,
        INJURY,
        ASSIST
    }
    private Event event;

    public GameEvent(int minute, Player player, Event event) {
        this.minute = minute;
        this.player = player;
        this.event = event;
    }

    public int getMinute() {
        return minute;
    }

    public Player getPlayer() {
        return player;
    }

    public Event getEvent() {
        return event;
    }

    public String toString() {
        return "Minute = " + minute + " Player = " + player.toString() + "Event = " + event.toString();
    }
}
