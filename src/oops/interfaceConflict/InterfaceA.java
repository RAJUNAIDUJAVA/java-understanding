package oops.interfaceConflict;

public interface InterfaceA {
    public void m1();
    public default void m2(){
        System.out.println("m2 from A");
    }
}
