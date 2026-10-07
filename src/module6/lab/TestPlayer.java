package module6.lab;

/**
 * @author Blake
 * @version 10.07.26
 *
 * A class for a test player based on the player class.
 */
public class TestPlayer {
    private static Player player;

    /**
     * Initializes the test player, outputs player data, plays 50 games, outputs player data again.
     *
     * @param args [String[]] not used
     */
    public static void main(String[] args) {
        // init test player
        player = new Player("testPlayer", "testTag", 25);

        // output player data
        System.out.println(player.getData());

        // play 50 games
        playGame(50);

        // output player data again
        System.out.println(player.getData());
    }

    /**
     * The test player will play one game
     */
    public static void playGame() {
        playGame(1);
    }

    /**
     * The test player will play through the specified number of games and update their game and win counts accordingly.
     *
     * @implNote Only use directly for test cases or bulk player testing
     *
     * @param numGames [int] number of games
     */
    public static void playGame(int numGames) {
        for (int i = 0; i < numGames; i++) {
            player.addGamePlayed();

            double num = Math.random();

            if (num >= 0.5) {
                player.addWin();
            }
        }
    }

    /**
     * Reset all game states for the test player.
     */
    public static void reset() {
        // adds the negative of the current number to reset count to 0
        player.addWin(- player.getWins());
        player.addGamePlayed(- player.getGamesPlayed());
    }
}
