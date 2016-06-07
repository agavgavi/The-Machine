package main.java.theMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.bytedeco.javacv.VideoInputFrameGrabber;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartUp extends Application {

	public static void main(String[] args) {
		launch(args);
		
	}

	ArrayList<String> webCamOptions = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {

		String[] deviceList = VideoInputFrameGrabber.getDeviceDescriptions();
		webCamOptions = new ArrayList<String>(Arrays.asList(deviceList));
		if (webCamOptions.size() == 0) {
			Alert alert = new Alert(Alert.AlertType.ERROR, "NO WEBCAM DETECTED. MACHINE TERMINATING", ButtonType.OK);
			alert.setHeaderText("");
			alert.showAndWait();
			System.exit(1);

		}
		ChoiceDialog<String> dialog = new ChoiceDialog<>("", deviceList);

		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.setTitle("Webcam Selector");
		// dialog.setGraphic(null);
		dialog.setHeaderText("");
		dialog.setContentText("Webcam Selector");
		
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(letter -> CreateUser.display());

	}

}