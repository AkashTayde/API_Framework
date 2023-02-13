package day_29dec_22;

import org.testng.annotations.DataProvider;

public class AllInOneDataProvider {
	
	
	@DataProvider(name="getData101")
	public Object[][] getData11111()
	{
		Object [][] data= new Object[2][2];
		data[0][0]="Akash";
		data[0][1]="AkashPwd101";
		
		data[1][0]="Rajesh";
		data[1][1]="RajeshPwd201";
		
		return data;
		
	}

	@DataProvider(name="getData202")
	public Object[][] getData22222()
	{
		Object [][] data=new Object [3][3];
		
		data[0][0]="Akash";
		data[0][1]="AkashPwd101";
		data[0][2]=2000;
		
		data[1][0]="Rajesh";
		data[1][1]="RajeshPwd101";
		data[1][2]=4000;
		
		data[2][0]="Vikas";
		data[2][1]="VikashPwd101";
		data[2][2]=5000;

		return data;
	}
}
