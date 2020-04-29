package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void init(ArrayList<String> args){

    }
    @Override
    public  void execute(VirtualMachine VM) {
        System.out.print("Enter an Integer: ");
        VM.pushRunStack(scanner.nextInt());//to read from the number to test from the user
    }

    @Override
    public String toPrint(VirtualMachine VM) {
        return "READ ";
    }
}
