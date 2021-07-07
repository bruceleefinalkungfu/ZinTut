package zin.tut.exception;

import static zin.tools.ZIO.*;

public class ExceptionMain {
	
	public void willFinallyExecute_IfNotCatchingUnCheckedException() {
		try {
			int a = 4/0;
		} finally {
			print("Yes this finally will print. But not any of the lines out of this block");
		}
		print("This line won't print because RuntimeException failed to find any handler (catch)");
	}

}
