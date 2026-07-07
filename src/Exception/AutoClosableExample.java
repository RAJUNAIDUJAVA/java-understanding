package Exception;

public class AutoClosableExample {

    public static void main(String[] args) {
        try(DataSource ds = new DataSource()){
            String s= "rajunaidu";
            System.out.println(s);
        }
        catch (Exception e){
            System.out.println("Exception called");
        }
    }
}
