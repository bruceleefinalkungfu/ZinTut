package zin.tools.j8.lambda;

import static zin.tools.ZIO.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import zin.tut.inherit.InheritanceEasyMain;

public class J8LambdaEasyMain {

	public void javaDeducesTheLambdaType() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		// This lambda is considered Runnable because it returns nothing
		executorService.submit(() -> voidMethod());
		// This lambda is considered Callable because it returns something
		executorService.submit(() -> returningMethod());
	}

	private void voidMethod() {
		print("void method");
	}

	private String returningMethod() {
		return print("method that returns");
	}

	public static void main(String[] args) {
    	runAllMethod(J8LambdaEasyMain.class);
    }
    
	
	
}
