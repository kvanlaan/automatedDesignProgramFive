package logiccircuits;

public class Wire { 

	public logiccircuits.Gate getTo() {
        return this.to;
    }
    
    public int getToPin() {
        return this.toPin;
    }
    public logiccircuits.Gate getFrom() {
        return this.from;
    }
}