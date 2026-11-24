package module11;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.scene.shape.Circle;

import javafx.scene.text.Text;

import javafx.stage.Stage;

/**
 * @author Blake
 * @version 11.24.26
 *
 * <p>The class built for a module 11 project based on Exercise 15.12.</p>
 *
 * <p>Displays text based on whether a mouse is inside or outside of the circle.</p>
 *
 * <p>Exercise: Write a program that draws a fixed circle centered at (100, 60) with radius 50.
 * Whenever the mouse is moved, display a message indicating whether the mouse point is inside
 * the circle at the mouse point or outside of it, as shown in Figure 15.29a</p>
 */
public class InsideOfCircle extends Application {

    private static final double X = 100;
    private static final double Y = 60;
    private static final double RADIUS = 50;
    private static final String INSIDE_TEXT = "Mouse point is inside the circle.";
    private static final String OUTSIDE_TEXT = "Mouse point is outside the circle.";

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Circle circle = new Circle(X, Y, RADIUS);
        circle.setStyle("-fx-stroke: black; -fx-fill: transparent;");

        Text text = new Text("");

        pane.getChildren().addAll(circle, text);

        pane.setOnMouseMoved(e -> {
            double x = e.getX() - X;
            double y = e.getY() - Y;

            // set text based on distance from center
            text.setText(x * x + y * y < RADIUS * RADIUS ? INSIDE_TEXT : OUTSIDE_TEXT);

            text.setX(e.getX() + 12);
            text.setY(e.getY() + 12);
        });

        Scene scene = new Scene(pane, 300, 200);

        primaryStage.setTitle("Exercise 15.12 - Inside Of Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
