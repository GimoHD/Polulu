package serversocket;

import jdk.net.Sockets;
import server.BasisStation;
import server.TussenStation;
import timer.Random;
import timer.Timing;

import java.net.*;
import java.io.*;

public class SocketServer {

    public SocketServer() throws IOException {
        
        ServerSocket serverSocket = null;

        boolean listening = true;
        
         // een array voor referenties naar thread-objecten
        int aantal = 0;

        try {
            serverSocket = new ServerSocket(4020);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }
        
        System.out.println("Server draait");
        PrintWriter out = null;
        Socket clientSocket = null;
        while (true) {
            while (listening) {
                clientSocket = serverSocket.accept(); // wacht op client
                try {
                    out = new PrintWriter(clientSocket.getOutputStream(), true);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                aantal++;
                System.out.println("Client nr " + aantal + " heeft zich aangemeld");
                listening = false;
                out.println("start");

            }
           // System.out.println("Gestart");
            Object dataValues[] = {"N/A", "N/A", "N/A"};
            Timing timer = new Timing(50000);
            System.out.println("sending");
            try {
                Thread.sleep(Random.nextInt(7000,9000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println(" 1 5\n");
            try {
                Thread.sleep(Random.nextInt(7000,9000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println(" 2 5\n");
            try {
                Thread.sleep(Random.nextInt(7000,9000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println(" 3 5\n");

        }
	       

       // serverSocket.close();
    }



}
