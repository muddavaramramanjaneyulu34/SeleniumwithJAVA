package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseTest {

	public static String testDataFile;
	
	
public List<String> getUrls(String testName) throws IOException {
		
		List<String> urls=new ArrayList<String>();
		for(int i=1;i<=getNumberOfTestScripts("TestCases");i++)
		{
			String testNameCellData=getValueFromTestDataSheet(i,1);
			if(testNameCellData.equalsIgnoreCase(testName))
			{
				String urlCellData=getValueFromTestDataSheet(i,2);
				String[] splitString=urlCellData.split(",");
				for(int j=0;j<splitString.length;j++)
				{
				urls.add(splitString[j].trim());
				}
				break;
			}
		}
		return urls;

}
public static String getValueFromTestDataSheet(int i,int j) throws IOException
{
	FileInputStream inputStream = new FileInputStream(new File(testDataFile));
	 
	Workbook workbook = getWorkbook(inputStream, testDataFile);
	//int numberOfSheets = workbook.getNumberOfSheets();
	Sheet sheet = workbook.getSheet("TestCases");
	Row row=sheet.getRow(i);
	String cellData=row.getCell(j).toString();
	return cellData;
	
}
public int getNumberOfTestScripts(String sheetName) throws IOException {
	
	FileInputStream inputStream = new FileInputStream(new File(testDataFile));	 
	Workbook workbook = getWorkbook(inputStream, testDataFile);
	Sheet sheet = workbook.getSheet(sheetName);
	int totalScripts=sheet.getPhysicalNumberOfRows();
	return totalScripts;
}

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
}
