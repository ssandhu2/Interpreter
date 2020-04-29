package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    private int arco;
    @Override
    public void init(ArrayList<String> args){
        arco = Integer.parseInt(args.get(0)); //coverts to an int

    }
    @Override
    public  void execute(VirtualMachine VM){
        //System.out.println();
        VM.newFrameAtRunStack(arco); //adds a new frame
    }

    @Override
    public String toPrint(VirtualMachine VM) {
        return "ARGS" + "["+  arco+ "]";
    } // used to print
}
