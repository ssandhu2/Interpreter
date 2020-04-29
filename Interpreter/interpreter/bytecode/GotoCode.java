package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
    private int addressoffunc;
    private String funcName;

    @Override
    public void init(ArrayList<String> args){
        funcName = args.get(0);

    }
    @Override
    public  void execute(VirtualMachine VM){
        VM.setPc(addressoffunc-1);//to set counter

    }
    public void setAddress(int addressoffunc){ //sets address
        this.addressoffunc =addressoffunc;

    }
    public String getFuncName(){
        return funcName;
    } //return name
    @Override
    public String toPrint(VirtualMachine VM) {
        return "Goto " + funcName;
    }
}
