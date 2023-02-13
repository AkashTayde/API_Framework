package day_28dec_22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataByExcel {
	
	@Test(dataProvider="getData")
	public void test1(HashMap<String, String> map)
	{
		System.out.println(map.get("empid") + " :: " + 
	                       map.get("name")  + " :: " + 
	                       map.get("salary")+ " :: " + 
	                       map.get("fName") );
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data  = null;
		String  fileName = null;
		try
		{
			fileName = System.getProperty("user.dir") +
					"/src/test/resources/TestDataExcel/TestData.xlsx";
			FileInputStream fis = new FileInputStream(fileName);
			String  sheetName   = "Data";

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet       = workbook.getSheet(sheetName);

			int row = sheet.getLastRowNum();                //total rows present in Sheet1
			data    = new Object[row][1];

			Map<String, String> m = null;

			for(int i=1;i<=row;i++)   // accessing rows
			{
				m = new HashMap<>();
				m.put("empid",  sheet.getRow(i).getCell(0).getStringCellValue());
				m.put("name",   sheet.getRow(i).getCell(1).getStringCellValue());
				m.put("salary", sheet.getRow(i).getCell(2).getStringCellValue());
				m.put("fName",  sheet.getRow(i).getCell(3).getStringCellValue());
				data[i-1][0] = m;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + fileName);
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return data;
	}


}
