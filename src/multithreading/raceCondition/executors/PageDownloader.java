package multithreading.raceCondition.executors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PageDownloader implements Runnable{

    public String [] urlsList;

    public PageDownloader(String [] urls){
        this.urlsList = urls;
    }

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

    public static void main(String[] args) {
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
        long endTime = System.currentTimeMillis();

        System.out.println("Total Time taken:"+ (endTime-startTime)/1000 + "s");

       /*here the execution time taken is 0 . the reason is we just started the executor service but we not made join
        operation to wait main thread . i.e thread 1 and thread 0 started concurrently and main thread completed the execution
        here one more thing we noticed is ThreadExecutor is still running we need to explicitly stop the thread*/



        /*try{
            long startTime = System.currentTimeMillis();
            downloaderOne.start();
            downloaderTwo.start();

            downloaderOne.join();
            downloaderTwo.join();

            long endTime = System.currentTimeMillis();

            System.out.println("Total time taken: "+(endTime-startTime)/1000 + "s");

        }
        catch (InterruptedException exception){
            exception.printStackTrace();
        }*/

    }
}
