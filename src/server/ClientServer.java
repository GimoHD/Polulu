package server;

import java.io.*;
import java.net.*;
import org.json.*;


public class ClientServer {
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    String serverReply;


    JSONObject innerObject = new JSONObject();


    public void makeJson() {

        innerObject.put("mode", "1"); //0 - stop   1 - manual   2 - start
        innerObject.put("up", "0.8");
        innerObject.put("down", "0.9");
        innerObject.put("left", "0.5");
        innerObject.put("right", "0.4");
        System.out.println(innerObject.toString());

    }

    String host = "192.168.0.100";

    public ClientServer() {
        makeJson();

    }

    public void connect(){
        try {
            echoSocket = new Socket(host, 4020); // ip-adres
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in  = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        }
        catch (UnknownHostException e) {
            System.err.println("Don't know about host" + host);
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + host);
            System.exit(1);
        }
        System.out.println("echo: " + serverReply);
    }


    public void sendMessage(String string){
        out.println(string);
    }

    public String receiveMessage(){
        try {
            if (in.readLine() !=null) {
                serverReply = in.readLine();
                System.out.println("echo: " + serverReply);
                return serverReply;
            }
        } catch (IOException e) {
            return null;
       }
        return null;
    }

    public void close(){
        try {
            out.close();
            in.close();
            echoSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
 
    
}