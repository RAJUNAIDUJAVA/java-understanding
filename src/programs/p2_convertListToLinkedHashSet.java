package programs;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class p2_convertListToLinkedHashSet {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 1, 3);
        Set<Integer> s1=list.stream().collect(Collectors.toCollection(()-> new LinkedHashSet<>()));
        System.out.println(s1);
    }
}
