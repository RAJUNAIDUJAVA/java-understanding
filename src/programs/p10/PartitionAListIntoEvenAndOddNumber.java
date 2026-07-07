package programs.p10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionAListIntoEvenAndOddNumber {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Boolean,List<Integer>> res =numbers.stream().collect(Collectors.partitioningBy(x-> x%2==0));
        List<Integer> even = res.get(true);
        List<Integer> odd = res.get(false);
        System.out.println(even);
        System.out.println(odd);

    }
}
