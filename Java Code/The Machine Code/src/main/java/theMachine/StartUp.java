package main.java.theMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.VideoInputFrameGrabber;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartUp extends Application {
	static Boolean isOpen = false;
	static String choice = null;
	public static void main(String[] args) {
		launch(args);

	}

	ArrayList<String> webCamOptions = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {

		String[] WebcamList = VideoInputFrameGrabber.getDeviceDescriptions();
		webCamOptions = new ArrayList<String>(Arrays.asList(WebcamList));
		if (webCamOptions.size() == 0) {
			Alert alert = new Alert(Alert.AlertType.ERROR, "NO WEBCAM DETECTED. MACHINE TERMINATING", ButtonType.OK);
			alert.setHeaderText("");
			alert.showAndWait();
			System.exit(1);

		}
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>(null, WebcamList);
		DialogPane dialogPane = dialog.getDialogPane();
		
		dialogPane.getStylesheets().add(this.getClass().getResource("THEMACHINE.css").toExternalForm());
		
		dialog.setOnCloseRequest(e -> isClosed());
		dialog.initStyle(StageStyle.UNDECORATED);
		dialog.setTitle("INPUT SELECTOR");
		
		 dialog.setGraphic(null);
		dialog.setHeaderText(null);

		dialog.setContentText("SELECT WEBCAM");

		Optional<String> result = dialog.showAndWait();
		result.ifPresent(letter -> {

			CreateUser.display();
			setChoice(letter);
		});
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