package logiccircuits.library; 

import logiccircuits.Circuit; 
import logiccircuits.Gate; 

public  class  nAnd  extends Gate {
	 //beautify
    
    public nAnd(Circuit xx, String name, int nInputs) { //beautify
        super(xx, name, nInputs, 1, "nand");
    }


}
