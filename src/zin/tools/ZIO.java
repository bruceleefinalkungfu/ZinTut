package zin.tools;

public class ZIO {

	public static void print(String s) {
		String callingName = getClassNameAndMethodName(5);
		if(callingName != null && !callingName.trim().isEmpty()) {
			s = callingName + ": " + s;
		}
		System.out.println(s);
	}

	/**
	 * Not this class name {@link ZIO}. The class which is calling this method
	 */
	public static String getClassName() {
		StackTraceElement[] stackTraceElements = getStackTrace();
		int myCallerMethodIndex = 3;
		if(stackTraceElements != null && stackTraceElements.length > myCallerMethodIndex)
		{
			return stackTraceElements[myCallerMethodIndex].getClassName();
		}
		return "";
	}

	private static String getClassName(int myCallerMethodIndex) {
		StackTraceElement[] stackTraceElements = getStackTrace();
		if(stackTraceElements != null && stackTraceElements.length > myCallerMethodIndex)
		{
			return stackTraceElements[myCallerMethodIndex].getClassName();
		}
		return "";
	}

	/**
	 * Not this class name {@link ZIO#getMethodName()}. The class which is calling this method
	 */
	public static String getMethodName() {
		StackTraceElement[] stackTraceElements = getStackTrace();
		int myCallerMethodIndex = 3;
		if(stackTraceElements != null && stackTraceElements.length > myCallerMethodIndex)
		{
			return stackTraceElements[myCallerMethodIndex].getMethodName();
		}
		return "";
	}
	
	private static String getMethodName(int myCallerMethodIndex) {
		StackTraceElement[] stackTraceElements = getStackTrace();
		if(stackTraceElements != null && stackTraceElements.length > myCallerMethodIndex)
		{
			return stackTraceElements[myCallerMethodIndex].getMethodName();
		}
		return "";
	}

	public static String getClassNameAndMethodName() {
		return getClassName(3) + "." + getMethodName(3);
	}

	private static String getClassNameAndMethodName(int methodIndex) {
		return getClassName(methodIndex) + "." + getMethodName(methodIndex);
	}
	
	public static StackTraceElement[] getStackTrace() {
		return Thread.currentThread().getStackTrace();
	}
}
