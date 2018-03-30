package logiccircuits;


public class Wire {
    public Wire(logiccircuits.Circuit circuit, logiccircuits.Gate from, int fromPin, logiccircuits.Gate to) { //beautify
        this(circuit, from, fromPin, to, 1);
    }

    public Wire(logiccircuits.Circuit circuit, logiccircuits.Gate from, logiccircuits.Gate to, int toPin) { //beautify
		this(circuit, from, 1, to, toPin);
    }

    public Wire(logiccircuits.Circuit circuit, logiccircuits.Gate from, logiccircuits.Gate to) { //beautify
		this(circuit, from, 1, to, 1);
    }
}