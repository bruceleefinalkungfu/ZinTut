package zin.tut.j8.iface;

import static zin.tools.ZIO.*;

public interface ParentInterfaceWithDefaultStatic1 {

	String abstractMethod();
	
	default String defaultMethod() {
		return getClassNameAndMethodName();
	}
	
	static String staticMethod() {
		return getClassNameAndMethodName();
	}
	
}
