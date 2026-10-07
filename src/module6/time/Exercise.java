package module6.time;

/**
 * @author Blake
 * @version 10.05.26
 *
 * Initializes Time() using the three different constructors available and then prints them in an hour:minute:second
 * format
 */
public class Exercise {
    public static void main(String[] args) {
        Time t1 = new Time(); // default constructor
        Time t2 = new Time(555550000); // using milliseconds
        Time t3 = new Time(5, 23, 55); // using hour, minute, and second

        // print t1
        System.out.println(t1.toString());

        // print t2
        System.out.println(t2.toString());

        // print t3
        System.out.println(t3.toString());
    }
}
