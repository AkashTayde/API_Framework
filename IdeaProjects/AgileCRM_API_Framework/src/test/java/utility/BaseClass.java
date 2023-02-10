package utility;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static FileInputStream fis = null;
    public static Properties prop     = null;

  public static  Response response=null;
   public static  RequestSpecification requestSpecification=null;

    public BaseClass() {
        String fileName = System.getProperty("user.dir") +"/src/test/resources/features/config.properties";  //path of the project

        try {
            fis = new FileInputStream(fileName);
            prop=new Properties();
            prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found : "  +fileName);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found : " +fileName);
        }



    }


}
