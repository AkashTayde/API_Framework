package testngdemo_framework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo
{
	@Test (dataProvider="getData")
	public void registration(int id,String Name,String Package)
	{
		System.out.println("id : "+id +" " + "Name : " +Name +" " +"Package : " +Package);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data=new Object [4][3];
		data[0][0]=101;
		data[0][1]="Rajesh";
		data[0][2]="15 Lac";
		
		data[1][0]=102;
		data[1][1]="Akash";
		data[1][2]="15 Lac";
		
		data[2][0]=103;
		data[2][1]="Vikas";
		data[2][2]="15 Lac";
		
		data[3][0]=103;
		data[3][1]="Chuku";
		data[3][2]="15 Lac";
		
		return data;
	}
	

}
