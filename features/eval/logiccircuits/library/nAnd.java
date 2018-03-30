package logiccircuits.library;

import logiccircuits.Circuit;
import logiccircuits.Gate;

public class nAnd extends Gate { //beautify
	int nInputs;
    @Override
    public boolean get() {
            boolean res = true;
            for (int i = 1; i <= this.nInputs; i ++) {
                Gate gin = super.findInputGate(super.getGid(), i);
                res = res && gin.get();
                if (res == false) {
                    return true;
                }
            }
            return false;
}

}