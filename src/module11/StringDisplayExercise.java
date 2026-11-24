package module11;

import javafx.application.Application;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import javafx.scene.text.Text;

import javafx.stage.Stage;

/**
 * @author Blake
 * @version 11.24.26
 *
 * <p>The class built for a module 11 project based on Exercise 15.10.</p>
 *
 * <p>Displays a string once it's been entered into a textbox.</p>
 *
 * <p>Exercise: Write a program that receives a string from the keyboard and displays it on a pane. The Enter key
 * signals the end of a string. Whenever a new string is entered, it is displayed on the pane.</p>
 */
public class StringDisplayExercise extends Application {

    private Text text = new Text("");

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane(this.text);

        TextField field = new TextField();
        field.setAlignment(Pos.CENTER);
        field.setOnAction(e -> text.setText(field.getText()));

        BorderPane root = new BorderPane();
        BorderPane.setAlignment(field, Pos.CENTER);
        root.setCenter(pane);
        root.setBottom(field);

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Exercise 15.10 - String Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
