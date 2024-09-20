package learningtest.java.net;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Tests for {@link InetAddress}.
 *
 * @author Johnny Lim
 */
class InetAddressTests {

    @Test
    void getLocalHost() throws UnknownHostException {
        long startTimeMillis = System.currentTimeMillis();

        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.println("hostName: " + hostName);

        long elapsedTimeMillis = System.currentTimeMillis() - startTimeMillis;
        System.out.println("elapsedTimeMillis: " + elapsedTimeMillis);
    }

}
