import java.util.ArrayList;
import java.util.Scanner;
 
public class Calculator {
        
       public static double multiplyEquals(double result, double block){
              result *= Double.valueOf(block);
              return result;
       }

       public static Double operation(
              String input
       ){
              String[] blocks = input.split("[-+*/^]");  // format to list of characters
              String[] operators = input.split("[^-+*/^]+");

              double result = 1;
              int index = 0; // enumerate these

              for (String block : blocks){
                     if (index == 0){
                            result = Double.valueOf(block);
                     }
                     else{
                            String operator = operators[index];
                            if (operator.equals("+")){
                                   result += Double.valueOf(block); 
                            }
                            if (operator.equals("-")){
                                   result -= Double.valueOf(block); 
                            }
                            if (operator.equals("*")){
                                   result *= Double.valueOf(block); 
                            }
                            if (operator.equals("/")){
                                   result /= Double.valueOf(block); 
                            }
                            if (operator.equals("^")){
                                   result = Math.pow(result, Double.valueOf(block)); 
                            }
                            
                     }
                     index++;
              }

              return result;
       }
    
       public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              String input = in.nextLine();
              String output = ": " + input;

              output = String.valueOf(operation(input));             
              System.out.println(output);
              in.close();
              }
       }