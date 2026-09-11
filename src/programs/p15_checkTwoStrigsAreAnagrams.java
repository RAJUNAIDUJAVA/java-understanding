package programs;

import java.util.List;
import java.util.stream.Collectors;

public class p15_checkTwoStrigsAreAnagrams {

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        List<Character> rs1=s1.chars().mapToObj(x-> (char)x).sorted().collect(Collectors.toList());
        List<Character> rs2=s2.chars().mapToObj(x-> (char)x).sorted().collect(Collectors.toList());
        System.out.println(rs1.equals(rs2));
    }
}
