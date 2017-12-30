package Execution_Engine;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import java.text.*;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Base_Camp.SetUP;
import Utility.captureScreenShot;

public class SearchQueryHome extends SetUP{
  @Test
  public void searchQueryHome() throws Exception 
  {		
	  report=extent.createTest("Search Query Page Testig", "Enquiry Travel Details").assignAuthor("Nivas");
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("from")))).sendKeys(OR.getProperty("from_city"));
	  waitFor(5);
	  String path = captureScreenShot.getScreenshot(driver, "from_City");
	  report.pass("From City Entered", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	  //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("from_Object")))).click();

	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("to")))).sendKeys(OR.getProperty("to_city"));
	  path = captureScreenShot.getScreenshot(driver, "to_City");
	  report.pass("To City Entered", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	  waitFor(5);
	  // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("to_object")))).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("onwardDate")))).click();
	  waitFor(4);
	  /* DateFormat ft = new SimpleDateFormat("dd/MM/yyyy");*/
	  Calendar cal = Calendar.getInstance();
	  cal.add(Calendar.DATE, 1);
	  int year = cal.get(Calendar.YEAR);
	  int month = cal.get(Calendar.MONTH);
	  int day = cal.get(Calendar.DAY_OF_MONTH);
	  System.out.println("Year "+year);
	  System.out.println("month "+month);
	  System.out.println("day "+day);
	  int m=month+1;
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='a_"+year+"_"+m+"_"+day+"']/span"))).click();
	  path = captureScreenShot.getScreenshot(driver, "onward_Date");
	  report.pass("Onward Date selected", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	  
	  //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("onwardDate")))).sendKeys(ft.format(cal.getTime()));
	  driver.findElement(By.xpath(OR.getProperty("searchBtn"))).click();

	  
	  
  }
}
