package logiccircuits;

public class Gate {
	public final String name; //base
    int nInputPins, nOutputPins; //base
    String type; //base
    logiccircuits.Circuit circuit; //base
    
    protected Gate(logiccircuits.Circuit circuit, String name, int nInputPins, int nOutputPins, String type) { //base
        this.circuit = circuit;
        
        this.name = name;
        this.nInputPins = nInputPins;
        this.nOutputPins = nOutputPins;
        this.type = type;
    }
}