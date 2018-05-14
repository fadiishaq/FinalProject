package edu.bu.FinalProjectMaven;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

class Encryption {
	public static void main(String args[]) {

		File file = new File("D:\\java-oxygen\\eclipse\\projects\\FinalProjectMaven\\admins.txt");
		File encryptedFile = new File("D:\\java-oxygen\\eclipse\\projects\\FinalProjectMaven\\encryptedAdmins.txt");

		encrypt(file, encryptedFile);
	}

	public static void encrypt(File file, File encryptedFile) {

		if (!encryptedFile.exists()) {
			try {

				encryptedFile.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Scanner scanner = null;
		PrintWriter writer = null;
		try {

			scanner = new Scanner(file);
			writer = new PrintWriter(new FileWriter(encryptedFile));

		} catch (Exception e2) {
			e2.printStackTrace();
		}

		String str = " ";

		str = scanner.nextLine();

		str = str.replaceAll("a", "36");
		str = str.replaceAll("b", "35");
		str = str.replaceAll("c", "34");
		str = str.replaceAll("d", "33");
		str = str.replaceAll("e", "32");
		str = str.replaceAll("f", "31");
		str = str.replaceAll("g", "30");
		str = str.replaceAll("h", "29");
		str = str.replaceAll("i", "28");
		str = str.replaceAll("j", "27");
		str = str.replaceAll("k", "26");
		str = str.replaceAll("l", "25");
		str = str.replaceAll("m", "24");
		str = str.replaceAll("n", "23");
		str = str.replaceAll("o", "22");
		str = str.replaceAll("p", "21");
		str = str.replaceAll("q", "20");
		str = str.replaceAll("r", "19");
		str = str.replaceAll("s", "18");
		str = str.replaceAll("t", "17");
		str = str.replaceAll("u", "16");
		str = str.replaceAll("v", "15");
		str = str.replaceAll("w", "14");
		str = str.replaceAll("x", "13");
		str = str.replaceAll("y", "12");
		str = str.replaceAll("z", "11");

		System.out.println("encrypted string: " +str);
		writer.print(str);
		writer.close();

	}

}