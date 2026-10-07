package module6.time;

/**
 * @author Blake
 * @version 10.05.26
 *
 * A module6.time class for processing module6.time from milliseconds into a human-readable format.
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    /**
     * No-param constructor that sets data fields based on module6.time when initialized.
     */
    public Time() {
        long elapseTime = System.currentTimeMillis();
        this.calculateTime(elapseTime);
    }

    /**
     * Constructor that sets data fields based on the provided module6.time in milliseconds.
     *
     * @param elapseTime [long] module6.time in milliseconds
     */
    public Time(long elapseTime) {
        this.calculateTime(elapseTime);
    }

    /**
     * Constructor that sets data fields based on the provided hour, minute, and second.
     *
     * @param hour [int] number of hours
     * @param minute [int] number of minutes
     * @param second [int] number of seconds
     */
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Calculates the hour, minute, and second from the elapsed module6.time and assigns them to the data fields.
     *
     */
    private void calculateTime(long elapseTime) {
        // calculate current second
        long totalSeconds = elapseTime / 1000;
        this.second = (int) totalSeconds % 60;

        // calculate current minute
        long totalMinutes = totalSeconds / 60;
        this.minute = (int) totalMinutes % 60;

        // calculate current hour
        long totalHours = totalMinutes / 60;
        this.hour = (int) totalHours % 24;
    }

    /**
     * Calculates and sets the hour, minute, and second based on new elapsed module6.time.
     *
     * @param elapseTime [long] module6.time in milliseconds
     */
    public void setTime(long elapseTime) {
        this.calculateTime(elapseTime);
    }

    /**
     * Retrieves the hour.
     *
     * @return [int] hour
     */
    public int getHour() {
        return this.hour;
    }

    /**
     * Retrieves the minute.
     *
     * @return [int] minute
     */
    public int getMinutes() {
        return this.minute;
    }

    /**
     * Retrieves the second.
     *
     * @return [int] second
     */
    public int getSeconds() {
        return this.second;
    }

    /**
     * Creates a human-readable string of the module6.time.
     *
     * @return [String] module6.time in hour:minute:second format
     */
    public String toString() {
        String time = "%d:%d:%d";

        return String.format(time, this.hour, this.minute, this.second);
    }
}
