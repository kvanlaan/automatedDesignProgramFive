package logiccircuits.library; 

import logiccircuits.Circuit; 
import logiccircuits.Gate; 

public   class  Nor  extends Gate {
	 //beautify
    
    public Nor(Circuit xx, String name, int nInputs) { //beautify
        super(xx, name, nInputs, 1, "nor");
    }

	
	int nInputs;

	
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
