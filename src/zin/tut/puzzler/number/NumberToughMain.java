package zin.tut.puzzler.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static zin.tools.ZIO.*;

public class NumberToughMain {

	public void underflowOverflowWhenSorting() {
		List<Integer> list = Arrays.asList(10, 5, Integer.MAX_VALUE -10 , 20, Integer.MAX_VALUE-20,  Integer.MIN_VALUE+10, Integer.MIN_VALUE+20);
		Collections.sort(list, (i1, i2) -> i1 - i2 );
		/*
		 * Sorting failed [5, 10, 20, 2147483627, 2147483637, -2147483638, -2147483628]
		 * Because of Integer underflow. Integer.MIN_VALUE - 1 will become Integer.MAX_VALUE
		 */
		print(list.toString());
		print("Sorting failed because of Integer underflow because");
		print("((Integer.MIN_VALUE - 1) == Integer.MAX_VALUE) is "+((Integer.MIN_VALUE - 1) == Integer.MAX_VALUE));
		/*
		 * Use compareTo which takes care of overflow/underflow
		 */
		Collections.sort(list, (i1, i2) -> i1.compareTo(i2) );
		print(list.toString());
	}

	public static void main(String[] args) {
		runAllMethod(NumberToughMain.class);
	}
}
