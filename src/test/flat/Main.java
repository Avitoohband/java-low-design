package test.flat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static util.Flat.flat;

public class Main {
    public static void main(String[] args) {



        // Test 01 - Nested list
        List<Object> nestedList1 = Arrays.asList(1,2,Arrays.asList(3,4), 5);
        System.out.println("Test 01 - Nested list: " + nestedList1);
        System.out.println("Flattened list: " + flat(nestedList1));
        System.out.println();


        // Test 02 - Nested list no 2
        List<Object> nestedList2 = Arrays.asList(1, 2, Arrays.asList(3, 4, Arrays.asList(5,4,3,2), 3,4,5,6 , Arrays.asList(
                Arrays.asList(Arrays.asList(Arrays.asList(5)))
        )), 5);
        System.out.println("Test 02 - Nested list 2: " + nestedList2);
        System.out.println("Flattened list: " + flat(nestedList2));
        System.out.println();


        // Test 03 - Mixed types
        List<Object> mixedTypesList = Arrays.asList(
                1,"one", 3, "four" , Arrays.asList(1, "five", Arrays.asList(
                        4, 6, 7, "eight"
                ))
        ) ;
        System.out.println("Test 03 - Mixed types: " + mixedTypesList);
        System.out.println("Flattened list: " + flat(mixedTypesList));
        System.out.println();


        // Test 04 - Empty list
        List<Object> emptyList = Collections.emptyList();
        System.out.println("Test 04 - Empty list: " + emptyList);
        System.out.println("Flattened list: " + flat(emptyList));
        System.out.println();


        // Test 5 - Non-Nested List
        List<Object> nonNestedList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Test 05 - Non-Nested List: " + nonNestedList);
        System.out.println("Flattened list: " + flat(nonNestedList));
        System.out.println();


    }
}
