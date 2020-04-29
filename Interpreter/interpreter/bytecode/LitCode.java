package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int number;
    private String val;
    @Override
    public void init(ArrayList<String> args){
        number = Integer.parseInt((String) args.get(0)); //use parse int to convert to an int
        if(args.size() > 1)
            val = (String) args.get(1);

    }
    @Override
    public  void execute(VirtualMachine VM){
        VM.pushRunStack(number);
    }//to add to the stack

    @Override
    public String toPrint(VirtualMachine VM) {
        return ("LIT " +number);
    }
}
