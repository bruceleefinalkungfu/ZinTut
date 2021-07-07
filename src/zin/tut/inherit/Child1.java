package zin.tut.inherit;

public class Child1 extends Parent {

	public String childMethod() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "childMethod_1";
	}
	
}
