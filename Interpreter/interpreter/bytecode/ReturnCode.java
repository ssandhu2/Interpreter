package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String funcName;
    private int retVal;
    @Override
    public void init(ArrayList<String> args){
        if(args.size()>0){
            funcName = args.get(0);
        }
        else {
            funcName="";
        }
    }
    @Override
    public  void execute(VirtualMachine VM){
        VM.popFrameRunStack();
        VM.setPc(VM.popReturnAddrs());
        retVal = VM.peekRunStack();

    }
    @Override
    public String toPrint(VirtualMachine VM) {
        return "RETURN " +funcName;
    }
}
