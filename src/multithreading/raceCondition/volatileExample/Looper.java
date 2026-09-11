package multithreading.raceCondition.volatileExample;

public class Looper implements Runnable {

    public static volatile boolean keepLooping = true;
    public static  int number = 0;
    public int localNum = 0;


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while(keepLooping){
            if(localNum !=number){
                System.out.println(threadName + "has Picked up the change in number");
                System.out.println("mumber is "+number);
                localNum = number;
            }
        }
        System.out.println(threadName + "is Done!");
    }

    public static void main(String[] args) throws InterruptedException{
        for(int i=0; i<10; i++){
            Thread t = new Thread(new Looper(), "Looper"+i);
            t.start();
        }

        number = 13;
        System.out.println("Number changed by main");

        Thread.sleep(10000);
        System.out.println("completed");
        keepLooping = false;
    }
}
