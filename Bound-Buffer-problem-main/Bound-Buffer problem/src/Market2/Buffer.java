package Market2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Buffer {

    
    public static void main(String[] args) {
        
        BoundedBuffer x = new BoundedBuffer();
        
            Thread ProducerThread0=new Thread(new Grep(x,7),"Supporter1");
            Thread ProducerThread1=new Thread(new Watermellon(x,1),"Supporter2");
            Thread ProducerThread2=new Thread(new Apple(x,3),"Supporter3");
            Thread ProducerThread3=new Thread(new Orange(x,5),"Supporter4");
            
            Thread ConsumerThread=new Thread(new Consumer(x,5),"Customer");
            Thread ConsumerThread1=new Thread(new Consumer(x,6),"Customer");
            Thread ConsumerThread2=new Thread(new Consumer(x,3),"Customer");
            Thread ConsumerThread3=new Thread(new Consumer(x,2),"Customer");
            Thread ConsumerThread4=new Thread(new Consumer(x,1),"Customer");
            ProducerThread0.start();
            
            ProducerThread1.start();
            ProducerThread2.start();
            ProducerThread3.start();
            
            
            ConsumerThread.start();
            ConsumerThread1.start();
            ConsumerThread2.start();
            ConsumerThread3.start();
            ConsumerThread4.start();
        
            
            
            
            
            
        
        
    }
    
}
