package Application; 

import logiccircuits.*; 
import logiccircuits.library.*; 

public   class  Main {
	
	public static boolean basefeature = true;

	
	public static boolean beautifyfeature = false;

	
	public boolean tablefeature = false;

	
	public boolean conformfeature  = false;

	
	public boolean evalfeature = false;

	
	public Main  () {
		basefeature = true;
	
		beautifyfeature = true;
	
		tablefeature = true;
	
		conformfeature = true;
	}

	
	
	 private void  print__wrappee__base  () {
		System.out.println("base");
	}

	
	
	 private void  print__wrappee__beautify  () {
		print__wrappee__base();
		System.out.println("beautify");
	}

	
	
	 private void  print__wrappee__table  () {
		print__wrappee__beautify();
		System.out.println("table");
	}

	
	
	public void print() {
		print__wrappee__table();
		System.out.println("conform");
	}

	
   
	public void create_circuit  () {
        Circuit xx = new Circuit("XX");         // create a new circuit object xx called "XX"

        Gate A = new Input(xx,"A");
        Gate B = new Input(xx,"B");
        Gate C = new Input(xx,"C");
        Gate D = new Input(xx,"D");
        Gate α = new Output(xx,"α");
        Gate β = new Output(xx,"β");

        Gate nor = new Nor(xx,"nor",2);
        Gate inv = new Inv(xx,"inv");
        Gate and = new And(xx,"and", 3);
        Gate or = new Or(xx,"or", 2);
     
        new Wire(xx,A,nor,1);
        new Wire(xx,B,nor,2);
        new Wire(xx,nor,and, 1);
        new Wire(xx,C,or, 1);
        new Wire(xx,D,or, 2);
        new Wire(xx,C,inv, 1);
        new Wire(xx,inv,and, 2);
        new Wire(xx,or,and, 3);
        new Wire(xx,or,β);
        new Wire(xx,and, α);
        xx.validate();
        xx.print();
    }

	
	
	/******************************************************************************************************/
	
	static Main me;

	
	
	public static void main(String[] args) {
    	me = new Main();
    	me.print();
    	System.out.println();
    	me.create_circuit();
	}


}
