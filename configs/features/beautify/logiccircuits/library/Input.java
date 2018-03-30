package logiccircuits.library;

import logiccircuits.Circuit;
import logiccircuits.Gate;

public class Input extends Gate { //beautify
    public Input(Circuit xx, String name) { //beautify
        super(xx, name, 0, 1, "input");
    }
}