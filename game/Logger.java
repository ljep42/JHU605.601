/**
 * Logger class write a log message to a given file. This class contains all
 * the necessary methods to initialize a file and append to the log file
 * with the given message string input
 *
 * @author Govind
 **/

package game;

import java.io.*;


public class Logger
{

   File file;

   private String logFile;

   /**
    *
    * Logger contructor
    *
    * @param fileName The full file path to log to.
    *
    **/
   public Logger (String fileName) {
      this.logFile = fileName;
      this.init();
   }

   /**
    *
    * Initialize the given file. As part of initilization
    * the method mainly checks if the file can be written to. This has to be
    * called only once, at the beginning.
    *
    **/
   private void init() {
      try {
         file = new File(logFile);
         file.createNewFile();

         if (!file.canWrite()) {
            throw new IOException("File " + logFile + " not writable");
         }
      } catch (IOException e) {
         System.out.println("Error opening file " + logFile);
         System.exit(1); /* Exit on IO exception */
      }
   }

   public String getLogFile() {
        return logFile;
   }

   /**
    *
    * Public method to write a given string to the log file.
    *
    * @param message
    *
    * Message string that needs to be written to the log file.
    *
    **/
   public void Write(String message) {
      try {
         /* Create a FileWriter instance */
         FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
         /* Wrap it around a BufferedWriter instance */
         BufferedWriter bw = new BufferedWriter(fw);
         /* Create a PrintWriter instance using the BufferedWriter instance */
         PrintWriter pw = new PrintWriter(bw);
         pw.println(message); /* Append the given string to a file */
         pw.close();
         bw.close();
         fw.close();
      } catch (IOException e) {
         System.out.println("Cannot write to output file " + logFile);
         System.exit(1);
      }
   }
}

