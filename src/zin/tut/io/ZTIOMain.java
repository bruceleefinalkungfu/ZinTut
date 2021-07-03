/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED.
 *
 * Sensproducts  
 * 
 */

package zin.tut.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ZTIOMain
{

    String IO_TEXT_FILE_NAME = "io_text_file.txt";
    
    public void tryWithResource_ClosesAutoClosablesBeforeFinallyBlock() {
        File file = new File(IO_TEXT_FILE_NAME);
        try(
            /**
             * BufferedReader is closed before fileReader after finishing the try block and before finally block
             * ZTIOMyFileReader close called twice. bufferedReader.close() also called its fileReader's close
             */
            FileReader fileReader = new ZTIOMyFileReader(file);
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
            System.out.println("FirstLine :"+firstLine);
        } catch(Exception e) {
            System.out.println("Exception "+e.getMessage());
        } finally {
            System.out.println("Finally block");
        }
    }
    
}


/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED
 *
 * Sensproducts
 */
