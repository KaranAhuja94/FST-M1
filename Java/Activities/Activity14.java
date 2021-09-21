package activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		try 
		{
			String data = null, newData = null;
			
			File file = new File("src/activities/test.txt");
			boolean status = file.createNewFile();
			if(status)
				System.out.println("File created");
			else
				System.out.println("File already exists or not created");
			
			File readFile = FileUtils.getFile("src/activities/test.txt");
			data = FileUtils.readFileToString(readFile, StandardCharsets.UTF_8);
			System.out.println("Data in file: " + data);
			
			File directory = new File("src/resources");
			FileUtils.copyFileToDirectory(file, directory, true);
			
			File readNewFile = FileUtils.getFile("src/resources/test.txt");
			newData = FileUtils.readFileToString(readNewFile, StandardCharsets.UTF_8);
			System.out.println("Data in new file: " + newData);
		}
		catch(IOException ex) {
			System.out.println(ex);
		}	
	}

}
