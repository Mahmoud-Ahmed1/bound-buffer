package BoundedBuffer;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Consumer implements Runnable {
    
    private final BoundedBuffer Buffer;
    String item = "";
    int Loop;
    
    public Consumer(BoundedBuffer buffer,int Loop) {
        this.Buffer = buffer;
        this.Loop=Loop;
    }

    @Override
    public void run() {
        
        
        for(int i=0;i<Loop;i++){
            try {
                Thread.sleep(0);
                
                Buffer.reciveOrder();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        
        
        
    }
    
}
