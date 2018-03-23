package Application;

import logiccircuits.*;

public class Main {
	public static boolean basefeature = true;
	public static boolean beautifyfeature = false;
	public boolean tablefeature = false;
	public boolean conformfeature  = false;
	public boolean evalfeature = false;
	
	public Main() {
		basefeature = true;
	}
	
	public void print() {
		System.out.println("base");
	}
	
	public void create_circuit() {
		Circuit xx = new Circuit("XX"); // base - create circuit
	    
		Gate A = xx.Gate("A", 0, 1, "Input");
	    Gate B = xx.Gate("B", 0, 1, "Input");
	    Gate C = xx.Gate("C", 0, 1, "Input");
	    Gate D = xx.Gate("D", 0, 1, "Input");
	    Gate α = xx.Gate("α", 1, 0, "Output");
	    Gate β = xx.Gate("β", 1, 0, "Output");
	
	    Gate nor = xx.Gate("nor", 2, 1, "nor");
	    Gate inv = xx.Gate("inv", 1, 1, "inv");
	    Gate and = xx.Gate("and", 3, 1, "and");
	    Gate or = xx.Gate("or", 2, 1, "or");
	 
	    new Wire(xx,A,1,nor,1);
	    new Wire(xx,B,1,nor,2);
	    new Wire(xx,nor,1,and,1);
	    new Wire(xx,C,1,or,1);
	    new Wire(xx,D,1,or,2);
	    new Wire(xx,C,1,inv,1);
	    new Wire(xx,inv,1,and,2);
	    new Wire(xx,or,1,and,3);
	    new Wire(xx,or,1,β,1);
	    new Wire(xx,and,1,α,1);
	}
	
	/******************************************************************************************************/
	
	static Main me;
	
	public static void main(String[] args) {
    	me = new Main();
    	me.print();
    	me.create_circuit();
	}
	
	
}