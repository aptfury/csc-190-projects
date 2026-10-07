package module5.student;

/**
 * @author Blake
 * @version 10.04.26
 *
 * Creates a module5.student by name and id, stores their grade information, and calculates whether they can graduate with
 * their current grade.
 *
 * @implNote The prompt provided specifies that the constructor and methods are public, but it doesn't specify the
 * module5.student information, and so I have chosen to make it private here in keeping with standard data encapsulation. I
 * have also made the module5.student id and name data fields final.
 */
public class Student {
    private final String NAME; // module5.student name
    private final int ID; // module5.student id; immutable once initialized
    private int units = 0; // module5.student grade; default: 0

    /**
     * Creates a new module5.student based on the id and name submitted; Units defaults to 0
     *
     * @implNote Student id and name CANNOT be changed. Please take care when initializing.
     *
     * @param id [int] module5.student id
     * @param name [String] module5.student name
     */
    public Student(String name, int id) {
        this.NAME = name;
        this.ID = id;
    }

    /**
     * Retrieve module5.student ID
     *
     * @return [int] module5.student id
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Retrieve module5.student name
     *
     * @return [String] module5.student name
     */
    public String getName() {
        return this.NAME;
    }

    /**
     * Retrieve module5.student grade
     *
     * @return [int] module5.student grade
     */
    public int getUnits() {
        return this.units;
    }

    /**
     * Add units to module5.student grade; Negative units can be passed to subtract from grade as needed
     *
     * @param units [int] amount added
     */
    public void incrementUnits(int units) {
        this.units += units;
    }

    /**
     * Calculates whether module5.student has enough units to graduate
     *
     * @return [boolean] module5.student graduates
     */
    public boolean hasEnoughUnits() {
        // minimum units needed to graduate
        final int MIN_GRADUATION_UNITS = 180;

        return (this.units - MIN_GRADUATION_UNITS) >= 0;
    }

    /**
     * Retrieves module5.student name and id number in the following format: Name (#ID)
     *
     * @return [String] Student Name (#ID)
     */
    public String toString() {
        String student = "%s (#%d)";

        return String.format(student, this.NAME, this.ID);
    }
}