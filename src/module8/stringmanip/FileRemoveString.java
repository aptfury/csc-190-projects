package module8.stringmanip;

import java.io.File;
import java.io.PrintWriter;

import java.util.Scanner;

/**
 * @author Blake
 * @version 10.26.26
 *
 * Removes the provided string from the provided file.
 */
public class FileRemoveString {
    public static void main(String[] args) {
        String target = args[0] + " "; // added whitespace after to avoid double whitespace after edit
        String fileName = args[1];
        File path = new File("workspace/Projects/src/module8/stringmanip/" + fileName);

        String fileData = readFileData(path);
        String newData = fileData.replaceAll(target, "");

        writeFileData(path, newData);
    }

    public static String readFileData(File path) {
        String fileData = "";

        try (Scanner input = new Scanner(path)) {
            while (input.hasNext()) {
                fileData += input.next() + " ";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return fileData;
    }

    public static void writeFileData(File path, String data) {
        try (PrintWriter output = new PrintWriter(path)) {
            output.print(data);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
