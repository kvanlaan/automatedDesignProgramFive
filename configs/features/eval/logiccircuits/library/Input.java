package logiccircuits.library;

import logiccircuits.Circuit;
import logiccircuits.Gate;

public class Input extends Gate { //beautify
    
    @Override
    public boolean get() {
        if (super.getValue() == Value.U) {
            throw Err.toss("Input gate %s value is unknown.", name);
        }
        return super.getValue() == Value.T;
}
}