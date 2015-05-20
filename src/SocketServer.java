/**
 * @(#)SocketServer.java
 *
 * SocketServer application
 *
 * @author 
 * @version 1.00 2015/3/12
 */
 
import java.net.*;
import java.io.*; 

 
public class SocketServer {
    
    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
	        ServerSocket serverSocket = null;
        BufferedReader in=null;
        PrintWriter out=null;
        try {
            echoSocket = new Socket("192.168.1.2", 4020); // ip-adres

        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        
        System.out.println("Server draait");
        

        try{
        	 out = new PrintWriter(echoSocket.getOutputStream(), true);
        }catch (IOException e){
        	System.out.println ("fout printwriter");
        }
        
        try{
        	 in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        }catch (IOException e){
        	System.out.println ("fout bufferedreader");
        }
        
        
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {

             //JSONObject obj = new JSONObject ();
             //String n = obj.getString("pololu");
             //System.out.println("de auto rijdt" + n);
            System.out.println(""+inputLine);
        }


        try {out.close();
            in.close();
           echoSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
