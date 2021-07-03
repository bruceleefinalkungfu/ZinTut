/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED.
 *
 * Sensproducts  
 * 
 */

package zin.tut.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZTIOMyFileReader extends FileReader
{

    public ZTIOMyFileReader(File file) throws FileNotFoundException
    {
        super(file);
    }

    public ZTIOMyFileReader(FileDescriptor fd)
    {
        super(fd);
    }

    public ZTIOMyFileReader(String fileName) throws FileNotFoundException
    {
        super(fileName);
    }
    
    @Override
    public void close() throws IOException
    {
        System.out.println("In my close method");
        super.close();
    }
    
}


/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED
 *
 * Sensproducts
 */
