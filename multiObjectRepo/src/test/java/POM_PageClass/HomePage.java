package POM_PageClass;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base_Camp.SetUP;

public class HomePage extends SetUP{
  
	  private WebDriver driver;
	  public HomePage(WebDriver driver)
	  {
		  this.driver =driver;
		  PageFactory.initElements(driver, this);
		  
	  }
  
	 @FindBy(xpath="//label[text()='FROM']/preceding-sibling::input[1]")
	  WebElement from_object;
	 
	 @FindBy(xpath="//section[@id='search']//div[1]//li[1]")
	  WebElement from_city;
	 
	 @FindBy(xpath="//label[text()='TO']/preceding-sibling::input[1]")
	  WebElement to_object;
	 
	 @FindBy(xpath="//section[@id='search']//div[2]//li[1]")
	  WebElement to_city;
	 
	 @FindBy(xpath="//section[@id='search']//label[text()='Onward Date']/preceding-sibling::input")
	 WebElement onwardDate_Object;
	 
	 @FindBy(xpath=".//*[@id='search_btn']")
	 WebElement searchBtn;
	 
	 
	 public void enterFrom(String from) throws Exception
	 {
		 waitFor(2);
		 from_object.sendKeys(from);
		 wait.until(ExpectedConditions.visibilityOf(from_city)).click();
	 }
	 
	 public void enterTo(String to) throws Exception
	 {
		 waitFor(2);
		 to_object.sendKeys(to);
		 wait.until(ExpectedConditions.visibilityOf(to_city)).click();
	 }
	 
	 public void enterTodaysDate()
	 {
		 DateFormat format=new SimpleDateFormat("dd-MMM-yyyy");
		 Date date=new Date();
		 onwardDate_Object.sendKeys(format.format(date));
	 }
	 
	 public void clickSearch() throws Exception
	 {
		 waitFor(2);
		 searchBtn.click();
	 }

	 public void enquiryBus(String to,String from) throws Exception
	 {
		 this.enterFrom(from);
		 this.enterTo(to);
		 this.enterTodaysDate();
		 this.clickSearch();
	 }
	 
}
