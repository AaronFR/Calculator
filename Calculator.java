import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Calculator {

       public static boolean hasFailed = false;
       public static String internalErrorMessage = new String();

       public static Double operation(
              String input
       ) {
              input = input.replace(" ", "");

              String operationsString = "-+*/^";
              String[] blocks = input.split(
                     String.format("[%s]", operationsString)
              );

              ArrayList<String> operators = new ArrayList<String>();
              char[] inputChars = input.toCharArray();
              for (char c: inputChars) {
                     String s = String.valueOf(c);
                     if (s.equals("^") || s.equals("-") || s.equals("+") || s.equals("*") || s.equals("/")) {
                            operators.add(s);
                     }
              }

              boolean isNegative = false;
              if (input.startsWith("-")) {
                     blocks = Arrays.copyOfRange(blocks, 1, blocks.length);
                     isNegative = true;
              }
              
              int index = 0;
              double result = 1;
              for (String block : blocks) {
                     try {
                            if (index == 0) {
                                   if (isNegative) {
                                          result = -Double.valueOf(blocks[0]);
                                   }
                                   else{
                                          result = Double.valueOf(block);
                                   }
                                   
                            }
                            else{
                                   String operator = operators.get(index - 1);
                                   if (operator.equals("+")) {
                                          result += Double.valueOf(block); 
                                   }
                                   if (operator.equals("-")) {
                                          result -= Double.valueOf(block);
                                   }
                                   if (operator.equals("*")) {
                                          result *= Double.valueOf(block); 
                                   }
                                   if (operator.equals("/")) {
                                          result /= Double.valueOf(block); 
                                   }
                                   if (operator.equals("^")) {
                                          result = Math.pow(result, Double.valueOf(block)); 
                                   }
                            }
                            index++;
                     } catch (Exception e) {
                            hasFailed = true;
                            System.out.println(
                                   "INVALID: DIGITS EXPECTED!" +
                                   " >   " + e
                            );
                     }
                     
              }

              return result;
       }

       public static String derivative(String input) {
              String result = new String();

              String[] variableBlocks = input.split("d\\/d");
              String[] variableStatements = variableBlocks[1].split(" ");
              String variable = variableStatements[0];
              String[] terms = variableStatements[1].split(variable);

              Double constant = Double.valueOf(terms[0]);
              boolean isConstant = false;
              if (terms.length == 1){
                     if (variableStatements[1].endsWith(variable)) {
                            return String.valueOf(constant);
                     }
                     else {
                            return "0";
                     }
              }

              if (terms[1].startsWith("^")) {
                     String[] splitByExponent = terms[1].split("\\^");
                     Double exponent = Double.valueOf(splitByExponent[1]);

                     if (exponent != 0 || !isConstant) {
                            constant *= exponent;
                            exponent--;

                            result = String.valueOf(constant) + variable + "^" + String.valueOf(exponent);
                     }
                     else {
                            result = "0";
                     }
                     
              }
              else {
                     hasFailed = true;
                     System.out.println("EXPONENT NOT FOUND");
              }

              return result;
       }

       public static void calculatorInput() {
              Scanner in = new Scanner(System.in);
              String input = in.nextLine();
              String output = ": " + input;

              if (!input.toLowerCase().equals("quit")) {
                     if (input.startsWith("d/d")) {
                            output = derivative(input);
                     }
                     else {
                            output = String.valueOf(operation(input));     
                     }
                     
                     if (hasFailed) {
                            System.out.println();
                     }
                     else {
                            System.out.println(output);
                            System.out.println();
                     }
                     hasFailed = false;

                     calculatorInput();
              }
              else{
                     in.close();
              }
       }
    
       public static void main(String[] args) {
              calculatorInput();
       }
}