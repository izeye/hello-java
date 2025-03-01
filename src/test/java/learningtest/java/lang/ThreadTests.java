package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Thread}.
 *
 * @author Johnny Lim
 */
class ThreadTests {

    @Test
    void ofVirtual() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        assertThat(currentThread).isExactlyInstanceOf(Thread.class);
        printThreadInfo(currentThread);

        Thread thread = Thread.ofVirtual().start(() -> printThreadInfo(Thread.currentThread()));
        assertThat(thread.getClass().getName()).isEqualTo("java.lang.VirtualThread");
        assertThat(thread.getName()).isEmpty();
        thread.join();
    }

    @Test
    void ofVirtualWithName() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        assertThat(currentThread).isExactlyInstanceOf(Thread.class);
        printThreadInfo(currentThread);

        String threadName = "my-virtual-thread";
        Thread thread = Thread.ofVirtual().name(threadName).start(() -> printThreadInfo(Thread.currentThread()));
        assertThat(thread.getName()).isEqualTo(threadName);
        thread.join();
    }

    @Test
    void ofVirtualWithNameMultiple() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        assertThat(currentThread).isExactlyInstanceOf(Thread.class);
        printThreadInfo(currentThread);

        String threadNamePrefix = "my-virtual-thread-";
        Thread.Builder.OfVirtual threadBuilder = Thread.ofVirtual().name(threadNamePrefix, 0);
        Thread thread1 = threadBuilder.start(() -> printThreadInfo(Thread.currentThread()));
        Thread thread2 = threadBuilder.start(() -> printThreadInfo(Thread.currentThread()));
        assertThat(thread1.getName()).isEqualTo(threadNamePrefix + 0);
        assertThat(thread2.getName()).isEqualTo(threadNamePrefix + 1);
        thread1.join();
        thread2.join();
    }

    @Test
    void ofPlatform() throws InterruptedException {
        Thread thread = Thread.ofPlatform().start(() -> printThreadInfo(Thread.currentThread()));
        assertThat(thread).isExactlyInstanceOf(Thread.class);
        thread.join();
    }

    private void printThreadInfo(Thread thread) {
        System.out.println("thread.getName(): " + thread.getName());
        System.out.println("thread.threadId(): " + thread.threadId());
        System.out.println("thread.getClass(): " + thread.getClass());
        System.out.println("thread.getThreadGroup(): " + thread.getThreadGroup());
    }

}
