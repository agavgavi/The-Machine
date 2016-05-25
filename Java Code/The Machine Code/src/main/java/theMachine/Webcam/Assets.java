package main.java.theMachine.Webcam;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Assets {

	// Folders
	public static String Resources = "resources";
	public static String Images = Resources + File.separator + "images";
	public static String Fonts = Resources + File.separator + "fonts";
	public static String OpenCV = Resources + File.separator + "opencv";
	public static String Cascade = Resources + File.separator + "cascades"
			+ File.separator + "haarcascade_frontalface_alt2.xml";

	// Image Locations
	public static String AdminImage = Images + File.separator + "Admin.png";
	public static String SecondaryImage = Images + File.separator + "Secondary.png";
	public static String AnalogImage = Images + File.separator + "Analog Interface.png";
	public static String ThreatImage = Images + File.separator + "Threat.png";

	private enum ImageTypes {
		admin, secondary, analog, threat
	}

	// OpenCV Stuff
	public static String Windows = OpenCV + File.separator + "windows";
	public static String Linux = OpenCV + File.separator + "linux/libopencv_java300.so";
	public static String Mac = OpenCV + File.separator + "mac/libopencv_java300.dylib";
	public static String Windowsx64 = Windows + File.separator + "x64/opencv_java310.dll";
	public static String Windowsx86 = Windows + File.separator + "x86/opencv_java310.dll";

	// Images
	public static Image Admin = loadImage(ImageTypes.admin);
	public static Image Secondary = loadImage(ImageTypes.secondary);
	public static Image Analog = loadImage(ImageTypes.analog);
	public static Image Threat = loadImage(ImageTypes.threat);

	public static Image loadImage(ImageTypes image) {
		try {
			switch (image) {
			case admin:
				return SwingFXUtils.toFXImage(ImageIO.read(new File(AdminImage)), null);
			case secondary:
				return SwingFXUtils.toFXImage(ImageIO.read(new File(SecondaryImage)), null);
			case analog:
				return SwingFXUtils.toFXImage(ImageIO.read(new File(AnalogImage)), null);
			case threat:
				return SwingFXUtils.toFXImage(ImageIO.read(new File(ThreatImage)), null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}