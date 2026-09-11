package oops;

public interface PrivateMethodsInInterface {

    public default void defMethod(){
        m11();
    }
    public static void statMethod(){
        m12();
    }
    private void m11(){

    }
    private static void m12(){

    }
}
