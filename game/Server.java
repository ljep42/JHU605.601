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


public class Server {
    ServerSocket sock;
    boolean running = true;
    ArrayList<Thread> clients = new ArrayList<Thread>();
    final int port = 9002;

    public Server() {
        try {
            sock = new ServerSocket(port);
        } catch(IOException ioe) {
             System.out.println("Could not create server socket on port " + port);
            System.exit(1);
        }

        while(running) {
            try {
                Socket client_sock = sock.accept();
                ClientThread client = new ClientThread(client_sock);
                client.start();
                clients.add(client);

                for(Thread cli : clients) {
                    if(cli.getState() == Thread.State.TERMINATED) {
                        clients.remove(cli);
                    }
                }

            } catch(IOException ioe) {
                System.out.println("Exception on accept. Stack Trace : ");
                ioe.printStackTrace();
            }
        }
        try {
            sock.close();
            System.out.println("Server Stopped");
        } catch(Exception ioe) {
            System.out.println("Error Found stopping server socket");
            System.exit(-1);
        }
    }


    class ClientThread extends Thread {
        Socket client_sock;
        boolean alive = true;

        public ClientThread() {
            super();
        }

        ClientThread(Socket s) {
            client_sock = s;
        }

        public void run() {
            BufferedReader in = null;
            PrintWriter out = null;
            System.out.println(
                "Accepted client connection from address: "
                + client_sock.getInetAddress().getHostName());
            try {
                in = new BufferedReader(
                new InputStreamReader(client_sock.getInputStream()));
                out = new PrintWriter(
                new OutputStreamWriter(client_sock.getOutputStream()));

                while(alive) {
                String client_msg = in.readLine();
                System.out.println("Client Message: " + client_msg);

                if(!running) {
                    System.out.print("Server has exited");
                    out.flush();
                    alive = false;
                }

                if(client_msg.equalsIgnoreCase("quit")) {
                    alive = false;
                    System.out.println("Stopping thread for client : "
                    + client_sock.getInetAddress().getHostName());

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
                    in.close();
                    out.close();
                    client_sock.close();
                } catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }


    public static void main (String[] args) {
        new Server();
    }

}
