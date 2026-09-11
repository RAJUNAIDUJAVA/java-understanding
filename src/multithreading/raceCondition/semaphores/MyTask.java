package multithreading.raceCondition.semaphores;

import java.util.concurrent.Semaphore;

public class MyTask implements Runnable{

    Semaphore semaphore;
    SharedResources sr;
    String threadName;

    public MyTask( SharedResources sr,Semaphore semaphore){
        this.sr= sr;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {

        try{
            threadName= Thread.currentThread().getName();
            System.out.println(threadName + "is waiting for the semaphore");
            semaphore.acquire();
            System.out.println(threadName+ "has Acquired the semaphore");
            Thread.sleep((long) ((Math.random()*1000)*5));
            int numListElements = sr.myList.size();
            semaphore.release();
            System.out.println(threadName+ "has Released the semaphore");

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        SharedResources sharedResources = new SharedResources();
        Semaphore sem = new Semaphore(10);
        for(int i=0; i<10; i++){
            Thread t = new Thread(new MyTask(sharedResources,sem), "Thread"+i);
            t.start();
        }
    }
}
