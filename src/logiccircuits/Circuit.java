package logiccircuits; 

import java.util.List; 
import java.util.LinkedList; 

import PrologDB.*; 
import java.util.HashSet; 
import java.util.ArrayList; 

public   class  Circuit {
	
	String name;

	

    // fill in the rest
    public Circuit  (String s) {
        name = s;
    
        gates = new LinkedList<logiccircuits.Gate>(); //table
        wires = new LinkedList<logiccircuits.Wire>(); //table
    
    	name = s;
        gates = new LinkedList<logiccircuits.Gate>(); //table
        wires = new LinkedList<logiccircuits.Wire>(); //table
    }

	
    public void Gate  (String name, int nInputPins, int nOutputPins, String type) { //beautify
    }

	

    List<logiccircuits.Gate> gates;

	 //table
    List<logiccircuits.Wire> wires;

	 //table
    int num_and = 0, num_or = 0, num_nand = 0, num_nor = 0, num_inv = 0;

	

    public int getGateNum(String type) { //table
        switch (type) {
            case "and":
                return num_and;
            case "or":
                return num_or;
            case "nand":
                return num_nand;
            case "nor":
                return num_nor;
            case "inv":
                return num_inv;
            default:
                return -1;
        }
    }

	

    public void addOneGate(String type) { //table
        switch (type) {
            case "and":
                num_and += 1;
                break;
            case "or":
                num_or += 1;
                break;
            case "nand":
                num_nand += 1;
                break;
            case "nor":
                num_nor += 1;
                break;
            case "inv":
                num_inv += 1;
                break;
        }
    }

	

    public void print() { //table
        System.out.format("circuit(%s).\n", this.name);
        
        System.out.println();
        for (logiccircuits.Gate gate : gates) {
        	gate.print();
        }
        
        System.out.println();
        for (logiccircuits.Wire wire : wires) {
        	wire.print();
        }
    }

	

    public void validate  () {
        ErrorReport er = new ErrorReport();

        // Constraint 1: Each Gate has a unique id
        ArrayList<String> gateNames = new ArrayList<String>();
        for(logiccircuits.Gate gate: gates) {
            gateNames.add(gate.getGateId());
        };
        HashSet<String> gateNameSet = new HashSet<String>();
        for (String name : gateNames) {
            if (!gateNameSet.add(name)) {
                er.add("Duplicate Gate Id is Found");
            }
        }

        // Constraint 2: Circuit has >= 1 gates
        if (gates.size() < 1) {
            er.add("Circuit is missing gates");
        }
        // Constraint 3: Circuit has >= 1 wire
        if (wires.size() < 1) {
            er.add("Circuit is missing wires");
        }

        // Constraint 4-6: All wires are properly connected
        ArrayList<logiccircuits.Gate> inputGates = new ArrayList<logiccircuits.Gate>();
        ArrayList<logiccircuits.Gate> outputGates = new ArrayList<logiccircuits.Gate>();
        for (logiccircuits.Wire wire: wires) {
            if (wire.to == null || wire.from == null) {
                er.add("Wire is missing either a to or from pin");
            }

            if (wire.from.type.equals("output")) {
                er.add("Wire's from gate is an ouput");
            }
            if (wire.to.type.equals("input")) {
                er.add("Wire's to gate is an input");
            }

            if (wire.from.type.equals("input")) {
                inputGates.add(wire.from);
            }

            if (wire.to.type.equals("input")) {
                inputGates.add(wire.to);
            }

            if (wire.from.type.equals("output")) {
                outputGates.add(wire.from);
            }

            if (wire.to.type.equals("output")) {
                outputGates.add(wire.to);
            }
        };

        // Constraint 7: Circuit has >= 1 input pins
        if (inputGates.size() < 1) {
            er.add("Circuit is missing an input gate");
        }

        // Constraint 8: Circuit has >= 1 output pins
        if (outputGates.size() < 1) {
            er.add("Circuit is missing an output gate");
        }

        // Finish by reporting collected errors
        er.printReportEH(System.out);

        if (!er.printReport(System.out)) {
            this.conform = true;
        }
    }

	

    boolean conform = false;

	
    
    public boolean isConformed() {
        return this.conform;
    }

	
    
    public void initValues() {
    	for(logiccircuits.Gate gate: gates) {
            gate.setValue(Value.U);
        };
    }

	
    
    public logiccircuits.Gate findInputGate(String to_gid, int to_pin_no) {
        for (logiccircuits.Wire wire : wires) {
            if ((wire.getTo().getGid().equals(to_gid)) && (wire.getToPin() == to_pin_no)) {
                return wire.getFrom();
            }
        }
        throw Err.toss("Input gate %s value is unknown.", to_gid);
    }


}
