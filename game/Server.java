package game;

import java.net.*;
import java.io.*;
/**
 *
 * @author Lee
 */
public class Server extends Thread {
    
    public void start() {
        
        final int PORT = 6000;
        
        try {
        // create listener object on the server designated with port number
        // if it binds then object listener is created
        ServerSocket listener = new ServerSocket(PORT);
            
        //keep listening indefinitely until receives 'exit' call or program terminates
        
            while(true) {
                System.out.println("Waiting for clients...");
                // create object s when connection to client has been requested and successfully established. 
                // the accept method returns a new Socket object which is bound 
                // to the same local port and has its remote address and remote 
                // port set to that of the client. The server can communicate with 
                // the client over this new Socket and continue to listen for 
                // client connection requests on the original ServerSocket
                Socket s = listener.accept();
                
                // for each client object s that is created, do the below
                
                // Get the socket outputstream and create writer out object
                OutputStream outStream = s.getOutputStream();
                PrintWriter out = new PrintWriter(outStream);
                
                // Get the socket input stream and create reader in object
                InputStream inStream = s.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
                
                //create inline string variable to capture client out
                String clientInputLine;
                
                while((clientInputLine = in.readLine()) != null) {
                    System.out.println(clientInputLine);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    class messageProtocol {
        private static final int WAITING = 0;
        private static final int PLAYERS = 6;
        
        
        
        private String[] characters = {"Ms Scarlet", "Mr. Green", "Professor Plum",
                                       "Col. Mustand", "Mrs. White", "Ms. Peacock"};
        
        
        // set default state
        private int state = WAITING;
        
        // set default player
        private int player = 0;
                
//      public String processMsg(String input) {
            
//        }
        
    }
    
    public static void main(String[] args)  {
        
        Server clueServer = new Server();
        clueServer.start();
    }
}

