package programs;

import java.util.*;

public class p3_convertSetToList {

    public static void main(String[] args) {
        Set<String>set = new HashSet<>(Arrays.asList("banana", "apple", "cherry"));
        List<String> l1 = new ArrayList<>(set);
        System.out.println(l1);
    }
}
