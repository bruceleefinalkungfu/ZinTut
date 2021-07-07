package zin.tools.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import zin.tools.j8.lambda.J8LambdaEasyMain;

import static zin.tools.ZIO.*;

public class MultiThreadEasyMain {

	public void threadDeathError() {
		
	}
	
	public void executorServiceSubmitRunnableReturnsFutureOfWildCard() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(() -> print("My Runnable"));
	}

	public static void main(String[] args) {
    	runAllMethod(MultiThreadEasyMain.class);
    }
    
}
