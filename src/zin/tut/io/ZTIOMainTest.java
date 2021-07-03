/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED.
 *
 * Sensproducts  
 * 
 */

package zin.tut.io;

import org.junit.Test;

public class ZTIOMainTest
{
    ZTIOMain ztioMain = new ZTIOMain();
    
    @Test public void tryWithResource() {
        ztioMain.tryWithResource_ClosesAutoClosablesBeforeFinallyBlock();
    }
}


/*
 * Copyright (c) Siemens AG 2021 ALL RIGHTS RESERVED
 *
 * Sensproducts
 */
