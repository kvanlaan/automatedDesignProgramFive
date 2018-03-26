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
    
    public boolean get() {
    	return false;
    }
}