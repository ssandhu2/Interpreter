package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args){

    }
    @Override
    public  void execute(VirtualMachine VM){
        VM.checkRun(false); //to stop the program

    }
    @Override
    public String toPrint(VirtualMachine VM) {
        return "HALT ";
    }
}
