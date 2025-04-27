package echomath;
import echo.*;
import java.net.Socket;

public class MathHandler extends RequestHandler {

    public MathHandler(Socket s) {
        super(s);
    }

    public MathHandler() {
        super();
    }

    @Override
    protected String response(String request) throws Exception {
        String[] args = request.split("\\s+");
        double result = 0;
        
        if (args.length < 3) { // Make sure there's at least 3 arguments: operation and 2 or more numbers
            return "Invalid command. Usage: <operation> <num1> <num2> <...>";
        } 
        else {  
            String operation = args[0].toLowerCase();
            double num;

            for (int i = 1; i < args.length; i++) {
                try {
                    num = Double.valueOf(args[i]);
                }
                catch (NumberFormatException e) {
                    return "Invalid input " + args[i] + ". Please provide valid numbers.";
                }
                switch (operation) {
                    case "add":
                        result += num;
                        break;
                    case "sub":
                        if (i == 1) result = num; // Set the first number for subtraction
                        else result -= num;
                        break;
                    case "mul":
                        if (result == 0) result = 1; // Set to 1 for multiplication
                        result *= num;
                        break;
                    case "div":
                        if (num == 0) return "Cannot divide by 0. Please enter valid operands.";
                        if (i == 1) result = num; // Set the first number for division
                        else result /= num;
                        break;
                    default:
                        return "Invalid operation. Valid commands: add | sub | mul | div";
                }
            }
        }
        return String.valueOf(result);
    }

}
