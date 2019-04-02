/****
*
*
*
****/

package game;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Lee
 */
public class Client {
    
    Logger logger;
    final int PORT;
    
    public Client(int port, Logger logger) {
        PORT = port;
        this.logger = logger;
    }

    public void setupConnection() throws IOException {

        // try with resources
        try (
                // these will auto close when we are finished using them
                // create socket for client (hostname, server port number)
                Socket sock = new Socket("localhost", PORT);
                // create out stream for client, set auto flush buffer to true
                OutputStream outStream = sock.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);
                // create in stream for client
                InputStream inStream = sock.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inStream));) {
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                out.println("Client: Connected");
                // get msg from server
                System.out.println(in.readLine());

            while (true) {
                //get input from user and send to server
                String fromUser = stdIn.readLine();
                out.println(fromUser);
                
                if (fromUser.equals("Exit")) {
                    System.out.println("closing connection...");
                    break;
                }
                
                String fromServer = in.readLine();
                System.out.println(fromServer);
            }

        } //catch from method
        catch (UnknownHostException e) {
            System.err.println("Don't know about host");
            e.printStackTrace();
            System.exit(1);
        } // catch from main
        catch (IOException e) {
            System.out.println("Client unable to make connection to server on port: " + PORT);
            e.printStackTrace();
            System.exit(1);
        }
    }
}
