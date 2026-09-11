package programs;

import java.util.stream.Stream;

public class p21_fibanacciSeries {

    /*public static void main(String[] args) {
        int first = 0;
        int second = 1;
        for(int i=0; i<=10; i++){
            System.out.println(first);
            int next = first+second;
            first= second;
            second= next;

        }
    }*/

    public static void main(String[] args) {
        Stream.iterate(new int [] {0,1}, f-> new int[]{f[1],f[0]+f[1]}).limit(10)
                .map(f-> f[0])
                .forEach(n-> System.out.println(n));
    }
}
