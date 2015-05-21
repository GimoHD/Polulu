package serversocket;

import java.io.IOException;

/**
 * Created by Kristof on 6/05/2015.
 */
public class Main {

    public static void main(String[] args) {
        try {
            new SocketServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
