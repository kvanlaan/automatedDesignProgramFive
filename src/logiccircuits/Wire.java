package logiccircuits; 


public   class  Wire {
	
	Circuit circuit;

	
    Gate from, to;

	
    int toPin;

	

    public Wire(Circuit xx, Gate from, int fromPin, Gate to, int toPin) { // base
        this.circuit = xx;
        
        this.from = from;
        this.fromPin = fromPin;
        this.to = to;
        this.toPin = toPin;
    }

	
	int fromPin;

	 // beautify 
    
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
