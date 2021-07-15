package zin.tut.inherit;

import java.util.Arrays;
import java.util.List;

import zin.tut.io.IOEasyMain;

import static zin.tools.ZIO.*;

/**
 * @author anuragawasthi
 *
 */
public class InheritanceEasyMain {

	public void needOfWildCard() {
		List<Parent> parents = Arrays.asList(new Parent());
		List<Child1> child1s = Arrays.asList(new Child1());

		// Working
		methodAcceptingArrayOfParent(new Child1[] {new Child1()});
		// Compile time error
		// methodAcceptingListOfParent(child1s);
		
		// Generic working. But you can't add any value to the list
		methodAcceptingListOfGenericExtendingParent(child1s);
		
		// Wild card working for both Parent, Child or Object because it also is a super class
		methodAcceptingListOfWildCardSuperClassingChild1(parents);
		methodAcceptingListOfWildCardSuperClassingChild1(child1s);
		methodAcceptingListOfWildCardSuperClassingChild1(Arrays.asList(new Object()));
		
		Child1 child1 = new Child1();
		print(child1.childMethod());
		
	}

	private void methodAcceptingListOfParent(List<Parent> parents) {
		
	}

	private void methodAcceptingArrayOfParent(Parent[] parents) {
	}

	private <T extends Parent> void methodAcceptingListOfGenericExtendingParent(List<T> list) {
		// Since Jdk isn't sure what this list actually is of
		// You can neither add Parent nor child in it
		// list.add(new Parent());
		// list.add(new Child1());
		
		// You can only add T in it at compile time
		// but at runtime UnsupportedOperationException because it was not ArrayList
		T t = null;
		//list.add(t);
	}
	
	private void methodAcceptingListOfWildCardSuperClassingChild1(List<? super Child1> list) {
		/**
		 * You can't use super with Generics, they can only be used with wild card (?)
		 */
	}
    
	public static void main(String[] args) {
    	runAllMethod(InheritanceEasyMain.class);
    }
    
}
