package com.izeye.helloworld.sample.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Echo client.
 *
 * @author Johnny Lim
 */
public class EchoClient {

    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("localhost", 8080);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = stdIn.readLine()) != null) {
                out.println(line);
                System.out.println("echo: " + in.readLine());
                if (line.equals("bye")) {
                    break;
                }
            }
        }
    }

}
