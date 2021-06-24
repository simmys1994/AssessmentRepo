package com.auto.pageObjects;

public class BookingSectionPageObjects {

	//Booking Section Test Data
	public static String departFromValue = "BLR";
	public static String arrivalValue = "DEL";
	public static String departureSearchValue = "Bangalore";
	public static String arrivalSearchValue = "New Delhi";

	//Booking Section Locators
	public static String departFromCssLoc = "div.oneway-roundtrip input#BE_flight_origin_city";
    public static String bangloreDropdownLoc = "//div[@class='ac_airport']//*[text()='BLR']";
	public static String departFromBangloreCssLoc = "div.oneway-roundtrip.CitySwap li:nth-child(1) li.initial-tab.flex1.safariFix__field div p";
	public static String goingToCssLoc = "div.oneway-roundtrip input#BE_flight_arrival_city";
    public static String delhiDropdownLoc = "//div[@class='ac_airport']//*[text()='DEL']";
	public static String selectToDelhiCssLoc = "div.oneway-roundtrip.CitySwap li:nth-child(1) li.flex1.destAutoSugestField.safariFix__field div p";
    public static String searchFlightsCssLoc = "div.search-height input[value='Search Flights']";
    public static String departureDateLoc = "tbody.BE_flight_origin_date td[data-date='27/06/2021']";
    public static String departureDateInputFieldCssLoc = "input#BE_flight_origin_date";
    public static String returnDateInputFieldCssLoc = "input#BE_flight_arrival_date";
    public static String returnDateLoc = "tbody.BE_flight_arrival_date td[data-date='27/06/2021']";
    public static String departLoc = "input[placeholder= 'Depart']";
    public static String UpdateDepartDateLoc = "div[title='Thursday, July 15, 2021']";
    public static String NoFlightsLoc = "//*[text()='Sorry, There were no flights found for this route and date combination.']";
    public static String SearchAgainLoc = "div.sel-submit.col-2.text-right > div > button";
    public static String VerifyNewDelhiSearchLoc = "(//div[@class='full-width wrapper']//*[text()='New Delhi'])[1]";
    public static String VerifyBangaloreSearchLoc = "(//div[@class='full-width wrapper']//*[text()='Bangalore'])[1]";
}
