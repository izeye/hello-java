package com.izeye.helloworld;

import java.util.concurrent.TimeUnit;

/**
 * Virtual thread with {@code synchronized}.
 *
 * @author Johnny Lim
 */
public class VirtualThreadWithSynchronized {

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();

        Thread.ofVirtual().start(() -> {
            synchronized (monitor) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).join();
    }

}
