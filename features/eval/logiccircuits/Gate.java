package logiccircuits;

public abstract class Gate {
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