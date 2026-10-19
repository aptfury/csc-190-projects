package module7.duplicates;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise extends Dedupe {
    private static final Scanner INPUT = new Scanner(System.in);
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println("Enter ten integers: ");

        while (INPUT.hasNext() && list.size() < 10) {
            list.add(INPUT.nextInt());
        }

        removeDuplicate(list);
    };
}

class Dedupe {

    protected static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> distinct = new ArrayList<>();

        for (Integer i: list) {
            if (!distinct.contains(i)) {
                distinct.add(i);
            }
        }

        System.out.print("The distinct integers are ");
        distinct.forEach(i -> {
            System.out.print(i + " ");
        });
    }

}