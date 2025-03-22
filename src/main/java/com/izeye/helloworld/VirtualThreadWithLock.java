package com.izeye.helloworld;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Virtual thread with {@link Lock}.
 *
 * @author Johnny Lim
 */
public class VirtualThreadWithLock {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        Thread.ofVirtual().start(() -> {
            if (lock.tryLock()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).join();
    }

}
