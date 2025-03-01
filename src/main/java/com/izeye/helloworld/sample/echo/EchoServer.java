package com.izeye.helloworld.sample.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Echo server.
 *
 * @author Johnny Lim
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread.ofVirtual().start(() -> {
                    try (
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                    ) {
                        String line;
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                            out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
