package game;

import java.net.*;
import java.io.*;
/**
 *
 * @author Lee
 */
public class Client {

   public void go() {
       
       final int PORT = 6000;
       
       try {
           // read data from server (input of client connects to output from server)
           
           // socket(hostname,port number)
           Socket s = new Socket("localhost", PORT);
           
           // create printwriter from client output stream
           PrintWriter out = new PrintWriter(s.getOutputStream(),true);
           out.println("Client: Acknowledge");
           
           //InputStreamReader inStream = new InputStreamReader(s.getInputStream());
           //BufferedReader reader = new BufferedReader(inStream);
       
       } catch(IOException e) {
           System.out.println("Client unable to make connection to server on port: " + PORT);
           e.printStackTrace();
       }
   }
    
   public static void main(String [] args) {
      
      Client ac = new Client();
      ac.go();
   }
}