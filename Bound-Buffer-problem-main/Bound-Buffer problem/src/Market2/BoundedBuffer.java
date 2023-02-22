package Market2;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BoundedBuffer {
    
    
    int bufferSize=10;
    String[] Buffer = new String[10];
    private final Semaphore Mutex;//to check critical sections
    private final Semaphore Empty;//to check empty place
    private final Semaphore Full;//to check full
    volatile int  In=0 , Out=0 , Count=0;
    
    

    
    
    public BoundedBuffer () {
        //this.bufferSize = size;
        Mutex = new Semaphore(1,true);// to solve starvation
        Empty = new Semaphore(bufferSize);//to solve
        Full = new Semaphore(0);
    }
      
    
    /*public synchronized boolean isEmpty() {
        return Buffer.isEmpty();
    }
    
    
    public synchronized boolean isFull() {
        return Buffer.size() == this.bufferSize;
    }*/
    public boolean isFull(){
        return bufferSize==Count;
    
    }
    
    public boolean isEmpty(){
        return Count==0;
    
    }
     
    public void placeOrder(String item){
        
        if (Count==10){
            System.out.println("Storage is Full,Sorry Try again Later");
            
            
        }
        else{ 
            try {
            Empty.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(BoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            try {
            Mutex.acquire();  
            } catch (InterruptedException ex) {
            Logger.getLogger(BoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            Buffer[In]=item;
            In=(In+1)%bufferSize;
            Count++;
            
            
            Mutex.release();
            Full.release();
            /*System.out.println("You Have Ordered "+item);*/
            
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
            Logger.getLogger(BoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }
    
    
    
    
    
    
    public  String reciveOrder() {
         String item = "Noting";       
            if ( Count==0 ) {
                System.out.println("We do not have any fruits for Sell");
            }
            
            else  {
                Empty.release();
             try {
                 Mutex.acquire();
             } catch (InterruptedException ex) {
                 Logger.getLogger(BoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
             }
                item = Buffer[Out];
                Out=(Out+1)%bufferSize;
                Count--;
                
                
                System.out.println( item + " is Recived");
                
                Mutex.release();
             try {
                 Full.acquire();
             } catch (InterruptedException ex) {
                 Logger.getLogger(BoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
            
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
        }   */ 
            return item;        
    }    
}
