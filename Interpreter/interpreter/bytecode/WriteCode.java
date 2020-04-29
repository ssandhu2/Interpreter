package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode{
    @Override
    public void init(ArrayList<String> args){

    }
    @Override
    public  void execute(VirtualMachine VM){
        System.out.println("WRITE \n" + VM.peekRunStack());

    }

    @Override
    public String toPrint(VirtualMachine VM) {
        return "WRITE";
    }
}

