package logiccircuits.library; 

import logiccircuits.Circuit; 
import logiccircuits.Gate; 

public  class  Nor  extends Gate {
	 //beautify
    
    public Nor(Circuit xx, String name, int nInputs) { //beautify
        super(xx, name, nInputs, 1, "nor");
    }


}
