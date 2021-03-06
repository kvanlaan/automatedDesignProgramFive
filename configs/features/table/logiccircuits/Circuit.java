package logiccircuits;

import java.util.List;
import java.util.LinkedList;

public class Circuit {

    List<logiccircuits.Gate> gates; //table
    List<logiccircuits.Wire> wires; //table
    int num_and = 0, num_or = 0, num_nand = 0, num_nor = 0, num_inv = 0; //table

    public Circuit(String s) {
        gates = new LinkedList<logiccircuits.Gate>(); //table
        wires = new LinkedList<logiccircuits.Wire>(); //table
    }

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
}
