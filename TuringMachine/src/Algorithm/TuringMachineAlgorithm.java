package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class TuringMachineAlgorithm {

    private ArrayList<String> startState;
    private ArrayList<String> acceptState;
    private ArrayList<String> rejectState;
    private ArrayList<List> transitions;
    private ArrayList<List> newTransition;
    private ArrayList<Configuration> newConfigList;
    private ArrayList<Configuration> newConfig;
    private ArrayList<Configuration> configArray;
    private Configuration initConfig;
    private Configuration nextConfig;
    private Tape tempTape;
    private String blank;

    public TuringMachineAlgorithm(ArrayList<String> startState, ArrayList<String> acceptState, ArrayList<String> rejectState, ArrayList<List> transitions, String blank) {
        this.startState = startState;
        this.acceptState = acceptState;
        this.rejectState = rejectState;
        this.transitions = transitions;
        this.blank = blank;
    }

    public ArrayList<List> getTransitions(String state) {
        newTransition = new ArrayList<>();
        for(int i=0; i<transitions.size(); i++) {
            if(transitions.get(i).get(0).equals(state))
                newTransition.add(transitions.get(i));
        }
        return newTransition;
    }

    public ArrayList<Configuration> config(Configuration configuration) {
        newConfig = new ArrayList<>();
        ArrayList<List> transitions = getTransitions(configuration.getState());

        for(int i=0; i<transitions.size(); i++) {
            String readTape = transitions.get(i).get(1).toString();
            String writeTape = transitions.get(i).get(2).toString();
            String direction = transitions.get(i).get(3).toString();
            String nextState = transitions.get(i).get(4).toString();
            tempTape = new Tape(configuration.getTape());

            if((tempTape.getTapeInputs().size()-1==tempTape.getTapeHead() && (direction.equals("R"))) || tempTape.getTapeInputs().isEmpty()) {
                tempTape.getTapeInputs().add(blank);
            }

            if(readTape.equals(tempTape.getTapeInputs().get(tempTape.getTapeHead()))) {
                tempTape.getTapeInputs().set(tempTape.getTapeHead(), writeTape);
                tempTape.incDecTapeHead(direction);
                nextConfig = new Configuration(nextState, tempTape, configuration.getRoute()+" "+nextState);
                newConfig.add(nextConfig);
            }
        }
        return newConfig;
    }

    public String TM(String input) {
        newConfigList = new ArrayList<>();
        initConfig = new Configuration(startState.get(0), new Tape(input), startState.get(0));
        newConfigList.add(initConfig);

        while(newConfigList.size() > 0) {
            configArray = new ArrayList<>();
            for(int i=0; i<newConfigList.size(); i++) {
                if(acceptState.get(0).equals(newConfigList.get(i).getState()))
                    return newConfigList.get(i).getRoute()+"\nAccepted";
                else if(rejectState.get(0).equals(newConfigList.get(i).getState()))
                    return newConfigList.get(i).getRoute()+"\nRejected";
                configArray.addAll(config(newConfigList.get(i)));
            }
            initConfig = newConfigList.get(newConfigList.size()-1);
            newConfigList.clear();
            newConfigList.addAll(configArray);
        }
        return "Looped";
    }
}
