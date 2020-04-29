package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String statusOfDump;
    @Override
    public void init(ArrayList<String> args){
        statusOfDump = args.get(0);

    }
    @Override
    public  void execute(VirtualMachine VM){
        //to check if dump is on or not
        if("ON".equals(statusOfDump)){
            VM.dumpOn();
        }
        else{
            VM.dumpOf();
        }

    }
    @Override
    public String toPrint(VirtualMachine VM) {
        return "DUMP" + statusOfDump;
    }
}
