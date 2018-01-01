package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreenShot 
{

	public static String getScreenshot(WebDriver driver,String name)
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		  // now copy the  screenshot to desired location using copyFile method
		 String dest="./ScreenShot/"+name+".png";
		 File destination=new File(dest);
		 try {
		 FileUtils.copyFile(src, destination);
		 
		}
		 
		catch (IOException e)
		 
		{
		 
		System.out.println(e.getMessage());
		 
		}
		return dest;
	}
	
}
