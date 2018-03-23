package logiccircuits;

public class Wire {
    String wid; // table

    public Wire(Circuit xx, Gate from, int fromPin, Gate to, int toPin) {        
        this.wid = this.getWireId(); // table
        addToCircuitTable(this.circuit); // table
    }
    
    private String getWireId() { // table
        int idx;
        idx = this.circuit.wires.size() + 1;
        return wid = "w" + Integer.toString(idx);
    }
    
    private void addToCircuitTable(Circuit xx) { // table
        xx.wires.add(this);
    }
    
    public void print() { // table
        System.out.format("wire(%s,%d,%s,%d).\n", this.from.getName(), this.fromPin, this.to.getName(), this.toPin);
    }
}
