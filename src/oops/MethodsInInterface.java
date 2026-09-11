package oops;

public interface MethodsInInterface {

    public abstract void m1();
    public default void m2(){
        m4();
    }
    public static void m3(){
        m5();
    }
    private void m4(){
    }
    private static void m5(){
    }
}
