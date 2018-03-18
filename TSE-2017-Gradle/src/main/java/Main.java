import console.CommandFactory;
import orders.OrderQueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        for(String arg : args) {
            System.out.println(arg);
        }



        // Reading the proper file
        final String mapFileName = args[0];
        final String missionFileName = args[1];
        List<String> encryptedCommands = readMissionFile(missionFileName);

        for( String command : encryptedCommands) {
            System.out.println("Order: " + command);
           // OrderQueue.get  CommandFactory.createCommand(command);
        }


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
