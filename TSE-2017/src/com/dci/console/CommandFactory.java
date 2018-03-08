package com.dci.console;

import java.security.InvalidParameterException;

/**
 * Takes the command from the client (including the base64 command) and parses it to get its value.
 */
public class CommandFactory {
    private static final String DELIMITER = " ";
    private static final String DEFAULT_NAME = "Jacqueline";

    public static void createCommand(String customerCommand) {
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
        String realCommand = Base64Decoder.decode(base64Command);

        System.out.println(realCommand);
    }
}
