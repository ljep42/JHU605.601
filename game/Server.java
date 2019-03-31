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
        
        ServerSocket serverSocket;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        
        System.out.println("Establishing connection, please wait...");
        
        try {
        // create listener object on the server designated with port number
        // if it binds then object is created
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server started, waiting for clients...");
        //Server always keeps listening for clients
            while(true) {
                // create object when connection to client has been requested and successfully established. 
                // the accept method returns a new Socket object which is bound 
                // to the same local port and has its remote address and remote 
                // port set to that of the client. The server can communicate with 
                // the client over this new Socket and continue to listen for 
                // client connection requests on the original ServerSocket
                clientSocket = serverSocket.accept();
                count++;
                System.out.println("client number " + count +" is connected.");
                
                // for each client object that is created, do the below
                
                // Get the socket outputstream and create writer out object, flush buffer at end set to true
                OutputStream outStream = clientSocket.getOutputStream();
                out = new PrintWriter(outStream, true);
                
                // Get the socket input stream and create reader in object
                InputStream inStream = clientSocket.getInputStream();
                in = new BufferedReader(new InputStreamReader(inStream));
                
                // send msg to client
                out.println("Server: You are client number " + count + " and are now connected");
                
                System.out.println("Assigning new thread for this client");
                // clientHandler extends Thread so its okay
                Thread thread = new ClientHandler(clientSocket, in, out);
                thread.start();
                System.out.println("Thread created");
            }
            
            
            
        } catch(IOException e) {
            System.out.println("Server: Unable to establish connection on port: " + PORT);
            e.printStackTrace();
        }
    }
    
    // ClientHandler class 
    class ClientHandler extends Thread {

    final BufferedReader in;
    final PrintWriter out;
    final Socket s;

    // Constructor 
    public ClientHandler(Socket s, BufferedReader in, PrintWriter out) {
        this.s = s;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        while (true) {
            try {
                // Ask user what he wants 
                out.println("Welcome! Do you want to play Clue?\n"
                        + "Type Exit to terminate connection.");

                // receive the answer from client 
                received = in.readLine();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection...");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }


                // write on output stream based on the 
                // answer from the client 
                switch (received) {

                    case "test":
                        toreturn = "test";
                        out.println(toreturn);
                        break;

                    case "test2":
                        toreturn = "test2";
                        out.println(toreturn);
                        break;

                    default:
                        out.println("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // closing resources 
            this.in.close();
            this.out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
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

