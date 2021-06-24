package com.auto.Homepage_Test_Scenario;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.auto.base.BasePage;
import com.auto.base.TestCore;
import com.auto.pageObjects.BookingSectionPageObjects;
import com.auto.pages.BookingSectionPage;
import com.relevantcodes.extentreports.LogStatus;

public class Booking_Section_Test_Scenarios extends TestCore {
	BasePage basePage;
	BookingSectionPage bookingSectionPage;

	@Test
	public void TC_01_Verify_Booking_Section_E2e_Flow() throws IOException {
		basePage = new BasePage(driver);
		bookingSectionPage = new BookingSectionPage(driver);
		test = report.startTest("Booking Section");

		bookingSectionPage.VerifySiteUrl(); // verify site url
		TestCore.test.log(LogStatus.PASS, "Verify site Url", "Site Url verified successfully");
		bookingSectionPage.SelectDepartFromCity(); // select Bangalore from departure field
		assertEquals(basePage.getText(By.cssSelector(BookingSectionPageObjects.departFromBangloreCssLoc)),
				BookingSectionPageObjects.departFromValue); // verify Bangalore selected from departure field
		TestCore.test.log(LogStatus.PASS, "Verify Bangalore selected from Departure field",
				"Bangalore selected from Departure field verified successfully");
		bookingSectionPage.SelectGoingToCity(); // select New Delhi from going to field
		assertEquals(basePage.getText(By.cssSelector(BookingSectionPageObjects.selectToDelhiCssLoc)),
				BookingSectionPageObjects.arrivalValue); // verify New Delhi selected from going to field
		TestCore.test.log(LogStatus.PASS, "Verify New Delhi selected from Going to field",
				"New Delhi selected from Going to field verified successfully");
		bookingSectionPage.ClickOnDepartureDate(); // click on departure date field
		TestCore.test.log(LogStatus.PASS, "Click on departure date field", "Departure date field clicked successfully");
		bookingSectionPage.SelectDepartureDate(); // select departure date value
		TestCore.test.log(LogStatus.PASS, "Select departure date from dropdown",
				"Departure date selected successfully");
		bookingSectionPage.ClickOnSearchFlightsButton(); // click on search flights button
		TestCore.test.log(LogStatus.PASS, "Click on Search flights button",
				"Search flights button clicked successfully");
		bookingSectionPage.NoFlightsIfExists(); // verify no flights paresent text if present
		TestCore.test.log(LogStatus.PASS, "Verify No flights text if exists",
				"No flights present text verified successfully");
		assertEquals(basePage.getText(By.xpath(BookingSectionPageObjects.VerifyNewDelhiSearchLoc)),
				BookingSectionPageObjects.arrivalSearchValue); // verify New Delhi value
		TestCore.test.log(LogStatus.PASS, "Verify New Delhi value", "New Delhi value verified successfully");
		assertEquals(basePage.getText(By.xpath(BookingSectionPageObjects.VerifyBangaloreSearchLoc)),
				BookingSectionPageObjects.departureSearchValue); // verify Bangalore value
		TestCore.test.log(LogStatus.PASS, "Verify Bangalore value", "Bangalore value verified successfully");
	}

}
