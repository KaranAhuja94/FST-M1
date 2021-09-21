package activities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity15 {
	
	private static final String FILE_NAME = "src/resources/Worksheet.xlsx";
	
	public static void main(String[] args) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
		
		Object[][] datatypes = {
				{"Datatype", "Type", "Size (in bytes)"},
				{"int", "Primitive", "2"},
				{"float", "Primitive", "4"},
				{"double", "Primitive", "8"},
				{"char", "Primitive", "1"},
				{"String", "Non-Primitive", "No fixed size"}
		};
		
		int row = 0;
		System.out.println("Creating excel");
		
		for(Object[] datatype : datatypes) {
			Row rowObj = sheet.createRow(row++);
			int column = 0;
			for (Object field : datatype) {
				Cell cellObj = rowObj.createCell(column++);
				if(field instanceof String) {
					cellObj.setCellValue((String)field);
				} else if (field instanceof Integer) {
					cellObj.setCellValue((Integer)field);
				}
					
			}
		}
		
		try {
			FileOutputStream streamObj = new FileOutputStream(FILE_NAME);
			workbook.write(streamObj);
			workbook.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		catch (IOException ex) {
			System.out.println(ex);
		}
		
		System.out.println("Done");
		
	}
	
	
}
