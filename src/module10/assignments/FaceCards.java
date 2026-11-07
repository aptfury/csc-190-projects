package module10.assignments;

import java.util.Random;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.image.ImageView;

import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * @author Blake
 * @version 11.07.26
 *
 * An application that will display three random playing cards face up on launch.
 */
public class FaceCards extends Application {

    /**
     * Launches the application.
     * I put this at the top to see if it still works that way.
     * @param args Unused args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method with the content the application launches.
     * @param primaryStage Base stage for application
     */
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        HBox hbox = new HBox();

        ImageView cardOne = getCardImage();
        ImageView cardTwo = getCardImage();
        ImageView cardThree = getCardImage();

        hbox.getChildren().addAll(cardOne, cardTwo, cardThree);

        hbox.setPadding(new Insets(30));
        hbox.setSpacing(10);

        pane.getChildren().add(hbox);

        Scene scene = new Scene(pane, 300, 150);

        primaryStage.setTitle("Face Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Generates a random number between 1 and 54. Used to get card number.
     *
     * @return int - card number
     */
    private static int getCardNumber() {
        Random random = new Random();
        return random.nextInt(54) + 1;
    }

    /**
     * Create image based on a random number.
     *
     * @return ImageView - image of card
     */
    private static ImageView getCardImage() {
        int cardNumber = getCardNumber();

        String cardFile = String.format("module10/assignments/image/card/%d.png", cardNumber);

        return new ImageView(cardFile);
    }

}
