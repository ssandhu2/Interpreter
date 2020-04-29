package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{
    private int number;
    @Override
    public void init(ArrayList<String> args){
        number = Integer.parseInt(args.get(0));

    }
    @Override
    public  void execute(VirtualMachine VM){
        for (int z=0;z<number;z++){
            VM.popRunStack(); //pop the runtimestack
        }

    }
    @Override
    public String toPrint(VirtualMachine VM) {
        return "POP " + number;
    }
}


