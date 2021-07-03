package zin.tools;

public class ZIO {

	public static void print(String s) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		int myCallerMethodIndex = 2;
		if(stackTraceElements != null && stackTraceElements.length > myCallerMethodIndex)
		{
			s = stackTraceElements[myCallerMethodIndex].getMethodName() + ": " + s;
		}
		System.out.println(s);
	}
	
}
