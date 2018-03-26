package logiccircuits;

public class Wire {
	logiccircuits.Circuit circuit; //base
	logiccircuits.Gate from, to; //base
    int fromPin, toPin; //base

    public Wire(logiccircuits.Circuit xx, logiccircuits.Gate from, int fromPin, logiccircuits.Gate to, int toPin) { //base
        this.circuit = xx;
        
        this.from = from;
        this.fromPin = fromPin;
        this.to = to;
        this.toPin = toPin;
    }
}
