package console;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderUtil {

    public static List<String> readMissionFile(String fileName) {
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
