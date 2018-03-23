package logiccircuits;

public class Wire {
	Circuit circuit; //base
    Gate from, to; //base
    int fromPin, toPin; //base

    public Wire(Circuit xx, Gate from, int fromPin, Gate to, int toPin) { //base
        this.circuit = xx;
        
        this.from = from;
        this.fromPin = fromPin;
        this.to = to;
        this.toPin = toPin;
    }
}
