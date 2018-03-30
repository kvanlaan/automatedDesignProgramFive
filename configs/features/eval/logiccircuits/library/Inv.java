package logiccircuits.library;

import logiccircuits.Circuit;
import logiccircuits.Gate;

public class Inv extends Gate { //beautify
    @Override
    public boolean get() {
        Gate gin = super.findInputGate(super.getGid(), 1);
        return !gin.get();
}
}