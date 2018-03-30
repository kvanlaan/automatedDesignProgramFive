package logiccircuits.library;

public class And extends Gate {
    @Override
    public boolean get() {
        boolean res = true;
        for (int i = 1; i <= this.nInputs; i ++) {
            Gate gin = super.findInputGate(super.getGid(), i);
            res = res && gin.get();
            if (res == false) {
                return false;
            }
        }
        return true;
}
    
}