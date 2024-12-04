package learningtest.java.net;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Tests for {@link ServerSocket}.
 *
 * @author Johnny Lim
 */
class ServerSocketTests {

    @Disabled
    @Test
    void test() {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket socket = serverSocket.accept();
             InputStream is = socket.getInputStream()) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int readBytes;
            while ((readBytes = is.read(buffer)) > 0) {
                baos.write(buffer, 0, readBytes);
            }
            String request = new String(baos.toByteArray(), StandardCharsets.UTF_8);
            System.out.println(request);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
