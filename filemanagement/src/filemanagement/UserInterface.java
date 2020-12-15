package filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {

	private FileManagerInterface fileManager;
	Scanner scan;

	public UserInterface() {
		fileManager = new FileManager();
	}

	public void runTheApp() {
		System.out.println("Welcome to the app!");
		System.out.println("Programer's name: Saman Nabavi");
		fileManager.showAllFiles();
		while (true) {

			this.regularOptions();
			scan = new Scanner(System.in);
			// int choice = -1;
			String choice = "";
			try {
				// choice = scan.nextInt();
				choice = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Oooops");
				continue;
			}

			if (choice.equals("1")) {
				fileManager.showAllFiles();
				continue;
			} else if (choice.equals("2")) {
				this.runTheEditOption();
				continue;
			} else if (choice.equals("3")) {
				return;
			} else {
				System.out.println("Ooops! Try Again");
				continue;
			}

		}
	}

	public void runTheEditOption() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			this.editOptions();
			// int choice = -1;
			String choice = "";
			try {
				// choice = sc.nextInt();
				choice = sc.nextLine();
			} catch (Exception e) {
				System.out.println("Oooops");
			}
			Scanner fname = new Scanner(System.in);
			String newFileName = "";
			File newFile = null;
			Pattern pattern = null;
			Matcher matcher = null;
			if (choice.equals("1")) {
				System.out.println("Enter the name of the file");
				fname = new Scanner(System.in);
				newFileName = fname.nextLine();
				pattern = Pattern.compile(".*\\.txt$");
				matcher = pattern.matcher(newFileName);
				if (matcher.matches()) {
					newFileName = "./my-current-directory/" + newFileName;
					newFile = new File(newFileName);
					fileManager.addFile(newFile);
					fileManager.showAllFiles();
				} else {
					System.out.println("You only can add a .txt file.");
				}
				continue;
			} else if (choice.equals("2")) {
				System.out.println("Enter the name of the file");
				fname = new Scanner(System.in);
				newFileName = fname.nextLine();
				newFileName = "./my-current-directory/" + newFileName;
				newFile = new File(newFileName);
				fileManager.deleteFile(newFile);
				fileManager.showAllFiles();
				continue;
			} else if (choice.equals("3")) {
				System.out.println("Enter the name of the file");
				fname = new Scanner(System.in);
				newFileName = fname.nextLine();
				newFileName = "./my-current-directory/" + newFileName;
				newFile = new File(newFileName);
				fileManager.searchFile(newFile);
				fileManager.showAllFiles();
				continue;
			} else if (choice.equals("4")) {
				return;
			} else {
				System.out.println("Ooops! Try Again");
				continue;
			}

		}
	}

	public void regularOptions() {
		System.out.println("Please choose one of the options.");
		System.out.println("(1) See all the files in the list.");
		System.out.println("(2) Edit file list.");
		System.out.println("(3) Exit the program.");
	}

	public void editOptions() {
		System.out.println("Please choose one of the options.");
		System.out.println("(1) Add a file to the list.");
		System.out.println("(2) Delete a file from the list.");
		System.out.println("(3) Search for an existing file.");
		System.out.println("(4) Return to main options.");
	}
}
