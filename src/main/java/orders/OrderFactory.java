package orders;

import console.Base64Decoder;
import orders.Order;

import java.security.InvalidParameterException;

/**
 * Takes the command from the client (including the base64 command) and parses it to get its value.
 */
public class OrderFactory {
    private static final String DELIMITER = " ";
    private static final String DEFAULT_NAME = "Jacqueline";

    public static Order createCommand(String customerCommand) {
        String customerName;
        String base64Command;

        if(customerCommand == null || customerCommand.length() <= 0 ) {
            throw new InvalidParameterException("The command is invalid. Please come again.");
        }

        // Getting the string before the first space.
        final int indexOfFirstDelimiter = customerCommand.indexOf(DELIMITER);
        // If the delimiter was found, extract the customer name
        if(indexOfFirstDelimiter != -1) {
            customerName = customerCommand.substring(0, indexOfFirstDelimiter);
            base64Command = customerCommand.substring(indexOfFirstDelimiter + 1);
        }
        else {
            customerName = DEFAULT_NAME;
            base64Command = customerCommand;
        }

        // Decoding the command
        String realCommand = null;
        try {
            realCommand = Base64Decoder.decode(base64Command);
        }
        catch(IllegalArgumentException ex) {
            System.out.println("Unable to parse the given order. Please come again.");
            System.err.println(ex.getMessage());
        }

        // Once we have the command in string format, we send it to the menu.


        System.out.println(realCommand);

        // TODO Ask the menu for ItemRecipe.

        return null;
    }

}
