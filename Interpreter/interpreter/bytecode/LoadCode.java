package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int number;
    private String val;

    @Override
    public void init(ArrayList<String> args){
        number = Integer.parseInt( args.get(0));
        if(args.isEmpty()){
            val = "";
        }
        else {
            val = args.get(1);
        }

    }
    @Override
    public  void execute(VirtualMachine VM){
        VM.loadRunStack(number);

    }
    @Override
    public String toPrint(VirtualMachine VM) {
        return "LOAD " + number + " " + val;
    }
}

