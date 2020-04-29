package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() { //to dump the state of runtimetstack
      Iterator itr = framePointer.iterator(); //used iterator
        int latestFrame, nowFrame = (Integer) itr.next();
        int z = 0;

        while (z < framePointer.size()) {
            if (itr.hasNext()) { // see if there are more elements
                latestFrame = (Integer) itr.next(); // returns the next element
            } else {
                latestFrame = runTimeStack.size();
            }
            System.out.print("["); //to created divisions

            int y = nowFrame;
            while (y < latestFrame) {
                System.out.print(runTimeStack.get(y));
                if (y != latestFrame - 1) { //check to see if the nowFrame isn't equal to the latestFrame
                    System.out.print(",");
                }
                y++;
            }
            System.out.print("]");
            nowFrame = latestFrame;
            z++;
        }
        System.out.println();

    }

    public int peek(){
        return runTimeStack.get(runTimeStack.size()-1);
    } //gives the top of the stack
    public int pop(){

       if(runTimeStack.size() != 0){ //if isn;t empty
           return runTimeStack.remove(runTimeStack.size()-1); //remove from the top
        }

        else{
            return 0;
        }

    }
    public int push(int i){
        runTimeStack.add(i); //add to the top
        return i;
    }
    public void newFrameAt(int offset){
        int sizeOfRtStack = runTimeStack.size();
        framePointer.push(sizeOfRtStack - offset);//how many slots down to add the frame
    }

    public void popFrame() {

        int retVal = this.peek();
        int fp = framePointer.pop();
        for (int z = runTimeStack.size() - 1; z >= fp; z--) {
            this.pop(); //pop the top frame
        }
        this.push(retVal); //push to the top of the stack
    }
    public int store(int offset){
        int retVal = this.pop();
        runTimeStack.set(framePointer.peek() + offset, retVal); //replaces the value at the given offset

        return retVal;
    }
    public int load(int offset){
        int cpyVal = runTimeStack.get(framePointer.peek()+offset); //copy the value from the offset
        runTimeStack.add(cpyVal);
        return cpyVal;
    }
    public Integer push(Integer val){
        runTimeStack.add(val); //add to runtimestack
        return val;
    }

}


