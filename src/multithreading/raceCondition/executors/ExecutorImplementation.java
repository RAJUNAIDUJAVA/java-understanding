package multithreading.raceCondition.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorImplementation implements Runnable {

    public static final int NUM_ITERATIONS =10000;
    public static int count;



    public void run(){
        for(int i=0; i<NUM_ITERATIONS; i++){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(new ExecutorImplementation());
        Thread t2= new Thread(new ExecutorImplementation());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(t1);
        executorService.execute(t2);

        Thread.sleep(1000);

        System.out.println(count);


    }



}
