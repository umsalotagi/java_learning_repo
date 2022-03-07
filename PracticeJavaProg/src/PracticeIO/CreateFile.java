package PracticeIO;
import java.io.File;
import java.io.IOException;


public class CreateFile {

	public static void main(String[] args) throws IOException {
		
		File f = new File("files" + File.separator + "myfile.txt");
		if (!f.exists()) {
			f.createNewFile();
			System.out.println("New file \"myfile.txt\" has been created to specified location");
			
		}
		
		System.out.println("path of file " + f.getAbsolutePath());

	}

}
