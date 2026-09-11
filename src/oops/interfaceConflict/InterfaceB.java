package oops.interfaceConflict;

public interface InterfaceB {

    public void m1();
    public default void m2(){
        System.out.println("from m2 B");
    }
}
