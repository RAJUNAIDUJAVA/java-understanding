package programs;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class p1_convertListToSet {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 4);
        Set<Integer> s1=list.stream().collect(Collectors.toSet());
        System.out.println(s1);
    }
}
