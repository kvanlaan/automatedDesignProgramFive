package logiccircuits.library; 

import logiccircuits.Circuit; 
import logiccircuits.Gate; 

public   class  And  extends Gate {
	 //beautify
    
    public And(Circuit xx, String name, int nInputs) { //beautify
        super(xx, name, nInputs, 1, "and");
    }

	
	int nInputs;

	
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
