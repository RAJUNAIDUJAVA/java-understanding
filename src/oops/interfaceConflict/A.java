package oops.interfaceConflict;

public class A implements InterfaceB, InterfaceA{
    @Override
    public void m1() {
        System.out.println("called");
    }
    @Override
    public void m2() {
        System.out.println("this is from child class implementation");

        InterfaceA.super.m2();
        InterfaceB.super.m2();
    }
}
