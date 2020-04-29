package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String label;

    @Override
    public void init(ArrayList<String> args){
        label = args.get(0);

    }
    @Override
    public  void execute(VirtualMachine VM){
      
    }
    public String getLabel(){
        return label;
    } // to get the label
    @Override
    public String toPrint(VirtualMachine VM) {
        return "LABEL " + label;
    }

}
