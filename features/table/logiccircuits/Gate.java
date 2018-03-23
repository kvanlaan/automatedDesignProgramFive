package logiccircuits;

public abstract class Gate {
    String gid;
    
    protected Gate(Circuit circuit, String name, int nInputPins, int nOutputPins, String type) {
        this.gid = this.getGateId(); // table
        this.addToCircuitTable(this.circuit); //table
    }
    
    protected String getGateId() { // table
        if ((this.type.equals("input")) || (this.type.equals("output"))) {
            return this.name.toLowerCase();
        } else {
            this.circuit.addOneGate(this.type);
            int idx = this.circuit.getGateNum(this.type);
            return this.name.charAt(0) + Integer.toString(idx);
        }
    }
    
    private void addToCircuitTable(Circuit xx) { // table
        xx.gates.add(this);
    }
    
    public String getName() { //table
        return this.name;
    }
    
    public void print() { // table
        System.out.format("gate(%s,%s,%d,%d).\n", this.name, this.type, this.nInputPins, this.nOutputPins);
    }
}