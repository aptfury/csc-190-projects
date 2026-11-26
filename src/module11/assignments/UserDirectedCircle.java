package module11.assignments;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.input.KeyCode;

import javafx.scene.layout.Pane;

import javafx.scene.shape.Circle;

import javafx.stage.Stage;

/**
 * @author Blake
 * @version 11.24.26
 *
 * <p>The class built for a module 11 project based on Exercise 15.11.</p>
 *
 * <p>Moves circle based on input from user's arrow keys.</p>
 *
 * <p>Exercise: Write a program that moves a circle up, down, left, or right using the arrow keys.</p>
 */
public class UserDirectedCircle extends Application {

    private static final double RADIUS = 25;
    private static final double STEP = 5;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPrefSize(300, 200);

        Circle circle = new Circle(150, 100, RADIUS);

        pane.getChildren().add(circle);

        pane.setOnKeyPressed(e -> {
           double x = circle.getCenterX();
           double y = circle.getCenterY();

           if (e.getCode() == KeyCode.UP && y - RADIUS - STEP >= 0) {
               circle.setCenterY(y - STEP);
           }
           else if (e.getCode() == KeyCode.DOWN && y + RADIUS + STEP <= pane.getHeight()) {
               circle.setCenterY(y + STEP);
           }
           else if (e.getCode() == KeyCode.LEFT && x - RADIUS - STEP >= 0) {
               circle.setCenterX(x - STEP);
           }
           else if (e.getCode() == KeyCode.RIGHT && x + RADIUS + STEP <= pane.getWidth()) {
               circle.setCenterX(x + STEP);
           }
        });

        Scene scene = new Scene(pane, 300, 200);

        primaryStage.setTitle("Exercise 15.11 - User Directed Circle");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus(); // note to self to remember this because it took me forever to realize I was missing it
    }

    public static void main(String[] args) {
        launch(args);
    }

}
