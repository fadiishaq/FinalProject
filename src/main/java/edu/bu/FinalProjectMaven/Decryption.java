package edu.bu.FinalProjectMaven;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Decryption {
	public static void main(String args[]) {

		File encryptedFile = new File("encryptedAdminsFile.txt");
		File decryptedFile = new File("decryptedAdmins.txt");

		if (!encryptedFile.exists()) {
			System.out.println("cant find enc file");
		}
		if (!decryptedFile.exists()) {
			try {

				decryptedFile.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		decrypt(encryptedFile, decryptedFile);
	}

	public static void decrypt(File decryptedFile, File encryptedFile) {

		
		
		String str = null;

		
		
		Scanner scanner = null;
		PrintWriter writer = null;

		try {

			scanner = new Scanner(encryptedFile);
			
			writer = new PrintWriter(decryptedFile);
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		try {

			str = scanner.nextLine();
			scanner.close();

//			if(!str.equals(null)) {
			str = str.replace("36", "a");
			str = str.replace("35", "b");
			str = str.replace("34", "c");
			str = str.replace("33", "d");
			str = str.replace("32", "e");
			str = str.replace("31", "f");
			str = str.replace("30", "g");
			str = str.replace("29", "h");
			str = str.replace("28", "i");
			str = str.replace("27", "j");
			str = str.replace("26", "k");
			str = str.replace("25", "l");
			str = str.replace("24", "m");
			str = str.replace("23", "n");
			str = str.replace("22", "o");
			str = str.replace("21", "p");
			str = str.replace("20", "q");
			str = str.replace("19", "r");
			str = str.replace("18", "s");
			str = str.replace("17", "t");
			str = str.replace("16", "u");
			str = str.replace("15", "v");
			str = str.replace("14", "w");
			str = str.replace("13", "x");
			str = str.replace("12", "y");
			str = str.replace("11", "z");
//			}
		/*	else
		*/		System.out.println("== null :/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The decrypted string is: " + str);
		
		writer.print(str);
		writer.close();
	}
}