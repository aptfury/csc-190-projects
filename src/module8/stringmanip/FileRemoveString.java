package module8.stringmanip;

import java.io.File;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Blake
 * @version 10.26.26
 *
 * Removes the provided string from the provided file.
 */
public class FileRemoveString {
    public static void main(String[] args) {
        String target = args[0];
        String fileName = args[1];

        File path = new File(fileName);

        try (Scanner input = new Scanner(path);
             PrintWriter output = new PrintWriter(path)) {
            List<String> newLines = new ArrayList<>();

            while (input.hasNextLine()) {
                String original = input.nextLine();
                String edited = original.replaceAll(target, "");
                newLines.add(edited);
            }

            newLines.forEach(line -> {
                output.println(line);
            });
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
