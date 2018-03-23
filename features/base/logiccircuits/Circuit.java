package logiccircuits;

public class Circuit {
	String name; //base

    public Circuit(String s) {
        name = s;
    }
    
    class Gate extends logiccircuits.Gate { //base
    	public Gate(Circuit circuit, String name, int nInputPins, int nOutputPins, String type) {
    		super(circuit, name, nInputPins, nOutputPins, type);
    	}
    }
    
    public Gate Gate(String name, int nInputPins, int nOutputPins, String type) { //base
		return new Gate(this, name, nInputPins, nOutputPins, type);
    }
}