package theMachine.Webcam;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.*;
public class App {
	static {
		
		LoadLibrary.loadOpenCV();
	}
	

	private JFrame frame;
	private JLabel imageLabel;
	private CascadeClassifier faceDetector;
	private String icon = new String("resources/theMachine/images/Admin.png");
	ImageIcon img = new ImageIcon(icon);

	public static void main(String[] args) {
	
		App app = new App();
		app.initGUI();
		
		app.loadCascade();
		app.runMainLoop(args);
		 	 
	}

	private void initGUI() {
		frame = new JFrame("Locate Admin");
		frame.setSize(400, 400);
		imageLabel = new JLabel();
		frame.add(imageLabel);
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void loadCascade() {

		faceDetector = new CascadeClassifier("resources/theMachine/cascades/haarcascade_frontalface_alt2.xml");

	}

	private void runMainLoop(String[] args) {

		ImageProcessor imageProcessor = new ImageProcessor();
		Mat webcamMatImage = new Mat();
		Image tempImage;
		VideoCapture capture = new VideoCapture(0);
		capture.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 567);
		capture.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 358);
		if (capture.isOpened()) {
			while (true) {
				capture.read(webcamMatImage);
				if (!webcamMatImage.empty()) {
					detectAndDrawFace(webcamMatImage);
					tempImage = imageProcessor.toBufferedImage(webcamMatImage);
					ImageIcon imageIcon = new ImageIcon(tempImage, "Captured video");
					imageLabel.setIcon(imageIcon);
					frame.pack(); // this will resize the window to fit the
					
				} else {
					System.out.println(" -- Frame not captured -- Break!");
					break;
				}
				
			}
		} else {
			System.out.println("Couldn't open capture.");
		}
	}
	private void detectAndDrawFace(Mat image) {
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(image, faceDetections, 1.1, 7, 0, new Size(250, 40), new Size());
		// Draw a bounding box around each face.
		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(60, 233, 238));

		}
	}

}
