package programs.withOutJava8;

public class ReverseAString {
    public static void main(String[] args) {
        String name = "Rajunaidu";
        String reverseName = "";
        for(int i =name.length()-1; i>=0; i--){
            reverseName+=name.charAt(i);
        }

        System.out.println(reverseName);
    }
}
