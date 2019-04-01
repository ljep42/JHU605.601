/**
 * Input class to parse and return input data from specified input file.
 * Assumption is that the input file is a plain text file. Any line with
 * a '#' in the beginning is ignored, as with any Linux/Unix configuration
 * files. Also, all empty lines are ignored.
 *
 * @author Govind
 */


import java.io.*;
import java.util.*;


public class Config {

   private String inputFile; /* String containing input file name */
   private HashMap<String, String> params = new HashMap<String, String>();

   /**
    *
    * Config class constructor.
    *
    * @param input Input filename including path, if not in cwd,
    * is passed as argument to this constructor.
    *
    **/
   public Config(String input) {
      inputFile = input;
   }

   /**
    *
    * Private method to parse the input file and extract valid string data
    * from it. Each line (string) is placed as an array item in input data.
    *
    **/
   private void parseConfigFile() {

      try
      {  /* Create a BufferedReader instance */
         BufferedReader br = new BufferedReader(new FileReader(inputFile));
         String line;
         String [] lineContent;

         while((line = br.readLine()) != null)
         {   /* Read till end of file */
            if(line.trim().indexOf('#') == 0) {
               /* Discard lines beginning with # */
               continue;
            }

            if(line.trim().equals("") || line.trim().equals("\n")) {
               /* Discard empty lines */
               continue;
            }

            /* Populate array with line from file */
            lineContent = line.trim().split("=");
            params.put(lineContent[0].trim(), lineContent[1].trim());
            //System.out.println(line);
            //System.out.println(Arrays.asList(params));

         }
         /* Close file handle */
         br.close();
      }

      catch(IOException ex)
      {   /* Catch IO exception and exit */
         System.out.println("Error reading file " + inputFile);
         System.exit(1);
      }
   }

   /**
    * Public method to parse and return array containing input data parsed
    * from file.
    *
    **/
   public void parse() {
      parseConfigFile();
   }


   /**
    * Getter method to get config params
    *
    * @return params Hashmap of vertex and its corresponding adjacent vertices
    **/
   public HashMap<String, String> getParams() {
      return params;
   }
}
