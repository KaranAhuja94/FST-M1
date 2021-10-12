package activities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity13_1 {

	public static void main(String[] args) throws IOException, CsvException {
		
		CSVReader reader = new CSVReader(new FileReader("src/data.csv"));
		
		List<String[]> list = reader.readAll();
		System.out.println("Number of rows: " + list.size());
		
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()) {
			
			String[] str = iterator.next();
			for(int i=0;i<str.length;i++) {
				
				System.out.print(str[i] + " ");
				
			}
			System.out.println(" ");
		}
		reader.close();
	}

}
