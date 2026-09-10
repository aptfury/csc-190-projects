import java.util.Scanner;

/**
 * @author Blake
 * @version 09.09.26
 *
 * Chapter 7 class project
 */

public class Ch7ProgProj1 {
    /**
     * @param args - no args used
     */
    public static void main(String[] args) {
        double[] grades = recordGrades();
        String res = "Student %d score is %.0f and grade is %c%n";

        for (int i = 0; i < grades.length; i++) {
            System.out.printf(res, i, grades[i], getLetterGrade(grades[i], grades));
        }
    }

    /**
     * Prompts the user to enter the number of students and return the grades for each
     *
     * @return [double[]] - an array of student grades
     */
    public static double[] recordGrades() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int numOfStudents = input.nextInt();

        double[] grades = new double[numOfStudents];

        System.out.println("Enter " + numOfStudents + " scores: ");

        for (int i = 0; i < grades.length; i++) {
            grades[i] = input.nextDouble();
        }

        return grades;
    }

    /**
     * Use's the given student's grade to find and return the matching letter grade.
     *
     * @param grade [double] - the student's grade
     * @param grades [double[]] - the list of student grades
     * @return [char] - the char representing the corresponding letter grade
     */
    public static char getLetterGrade(double grade, double[] grades) {
        double highest = getHighestGrade(grades);
        char letter;

        if (grade >= highest - 10) {
            letter = 'A';
        }
        else if (grade >= highest - 20) {
            letter = 'B';
        }
        else if (grade >= highest - 30) {
            letter = 'C';
        }
        else if (grade >= highest - 40) {
            letter = 'D';
        }
        else {
            letter = 'F';
        }

        return letter;
    }

    /**
     * Find the highest grade from the provided array of student grades.
     *
     * @param grades [double[]] - the list of student grades
     * @return [double] - the highest grade from the array
     */
    public static double getHighestGrade(double[] grades) {
        double highest = 0;

        for (double i: grades) {
            if (i > highest) {
                highest = i;
            }
        }

        return highest;
    }
}
