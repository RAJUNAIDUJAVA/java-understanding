package programs;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p5_convertListIntoMapWithTheirLength {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi");
        Map<String,Integer> m1  =words.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(m1);
    }
}
