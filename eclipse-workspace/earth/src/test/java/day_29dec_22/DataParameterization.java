package day_29dec_22;

import org.testng.annotations.Test;

public class DataParameterization {

	@Test(dataProvider = "getData101",dataProviderClass = AllInOneDataProvider.class)
	public void test101(String name,String password)
	{
		System.out.println("name is " +name  + "::"   +" password is " +password);
		
	}
	
	
	@Test(dataProvider = "getData202",dataProviderClass = AllInOneDataProvider.class )
	public void test202(String name,String password,int salary)
	{
		System.out.println("name is "+name +"::" +" password is "+"::"+password  +"Salary is" +"::" +salary);
	}
	
}
