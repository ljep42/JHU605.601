/***
*
*
*
***/

package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


public class Server {
    ServerSocket sock;
    boolean running = true;
    ArrayList<Thread> clients = new ArrayList<Thread>();
    final int PORT;
    int maxClients = 6;
    int minClients = 3;
    long startTime = 0L;
    long elapsedTime = 0L;
    long timeout = 2*60*1000;
    Logger logger;

    public Server(int port, int maxClients, int minClients, Logger logger) {
    
        PORT = port;
        maxClients = maxClients;
        minClients = minClients;
        logger = logger;
        startTime = System.currentTimeMillis();
        try {
            logger.Write("Starting server on port: " + PORT);
            sock = new ServerSocket(PORT);

        } catch(IOException ioe) {
             logger.Write("Could not create server socket on port " + PORT);
            System.exit(1);
        }

        while(running) {
            try {
                //elapsedTime = System.currentTimeMillis() - startTime;
                Socket client = sock.accept();
                ClientThread client_t = new ClientThread(client);
                client_t.start();
                clients.add(client_t);
                //if (clients.size() >= minClients && elapsedTime < timeout) {
                //    elapsedTime = System.currentTimeMillis() - startTime;
                //}
                
                for(Thread cli : clients) {
                    if(cli.getState() == Thread.State.TERMINATED) {
                        clients.remove(cli);
                    }
                }

            } catch(IOException ioe) {
                logger.Write("Exception on accept. Stack Trace : ");
                ioe.printStackTrace();
            }
        }
        try {
            sock.close();
            logger.Write("Server Stopped");
        } catch(Exception ioe) {
            logger.Write("Error Found stopping server socket");
            System.exit(-1);
        }
    }


    class ClientThread extends Thread {
        Socket client;
        boolean alive = true;

        public ClientThread() {
            super();
        }

        ClientThread(Socket s) {
            client = s;
            //Logger logger = new Logger();
        }

        public void run() {
            BufferedReader in = null;
            PrintWriter out = null;

            try {
                in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(
                new OutputStreamWriter(client.getOutputStream()));

                while(alive) {
                    String client_msg = in.readLine();
                    
                    if(client_msg != null && ! client_msg.equals("")) {
                        System.out.println("Client Message: " + client_msg);
                    }
                    
                    if(!running) {
                        System.out.print("Server has exited");
                        out.flush();
                        alive = false;
                    }
                    
                    if(client_msg == null || client_msg.equals("")) {
                        alive =false;
                        continue;
                    }

                    if(client_msg.equalsIgnoreCase("quit")) {
                        alive = false;
                        System.out.println("Stopping thread for client : "
                        + client.getInetAddress().getHostName());

                    } else if(client_msg.equalsIgnoreCase("end")) {
                        alive = false;
                        System.out.print("Stopping client thread for client : ");
                        running = false;

                    } else {
                        out.println("Server Message : " + client_msg);
                        out.flush();
                        }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    System.out.println("Client disconnected, closing");
                    in.close();
                    out.close();
                    client.close();
                } catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
