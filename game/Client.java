package game;

import java.net.*;
import java.io.*;
/**
 *
 * @author Lee
 */
public class Client {

   public void start() {
       
       final int PORT = 6000;
       
       try {
           // read data from server (input of client connects to output from server)
           
           // socket(hostname,port number)
           Socket s = new Socket("localhost", PORT);
           
           // create printwriter from client output stream
           PrintWriter out = new PrintWriter(s.getOutputStream());
           out.println("hello!");
           
           //InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
           //BufferedReader reader = new BufferedReader(streamReader);
       
       } catch(IOException e) {
           e.printStackTrace();
       }
   }
    
   public static void main(String [] args) {
      
      Client ac = new Client();
      ac.start();
   }
}