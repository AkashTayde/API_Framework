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

public class DataParamerizationUsingExcel 
{
	@Test (dataProvider = "getData")
	public void test(HashMap<String, String> table)
	{
		String Filename= System.getProperty("user.dir");
		System.out.println(Filename);

		System.out.println(table.get("EmpId") +":"
				+table.get("Name")  +":"
				+table.get("Salary")+":"
				+table.get("Company"));
	}


	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=null;
		String FileName=null;

		try {
			FileName = System.getProperty("user.dir") 
					+ "/src/test/resources/TestDataExcel/TestData.xlsx";
			System.out.println(FileName);
			FileInputStream fis=new FileInputStream(FileName);
			String sheetName="Data";

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet= workbook.getSheet(sheetName);

			int row=sheet.getLastRowNum();     //Total row present in sheet1=Data
			System.out.println(row);
			data    = new Object[row][1];

			Map<String, String> map=null;

			for(int i=1; i<=row; i++ )   //assending row
			{
				map=new HashMap<>();
				map.put("EmpId", sheet.getRow(i).getCell(0).getStringCellValue());
				map.put("Name", sheet.getRow(i).getCell(1).getStringCellValue());
				map.put("Salary", sheet.getRow(i).getCell(2).getStringCellValue());
				map.put("Company", sheet.getRow(i).getCell(3).getStringCellValue());
				data[i-1][0]=map;
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found"  +FileName);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
