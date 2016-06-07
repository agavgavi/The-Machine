package main.java.theMachine;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Assets {

// Folders
	public static final String Resources = "resources";
	public static final String Images = Resources + File.separator + "images";
	public static final String Fonts = Resources + File.separator + "fonts";
	public static final String OpenCV = Resources + File.separator + "opencv";
	public static final String Cascade = Resources + File.separator + "cascades" + File.separator
			+ "haarcascade_frontalface_alt2.xml";
	public static final String USERDATA = Resources + File.separator + "USERDATA";

// Image Locations
	public static final String AdminImage = Images + File.separator + "Admin.png";
	public static final String SecondaryImage = Images + File.separator + "Secondary.png";
	public static final String AnalogImage = Images + File.separator + "Analog Interface.png";
	public static final String ThreatImage = Images + File.separator + "Threat.png";

	private static enum ImageTypes {
		admin, secondary, analog, threat
	}

// OpenCV Stuff
	public static final String Windows = OpenCV + File.separator + "windows";
	public static final String Linux = OpenCV + File.separator + "linux/opencv_java310.so";
	public static final String Mac = OpenCV + File.separator + "mac/libopencv_java300.dylib";
	public static final String Windowsx64 = Windows + File.separator + "x64/opencv_java310.dll";
	public static final String Windowsx86 = Windows + File.separator + "x86/opencv_java310.dll";

// Images
	public static final Image Admin = loadImage(ImageTypes.admin);
	public static final Image Secondary = loadImage(ImageTypes.secondary);
	public static final Image Analog = loadImage(ImageTypes.analog);
	public static final Image Threat = loadImage(ImageTypes.threat);

	// Fonts
	public static final String FUTURA_LOWERCASE = Fonts + File.separator + "Futura Lowercase.ttf";
	public static final Font FuturaLowercaseSmall = createFonts("FUTURA_LOWERCASE_12");
	public static final Font FuturaLowercaseMedium = createFonts("FUTURA_LOWERCASE_24");
	public static final Font FuturaLowercaseLarge = createFonts("FUTURA_LOWERCASE_48");
	public static final Font FuturaLowercaseTiny = createFonts("FUTURA_LOWERCASE_8");

	public static final String FUTURA_UPPERCASE = Fonts + File.separator + "Futura Uppercase.ttf";
	public static final Font FuturaUppercaseSmall = createFonts("FUTURA_UPPERCASE_12");
	public static final Font FuturaUppercaseMedium = createFonts("FUTURA_UPPERCASE_24");
	public static final Font FuturaUppercaseLarge = createFonts("FUTURA_UPPERCASE_48");
	public static final Font FuturaUppercaseTiny = createFonts("FUTURA_UPPERCASE_8");
	public static final File fu = new File(FUTURA_UPPERCASE);

	public static final String FUTURA_ITALICIZED = Fonts + File.separator + "Futura Italicized.ttf";
	public static final Font FuturaItalicizedSmall = createFonts("FUTURA_ITALICIZED_12");
	public static final Font FuturaItalicizedMedium = createFonts("FUTURA_ITALICIZED_24");
	public static final Font FuturaItalicizedLarge = createFonts("FUTURA_ITALICIZED_48");
	public static final Font FuturaItalicizedTiny = createFonts("FUTURA_ITALICIZED_8");
	public static final File fi = new File(FUTURA_ITALICIZED);

	public static Image loadImage(ImageTypes image) {
		try {
			if (image == ImageTypes.admin) {
				return SwingFXUtils.toFXImage(ImageIO.read(new File(AdminImage)), null);
			} else if (image == ImageTypes.secondary) {
				return SwingFXUtils.toFXImage(ImageIO.read(new File(SecondaryImage)), null);
			} else if (image == ImageTypes.analog) {
				return SwingFXUtils.toFXImage(ImageIO.read(new File(AnalogImage)), null);
			} else if (image == ImageTypes.threat) {
				return SwingFXUtils.toFXImage(ImageIO.read(new File(ThreatImage)), null);
			} else {
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Font createFonts(String fontname) {
		try {

// LOWERCASE
			if (fontname == "FUTURA_LOWERCASE_12") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_LOWERCASE)).deriveFont(12f);
			} else if (fontname == "FUTURA_LOWERCASE_24") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_LOWERCASE)).deriveFont(24f);
			} else if (fontname == "FUTURA_LOWERCASE_48") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_LOWERCASE)).deriveFont(48f);
			} else if (fontname == "FUTURA_LOWERCASE_8") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_LOWERCASE)).deriveFont(8f);
			}

// UPPERCASE
			else if (fontname == "FUTURA_UPPERCASE_12") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_UPPERCASE)).deriveFont(12f);
			} else if (fontname == "FUTURA_UPPERCASE_24") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_UPPERCASE)).deriveFont(24f);
			} else if (fontname == "FUTURA_UPPERCASE_48") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_UPPERCASE)).deriveFont(48f);
			} else if (fontname == "FUTURA_UPPERCASE_8") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_UPPERCASE)).deriveFont(8f);
			}

// ITALICIZED
			else if (fontname == "FUTURA_ITALICIZED_12") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_ITALICIZED)).deriveFont(12f);
			} else if (fontname == "FUTURA_ITALICIZED_24") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_ITALICIZED)).deriveFont(24f);
			} else if (fontname == "FUTURA_ITALICIZED_48") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_ITALICIZED)).deriveFont(48f);
			} else if (fontname == "FUTURA_ITALICIZED_8") {
				return Font.createFont(Font.TRUETYPE_FONT, new File(FUTURA_ITALICIZED)).deriveFont(8f);
			} else {
				return null;
			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		return null;

	}

}