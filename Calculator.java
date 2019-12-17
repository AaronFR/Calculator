import java.util.Arrays;
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

              String operationsString = "-+*/^";
              String[] blocks = input.split(
                     String.format("[%s]", operationsString)
              );
              ArrayList<String> operators = new ArrayList<String>(
                     Arrays.asList(input.split(
                            String.format("[^%s]", operationsString))
                     )
              );

              boolean isNegative = false;
              if (operators.get(0).equals("-")){
                     operators.set(0, "");
                     blocks = Arrays.copyOfRange(blocks, 1, blocks.length);
                     isNegative = true;
              }
              
              int index = 0;
              double result = 1;
              for (String block : blocks){
                     System.out.println("Block: " + block);
                     if (index == 0){
                            if (isNegative){
                                   result = -Double.valueOf(blocks[0]);
                            }
                            else{
                                   result = Double.valueOf(block);
                            }
                            
                     }
                     else{
                            String operator = operators.get(index);
                            if (operator.equals("+")){
                                   result += Double.valueOf(block); 
                            }
                            if (operator.equals("-")){
                                   System.out.println("b" + result);
                                   result -= Double.valueOf(block); 
                                   System.out.println("a" + result);
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