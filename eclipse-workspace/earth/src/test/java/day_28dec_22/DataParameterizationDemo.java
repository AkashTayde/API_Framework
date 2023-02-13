package day_28dec_22;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataParameterizationDemo 
{
	@Test(dataProvider="getData")
	public void signIn(String Name,String Pwd)
	{
		System.out.println("Name is " +Name   +":"   +"Pwd is " +Pwd);
	}
	
	@DataProvider
	public Object getData()
	{
		Object[][] data=new Object [4][2];
		data[0][0]="Akash";
		data[0][1]="Akashpwd1";
		
		data[1][0]="Vikas";
		data[1][1]="Vikaspwd2";
		
		data[2][0]="Rajesh";
		data[2][1]="Rajeshpwd3";
		
		data[3][0]="Rakesh";
		data[3][1]="Rakeshpwd4";
		return data;
	}

}
