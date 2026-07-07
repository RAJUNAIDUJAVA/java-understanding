package programs;
import java.util.*;
import java.util.stream.Collectors;

public class p8_GroupStringByFirstCharacterAndCount {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple","avocado","banana","blueberry","cherry");

        Map<Character, Long> res=words.stream().collect(Collectors.groupingBy(x-> x.charAt(0),Collectors.counting()));
        System.out.println(res);

    }
}
