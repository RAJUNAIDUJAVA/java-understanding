package programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p9_flattenAListAndSortedDistinctElements {
    public static void main(String[] args) {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(3, 1, 2),
                Arrays.asList(5, 3, 4),
                Arrays.asList(2, 6, 1)
        );

        List<Integer> records =nested.stream().flatMap(x-> x.stream()).distinct().sorted().collect(Collectors.toList());
        System.out.println(records);
    }
}
