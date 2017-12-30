package Execution_Engine;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import Base_Camp.SetUP;
import Utility.captureScreenShot;

public class ResultPage extends SetUP {
  
	public static String name,number,fare;
	
  @Test
  
  public void resultPage() throws Exception {
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("flight_Nm"))));
	   name=driver.findElement(By.xpath(OR.getProperty("flight_Nm"))).getText();
	   String path = captureScreenShot.getScreenshot(driver, "flight_Name");
	   report.pass("Flight selected as "+name, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	  System.out.println("Flight Name "+name);
	   number=driver.findElement(By.xpath(OR.getProperty("flight_Num"))).getText();
	   path = captureScreenShot.getScreenshot(driver, "flight_Number");
	   report.pass("Flight selected as "+number, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	   System.out.println("Flight Name "+number);
	   fare=driver.findElement(By.xpath(OR.getProperty("flight_Fare"))).getText();
	   report.pass("Flight fare is displayed as "+fare);
	  System.out.println("Flight Name "+fare);
	  driver.findElement(By.xpath(OR.getProperty("book_Btn"))).click();
  }
}
