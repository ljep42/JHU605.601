package game;

import java.net.*;
import java.io.*;

/**
 *
 * @author Lee
 */
public class Client {

	public int ClientID;
	
    public void setupConnection() throws IOException {

        final int PORT = 6000;
        // try with resources
        try (
                // these will auto close when we are finishing using them
                // create socket for client (hostname, server port number)
                Socket sock = new Socket("localhost", PORT);
                // create out stream for client, set auto flush buffer to true
                OutputStream outStream = sock.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);
                // create in stream for client
                //InputStream inStream = sock.getInputStream();
                //BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        		) 
        {
        	Socket socketConnection = new Socket("localhost", PORT);

        	ObjectInputStream objectInputStream = 
                    new ObjectInputStream(sock.getInputStream());
        	
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // send msg to server
                out.println("Client: Connected");
            
                Object testClass = null;
                do 
                {
                	
                	testClass = objectInputStream.readObject();
                }while(testClass == null);
                
                
                
                //TestClass test;
                //test = (TestClass)testClass;
                System.out.println("Object received:");
                System.out.println(testClass.toString());
                // get msg from server
                //System.out.println(in.readLine());

                //get input from user and send to server
                String fromUser = stdIn.readLine();
                out.println(fromUser);

                if (fromUser.equals("Exit")) {
                    System.out.println("closing connection...");
                    break;
                }
                
                //String fromServer = in.readLine();
                //System.out.println(fromServer);
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
        
        catch(ClassNotFoundException e)
        {
        	e.printStackTrace();
        }
        
    }

    public void lobbyRoom() {

    }

    public static void main(String[] args) throws IOException {

        Client ac = new Client();
        ac.setupConnection();
        ac.lobbyRoom();
    }
}
