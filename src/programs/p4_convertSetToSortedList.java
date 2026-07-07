package programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class p4_convertSetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 1, 4, 2));
        List<Integer> l1 = set.stream().sorted().collect(Collectors.toList());
        System.out.println(l1);
    }
}