package filemanagement;
import java.io.File;

public interface FileManagerInterface {

	public void getAllFiles(File dir);
	public void showAllFiles();
	public void addFile(File file);
	public void deleteFile(File file);
	public void searchFile(File file);
}
