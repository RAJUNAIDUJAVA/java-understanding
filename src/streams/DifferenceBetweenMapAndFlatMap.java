package streams;

import java.util.Arrays;
import java.util.List;

public class DifferenceBetweenMapAndFlatMap {

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1,3,2,4,5);
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1,2,3,4,5),Arrays.asList(6,7,8,9,10));

        l1.stream().map(x-> x*2).forEach(x-> System.out.println(x));
        nestedList.stream().flatMap(x-> x.stream().map(y->y*2)).forEach(x-> System.out.println(x));
    }
}
