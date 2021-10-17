package activities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13_2b {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		String filePath = "src/sample.xlsx";
		
		List<List<String>> data = Activity13_2b.readExcel(filePath);
		List<String> row;
		
		driver.get("https://www.training-support.net/selenium/simple-form");
		
		row = data.get(3);
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(row.get(1));
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(row.get(2));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(row.get(3));
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys(row.get(4));
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.close();

	}
	
	public static List<List<String>> readExcel (String filepath) {
		
		List<List<String>> data = new ArrayList<List<String>>();
		try {
			FileInputStream file = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				List<String> rowData = new ArrayList<String>();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(row.getLastCellNum() == 5) {
						rowData.add(cell.getStringCellValue());
					}
				}
				data.add(rowData);
			}
			file.close();
			workbook.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
