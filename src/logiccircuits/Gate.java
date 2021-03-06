package logiccircuits; 

public abstract   class  Gate {
	
	public final String name;

	 //base
    int nInputPins, nOutputPins;

	 //base
    String type;

	 //base
    logiccircuits.Circuit circuit;

	 //table
    
    public Gate  (logiccircuits.Circuit circuit, String name, int nInputPins, int nOutputPins, String type) { //base
        this.circuit = circuit;
        
        this.name = name;
        this.nInputPins = nInputPins;
        this.nOutputPins = nOutputPins;
        this.type = type;
    
        this.gid = this.getGateId(); //table
        this.addToCircuitTable(this.circuit); //table
    }

	
    String gid;

	
    
    protected String getGateId() { //table
        if ((this.type.equals("input")) || (this.type.equals("output"))) {
            return this.name.toLowerCase();
        } else {
            this.circuit.addOneGate(this.type);
            int idx = this.circuit.getGateNum(this.type);
            return this.name.charAt(0) + Integer.toString(idx);
        }
    }

	
    
    private void addToCircuitTable(Circuit xx) { //table
        xx.gates.add(this);
    }

	
    
    public String getName() { //table
        return this.name;
    }

	
    
    public void print() { //table
        System.out.format("gate(%s,%s,%d,%d).\n", this.name, this.type, this.nInputPins, this.nOutputPins);
    }

	
    Value evalValue;

	
    public String getGid() {
        return this.gid;
    }

	
    public void setValue(Value v) {
        this.evalValue = v;
    }

	
    public void set(boolean v) {
        if (v == true) {
            this.setValue(Value.T);
        } else {
            this.setValue(Value.F);
        }
    }

	
    public Value getValue() {
        return this.evalValue;
    }

	
    
    public abstract boolean get();

	
    
    
    public Gate findInputGate(String gid, int pin_no) {
        return this.circuit.findInputGate(gid, pin_no);
    }


}
