package Market2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Watermellon implements Runnable {
    private final BoundedBuffer Buffer;
    String item = "Watermellon";
    int Loop;


    public Watermellon(BoundedBuffer buffer ,int Loop) {
        this.Buffer = buffer;
        this.Loop=Loop;

    }

    @Override
    public void run() {
        
        
        
        for(int i=0;i<Loop;i++){
            
            if(Buffer.isFull()){
                System.out.println("buffer Is Completed");
                break;
            }
            else{
                Buffer.placeOrder(item);
                System.out.println(Thread.currentThread().getName() + " Put "+item+" Number("+ (i+1) +")");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                     Logger.getLogger(Grep.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        } 
        
        
        
        
       
        
        
    }
        
    }