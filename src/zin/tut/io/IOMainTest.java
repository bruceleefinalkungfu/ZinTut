/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED.
 *
 * Sensproducts  
 * 
 */

package zin.tut.io;

import org.junit.Test;

public class IOMainTest
{
    IOMain ztioMain = new IOMain();
    
    @Test public void tryWithResource() {
        ztioMain.tryWithResource_ClosesAutoClosablesBeforeFinallyBlock();
    }
    
    @Test public void differenceBetweenScannerAndBufferedReader() {
    	ztioMain.differenceBetweenScannerAndBufferedReader();
    }
}


/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED
 *
 * Sensproducts
 */
