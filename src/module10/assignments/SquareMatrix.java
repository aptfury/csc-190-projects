package module10.assignments;

import javafx.application.Application;

import javafx.geometry.Pos;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.util.Random;

/**
 * @author Blake
 * @version 11.07.26
 *
 * Displays a 10 x 10 Binary Matrix with the binaries randomly generated.
 */
public class SquareMatrix extends Application {
    private static final int MAX_COL = 10;
    private static final int MAX_ROW = 10;

    /**
     * Launches application.
     * @param args String[]
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Sets the stage and scene for launch.
     * @param primaryStage Stage - main stage
     */
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        // adds created text fields to the grid
        fillGrid(grid);

        Scene scene = new Scene(grid, 400, 300);

        primaryStage.setTitle("Binary Matrix");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Creates a text field that is randomly filled with either a 1 or 0.
     * @return TextField
     */
    private static TextField getTextFieldWithBinary() {
        TextField field = new TextField();

        int binary = new Random().nextInt(2);
        String text = String.valueOf(binary);

        field.setText(text);
        field.setAlignment(Pos.CENTER);

        return field;
    }

    /**
     * Fills the grid with text fields based on MAX_COL and MAX_ROW.
     * @param grid GridPane - the grid used in start method
     */
    private static void fillGrid(GridPane grid) {
        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                TextField field = getTextFieldWithBinary();
                grid.add(field, col, row);
            }
        }
    }

}
