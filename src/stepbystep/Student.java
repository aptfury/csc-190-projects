package stepbystep;

/**
 * @author Blake
 * @version 10.04.26
 *
 * Creates a student by name and id, stores their grade information, and calculates whether they can graduate with
 * their current grade.
 *
 * @implNote The prompt provided specifies that the constructor and methods are public, but it doesn't specify the
 * student information, and so I have chosen to make it private here in keeping with standard data encapsulation. I
 * have also made the student id and name data fields final.
 */
public class Student {
    private final String NAME; // student name
    private final int ID; // student id; immutable once initialized
    private int units = 0; // student grade; default: 0

    /**
     * Creates a new student based on the id and name submitted; Units defaults to 0
     *
     * @implNote Student id and name CANNOT be changed. Please take care when initializing.
     *
     * @param id [int] student id
     * @param name [String] student name
     */
    public Student(String name, int id) {
        this.NAME = name;
        this.ID = id;
    }

    /**
     * Retrieve student ID
     *
     * @return [int] student id
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Retrieve student name
     *
     * @return [String] student name
     */
    public String getName() {
        return this.NAME;
    }

    /**
     * Retrieve student grade
     *
     * @return [int] student grade
     */
    public int getUnits() {
        return this.units;
    }

    /**
     * Add units to student grade; Negative units can be passed to subtract from grade as needed
     *
     * @param units [int] amount added
     */
    public void incrementUnits(int units) {
        this.units += units;
    }

    /**
     * Calculates whether student has enough units to graduate
     *
     * @return [boolean] student graduates
     */
    public boolean hasEnoughUnits() {
        // minimum units needed to graduate
        final int MIN_GRADUATION_UNITS = 180;

        return (this.units - MIN_GRADUATION_UNITS) >= 0;
    }

    /**
     * Retrieves student name and id number in the following format: Name (#ID)
     *
     * @return [String] Student Name (#ID)
     */
    public String toString() {
        String student = "%s (#%d)";

        return String.format(student, this.NAME, this.ID);
    }
}