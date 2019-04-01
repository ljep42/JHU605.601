package game;

import java.util.*;
import java.io.*;


public class ClueLess {


    public static void main (String [] args) {
    
        String paramFile = "";
        String logFile = "ClueLess.log";
        String role = "";
        HashMap<String, String> params = new HashMap<>();
        
        if (args.length != 2) {
            usage();
        }
        
        role = args[0];
        paramFile = args[1];
        Config config = new Config(paramFile);
        config.parse();
        params = config.getParams();
        int port = Integer.parseInt(params.get("server.port"));
        int maxClients = Integer.parseInt(params.get("server.maxClients"));
        int minClients = Integer.parseInt(params.get("server.minClients"));
        Logger logger = new Logger(logFile);
        
        if (role.equals("server")) {
            new Server(port, maxClients, minClients, logger);
        } else if (role.equals("client")) {
            try {
                Client client = new Client(port, logger);
                client.setupConnection();
            } catch (IOException e) {
                logger.Write("Client failed to connect");
                System.exit(-1);
            }
        }
        
    }

    public static void usage() {

      System.out.println("Usage: java ClueLess <role> <param file>");
      System.out.println("E.g: java ClueLess server config.txt");
      System.exit(1);
   }

}
