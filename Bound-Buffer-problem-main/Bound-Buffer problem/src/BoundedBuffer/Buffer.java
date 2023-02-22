package BoundedBuffer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    public static void main(String[] args) {

        BoundedBuffer x = new BoundedBuffer();
        Thread ProducerThread0 = new Thread(new producer(x, 10), "producer_2");
        Thread ProducerThread2 = new Thread(new producer(x, 7), "producer_1");

        Thread ConsumerThread = new Thread(new Consumer(x, 7), "consumer_1");

        Thread ConsumerThread2 = new Thread(new Consumer(x, 10), "consumer _2");

        ProducerThread0.start();

        ProducerThread2.start();

        ConsumerThread.start();

        ConsumerThread2.start();

    }

}
