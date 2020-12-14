package filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileManager implements FileManagerInterface {

	private List<File> fileList;
	
	public FileManager() {
		this.fileList = new ArrayList<File>();
		File currentDirectory = new File("./temp");
		this.getAllFiles(currentDirectory);
		Collections.sort(fileList);
		

		
	}
	@Override
	public void getAllFiles(File dir) {
		// TODO Auto-generated method stub
		
		for( File f: dir.listFiles()) {
			if(f.isFile()&& !f.isHidden() && !f.isDirectory()) {
				fileList.add(f);
			}
			//if(f.isDirectory() && !f.isHidden()) {
			//	this.getAllFiles(f);
			//}
		}
	}
	
	@Override
	public void showAllFiles() {
		Collections.sort(fileList);
		for( File f: fileList) {
			System.out.println(f.getPath());
		}
		
	}
	
	@Override
	public void addFile(File file) {
		if(!fileList.contains(file)) {
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
		} else {
			System.out.println("File " + file.getName() + " already exists.");
		}
		
	}

	@Override
	public void deleteFile(File file) {
		if(!fileList.contains(file)) {
			System.out.println("File " + file.toString() + " doesn't exit.");
		} else {
			fileList.remove(file);
			file.delete();

		}
	}

	@Override
	public void searchFile(File file) {
		if(!fileList.contains(file)) {
			System.out.println("File " + file.toString() + " doesn't exit.");
		} else {
			System.out.println("File " + file.toString() + " exits.");
		}
		
	}



	

}
