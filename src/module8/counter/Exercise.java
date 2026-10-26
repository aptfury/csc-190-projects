package module8.counter;

import java.io.File;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        String fileName = args[0];

        try {
            File path = new File(fileName);

            int chars = countCharacters(path);
            int words = countWords(path);
            int lines = countLines(path);

            String res = "File %s has%n" +
                    "%d characters%n" +
                    "%d words%n" +
                    "%d lines%n";

            System.out.printf(res, fileName, chars, words, lines);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int countCharacters(File path) throws Exception {
        int count = 0;

        try (Scanner file = new Scanner(path)) {
            while (file.hasNextLine()) {
                String next = file.nextLine();
                count += next.length() + 1; // adding 1 for the \n removed by nextLine()
            }
        }
        catch (Exception e) {
            System.out.println("Exception from countCharacters()");
            throw e;
        }

        return count - 1; // subtract 1 to remove final \n when there isn't a next line
    }

    private static int countWords(File path) throws Exception {
        int count = 0;

        try (Scanner file = new Scanner(path)) {
            while (file.hasNext()) {
                file.next();
                count++;
            }
        }
        catch (Exception e) {
            System.out.println("Exception from countWords()");
            throw e;
        }

        return count;
    }

    private static int countLines(File path) throws Exception {
        int count = 0;

        try (Scanner file = new Scanner(path)) {
            while (file.hasNextLine()) {
                file.nextLine();
                count++;
            }
        }
        catch (Exception e) {
            System.out.println("Exception from countLines()");
            throw e;
        }

        return count;
    }
}
