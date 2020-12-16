package filemanagement;

import java.io.File;
import java.io.IOException;

public class FileMain {

	public static void main(String[] args) {

		init();
		UserInterface ui = new UserInterface();
		ui.runTheApp();
		System.out.println("-------------");
		System.out.println("DONE");
		System.out.println("-------------");
	}

	public static void init() {
		File directory = new File(".\\my-current-directory");
		if (!directory.exists()) {
			directory.mkdir();
		}

		File file1 = new File(".\\my-current-directory/sample1.txt");
		if (!file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Couldn't make sample1.txt");
			}
		}

		File file2 = new File(".\\my-current-directory/sample2.txt");
		if (!file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Couldn't make sample2.txt");
			}
		}

		File file3 = new File(".\\my-current-directory/sample3.txt");
		if (!file3.exists()) {
			try {
				file3.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Couldn't make sample3.txt");
			}
		}
	}

}
