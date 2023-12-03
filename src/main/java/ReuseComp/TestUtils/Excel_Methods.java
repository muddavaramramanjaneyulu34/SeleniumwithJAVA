package ReuseComp.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;



public class Excel_Methods {
	

	//public static String testDataFile=Registration_Methods.testDataFilePath;

	
	
	public static  Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
	        throws IOException {
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputStream);
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputStream);
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	 
	    return workbook;
	}

	
	public  String getDataFromPropertieFile(String name) throws IOException
	
	{
		Properties prop=new Properties();
		InputStream input=new FileInputStream(System.getProperty("user.dir")+"/ConfigFile/Config.properties");
		prop.load(input);
		
		String value=prop.getProperty(name);
		
		return value;
	}
	
	public static String getXpathFromSheet(String testDataFile,String sheetName,String elementName, int rowNo) throws IOException
	{
		System.out.println("Test Data Path from Excel Metods: "+testDataFile);
		String xpath=null;
		FileInputStream inputStream = new FileInputStream(new File(testDataFile));
		 
		Workbook workbook = getWorkbook(inputStream, testDataFile);
		//int numberOfSheets = workbook.getNumberOfSheets();
		Sheet sheet = workbook.getSheet(sheetName);
		Row firstRow=sheet.getRow(rowNo);
		
		for(int i=0;i<firstRow.getPhysicalNumberOfCells();i++)
		{
			String cellData=firstRow.getCell(i).toString();
			
			if(cellData.equalsIgnoreCase(elementName)) {
				Row secondRow=sheet.getRow(rowNo+1);
				
				 xpath=secondRow.getCell(i).toString();
				 break;
			}
			//System.out.println(elementName+" xpath: "+xpath);
		}
		
		return xpath;
	}

	
	public static String getDataFromTestDataSheet(String testDataFile,String sheetName,String tcName,int colNo) throws IOException
	
	
	{
		
		
		//System.out.println("Test Case Number: "+tcName);
		String data=null;
		FileInputStream inputStream = new FileInputStream(new File(testDataFile));
		 
		Workbook workbook = getWorkbook(inputStream, testDataFile);
		//int numberOfSheets = workbook.getNumberOfSheets();
		Sheet sheet = workbook.getSheet(sheetName);
		
		
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
		{
			Row firstRow=sheet.getRow(i);
			
			String sNoData=firstRow.getCell(0).toString().trim();
			
			//System.out.println("sNoData: "+sNoData);
			if(sNoData.equalsIgnoreCase(tcName)) {
				 data=firstRow.getCell(colNo).toString();
				// System.out.println("Data from TestData Sheet: "+data);
				
				 break;
			}
			
		}
		
		return data;
	}
	
	
}
