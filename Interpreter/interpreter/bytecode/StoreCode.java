package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{
    private int offsetn;
    private String id;
    @Override
    public void init(ArrayList<String> args){
        offsetn = Integer.parseInt(args.get(0));
        id = args.get(1);
    }
    @Override
    public  void execute(VirtualMachine VM){
        VM.storeRunStack(offsetn);
    }
    @Override
    public String toPrint(VirtualMachine VM) {
        return "STORE " + offsetn + " " + id;
    }
}