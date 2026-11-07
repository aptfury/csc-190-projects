package module10.assignments;

import javafx.application.Application;

import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;

import javafx.scene.Scene;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;

/**
 * @author Blake
 * @version 11.07.26
 *
 * A house created out of basic shapes and paint using javafx.
 */
public class PaintShapes extends Application {

    /**
     * The start method with the content the application launches.
     * @param primaryStage Base stage for application
     */
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // must be added in this order to stack appropriately
        // no, I don't want to talk about how long it took me to realize that
        pane.getChildren().addAll(createSun(), createBody(), createRoof(), createDoor(), createWindow(), createDoorknob());

        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("PaintShapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the application.
     * @param args Unused args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates the sun for the house scene.
     * @return Circle
     */
    private static Circle createSun() {
        Circle sun = new Circle(340, 60, 30);
        sun.setFill(Color.GOLD);
        sun.setStroke(Color.BLACK);
        return sun;
    }

    /**
     * Creates the main house background, excluding the roof.
     * @return Rectangle
     */
    private static Rectangle createBody() {
        Rectangle body = new Rectangle(100, 160, 200, 100);
        body.setFill(Color.WHEAT);
        body.setStroke(Color.BLACK);
        return body;
    }

    /**
     * Creates the roof part of the main house background.
     * @return Polygon
     */
    private static Polygon createRoof() {
        Polygon roof = new Polygon(90, 160, 310, 160, 200, 80);
        roof.setFill(Color.SADDLEBROWN);
        roof.setStroke(Color.BLACK);
        return roof;
    }

    /**
     * Creates the door for the house.
     * @return Rectangle
     */
    private static Rectangle createDoor() {
        Rectangle door = new Rectangle(180, 200, 40, 60);
        door.setFill(Color.CHOCOLATE);
        door.setStroke(Color.BLACK);
        return door;
    }

    /**
     * Creates a window for the house (made out of an ellipse instead of rectangle because I needed a fourth shape,
     * don't judge me).
     * @return Ellipse
     */
    private static Ellipse createWindow() {
        Ellipse window = new Ellipse(140, 200, 15, 10);
        window.setFill(Color.SKYBLUE);
        window.setStroke(Color.BLACK);
        return window;
    }

    /**
     * Creates the doorknob for the door.
     * @return Circle
     */
    private static Circle createDoorknob() {
        Circle knob = new Circle(212, 230, 4);
        knob.setFill(Color.BLACK);
        return knob;
    }
}
