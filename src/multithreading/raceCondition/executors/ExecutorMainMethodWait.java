package multithreading.raceCondition.executors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* when we just used executor service , the main thread will not wait upto the child threads will complete the execution
    so now we will look how the main thread will wait upto some time to complete child thread execution
    */
public class ExecutorMainMethodWait implements Runnable{

    public String [] urlsList;

    public ExecutorMainMethodWait(String [] urls){
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

        Thread downloaderOne = new Thread(new PageDownloader(Arrays.copyOfRange(urls,0,6)));
        Thread downloaderTwo = new Thread(new PageDownloader(Arrays.copyOfRange(urls,6,urls.length)));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();
        executorService.submit(downloaderOne);
        executorService.submit(downloaderTwo);

        executorService.awaitTermination(20, TimeUnit.SECONDS);
        /*
        awaitTermination method will acts as a join. the main thread will wait upto 120 seconds or main thread will
        wait upto the executor service thread will get interrupted
        so we can see total time taken is 20 sec . but here the problem is still executor service was running and we need
        to explicitly terminate the prograam

        now the synchronization is happening after 20 seconds.but we are not sure whether with in 20 sec the child threads
        execution will complete or not
        to wait main methods upto child threads complete the execution we can use countdown latch

        */
        long endTime = System.currentTimeMillis();

        System.out.println("Total Time taken:"+ (endTime-startTime)/1000 + "s");

    }



}
