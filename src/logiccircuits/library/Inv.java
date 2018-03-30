package logiccircuits.library; 

import logiccircuits.Circuit; 
import logiccircuits.Gate; 

public   class  Inv  extends Gate {
	 //beautify
    
    public Inv(Circuit xx, String name) { //beautify
        super(xx, name, 1, 1, "inv");
    }

	 //beautify
    @Override
    public boolean get() {
        Gate gin = super.findInputGate(super.getGid(), 1);
        return !gin.get();
}


}
