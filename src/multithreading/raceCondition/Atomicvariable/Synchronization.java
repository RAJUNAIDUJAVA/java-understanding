package multithreading.raceCondition.Atomicvariable;

public class Synchronization {

    public static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) throws InterruptedException{


        CommonCounter commonCounter = new CommonCounter();
        Thread threadOne = new Thread(new CountIncrementor(commonCounter,NUM_ITERATIONS) );
        Thread threadTwo = new Thread(new CountIncrementor(commonCounter,NUM_ITERATIONS));

        System.out.println(commonCounter.getFirstNum());
        System.out.println(commonCounter.getSecondNum());

        threadOne.start();
        threadTwo.start();

        Thread.sleep(5000);

        System.out.println(commonCounter.getFirstNum());
        System.out.println(commonCounter.getSecondNum());


    }
}
