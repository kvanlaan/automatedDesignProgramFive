package logiccircuits;

public class Circuit {

    boolean conform = false;

    // fill in the rest
    public Circuit(String s) {
    	name = s;
        gates = new LinkedList<logiccircuits.Gate>(); //table
        wires = new LinkedList<logiccircuits.Wire>(); //table
    }

    public void validate() {
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
        ArrayList<Gate> inputGates = new ArrayList<logiccircuits.Gate>();
        ArrayList<Gate> outputGates = new ArrayList<logiccircuits.Gate>();
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
    
    public boolean isConformed() {
        return this.conform;
    }
    
    public void initValues() {
    	for(logiccircuits.Gate gate: gates) {
            gate.setValue(Value.U);
        };
    }
    
    public Gate findInputGate(String to_gid, int to_pin_no) {
        for (logiccircuits.Wire wire : wires) {
            if ((wire.getTo().getGid().equals(to_gid)) && (wire.getToPin() == to_pin_no)) {
                return wire.getFrom();
            }
        }
        throw Err.toss("Input gate %s value is unknown.", to_gid);
    }
}