package multithreading.raceCondition.executors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorShuttingDown implements Runnable {
    public String [] urlsList;
    CountDownLatch latch;

    public ExecutorShuttingDown(String [] urls, CountDownLatch latch){
        this.latch = latch;
        this.urlsList = urls;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();

        try{

            for(String urlString: urlsList){

                if(Thread.currentThread().isInterrupted()){
                    throw new InterruptedException(Thread.currentThread().getName()+ "interrupted");
                }

                URL url = new URL(urlString);
                String filename = urlString.substring(urlString.lastIndexOf("/")+1).trim()+".html";
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

                String line;

                while((line = reader.readLine())!= null){
                    writer.write(line);
                }
                System.out.println(threadName+"has downloaded"+filename);
                writer.close();

            }
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String [] urls = new String[]{
                "https://www.google.com",
                "https://www.google.com/blog",
                "https://www.google.com/partners",
                "https://www.google.com/about",
                "https://www.google.com/about",
                "https://www.google.com/blog",
                "https://www.google.com/blog",
                "https://www.google.com/blog",
                "https://www.google.com/blog",
                "https://www.google.com/blog",
                "https://www.google.com/blog",
                "https://www.google.com/blog",
                "https://www.google.com/blog"
        };

        int maxThreads= 4;

        CountDownLatch latch1 = new CountDownLatch(maxThreads);



        ExecutorService executorService = Executors.newFixedThreadPool(maxThreads);
        //ExecutorService executorService= Executors.newSingleThreadExecutor(); when we give newSingleThreadExecutor it will

        long startTime = System.currentTimeMillis();
        for(String url : urls){
            Thread thread = new Thread(new ExecutorShuttingDown(new String[]{url},latch1));
            executorService.submit(thread);
        }
        latch1.await();// this is the method will block upto latch threads will becomes 0
        // but here the problem is still executor service was not got shutdown
        //executorService.shutdown(); // this method will shut down the executor and there is no any tasks can  be performed after the shutdown

        /*Thread threadNew = new Thread(new ExecutorShuttingDown(urls,latch1));
        executorService.submit(threadNew);


        when we added the executor after shutdown we will ended up with RejectedExecutionException
        */

        executorService.shutdownNow();
        /* what is the difference between shutdown and shutdownnow methods
        shutdown method will wait  to all executorService threads complete the execution
        shutdownnow method will immediate shutdown the executor service even though there is processing threads

        */
        while(!executorService.isTerminated()){

            Thread.sleep(1000);

            // this block will help us to synchronize the executor service thread with main thread

        }
        long endTime = System.currentTimeMillis();

        Thread.sleep(10000);
        System.out.println("Total Time taken:"+ (endTime-startTime)/1000 + "s");

    }

}
