import java.util.ArrayList;
import java.util.*;
class producer implements Runnable{
     List<Integer> Buffer=null;
     private int i=0;
     final int max=10;
     producer(List<Integer>Buffer)
     {
         this.Buffer=Buffer;
     }
     public void produce(int i)throws InterruptedException
     {
       synchronized(Buffer)
       {
           while(Buffer.size()== max)
           {
               System.out.println("Producer is Waiting due to Buffer is Full");
               Buffer.wait();
           }
       }
       Buffer.add(i);
           System.out.println("Producer Producing");
           Thread.sleep(350);
       synchronized(Buffer)
       {
           
           Buffer.notify();
       }
     }
     public void run()
     {
         try{
             while(true)
             {
                 i++;
                 produce(i);
             }
         }
         catch(Exception e)
         {
             System.out.println("Exception overcome"+e);     
         }
     }
}

 class Consumer implements Runnable {
    List<Integer> Buffer = null;
    private int i = 0;
    final int max = 10;

    Consumer(List<Integer> Buffer) {
        this.Buffer = Buffer;
    }

    public void consume(int i) throws InterruptedException {
        synchronized (Buffer) {
            while (Buffer.size() == 0) {
                System.out.println("Consumer is Waiting due to Buffer is Empty");
                Buffer.wait();
            }
        }
        Buffer.remove(0); // Remove the first element from the buffer
        System.out.println("Consumer Consuming");
        Thread.sleep(350);
        synchronized (Buffer) {
            Buffer.notify();
        }
    }

    public void run() {
        try {
            while (true) {
                i++;
                consume(i);
            }
        } catch (Exception e) {
            System.out.println("Exception overcome" + e);
        }
    }
}


public class producerconsumer{
    public static void main(String[] args) {
        List<Integer> B=new ArrayList<Integer>();
        Thread p=new Thread(new producer(B));
        Thread c=new Thread(new Consumer(B));
        p.start();
        c.start();
    }
}