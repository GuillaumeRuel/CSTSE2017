import console.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final String[] ORDER_FILES = {"Easy_Missions.txt", "Medium_Missions.txt", "Hard_Missions.txt"};

    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);

        String difficulty = null;

        do {
            if(difficulty != null) {
                System.out.println("Invalid command. Try again...");
            }
            System.out.println("May I take your order?");
            System.out.println("1- Easy");
            System.out.println("2- Medium");
            System.out.println("3- Hard");

            difficulty = scanner.nextLine();
        }
        // Keep looping if the command is not either 1 or 2 or 3
        while(!(difficulty.equals("1") || difficulty.equals("2") || difficulty.equals("3")));


        // Reading the proper file
        final String fileName = ORDER_FILES[Integer.parseInt(difficulty)];
        List<String> list = readMissionFile(fileName);

        for( String command : list) {

        }

        CommandFactory.createCommand(difficulty);*/
    }

    private static List<String> readMissionFile(String fileName) {
        List<String> list = null;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            System.err.println("Unable to read the missions file.");
            e.printStackTrace();
        }

        return list;
    }
}
