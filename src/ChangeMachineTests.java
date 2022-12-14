import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class ChangeMachineTests {

	@Test
	void test1() {
		ChangeMachine changeMachine = new ChangeMachine();
		List<Integer> change = changeMachine.change(13);
		int[] array = {10,2,1};
		List<Integer> expectedResult = toList(array);
		Assert.assertTrue("13 = 10,2,1", change.equals(expectedResult));
	}
//	@Test
//	void test2() {
//		ChangeMachine changeMachine = new ChangeMachine();
//		List<Integer> change = changeMachine.change(574);
//		int[] array = {200, 200, 100, 50, 20, 2, 2};
//		List<Integer> expectedResult = toList(array);
//		Assert.assertTrue("574 = 200, 200, 100, 50, 20, 2, 2", change.equals(expectedResult));
//	}	
	@Test
	void test3() {
		ChangeMachine changeMachine = new ChangeMachine();
		List<Integer> change = changeMachine.change(Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1), 13);
		int[] array = {10,2,1};
		List<Integer> expectedResult = toList(array);
		Assert.assertTrue("13 = 10,2,1", change.equals(expectedResult));
	}	
	@Test
	void test4() {
		ChangeMachine changeMachine = new ChangeMachine();
		List<Integer> change = changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1, 1, 2), 574);
		int[] array = {200, 200, 100, 50, 20, 2, 2};
		List<Integer> expectedResult = toList(array);
		Assert.assertTrue("574 = 200, 200, 100, 50, 20, 2, 2", change.equals(expectedResult));
	}
	@Test
	void test5() {
		ChangeMachine changeMachine = new ChangeMachine();
		List<Integer> change = changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1, 1), 574);
		int[] array = {200, 200, 100, 50, 20, 2, 1, 1};
		List<Integer> expectedResult = toList(array);
		Assert.assertTrue("574 = 200, 200, 100, 50, 20, 2, 1, 1", change.equals(expectedResult));
	}
	@Test
	void test6() { //close but ran out of coins
		ChangeMachine changeMachine = new ChangeMachine();
		List<Integer> change = changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1), 574);
		int[] array = {200, 200, 100, 50, 20, 2, 1};
		List<Integer> expectedResult = toList(array);
		Assert.assertTrue("574 = 200, 200, 100, 50, 20, 2, 1", change.equals(expectedResult));
	}

//	You supplied ?200, with a product price of ?49.21.
//
//	This is your change: 3 x 50 POUNDS 1 x 50 PENCE 1 x 20 PENCE 1 x 5 PENCE 2 x 2 PENCE
	@Test
	void test7() { //close but ran out of coins
		ChangeMachine changeMachine = new ChangeMachine();
		List<Integer> change = changeMachine.change(20000-4921);
		int[] array = {5000,5000,5000,50,20,5,2,2};
		List<Integer> expectedResult = toList(array);
		Assert.assertTrue(""+(20000-4921)+" = 5000,5000,5000,50,20,5,2,2", change.equals(expectedResult));
	}
	
	
	static List<Integer> toList(int[] array){
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(Integer i:array) {
			arrayList.add(i);
		}
		return (List)arrayList;
	}

}
