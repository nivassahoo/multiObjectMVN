package Base_Camp;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class SetUP {
  
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static final String objectRepo_1=".\\src\\test\\java\\Base_Camp\\OR_1.txt" , objectRepo_2=".\\src\\test\\java\\Base_Camp\\OR_2.txt";
	public static String chromePath="‪‪.\\chromedriver.exe";
	public static String driverPath=".\\chromedriver.exe";
	public static Properties OR;
	public static File f;
	public static FileInputStream fis;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest report;
	
	
	
  @BeforeSuite
  @Parameters("objectRepoVal")
  public void beforeSuite(String objectRepo) throws Exception 
  {
	  if(objectRepo.equalsIgnoreCase("Delhi-BBI"))
	  {
		  f=new File(objectRepo_1);
	  }
	  else
	  {
		  f=new File(objectRepo_2);
	  }
	  fis=new FileInputStream(f);
	  OR=new Properties(System.getProperties());
	  OR.load(fis);
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  options.addArguments("--incognito");
	  System.setProperty("webdriver.chrome.driver",driverPath);
	  driver=new ChromeDriver(options);
	  driver.get(OR.getProperty("url"));
	  System.out.println("URL is "+OR.getProperty("url"));
	  driver.manage().window().maximize();
	  wait=new WebDriverWait(driver,20);
	  htmlReporter=new ExtentHtmlReporter("./MyReport.html");
	  htmlReporter.setAppendExisting(false);
	  
	  extent= new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  
  }
  
  @AfterSuite
  public void teardown()
  {
	  extent.flush();
	  driver.quit();
  }
  
  public static void waitFor(int seconds) throws Exception
  {
	  Thread.sleep(seconds*1000);
  }
  
}
