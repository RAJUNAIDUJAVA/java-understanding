package programs;

public class p12_sumOfDigitsFromNumber {

    public static void main(String[] args) {
        int number = 12345; // how we can convert int into stream // first coonvert into String and then use chars
        Integer sum =String.valueOf(number).chars().map(x-> x-'0').sum();
        System.out.println(sum);

    }
}
