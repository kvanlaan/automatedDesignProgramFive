package logiccircuits.library;

import logiccircuits.Circuit;
import logiccircuits.Gate;

public class Nor extends Gate { //beautify
    @Override
    public boolean get() {
        boolean res = false;
        for (int i = 1; i <= this.nInputs; i ++) {
            Gate gin = super.findInputGate(super.getGid(), i);
            res = res || gin.get();
            if (res == true) {
                return false;
            }
        }
        return true;
}
}