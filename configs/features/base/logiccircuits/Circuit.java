package logiccircuits;

public class Circuit {
	String name; //base

    public Circuit(String s) {
        name = s;
    }

    public Gate Gate(String name, int nInputPins, int nOutputPins, String type) { //base
		return new Gate(this, name, nInputPins, nOutputPins, type);
    }
}