package logiccircuits.library; 

import logiccircuits.Circuit; 
import logiccircuits.Gate; 

public   class  nAnd  extends Gate {
	 //beautify
    
    public nAnd(Circuit xx, String name, int nInputs) { //beautify
        super(xx, name, nInputs, 1, "nand");
    }

	 //beautify
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
