import java.util.Scanner;

/**
 * @author Blake
 * @version 09.09.26
 *
 * Counts the number of letters in a given word
 */

public class LetterCount {
    /**
     * @param args - no arguments needed or used
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String word = requestInput(input, "Enter a Word: ");
        char ch = requestInput(input, "Enter a letter: ").charAt(0);

        int count = letterCounter(word, ch);

        System.out.println("The letter '" + ch + "' appears in the word '" + word + "' " + count + " times.");
    }

    /**
     * Requests a string input from the user. Ideally this would be modified to account for no input/empty string
     * values, but I am not putting that much effort into an ungraded practice assignment.
     *
     * @param input [Scanner] - the scanner variable set up in main
     * @param req [String] - the message for the prompt provided to the user
     * @return [String] - the response from the user
     */
    public static String requestInput(Scanner input, String req) {
        System.out.println(req);

        return input.next();
    }

    /**
     * Counts the number of times that the provided char appears in the provided word
     *
     * @param word [String] - the word being searched
     * @param ch [char] - the character being counted
     * @return [int] - the number of times the character appears
     */
    public static int letterCounter(String word, char ch) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) == ch || word.toUpperCase().charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }
}
