package zin.tut.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import zin.tut.j8.lambda.J8LambdaEasyMain;

import static zin.tools.ZIO.*;

public class MultiThreadEasyMain {

	public void threadDeathError() {
		
	}
	
	public void executorServiceSubmitRunnableReturnsFutureOfWildCard() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<?> future = executorService.submit(() -> {int a = 5;});
		// future.get returns null for Runnable because it's not supposed to return nothing
		Object o = future.get();
		print("Returned "+o);
	}

	public static void main(String[] args) {
    	runAllMethod(MultiThreadEasyMain.class);
    }
    
}
