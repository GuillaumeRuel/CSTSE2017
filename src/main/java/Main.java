import orders.OrderFactory;
import orders.OrderQueue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * @param args The first param mus be the map (eg. Easy_map.txt).
     *             The second must be the mission (eg. Easy_missions.txt)
     */
    public static void main(String[] args) {
        // Printing out the params to debug
        for(String arg : args) {
            System.out.println(arg);
        }

        // Reading the proper file
        final String mapFileName = args[0];
        final String missionFileName = args[1];
        List<String> encryptedCommands = readMissionFile(missionFileName);
        // Decrypting the base 64 orders and adding them to the order queue.
        for( String command : encryptedCommands) {
            System.out.println("Order: " + command);
            OrderQueue.getInstance().add( OrderFactory.createCommand(command));
        }

        // Once the queue is filled, send the orders to the menu to get the recipes

    }

    private static List<String> readMissionFile(String fileName) {
        List<String> list = new ArrayList<>();
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        File file = new File(loader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }

        } catch (IOException e) {
            System.err.println("Unable to read the missions file.");
            e.printStackTrace();
        }

        return list;
    }
}
