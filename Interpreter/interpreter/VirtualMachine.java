package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump =true; //to check for dump

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);//run the execute method in the subclasses

            if (dump && !(code instanceof DumpCode)) { //to check for dump
                System.out.println(code.toPrint(this));
                runStack.dump();

            }
            pc++;
        }
    }

    //below methods are from RuntimeStack to be used in the subclasses to avoid breaking encapsulation
    public int peekRunStack() {
        return runStack.peek();
    }

    public int popRunStack() {
        return runStack.pop();
    }

    public int pushRunStack(int i) {
        return runStack.push(i);
    }

    public void newFrameAtRunStack(int offset) {
        runStack.newFrameAt(offset);
    }

    public void popFrameRunStack() {
        runStack.popFrame();
    }

    public int storeRunStack(int offset) {
        return runStack.store(offset);
    }

    public int loadRunStack(int offset) {
        return runStack.load(offset);
    }

    public Integer pushRunStack(Integer val) {
        return runStack.push(val);
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void pushReturnAddrs(int i) {
        returnAddrs.push(i);
    }

    public int popReturnAddrs() {
        return (int) returnAddrs.pop();
    }

    //for halt to stop the program
    public void checkRun(boolean run) {
        isRunning = run;
    }

    //these two methods are to set dump to true or false
    public void dumpOn() {
        dump = true;
    }
    public void dumpOf(){
        dump= false;
    }

}

