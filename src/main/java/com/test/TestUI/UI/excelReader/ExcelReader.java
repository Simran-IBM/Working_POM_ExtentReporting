package com.test.TestUI.UI.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class ExcelReader {
	
	public static final Logger log = Logger.getLogger(ExcelReader.class.getName());
	
	public FileOutputStream fileout = null;
	public String filepath;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell = null;
	int columns=0;
	String str="";
	ArrayList<String> loginValues = new ArrayList<String>();
	int j=0;
	
	
	public ExcelReader(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public ArrayList<String> getCellData(String filepath,String excelName,String sheetName, int rowNumber) {
	
		try {
			this.filepath=filepath;
			String filepath1 = filepath+excelName;
			fis = new FileInputStream(filepath1);
			workbook = new XSSFWorkbook(fis);
			
			
			
			int rows=workbook.getSheet(sheetName).getLastRowNum();
			log.info("Number of Rows populated in the Excel:"+rows);
			
			columns = workbook.getSheet(sheetName).getRow(0).getLastCellNum();	
			log.info("Number of Colums populated in the Excel:"+columns);
			if(rowNumber<=rows) {
				
				for(j=0;j<columns;j++) {
			str =workbook.getSheet(sheetName).getRow(rowNumber).getCell(j).getStringCellValue();
			loginValues.add(str);
			
			}
		}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return loginValues;
	}
}	
	


