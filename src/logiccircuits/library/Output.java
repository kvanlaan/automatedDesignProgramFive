package logiccircuits.library; 

import logiccircuits.Circuit; 
import logiccircuits.Gate; 

public   class  Output  extends Gate {
	 //beautify
    public Output(Circuit xx, String name) { //beautify
        super(xx, name, 1, 0, "output");
    }

	 //beautify
    @Override
    public boolean get() {
        Gate gin = super.findInputGate(super.getGid(), 1);
        return gin.get();
}


}
