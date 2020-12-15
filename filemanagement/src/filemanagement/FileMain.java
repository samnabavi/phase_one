package filemanagement;

import java.io.File;

public class FileMain {
	
	
	public static void main(String[] args) {
		
		init();		
		UserInterface ui = new UserInterface();
		ui.runTheApp();

	}
	
	public static void init() {
		File directory = new File(".\\my-current-directory");
		if( !directory.exists() ) {
			directory.mkdir();
		}
	}

}
