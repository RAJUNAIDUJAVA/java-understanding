package programs;

import java.util.function.Function;
import java.util.stream.Collectors;

public class p14_DuplicateCharactersFromString {

    public static void main(String[] args) {
        String str = "programming";
        str.chars().mapToObj(x-> (char)x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x-> x.getValue()>1).forEach(x-> System.out.println(x.getKey()));
    }
}
