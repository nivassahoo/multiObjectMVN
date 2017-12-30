package Execution_Engine;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base_Camp.SetUP;

public class VerifyPage extends SetUP {
  @Test
  public void verifyPage()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("flight_NmCheck"))));
	  String name=driver.findElement(By.xpath(OR.getProperty("flight_NmCheck"))).getText();
	  
	  if(name.startsWith(ResultPage.name))
	  {
	  System.out.println("Flight Name is verified as "+name);
	  System.out.println("Flight Name "+name);
	  }
	  else
	  {Assert.fail("Flight Name mismatch");}
	  
	  
	  String number=driver.findElement(By.xpath(OR.getProperty("flight_NumCheck"))).getText();
	  Assert.assertEquals(number, ResultPage.number);
	  System.out.println("Flight Number is verified as "+number);
	  
	  String fare=driver.findElement(By.xpath(OR.getProperty("flight_FareCheck"))).getText();
//	  Assert.assertEquals(fare, ResultPage.fare);
	  System.out.println("Flight Fare verified as "+fare);
	  
  }
}
