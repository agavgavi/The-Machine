package main.java.theMachine;

import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class CreateUser {

	public static String User = null;
	public static String Discription = null;

	public static void display() {
		Dialog<Pair<String, String>> dialog1 = new Dialog<>();
		dialog1.setTitle("Login Dialog");
		dialog1.setHeaderText("Look, a Custom Login Dialog");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog1.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField username = new TextField();
		username.setPromptText("Username");
		TextArea discription = new TextArea();
		discription.setPrefWidth(200);
		discription.setPrefHeight(100);
		discription.setPromptText("Write your name here if you do not want anything special in the discription");
		discription.setWrapText(true);
		

		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Discription:"), 0, 1);
		grid.add(discription, 1, 1);

		// Enable/Disable login button depending on whether a username was
		// entered.
		Node loginButton = dialog1.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog1.getDialogPane().setContent(grid);

		// Request focus on the username field by default.
		Platform.runLater(() -> username.requestFocus());

		// Convert the result to a username-password-pair when the login button
		// is clicked.
		dialog1.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(username.getText(), discription.getText());
			}
			return null;
		});

		Optional<Pair<String, String>> result1 = dialog1.showAndWait();

		result1.ifPresent(usernamePassword -> {
			User = usernamePassword.getKey();
			Discription = usernamePassword.getValue();
			

		});

	}

}
