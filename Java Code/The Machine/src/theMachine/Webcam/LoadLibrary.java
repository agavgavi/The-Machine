package theMachine.Webcam;

import java.io.File;

public class LoadLibrary {
	public static void loadOpenCV() {
		File lib = null;
		String os = System.getProperty("os.name");
		String bitness = System.getProperty("sun.arch.data.model");

		if (os.toUpperCase().contains("WINDOWS"))

		{
			if (bitness.endsWith("64")) {
				lib = new File("resources/theMachine/opencv/windows/x64/opencv_java310.dll");
			} else {
				lib = new File("resources/theMachine/opencv/windows/x86/opencv_java310.dll");
			}
		} else if (os.toUpperCase().contains("LINUX"))

		{
			if (bitness.endsWith("64")) {
				lib = new File("resources/theMachine/opencv/linux/opencv_java300.so");
			} else {
				lib = new File("resources/theMachine/opencv/linux/opencv_java300.so");
			}
		}

		System.load(lib.getAbsolutePath());
	}
}