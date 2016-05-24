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
				lib = new File(Assets.Windowsx64);
			} else {
				lib = new File(Assets.Windowsx86);
			}
		} else if (os.toUpperCase().contains("LINUX"))

		{
			if (bitness.endsWith("64")) {
				lib = new File(Assets.Linux);
			} else {
				lib = new File(Assets.Linux);
			}
		}else if (os.toUpperCase().contains("OS X"))

		{
			if (bitness.endsWith("64")) {
				lib = new File(Assets.Mac);
			} else {
				lib = new File(Assets.Mac);
			}
		}

		System.load(lib.getAbsolutePath());
	}
}