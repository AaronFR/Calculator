import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Calculator {

       public static boolean hasFailed = false;
       public static String internalErrorMessage = new String();
       
       public static ArrayList<Double> numbers = new ArrayList<Double>();
       public static ArrayList<String> operations = new ArrayList<String>();
       
       public static String calculatorInput = new String();
       
       
       public static void hasFailed(String textToDisplay) {
    	   System.out.println("ERROR : " + textToDisplay);
       }
       
       
       public static void printResult(double result) {
    	   DecimalFormat df = new DecimalFormat("###.###");
    	   System.out.println(": " +  df.format(result));
       }
       public static void printResult(String result) {
    	   System.out.println(": " + result);
       }

       public static String derivative(String input) {
              String[] variableBlocks = input.split("d\\/d");
              String[] variableStatements = variableBlocks[1].split(" ");
              String variable = variableStatements[0];
              String[] terms = variableStatements[1].split(variable);

              String result = new String();
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
            	  	hasFailed("EXPONENT NOT FOUND");
              }

              return result;
       }
       
       public static void arithmetic() {
    	   double result = numbers.get(0);
    	   
    	   int index = 1;
    	   for (String operation : operations) {
    		   try {
    			   switch (operation) {
	    		   case ("+"):
	    			   result += numbers.get(index);
	    			   break;
	    		   case ("-"):
	    			   result -= numbers.get(index);
	    			   break;
	    		   case ("*"):
	    			   result *= numbers.get(index); 
	    			   break;
	    		   case "/":
	    			   result /= numbers.get(index); 
	    			   break;
	    		   case "^":
	    			   result = Math.pow(result, numbers.get(index)); 
	    			   break;
	    		   default:
	    			   hasFailed("UNKNOWN OPERATION");
    			   }
    		   }
    		   catch (IndexOutOfBoundsException e) {
    			   hasFailed("MALFORMED QUERY");
    			   index++;
    		   }
    		   
    		   index++;
    	   }

    	   printResult(result);
    	   calculatorInput();
       }
       


       public static void formOperatorsAndNumbers(String input) {
    	   numbers.clear();
           operations.clear();
    	   
    	   String[] blocks = input.split(" ");
    	   
    	   for (String block : blocks) {
	           	try {
	           		numbers.add(Double.parseDouble(block));	           		
	           	}
	           	catch (NumberFormatException e) {
	           		operations.add(block);
	           	}
           }
       }
       
       public static void chooseCalculation(String input) {
           if (input.startsWith("d/d")) {
        	   printResult(derivative(input));
        	   calculatorInput();
           }
           else {
        	   formOperatorsAndNumbers(input);
        	   arithmetic();
           }
       }
       
       public static void calculatorInput() {
              Scanner in = new Scanner(System.in);
              calculatorInput = in.nextLine();
              
              if (!calculatorInput.toLowerCase().equals("quit")) {
            	  chooseCalculation(calculatorInput);
              }
              else{
                     in.close();
              }
       }

       public static void main(String[] args) {
    	   System.out.println("Arithmetic and Derivation Calculator. All numbers and operators must be seperated with a space.");
     	   calculatorInput();
       }
}
