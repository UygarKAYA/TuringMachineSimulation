package Algorithm;

public class Configuration {
    private String state;
    private Tape tape;
    private String route;

    public Configuration(String state, Tape tape, String route) {
        this.state = state;
        this.tape = tape;
        this.route = route;
    }

    public String getState() { return state; }
    public Tape getTape() { return tape; }
    public String getRoute() { return route; }
}
