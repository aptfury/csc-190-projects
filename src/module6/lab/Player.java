package module6.lab;

import java.security.InvalidParameterException;

/**
 * @author Blake
 * @version 10.05.26
 *
 * A class to hold a player's data and manage date updates and retrieval.
 */
public class Player {
    private String name;
    private String tag;
    private int age;
    private int numGames = 0;
    private int numWins = 0;

    /**
     * Default constructor;
     * Name defaults to "player";
     * Tag defaults to "playerTag";
     * Age defaults to 18;
     * Number of games and wins defaults to 0
     */
    public Player() {
        this.name = "player";
        this.tag = "playerTag";
        this.age = 18;
    }

    /**
     * Creates new player with data from params;
     * Number of games and wins defaults to 0.
     *
     * @param name [String] player name
     * @param tag [String] player tag
     * @param age [int] player age
     */
    public Player(String name, String tag, int age) {
        this.name = name;
        this.tag = tag;
        this.age = age;
    }

    /**
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return String
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * @return int
     */
    public int getGamesPlayed() {
        return this.numGames;
    }

    /**
     * @return int
     */
    public int getWins() {
        return this.numWins;
    }

    /**
     * @return int
     */
    public int getLosses() {
        return this.numGames - this.numWins;
    }

    /**
     * @return double
     */
    public double getWinRatio() {
        return (double) this.numWins / this.numGames;
    }

    /**
     * Returns a string of the player's name, tag, and win ratio
     * @return String
     */
    public String getData() {
        String data = "%s%n" +
                "tag: %s%n" +
                "age: %d%n" +
                "win ratio: %d / %d";

        return String.format(data, this.name, this.tag, this.age, this.numWins, this.numGames);
    }

    /**
     * @param tag [String] new player tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Increase number of games played by 1
     */
    public void addGamePlayed() {
        this.addGamePlayed(1);
    }

    /**
     * Increases the number of games played by the given number.
     *
     * @implNote Only use directly for testing or bulk updates
     *
     * @param numGames [int] number of games played
     */
    public void addGamePlayed(int numGames) {
        int totalGames = this.numGames + numGames;

        if (totalGames >= 0 && totalGames >= this.numWins) {
            this.numGames = totalGames;
        }
        else if (totalGames < 0) {
            throw new InvalidParameterException("NEGATIVE_GAMES: Total games after update is less than 0.");
        }
        else {
            throw new UnsupportedOperationException("MORE_WINS_THAN_GAMES: You cannot have more wins than games " +
                    "played.");
        }
    }

    /**
     * Increase number of wins by 1
     */
    public void addWin() {
        this.addWin(1);
    }

    /**
     * Increases the number of wins by the given number.
     *
     * @implNote Only use directly for testing or bulk updates.
     *
     * @param numWins [int] number of wins
     */
    public void addWin(int numWins) {
        int totalWins = this.numWins + numWins;

        if (totalWins >= 0 && totalWins <= this.numGames) {
            this.numWins = totalWins;
        }
        else if (totalWins < 0) {
            throw new InvalidParameterException("NEGATIVE_WINS: Total wins after update is less than 0.");
        }
        else {
            throw new UnsupportedOperationException("MORE_WINS_THAN_GAMES: You cannot have more wins than games " +
                    "played. Update number of games first.");
        }
    }
}
