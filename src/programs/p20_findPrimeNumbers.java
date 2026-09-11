package programs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p20_findPrimeNumbers {
    public static void main(String[] args) {
        int N= 50;
        // for example take num 14
        // IntStream.rangeClosed(2, (int) Math.sqrt(n)) with give stream of root 14 i.e 3.7 i.e 3
        // 14/2 = 0 then it is not prime number
        // for example take num 17
        // IntStream.rangeClosed(2, (int) Math.sqrt(n)) with give stream of root 14 i.e 3.7 i.e 4
        // 17/2=0 false 17/3 false 17/4 false then this is prime number
        List<Integer> res=IntStream.rangeClosed(2,N).filter(n->
            IntStream.rangeClosed(2, (int) Math.sqrt(n))
                    .allMatch(i->n%i!=0)).boxed().collect(Collectors.toList());

        System.out.println(res);


    }
}
