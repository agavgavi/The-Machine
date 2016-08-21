package main.java.theMachine;


import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import javafx.util.Pair;

public class CreateUser {

	public static String User, Description = "";
	public static String choice = null;
	static CreateUser createUser = new CreateUser();

	public static void display() {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(createUser.getClass().getResource("THEMACHINE.css").toExternalForm());
		

		dialog.setTitle("CREATE USER");
		dialog.setHeaderText("CREATE IDENTITY");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("CREATE ASSET", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		dialog.initStyle(StageStyle.UNDECORATED);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));


		TextField username = new TextField();
		username.setPromptText("Username");

		TextArea description = new TextArea();
		description.setPrefWidth(200);
		description.setPrefHeight(100);
		description.setPromptText("Write your name here if you do not want anything special in the description");
		description.setWrapText(true);

		Label nameLabel = new Label("ALIAS:");
		Label descriptionLabel = new Label("DESCRIPTION:");

		nameLabel.setFont(Font.loadFont("file:resources/fonts/Futura-Lowercase.ttf", 16));
		username.setFont(Font.loadFont("file:resources/fonts/Futura-Lowercase.ttf", 16));
		description.setFont(Font.loadFont("file:resources/fonts/Futura-Lowercase.ttf", 16));
		descriptionLabel.setFont(Font.loadFont("file:resources/fonts/Futura-Lowercase.ttf", 16));

		
		grid.add(nameLabel, 0, 0);
		grid.add(username, 1, 0);
		grid.add(descriptionLabel, 0, 1);
		grid.add(description, 1, 1);

		// Enable/Disable login button depending on whether a username was
		// entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		// Request focus on the username field by default.
		Platform.runLater(() -> username.requestFocus());

		// Convert the result to a username-password-pair when the login button
		// is clicked.
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(username.getText(), description.getText());
			}
			return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(usernamePassword -> {
			User = usernamePassword.getKey();
			Description = usernamePassword.getValue();

			Users.setUser("ADMIN", User, Description);

			setChoice(usernamePassword.getKey());

		});
		dialog.setOnCloseRequest(e -> isClosed());

	}

	public static void setChoice(String string) {
		choice = string;
	}

	public static boolean isClosed() {
		if (choice == null) {
			return true;
		} else {
			return false;
		}
	}

}
