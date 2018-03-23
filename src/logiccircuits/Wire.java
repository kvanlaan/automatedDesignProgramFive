package logiccircuits; 

public   class  Wire {
	
	Circuit circuit;

	 //base
    Gate from, to;

	 //base
    int fromPin, toPin;

	 //table

    public Wire  (Circuit xx, Gate from, int fromPin, Gate to, int toPin) { //base
        this.circuit = xx;
        
        this.from = from;
        this.fromPin = fromPin;
        this.to = to;
        this.toPin = toPin;
            
        this.wid = this.getWireId(); //table
        addToCircuitTable(this.circuit); //table
    }

	
    public Wire(Circuit circuit, Gate from, int fromPin, Gate to) { //beautify
        this(circuit, from, fromPin, to, 1);
    }

	

    public Wire(Circuit circuit, Gate from, Gate to, int toPin) { //beautify
		this(circuit, from, 1, to, toPin);
    }

	

    public Wire(Circuit circuit, Gate from, Gate to) { //beautify
		this(circuit, from, 1, to, 1);
    }

	
    String wid;

	
    
    private String getWireId() { //table
        int idx;
        idx = this.circuit.wires.size() + 1;
        return wid = "w" + Integer.toString(idx);
    }

	
    
    private void addToCircuitTable(Circuit xx) { //table
        xx.wires.add(this);
    }

	
    
    public void print() { //table
        System.out.format("wire(%s,%d,%s,%d).\n", this.from.getName(), this.fromPin, this.to.getName(), this.toPin);
    }


}
