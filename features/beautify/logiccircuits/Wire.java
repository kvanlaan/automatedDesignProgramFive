package logiccircuits;


public class Wire {
	int fromPin; // beautify 
    
    public Wire(Circuit circuit, Gate from, int fromPin, Gate to) { // beautify
        this(circuit, from, fromPin, to, 1);
    }

    public Wire(Circuit circuit, Gate from, Gate to, int toPin) { // beautify
		this(circuit, from, 1, to, toPin);
    }

    public Wire(Circuit circuit, Gate from, Gate to) { // beautify
		this(circuit, from, 1, to, 1);
    }
}