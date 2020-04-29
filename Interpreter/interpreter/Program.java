package interpreter;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import interpreter.bytecode.*;


public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> addrsHash = new HashMap<String, Integer>();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public void byteCodeAdd(ByteCode byteCode){
        if (byteCode instanceof LabelCode) { //check if it's an instance of labelcode or not
            LabelCode instlbc = (LabelCode) byteCode; //downcast
            addrsHash.put(instlbc.getLabel(), program.size()); //add to the hasmap with key and value
        }
        program.add(byteCode);

    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        for (int z=0; z <program.getSize(); z++){ //for loop to run
            if(program.getCode(z) instanceof FalseBranchCode){ //check if it's an instance of labelcode or not
                FalseBranchCode instfbc = (FalseBranchCode) program.getCode(z); //downcast
                instfbc.setAddress(addrsHash.get(instfbc.getFunctionName()));  //setAddress in the falsebrach subclass to resolve symbolic address

            }
            if(program.getCode(z) instanceof CallCode){ //check if it's an instance of CallCode or not
                CallCode instcallco = (CallCode) program.getCode(z); //downcast
                instcallco.setAddressoffunc(addrsHash.get(instcallco.getFuncName())); //setAddress in the CallCode subclass to resolve symbolic address

            }
            if(program.getCode(z) instanceof GotoCode){ //check if it's an instance of GotoCode or not
                GotoCode instgotocode = (GotoCode) program.getCode(z);
                instgotocode.setAddress(addrsHash.get(instgotocode.getFuncName())); //setAddress in the GotoCode subclass to resolve symbolic address

            }

        }

    }




}
