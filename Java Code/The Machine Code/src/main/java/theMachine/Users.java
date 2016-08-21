package main.java.theMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Users {
public static final String Separator = "-----";
	public static String User = "", Description = "", RecogType="";

	public static void setUser(String recognitionType,String username, String description) {
		User = username;
		Description = description;
		RecogType = recognitionType;

		new File(Assets.USERDATA).mkdir();
		PrintWriter out;
		try {
			out = new PrintWriter(Assets.UserDataStrings);
			out.println(Separator + RecogType + Separator + User + Separator + Description);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void getUser(File file){
		try {
			@SuppressWarnings("resource")
			String content = new Scanner(file).next();
			System.out.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
