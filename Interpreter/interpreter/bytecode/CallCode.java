package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private int addressoffunc;
    private String funcName;

    @Override
    public void init(ArrayList<String> args){
        funcName = args.get(0);

    }
    @Override
    public  void execute(VirtualMachine VM){
        VM.pushReturnAddrs(VM.getPc());
        VM.setPc(addressoffunc-1);

    }

    public void setAddressoffunc(int addressoffunc) {
        this.addressoffunc = addressoffunc;
    }


    public String getFuncName(){
        return funcName;
    }

    @Override
    public String toPrint(VirtualMachine VM) {

        return "CALL " + funcName;
    }
}
