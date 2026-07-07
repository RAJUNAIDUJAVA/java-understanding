package programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestNumberInList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 5, 8, 20, 15, 20);
       Optional<Integer> secondNum= list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondNum.get());
    }
}
