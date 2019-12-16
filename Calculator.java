import java.util.ArrayList;
import java.util.Scanner;
 
public class Calculator {
        
       // public static String camelCaseToSnakeCase(String text) {
       //        /* Simplist Solution
       //        return input.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();

       //        (.) = 1st group matches any character
       //        (\\p{Upper}) = pattern match to {Upper case characters}
       //        $1, $2 = Group 1 and group 2 respectively
       //        */
       // }
    
       public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              String input = in.nextLine();
              String output = ": " + input;

              if(input.contains("*")){
                     String[] blocks = input.split("\\*");
                     double result = 1;

                     for (String block : blocks){
                            // block = block.replaceAll("\\s","");
                            result *= Double.valueOf(block);
                     }

                     output = String.valueOf(result);
              }
              System.out.println(output);
              }
       }