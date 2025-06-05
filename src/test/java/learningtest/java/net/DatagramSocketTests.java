package learningtest.java.net;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * Tests for {@link DatagramSocket}.
 *
 * @author Johnny Lim
 */
class DatagramSocketTests {

    private static final int PORT = 12345;

    @Test
    void test() throws IOException {
        new Thread(() -> startUdpServer()).start();
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] data = "Hello, world!".getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), PORT);
            socket.send(packet);
        }
    }

    private void startUdpServer() {
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                System.out.println("Listening...");
                serverSocket.receive(packet);

                String data = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received data: " + data);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
