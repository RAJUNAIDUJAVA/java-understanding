package programs;

import java.util.HashMap;
import java.util.Map;

public class p19_mergeTwoMapsAndHandleDuplicates {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Alice", 90);
        map1.put("Bob", 80);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Bob", 95); // duplicate key
        map2.put("Charlie", 85);

        // first add one map into merged and another map also add into merge using foreach
        // here foreach will take bi consumer and merge option will have key value if any duplicates we have how we handled
        map2.forEach((key,value)-> map1.merge(key,value,Integer::min));
        System.out.println(map1);
    }
}
