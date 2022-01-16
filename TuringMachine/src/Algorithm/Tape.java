package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Tape {
    private List<String> tapeInputs = new ArrayList<>();
    private int tapeHead = 0;

    public Tape(String tapeInput) {
        for(int input = 0; input<tapeInput.length(); input++) {
            tapeInputs.add(tapeInput.substring(input, input+1));
        }
    }

    public Tape(Tape tape) {
        for(String tapeInput : tape.getTapeInputs()) {
            tapeInputs.add(tapeInput);
        }
        this.tapeHead = tape.getTapeHead();
    }

    public void incDecTapeHead(String tapeDirection) {
        if(tapeDirection.equals("R"))
            tapeHead++;
        else
            tapeHead--;
    }

    public int getTapeHead() { return tapeHead; }
    public List<String> getTapeInputs() { return tapeInputs; }
}
