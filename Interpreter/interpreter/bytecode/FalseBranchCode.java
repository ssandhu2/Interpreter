package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    private int addressoffunc;
    private String funcName;

    @Override
    public void init(ArrayList<String> args){
        funcName = args.get(0);

    }

    @Override
    public  void execute(VirtualMachine VM){
        if(VM.popRunStack()==0){
            VM.setPc(addressoffunc-1); // to set program counter
        }

    }
    public void setAddress(int addressoffunc){
        this.addressoffunc =addressoffunc;
    } //set method of function address

    public String getFunctionName() {
        return funcName;
    } //gives the name


    @Override
    public String toPrint(VirtualMachine VM) {
        return "FALSEBRANCH: " + funcName;
    }
}
