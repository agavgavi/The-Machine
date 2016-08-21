package main.java.theMachine;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class App extends Assets {
	boolean isOpen = true;

	static {
		LoadLibrary.loadOpenCV();
	}

	ImageProcessor imageProcessor = new ImageProcessor();
	Mat webcamMatImage = new Mat();
	Image tempImage;
	VideoCapture capture = new VideoCapture(0);
	private static JFrame frame;
	int x = 1;
	private JLabel imageLabel;

	private CascadeClassifier faceDetector;
	static ImageIcon icon = new ImageIcon(AdminImage);

	public static void main(String[] args) {

		App app = new App();

		if (Users.User.isEmpty()) {
			StartUp.main(args);
			App.closeProgramBeforeWindow(StartUp.isClosed(), CreateUser.isClosed());

		}
		app.initGUI();
		app.loadCascade();
		app.runMainLoop(args);

	}

	public static void closeProgramBeforeWindow(Boolean bool, Boolean bool2) {
		if (bool == true | bool2 == true) {
			System.exit(0);
		}

	}

	private void initGUI() {
		frame = new JFrame("Locate Admin");
		frame.setSize(400, 400);
		imageLabel = new JLabel("Test");
		imageLabel.setFont(FuturaUppercaseMedium);
		frame.add(imageLabel);
		frame.setIconImage(icon.getImage());
		Users.getUser(new File(Assets.UserDataStrings));
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				isOpen = false;
				System.exit(0);
			}
		});

		frame.setVisible(true);

	}

	private void loadCascade() {

		faceDetector = new CascadeClassifier(Cascade);

	}

	private void runMainLoop(String[] args) {

		capture.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 640);
		capture.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 480);
		if (capture.isOpened()) {
			while (isOpen == true) {

				capture.read(webcamMatImage);
				if (!webcamMatImage.empty()) {
					detectAndDrawFace(webcamMatImage);
					tempImage = imageProcessor.toBufferedImage(webcamMatImage);
					ImageIcon imageIcon = new ImageIcon(tempImage, "Captured video");

					imageLabel.setIcon(imageIcon);

					frame.pack(); // this will resize the window to fit the

				} else {

					System.out.println(" -- Frame not captured -- Break!");

				}

			}
		} else {
			System.out.println("Webcam not found or could not load Capture");
			System.exit(0);
		}

	}

	private void detectAndDrawFace(Mat image) {

		MatOfRect faceDetections = new MatOfRect();

		faceDetector.detectMultiScale(image, faceDetections, 1.1, 7, 0, new Size(250, 40), new Size());
		// Draw a bounding box around each face.
		for (Rect rect : faceDetections.toArray()) {

			
			
			Imgproc.putText(image, Users.User, new Point(rect.x + rect.width + 10, rect.y + 100), 0, 1,
					new Scalar(60, 233, 238), 2);
			Imgproc.putText(image, Users.Description, new Point(rect.x + rect.width + 10, rect.y + 150), 0, 1,
					new Scalar(60, 233, 238), 2);
			Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(60, 233, 238),2);
		}
	}

}
