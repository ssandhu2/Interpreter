
package interpreter;
import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));

    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program program = new Program();
        ArrayList<String> arrL = new ArrayList<>();

        try {
            String rdline = byteSource.readLine(); //to read from the file

            while (rdline != null) { //to check if the file isn't empty
                StringTokenizer tokens = new StringTokenizer(rdline); //tokenize
                arrL.clear();

                String code = tokens.nextToken(); //store into variable
                String className = CodeTable.getClassName(code);//class name from code table

                while (tokens.hasMoreTokens()) {
                    arrL.add(tokens.nextToken()); //add to the arraylist is there are more tokens
                }

                Class c = Class.forName("interpreter.bytecode." + className);

                ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();
                bc.init(arrL); //call the init method and pass the arraylist
                program.byteCodeAdd(bc); //call the add method in program
                rdline = byteSource.readLine();

            }

        }

        catch(ClassNotFoundException| IOException| NoSuchMethodException| IllegalAccessException| InvocationTargetException|InstantiationException e){
            System.out.println("There's an error " +e );

        }

        program.resolveAddrs(program); //call the resolve address method

        return program;
    }

}
