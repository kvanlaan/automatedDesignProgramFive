package logiccircuits.library; 

import logiccircuits.Circuit; 
import logiccircuits.Gate; 

public   class  Or  extends Gate {
	 //beautify
    
    public Or(Circuit xx, String name, int nInputs) { //beautify
        super(xx, name, nInputs, 1, "or");
    }

	 //beautify
	int nInputs;

	
    @Override
    public boolean get() {
        boolean res = false;
        for (int i = 1; i <= this.nInputs; i ++) {
            Gate gin = super.findInputGate(super.getGid(), i);
            res = res || gin.get();
            if (res == true) {
                return true;
            }
        }
        return false;
}


}
