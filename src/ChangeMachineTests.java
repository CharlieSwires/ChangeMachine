import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class ChangeMachineTests {
    static ChangeMachine changeMachine;

    @BeforeAll
    static void startup() {
        changeMachine = new ChangeMachine();

    }
    @Test
    void test1() {
        List<Integer> change = changeMachine.change(13);
        int[] array = {10,2,1};
        List<Integer> expectedResult = toList(array);
        Assertions.assertEquals(change, expectedResult);
    }

    @Test
    void test3() {
        List<Integer> change = changeMachine.change(Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1), 13);
        int[] array = {10,2,1};
        List<Integer> expectedResult = toList(array);
        Assertions.assertEquals(change, expectedResult);
    }	
    @Test
    void test4() {
        List<Integer> change = changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1, 1, 2), 574);
        int[] array = {200, 200, 100, 50, 20, 2, 2};
        List<Integer> expectedResult = toList(array);
        Assertions.assertEquals(change, expectedResult);
    }
    @Test
    void test5() {
        List<Integer> change = changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1, 1), 574);
        int[] array = {200, 200, 100, 50, 20, 2, 1, 1};
        List<Integer> expectedResult = toList(array);
        Assertions.assertEquals(change, expectedResult);
    }
    @SuppressWarnings("deprecation")
    @Test
    void test6() { //close but ran out of coins
        try {
            List<Integer> change = changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1), 574);
            int[] array = {200, 200, 100, 50, 20, 2, 1};
            List<Integer> expectedResult = toList(array);
            Assertions.assertEquals(change, expectedResult);
        } catch(RuntimeException e) {
            int[] array = {200, 200, 100, 50, 20, 2, 1};
            List<Integer> expectedResult = toList(array);
            List<Integer> change = new ArrayList<Integer>();
            for (String item: e.getMessage().split(",")) {
                change.add(Integer.decode(item));
            }
            Assertions.assertEquals(change, expectedResult);
        }
    }

    //	You supplied �200, with a product price of �49.21.
    //
    //	This is your change: 3 x 50 POUNDS 1 x 50 PENCE 1 x 20 PENCE 1 x 5 PENCE 2 x 2 PENCE
    @Test
    void test7() { //close but ran out of coins
        List<Integer> change = changeMachine.change(20000-4921);
        int[] array = {5000,5000,5000,50,20,5,2,2};
        List<Integer> expectedResult = toList(array);
        Assertions.assertEquals(change, expectedResult);
    }

    @Test
    void test8() { //close but ran out of coins
        List<Integer> change = changeMachine.changeRecursive(Arrays.asList(10, 5, 2, 2, 2, 2),8);
        int[] array = {2,2,2,2};
        List<Integer> expectedResult = toList(array);
        Assertions.assertEquals(expectedResult,change);
    }


    static List<Integer> toList(int[] array){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Integer i:array) {
            arrayList.add(i);
        }
        return (List<Integer>)arrayList;
    }

}