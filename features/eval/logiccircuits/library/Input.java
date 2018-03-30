package logiccircuits.library;

import logiccircuits.Circuit;
import logiccircuits.Gate;

public class Input extends Gate { 
    @Override
    public boolean get() {
        if(super.getValue()== logiccircuits.Value.U) {
            throw logiccircuits.Err.toss("Input gate %s value is unknown.", name);
        }
    
        if(super.getValue() == logiccircuits.Value.T) {
        return true;
        }
        return true;
    }
    
}