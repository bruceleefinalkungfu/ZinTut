package zin.tut.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Scanner;

import static zin.tools.ZIO.*;
import static zin.tut.io.IOConstants.*;

/**
 * -----------------------------------
 * Q. What are I/O streams?
 * A. Streams are fixed size FIFO queues of bytes. A process writes to an O/P stream & reads from I/P stream.
 * Source and destination connecting the stream could be a process, file system, or TCP stack for socket, or a peripheral device.
 * 
 * Some streams you can re read after reseting it. Some you can't.
 * 
 * @author anuragawasthi
 *
 */
public class IOEasyMain
{

    public void tryWithResource_ClosesAutoClosablesBeforeFinallyBlock() {
        File file = getFile();
        /**
         * Without try with resource, you had to declare a null BufferedReader
         * outside the try block and in finally check for null before closing
         */
        try(
            /**
             * BufferedReader is closed before fileReader after finishing the try block and before finally block
             * ZTIOMyFileReader close called twice. bufferedReader.close() also called its fileReader's close
             */
            FileReader fileReader = new IOMyFileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            /**
             * Compile time error : String does not implement AutoClosable
             */
            // String randomVariable = "Hi";
            
            /**
             * Compile time error : Token misplaced
             * Any statement other than initialization of AutoClosable implemented classes are error
             */
            // System.out.println("Hi");
            ) {
            String firstLine = bufferedReader.readLine();
            print("FirstLine :"+firstLine);
        } catch(Exception e) {
            print("Exception "+e.getMessage());
        } finally {
            print("Finally block");
        }
    }
    
    private File getFile() {
    	return new File(IO_TEXT_FILE_NAME);
    }
    
    public static void main(String[] args) {
    	runAllMethod(IOEasyMain.class);
    }
    
}