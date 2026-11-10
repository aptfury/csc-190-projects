package module10.assignments;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import javafx.stage.Stage;

/**
 * @author Blake
 * @version 11.06.26
 *
 * A test for a logo and login example I want to prompt Thaura for in my AI assignment.
 * Not providing in depth comments since this isn't an assignment submission and was purely
 * experimental.
 */
public class LogoLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(12);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Group logo = buildBearLogo();

        Label titleLabel = new Label("Teddy Bank");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setMaxWidth(220);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMaxWidth(220);

        Button loginButton = new Button("Log In");
        loginButton.setMaxWidth(220);

        loginButton.setOnAction(e -> {
            if (usernameField.getText().equals("student") && passwordField.getText().equals("java")) {
                showAlert(Alert.AlertType.INFORMATION, "Welcome back, " + usernameField.getText() + "!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Invalid username or password.");
            }
        });

        root.getChildren().addAll(logo, titleLabel, usernameField, passwordField, loginButton);

        Scene scene = new Scene(root, 320, 420);
        primaryStage.setTitle("Teddy Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static Group buildBearLogo() {
        Color fur = Color.rgb(139, 90, 43);
        Color innerEar = Color.rgb(210, 166, 121);
        Color muzzle = Color.rgb(230, 200, 170);

        // Ears
        Circle leftEar = new Circle(58, 68, 24, fur);
        Circle rightEar = new Circle(142, 68, 24, fur);
        Circle leftInnerEar = new Circle(58, 68, 12, innerEar);
        Circle rightInnerEar = new Circle(142, 68, 12, innerEar);

        // Head
        Circle head = new Circle(100, 122, 56, fur);

        // Eyes
        Circle leftEye = new Circle(82, 112, 6, Color.BLACK);
        Circle rightEye = new Circle(118, 112, 6, Color.BLACK);

        // Muzzle and nose
        Ellipse muzzleShape = new Ellipse(100, 142, 28, 20);
        muzzleShape.setFill(muzzle);
        Ellipse nose = new Ellipse(100, 131, 9, 6);
        nose.setFill(Color.rgb(60, 35, 20));

        // Smile
        Arc smile = new Arc(100, 136, 14, 10, 180, 180);
        smile.setType(ArcType.OPEN);
        smile.setStroke(Color.rgb(60, 35, 20));
        smile.setStrokeWidth(2.5);
        smile.setFill(Color.TRANSPARENT);

        return new Group(leftEar, rightEar, leftInnerEar, rightInnerEar, head, leftEye, rightEye, muzzleShape, nose,
                smile);
    }

    private static void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
