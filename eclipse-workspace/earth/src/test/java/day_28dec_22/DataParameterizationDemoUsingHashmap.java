package day_28dec_22;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataParameterizationDemoUsingHashmap 
{
	@Test(dataProvider = "getData")
	public void signIn(HashMap<String, String> table )  
	{
		System.out.println(table.get("Username") +":" +table.get("Password"));
	}

	
	@DataProvider
	public Object getData()
	{
		Object[] data=new Object[4];
		Map<String,String> map1= new HashMap<>();
		map1.put("Username", "Akash");
		map1.put("Password", "Akashpwd1");
		data[0]=map1;
		
		Map<String,String> map2= new HashMap<>();
		map2.put("Username", "Vikas");
		map2.put("Password", "Vikaspwd2");
		data[1]=map2;
		
		Map<String,String> map3= new HashMap<>();
		map3.put("Username", "Rajesh");
		map3.put("Password", "Rajeshpwd3");
		data[2]=map3;
		
		Map<String,String> map4= new HashMap<>();
		map4.put("Username", "Rakesh");
		map4.put("Password", "Rakeshpwd4");
		data[3]=map4;
		
		return data;
		
		
	}
}
