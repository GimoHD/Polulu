package server;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientServer {
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    String serverReply;


    JSONObject innerObject = new JSONObject();
    String host = "192.168.1.103";

    public ClientServer() {
        makeJson();
        connect();
        //new Update().start();

    }
    //String host = "localhost";

    public void makeJson() {

        innerObject.put("mode", "0"); //0 - stop   1 - start   2 - battery
        innerObject.put("up", "0");
        innerObject.put("down", "0");
        innerObject.put("left", "1");
        innerObject.put("right", "0");
        System.out.println(innerObject.toString());

    }

    public void connect() {
        try {
            echoSocket = new Socket(host, 4020); // ip-adres
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host" + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + host);
            System.exit(1);
        }
        // System.out.println("echo: " + serverReply);
    }

    public void sendMessage(String string) {
        System.out.println(string);
        out.println(string);
    }

    public String receiveMessage() {
        try {
            if (in.readLine() != null) {
                serverReply = in.readLine();
                return serverReply;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public void close() {
        try {
            out.close();
            in.close();
            echoSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Update extends Thread {
        public void run() {
            while (true) {
                try {
                    if (in.readLine() != null) {
                        serverReply = in.readLine();
                        System.out.println("" + serverReply);
                    }
                } catch (Exception e) {

                }
            }
        }
    }


}