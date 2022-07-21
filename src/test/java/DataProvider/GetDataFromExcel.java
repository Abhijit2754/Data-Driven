package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetDataFromExcel {

	
	@DataProvider(name="passdata")
	public String[][] datapass() throws IOException
	{
		File file = new File(System.getProperty("user.dir")+"\\TestData\\Data.xlsx");

		FileInputStream fileIn = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileIn);
		int rowsCount = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
		int colcount = workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells();
		
		String[][] data = new String[rowsCount][colcount];
		
		for(int i = 0; i < data.length;i++)
		{
			for(int j = 0 ; j < data[i].length;j++ )
				data[i][j] = workbook.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
			
		}
		
		return data;
	}
}
