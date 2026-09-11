package multithreading.raceCondition;

public class RaceCondition1 implements Runnable{

    public static int myNum;
    public static void incrementNum(){
        myNum++;
    }
    @Override
    public void run() {
        for(int i=0; i<10000; i++){
            //System.out.println("Thread name "+ Thread.currentThread().getName());
            incrementNum();
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new RaceCondition1());
        Thread t2 = new Thread(new RaceCondition1());
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();

            System.out.println(myNum);

        }
        catch (Exception e){
           e.printStackTrace();
        }

    }




}
