package Algorithm;

import InputOutput.OutputFile;
import java.util.*;

public class SeparateData {

    private int numVariablesInput;
    private int numVariablesTape;
    private int numState;
    private ArrayList<String> states;
    private ArrayList<String> startState;
    private ArrayList<String> acceptState;
    private ArrayList<String> rejectState;
    private ArrayList<String> blankSymbol;
    private ArrayList<String> tapeAlphabet;
    private ArrayList<String> inputAlphabet;
    private ArrayList<List> transitions;
    private ArrayList<List> tmString;

    private String routeValidation = "";

    public void SplitData(ArrayList<String> arrayList) {
        numVariablesInput = Integer.parseInt(arrayList.get(0));
        numVariablesTape = Integer.parseInt(arrayList.get(1));
        numState = Integer.parseInt(arrayList.get(2));
        states = new ArrayList<>(Arrays.asList(arrayList.get(3).split(" ")));
        startState = new ArrayList<>(Arrays.asList(arrayList.get(4).split(" ")));
        acceptState = new ArrayList<>(Arrays.asList(arrayList.get(5).split(" ")));
        rejectState = new ArrayList<>(Arrays.asList(arrayList.get(6).split(" ")));
        blankSymbol = new ArrayList<>(Arrays.asList(arrayList.get(7).split(" ")));
        tapeAlphabet = new ArrayList<>(Arrays.asList(arrayList.get(8).split(" ")));
        inputAlphabet = new ArrayList<>(Arrays.asList(arrayList.get(9).split(" ")));
        transitions = new ArrayList<>();
        tmString = new ArrayList<>();

        for(int i=10; i<arrayList.size(); i++) {
            if(arrayList.get(i).split(" ").length == 5)
                transitions.add(new ArrayList<>(Arrays.asList(arrayList.get(i).split(" "))));
        }

        for(int i=(transitions.size())+10; i<arrayList.size(); i++) {
            tmString.add(new ArrayList<>(Arrays.asList(arrayList.get(i))));
        }

        TuringMachineAlgorithm tmAlgorithm = new TuringMachineAlgorithm(startState, acceptState, rejectState, transitions, blankSymbol.get(0));

        for(int i=0; i<tmString.size(); i++) {
            routeValidation += tmAlgorithm.TM(tmString.get(i).get(0).toString())+"\n";
        }

        OutputFile outputFile = new OutputFile();
        outputFile.WriteFile(routeValidation);
    }
}
