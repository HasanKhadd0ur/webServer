import handler.RequestsHandlerSocket;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This program demonstrates a simple TCP/IP socket server.
 *
 * @author www.codejava.net
 */
public class WebServerSocket {

    private static ExecutorService executorService;
    private static final int PORT = 8000;
    private static boolean running = true;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("WebServerSocket is listening on port " + PORT);

            //executorService = Executors.newFixedThreadPool(1);
            executorService = Executors.newCachedThreadPool();

            while (running) {
                RequestsHandlerSocket handler = new RequestsHandlerSocket(serverSocket.accept());
                executorService.submit(handler);
            }

        } catch (IOException ex) {
            System.out.println("Web server socket exception: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
