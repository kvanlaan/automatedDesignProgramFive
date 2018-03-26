package logiccircuits; 

public   class  Wire {
	
	logiccircuits.Circuit circuit;

	 //base
	logiccircuits.Gate from, to;

	 //base
    int fromPin, toPin;

	 //table

    public Wire  (logiccircuits.Circuit xx, logiccircuits.Gate from, int fromPin, logiccircuits.Gate to, int toPin) { //base
        this.circuit = xx;
        
        this.from = from;
        this.fromPin = fromPin;
        this.to = to;
        this.toPin = toPin;
            
        this.wid = this.getWireId(); //table
        addToCircuitTable(this.circuit); //table
    }

	
    public Wire(logiccircuits.Circuit circuit, logiccircuits.Gate from, int fromPin, logiccircuits.Gate to) { //beautify
        this(circuit, from, fromPin, to, 1);
    }

	

    public Wire(logiccircuits.Circuit circuit, logiccircuits.Gate from, logiccircuits.Gate to, int toPin) { //beautify
		this(circuit, from, 1, to, toPin);
    }

	

    public Wire(logiccircuits.Circuit circuit, logiccircuits.Gate from, logiccircuits.Gate to) { //beautify
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

	 

	public logiccircuits.Gate getTo() {
        return this.to;
    }

	
    
    public int getToPin() {
        return this.toPin;
    }

	
    public logiccircuits.Gate getFrom() {
        return this.from;
    }


}
