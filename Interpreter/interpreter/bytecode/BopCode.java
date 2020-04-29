package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode{
    private String operatr;

    public void init(ArrayList<String> args){
        operatr = args.get(0);

    }
    //used switch to check for + - * etc
    public  void execute(VirtualMachine VM){
        int opr1 = VM.popRunStack(); //
        int opr2 = VM.popRunStack();

        switch (operatr){
            case "+":
                VM.pushRunStack(opr2+opr1);
                break;
            case "-":
                VM.pushRunStack(opr2-opr1);
                break;
            case "*/":
                VM.pushRunStack(opr2/opr1);
                break;
            case "*":
                VM.pushRunStack(opr2*opr1);
                break;
            case "==":
                if(opr2==opr1) {
                    VM.pushRunStack(1);
                }
                else {
                    VM.pushRunStack(0);
                }
                break;
            case "!=":
                if(opr2!=opr1) {
                    VM.pushRunStack(1);
                }
                else {
                    VM.pushRunStack(0);
                }
                break;
            case "<=":
                if(opr2<=opr1) {
                    VM.pushRunStack(1);
                }
                else {
                    VM.pushRunStack(0);
                }
                break;
            case ">":
                if(opr2>opr1) {
                    VM.pushRunStack(1);
                }
                else {
                    VM.pushRunStack(0);
                }
                break;
            case ">=":
                if(opr2>=opr1) {
                    VM.pushRunStack(1);
                }
                else {
                    VM.pushRunStack(0);
                }
                break;
            case "<":
                if(opr2<opr1) {
                    VM.pushRunStack(1);
                }
                else {
                    VM.pushRunStack(0);
                }
                break;
            case "|":
                if(opr2==0 && opr1==0) {
                    VM.pushRunStack(0);
                }
                else {
                    VM.pushRunStack(1);
                }
                break;
            case "&":
                if(opr2==1 && opr1==1) {
                    VM.pushRunStack(1);
                }
                else {
                    VM.pushRunStack(0);
                }
                break;

        }

    }
    @Override
    public String toPrint(VirtualMachine VM) {
        return "BOP " + operatr;
    }
}