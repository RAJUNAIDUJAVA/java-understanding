package multithreading.raceCondition;

public class RaceConditionWithSynchronizedBlock implements Runnable {

    public static int value;
    public  int value2;

    public static  synchronized void incrementMethod(){
        value++;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            //System.out.println("Started thread"+Thread.currentThread().getName());
            incrementMethod();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RaceConditionWithSynchronizedBlock(),"ThreadOne");
        Thread t2 = new Thread(new RaceConditionWithSynchronizedBlock(),"ThreadTwo");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(value);
    }

}
