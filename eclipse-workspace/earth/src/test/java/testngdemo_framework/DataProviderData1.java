package testngdemo_framework;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderData1 {
	
	@Test(dataProvider="getdata")
	public void registration(Map <String,String> table)
	{
		table.forEach((key,val)->{
			System.out.println(key +":"+val);
		});
	}
	
	
	@DataProvider
	public Map<String,String> getdata()
	{
		Map <String,String> table= new HashMap<>();
		table.put("ID", "101");
		table.put("Name","Akash");
		table.put("Salary", "20lac");
		return table;
		
	}

}
