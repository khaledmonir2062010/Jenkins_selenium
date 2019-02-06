package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream fis=null;
	
	public FileInputStream getFileIputStream()
	{
		
		//Get File Path
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.xlsx";
		
		
		File srcfile = new File(filePath);
		
		try {
			fis=new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			System.out.println("testdata not found: "+e.getMessage());
			System.exit(0);
		}
		return fis;
		
	}
	
	//read From excel sheet 
	public Object[][] getExceData() throws IOException
	{
		
		fis=getFileIputStream();
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int TotalNumberOfows=(sheet.getLastRowNum()+1);
		
		int TotalNumberofCols=5;
		
		String [][]arrayExcelData =new String[TotalNumberOfows][TotalNumberofCols];
		
		for (int i = 0; i < TotalNumberOfows; i++)
		
		{
			for (int j = 0; j < TotalNumberofCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();		
			}
		}
		wb.close();
		return arrayExcelData;
	}
}
