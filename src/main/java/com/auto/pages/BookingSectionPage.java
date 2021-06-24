package com.auto.pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.auto.Utility.getData;
import com.auto.base.BasePage;
import com.auto.base.ILogLevel;
import com.auto.base.TestCore;
import com.auto.pageObjects.BookingSectionPageObjects;
import com.relevantcodes.extentreports.LogStatus;

public class BookingSectionPage extends BasePage{
	
	public BookingSectionPage(WebDriver driver) {
		super(driver);
	}

   /*
    * verify site url
    */
	public void VerifySiteUrl() {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.yatra.com/" );
		log("Verify site url", ILogLevel.METHOD);
		TestCore.test.log(LogStatus.PASS, "Verify site url", "Site url verified successfully");
	}
	
	/*
	 * select departure city from depart field
	*/
    public void SelectDepartFromCity() throws IOException
    {
    	driver.findElement(By.cssSelector(BookingSectionPageObjects.departFromCssLoc)).click();
    	fieldClear(By.cssSelector(BookingSectionPageObjects.departFromCssLoc));
    	driver.findElement(By.cssSelector(BookingSectionPageObjects.departFromCssLoc)).click();
    	String data[][] = getData.getDataFromExcel("testdata.xlsx", "MySheet");
		String departFrom = data[1][0];
		driver.findElement(By.cssSelector(BookingSectionPageObjects.departFromCssLoc))
		.sendKeys(departFrom);
    	driver.findElement(By.xpath(BookingSectionPageObjects.bangloreDropdownLoc)).click();
		log("Select Departure value:"+departFrom, ILogLevel.METHOD);
		TestCore.test.log(LogStatus.PASS, "Verify Banglore selected from Departure field", "Banglore selected from Departure field verified successfully");
     }
	
    /*
	 * select arrival city from going to field
	 */
    public void SelectGoingToCity() throws IOException
    {
    	driver.findElement(By.cssSelector(BookingSectionPageObjects.goingToCssLoc)).click();
    	fieldClear(By.cssSelector(BookingSectionPageObjects.goingToCssLoc));
    	driver.findElement(By.cssSelector(BookingSectionPageObjects.goingToCssLoc)).click();
    	String data[][] = getData.getDataFromExcel("testdata.xlsx", "MySheet");
		String arrivalValue = data[1][1];
		driver.findElement(By.cssSelector(BookingSectionPageObjects.goingToCssLoc))
		.sendKeys(arrivalValue);
    	driver.findElement(By.xpath(BookingSectionPageObjects.delhiDropdownLoc)).click();
		log("Select Departure value:"+arrivalValue, ILogLevel.METHOD);
		TestCore.test.log(LogStatus.PASS, "Verify Banglore selected from Departure field", "Banglore selected from Departure field verified successfully");
     }

    /*
     * click on search flighs button
    */
    public void ClickOnSearchFlightsButton()
    {
    	driver.findElement(By.cssSelector(BookingSectionPageObjects.searchFlightsCssLoc)).click();
    	log("Click on search flights button", ILogLevel.METHOD);
		TestCore.test.log(LogStatus.PASS, "Click on search flights button", "Search flights button clicked successfully");
    }
    
    /*
     * click on departure date button
    */
    public void ClickOnDepartureDate()
    {
    	driver.findElement(By.cssSelector(BookingSectionPageObjects.departureDateInputFieldCssLoc)).click();
    	log("Click on departure date field", ILogLevel.METHOD);
		TestCore.test.log(LogStatus.PASS, "Click on departure date field", "Departure date field clicked successfully");
    }
    
    /*
     * click on search return date field
    */
    public void ClickOnReturnDate()
    {
    	driver.findElement(By.cssSelector(BookingSectionPageObjects.returnDateInputFieldCssLoc)).click();
    	log("Click on return date field", ILogLevel.METHOD);
		TestCore.test.log(LogStatus.PASS, "Click on return date field", "Return date field clicked successfully");
    }
    
    /*
     * select departure date
    */
    public void SelectDepartureDate()
    {
    	Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.WEEK_OF_MONTH, 2);
		Date month = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String departuredate = dateFormat.format(month.getTime());
		driver.findElements(By.cssSelector(BookingSectionPageObjects.departureDateLoc.replace("27/06/2021", departuredate))).get(0).click();	
		log("Select departure date value"+departuredate, ILogLevel.METHOD);
		TestCore.test.log(LogStatus.PASS, "Select departure date value", "Departure date value selected successfully");
    }
    
    /*
     * verify on search flighs exists
    */
    public void NoFlightsIfExists()
    {
    		if(driver.findElements(By.xpath(BookingSectionPageObjects.NoFlightsLoc)).size() != 0)
    	 {
    		driver.findElement(By.cssSelector(BookingSectionPageObjects.departLoc)).click();
        	Calendar cal = Calendar.getInstance();
    		Date today = cal.getTime();
    		cal.add(Calendar.DATE, 10);
    		Date month = cal.getTime();
    		DateFormat dateFormat = new SimpleDateFormat("WW,MMMM dd,yyyy");
    		String updatedeparturedate = dateFormat.format(month.getDate());
    		System.out.println("Time is :" + updatedeparturedate);
    		driver.findElement(By.cssSelector(BookingSectionPageObjects.UpdateDepartDateLoc.replace("Thursday, July 15, 2021", updatedeparturedate))).click();	    	
    	    driver.findElement(By.cssSelector(BookingSectionPageObjects.SearchAgainLoc)).click();
    	    log("Select departure date value"+updatedeparturedate, ILogLevel.METHOD);
    		TestCore.test.log(LogStatus.PASS, "Select departure date value", "Departure date value selected successfully");
    }
    else {
    	  pause(2);
    }
   }
}

