package game;

import java.net.*;
import java.io.*;
/**
 *
 * @author Lee
 */
public class Server extends Thread {
    
    public void go() {
        
        final int PORT = 6000;
        int count = 0;
        
        try {
        // create listener object on the server designated with port number
        // if it binds then object listener is created
        ServerSocket listener = new ServerSocket(PORT);
            
        //keep listening indefinitely until receives 'exit' call or program terminates
        
            while(true) {
                System.out.println("Server: Waiting for clients...");
                // create object s when connection to client has been requested and successfully established. 
                // the accept method returns a new Socket object which is bound 
                // to the same local port and has its remote address and remote 
                // port set to that of the client. The server can communicate with 
                // the client over this new Socket and continue to listen for 
                // client connection requests on the original ServerSocket
                Socket s = listener.accept();
                count++;
                System.out.println("Server: Client number " + count +" Connected");
                // for each client object s that is created, do the below
                
                // Get the socket outputstream and create writer out object
                OutputStream outStream = s.getOutputStream();
                PrintWriter out = new PrintWriter(outStream);
                
                // Get the socket input stream and create reader in object
                InputStream inStream = s.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
                
                //get client message
                String clientInputLine;
                
                if((clientInputLine = in.readLine()) != null) {
                    System.out.println(clientInputLine);
                }
                else 
                    System.out.println("readline must be null");
            }
        } catch(IOException e) {
            System.out.println("Server: Unable to establish connection on port: " + PORT);
            e.printStackTrace();
        }
    }
    
    class messageProtocol {
        private static final int WAITING = 0;
        private static final int PLAYERS = 6;
        
        
        
        private String[] characters = {"Ms Scarlet", "Col. Mustand", "Mrs. White", "Mr. Green", 
                                         "Ms. Peacock","Professor Plum"};
        
        
        // set default state
        private int state = WAITING;
        
        // set default player
        private int player = 0;
                
//      public String processMsg(String input) {
            
//        }
        
    }
    
    public static void main(String[] args)  {
        
        Server Server = new Server();
        Server.go();
    }
}

