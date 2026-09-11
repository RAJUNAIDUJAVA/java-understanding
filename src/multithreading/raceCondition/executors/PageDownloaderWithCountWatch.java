package multithreading.raceCondition.executors;

import java.finallearning.C;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PageDownloaderWithCountWatch implements Runnable{

    public String [] urlsList;
    CountDownLatch latch;

    public PageDownloaderWithCountWatch(String [] urls, CountDownLatch latch){
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

        int maxThreads= 2;

        CountDownLatch latch1 = new CountDownLatch(maxThreads);

        Thread downloaderOne = new Thread(new PageDownloaderWithCountWatch(Arrays.copyOfRange(urls,0,6),latch1));
        Thread downloaderTwo = new Thread(new PageDownloaderWithCountWatch(Arrays.copyOfRange(urls,6,urls.length),latch1));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService= Executors.newSingleThreadExecutor(); when we give newSingleThreadExecutor it will

        long startTime = System.currentTimeMillis();
        executorService.submit(downloaderOne);
        executorService.submit(downloaderTwo);

        latch1.await();// this is the method will block upto latch threads will becomes 0
        // but here the problem is still executor service was not got shutdown

        long endTime = System.currentTimeMillis();

        System.out.println("Total Time taken:"+ (endTime-startTime)/1000 + "s");

    }
}
