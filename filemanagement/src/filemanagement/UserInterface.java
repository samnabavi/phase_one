package filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
			int choice = -1;
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Oooops");
				continue;
			}

			switch (choice) {
			case 1:
				fileManager.showAllFiles();
				continue;
			case 2:
				this.runTheEditOption();
				continue;
			case 3:
				return;
			default:
				System.out.println("Wrong number");
			}

		}
	}

	public void runTheEditOption() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			this.editOptions();
			int choice = -1;
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Oooops");
			}
			Scanner fname = new Scanner(System.in);
			String newFileName = "";
			File newFile = null;
			switch (choice) {
			case 1:
				System.out.println("Enter the name of the file");
				fname = new Scanner(System.in);
				newFileName = fname.nextLine();
				newFileName = "./temp/" + newFileName;
				newFile = new File(newFileName);
				fileManager.addFile(newFile);
				/*if (!newFile.exists()) {
					try {
						newFile.createNewFile();
						fileManager.addFile(newFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
				fileManager.showAllFiles();
				continue;
			case 2:
				System.out.println("Enter the name of the file");
				fname = new Scanner(System.in);
				newFileName = fname.nextLine();
				newFileName = "./temp/" + newFileName;
				newFile = new File(newFileName);
				fileManager.deleteFile(newFile);
				fileManager.showAllFiles();
				continue;
			case 3:
				System.out.println("Enter the name of the file");
				fname = new Scanner(System.in);
				newFileName = fname.nextLine();
				newFileName = "./temp/" + newFileName;
				newFile = new File(newFileName);
				fileManager.searchFile(newFile);
				fileManager.showAllFiles();
				continue;
			case 4:
				return;
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
