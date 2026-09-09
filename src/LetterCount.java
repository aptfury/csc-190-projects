/**
 * @author Blake
 * @version 09.09.26
 *
 * Counts the number of letters in a given word
 */

// imports
import java.util.Scanner;

// class
public class LetterCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a word: ");
        String word = input.next();

        System.out.println("Enter a letter: ");
        char letter = input.next().charAt(0);

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) == letter) {
                count++;
            }
            else if (word.toUpperCase().charAt(i) == letter) {
                count++;
            }
        }

        System.out.println("The letter '" + letter + "' appears in the word '" + word + "' " + count + " times.");
    }
}
