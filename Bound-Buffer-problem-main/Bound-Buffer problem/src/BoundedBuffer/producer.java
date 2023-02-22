package BoundedBuffer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class producer  implements Runnable {
    private final BoundedBuffer Buffer;
    String item = "one ";
    int Loop;


    public producer(BoundedBuffer buffer ,int Loop) {
        this.Buffer = buffer;
        this.Loop=Loop;

    }

    @Override
    public void run() {
        
        
        
        for(int i=0;i<Loop;i++){
            
            if(Buffer.isFull()){
                System.out.println("buffer Is Completed");
                
            }
            else{
                Buffer.placeOrder(item);
               
                try {
                    Thread.sleep(0);
                } catch (InterruptedException ex) {
                     Logger.getLogger(producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        } 
        
        
        
        
       
        
        
    }
        
    }
