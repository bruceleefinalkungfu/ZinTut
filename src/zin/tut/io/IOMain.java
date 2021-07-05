/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED.
 *
 * Sensproducts  
 * 
 */

package zin.tut.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

import static zin.tools.ZIO.*;

public class IOMain
{

    String IO_TEXT_FILE_NAME = "io_text_file_1st_line_int_2nd_line_string.txt";
    
    public void tryWithResource_ClosesAutoClosablesBeforeFinallyBlock() {
        File file = getFile();
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
    
    public void differenceBetweenScannerAndBufferedReader() {
    	File file = getFile();
    	try (
                FileReader fileReader = new IOMyFileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
    			FileInputStream fileInputStream = new FileInputStream(file);
    			Scanner scanner = new Scanner(fileInputStream);
    		) {
    		
    		// Reading the first line as Int from Scanner
    		int scanner1stLine = scanner.nextInt();
    		String scanner2ndLine = scanner.nextLine();

    		/**
    		 * It prints
    		 * Scanner 1st : 12. Scanner 2nd :
    		 */
    		print("Scanner 1st : "+scanner1stLine + ". Scanner 2nd : " + scanner2ndLine);
    		
    		int buffered1stLine = Integer.parseInt(bufferedReader.readLine());
    		String buffered2ndLine = bufferedReader.readLine();

    		/**
    		 * It prints
    		 * Buffer 1st : 12. Buffer 2nd : Hello world
    		 */
    		print("Buffer 1st : "+buffered1stLine + ". Buffer 2nd : " + buffered2ndLine);
    		
    		/**
    		 * Explanation :
    		 * It doesn't matter if you read from file or console. Or defining simply as Scanner scan = new Scanner("12\nHello World");
    		 * After calling Scanner.nextInt(), nextShort() etc, your Scanner.nextLine() will always return empty string.
    		 * Because nextInt() processes till \n. So it only reads 12 and not the \n after that.
    		 * When called nextLine() It reads the same line again but there's only empty string left before \n
    		 */
    		
    	} catch(Exception e) {
            print("Exception "+e.getMessage());
        } finally { }
    }
    
    public void scannerNextLineWeirdWorking()
    {
    	try (
    			Scanner scanner = new Scanner("Read this word\nGo to the Next line\nAnd again.");
    		) {
    		String firstWordRead = scanner.next();
    		String remainingWordsInLine = scanner.nextLine();
    		// It prints Read. Because it stops at the first whitespace
    		print("First word: " + firstWordRead);
    		// It print ' this word' because that many characters are left before the first \n
    		print("Scanner next Line result: " + remainingWordsInLine);
    	} catch (Exception e) {
    		print("Exception "+e.getMessage());
    	} finally { }
    }
    
    private File getFile() {
    	return new File(IO_TEXT_FILE_NAME);
    }
    
}


/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED
 *
 * Sensproducts
 */
