package filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager implements FileManagerInterface {

	private List<File> fileList;
	// private List<String> fileNames;

	public FileManager() {
		this.fileList = new ArrayList<File>();
		// this.fileNames = new ArrayList<String>();
		File currentDirectory = new File("./my-current-directory");
		this.getAllFiles(currentDirectory);
		// for(File f : fileList) {
		// fileNames.add(f.getName());
		// }
		Collections.sort(fileList);
		// Collections.sort(fileNames);

	}

	@Override
	public void getAllFiles(File dir) {
		// TODO Auto-generated method stub

		for (File f : dir.listFiles()) {
			if (f.isFile() && !f.isHidden() && !f.isDirectory()) {
				fileList.add(f);
			}
			// if(f.isDirectory() && !f.isHidden()) {
			// this.getAllFiles(f);
			// }
		}
	}

	@Override
	public void showAllFiles() {
		Collections.sort(fileList);
		for (File f : fileList) {
			System.out.println("File: '" + f.getName() + "' in " + f.getPath());
		}

	}

	@Override
	public void addFile(File file) {
		if (!fileList.contains(file)) {
			if (!file.exists()) {
				try {
					file.createNewFile();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fileList.add(file);
			System.out.println("File " + file.getName() + " added.");
			System.out.println("-----------------------------------");
		} else {
			System.out.println("File " + file.getName() + " already exists.");
			System.out.println("-----------------------------------");
		}

	}

	@Override
	public void deleteFile(File file) {
		if (!fileList.contains(file)) {
			System.out.println("File " + file.getName() + " doesn't exit.");
			System.out.println("-----------------------------------");
		} else {
			System.out.println("File " + file.getName() + " deleted.");
			System.out.println("-----------------------------------");
			fileList.remove(file);
			file.delete();

		}
	}

	@Override
	public void searchFile(File file) {
		if (!fileList.contains(file)) {
			System.out.println("File " + file.getName() + " doesn't exit.");
			System.out.println("-----------------------------------");
		} else {
			System.out.println("File " + file.getName() + " exits in " + file.getPath());
			System.out.println("-----------------------------------");
		}

	}

}
