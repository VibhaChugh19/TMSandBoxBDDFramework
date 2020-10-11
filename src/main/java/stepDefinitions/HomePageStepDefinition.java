package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utility.WebUIUtilty;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageClasses.HomePage;


public class HomePageStepDefinition {
	
	 static WebDriver driver;
	 HomePage homepage;

@Given("^Guest User is in tmsandbox Home page$")
public void guest_User_is_in_tmsandbox_Home_page() throws Throwable {
	
	driver = WebUIUtilty.launchBrowser("Chrome");
	WebUIUtilty.lauchApplication("https://www.tmsandbox.co.nz/");
 
}

@When("^User clicks on In all categories drop down in search field$")
public void user_clicks_on_In_all_categories_drop_down_in_search_field() throws Throwable {
     homepage = new HomePage(driver);
     WebUIUtilty.timeOUt(2);
    homepage.clickInAllCategories();
    
}

@Then("^User arrow down and clicks on car section$")
public void user_arrow_down_and_clicks_on_car_section() throws Throwable {
	WebUIUtilty.timeOUt(2);
	WebUIUtilty.scrollArrowDown(7).pressEnter();
	
}

@Then("^User clicks on search button$")
public void user_clicks_on_search_button() throws Throwable {
	WebUIUtilty.timeOUt(2);  
	homepage.clickSearchButton();
    
}

@Then("^User clicks on Used cars link$")
public void user_clicks_on_Used_cars_link() throws Throwable {
	WebUIUtilty.timeOUt(2);
	homepage.clickUsedCarsLink();
    
}

@Then("^User closes the browser$")
public void user_closes_the_browser() throws Throwable {
    
	driver.close();
	
    
}

@Then("^User checks the make Kia exists$")
public void user_checks_the_make_Kia_exists() throws Throwable {
	WebUIUtilty.timeOUt(2);
	boolean flag = homepage.verifykiaLink();
	Assert.assertTrue(flag);
	driver.close();
    
}


@Then("^User scroll down the page to check the listing of the cars$")
public void user_scroll_down_the_page_to_check_the_listing_of_the_cars() throws Throwable {
	WebUIUtilty.scrollPageDown(1);
    
}

@Then("^User clicks on more link to check the used cars listing$")
public void user_clicks_on_more_link_to_check_the_used_cars_listing() throws Throwable {
	WebUIUtilty.timeOUt(2);
	homepage.clickMoreLink();
	WebUIUtilty.scrollPageDown(1);
    

}

@Then("^User checks the car key details displaying in the listing$")
public void user_checks_the_car_key_details_displaying_in_the_listing() throws Throwable {
	WebUIUtilty.timeOUt(2);
	homepage.recentcarListingLink();
	WebUIUtilty.timeOUt(2);
	String expectedNoPlate = "EDD369";
	String actualNoPlate = homepage.verifyCarKeydetails().get(0);
	Assert.assertEquals(expectedNoPlate, actualNoPlate);
	WebUIUtilty.timeOUt(2);
	String expectedKM = "163,794km";
	String actualKM = homepage.verifyCarKeydetails().get(1);
	Assert.assertEquals(actualKM, expectedKM);
	WebUIUtilty.timeOUt(2);
	String expectedCarBody = "Dark Blue, 4 door, Sedan";
	String actualCarBody= homepage.verifyCarKeydetails().get(2);
	Assert.assertEquals(actualCarBody, expectedCarBody);
	WebUIUtilty.timeOUt(2);
	String expectedSeats = "5";
	String actualSeats= homepage.verifyCarKeydetails().get(3);
	Assert.assertEquals(actualSeats, expectedSeats);
	WebUIUtilty.timeOUt(2);
	String expectedFuelType = "Petrol";
	String actualFuelType= homepage.verifyCarKeydetails().get(4);
	Assert.assertEquals(actualFuelType, expectedFuelType);
	WebUIUtilty.timeOUt(2);
	String expectedEngine = "6 cylinder, 28cc";
	String actualEngine= homepage.verifyCarKeydetails().get(5);
	Assert.assertEquals(actualEngine, expectedEngine);
	WebUIUtilty.timeOUt(2);
	String expectedTransmission = "Tiptronic";
	String actualTransmission= homepage.verifyCarKeydetails().get(6);
	Assert.assertEquals(actualTransmission, expectedTransmission);
	WebUIUtilty.timeOUt(2);
	String expectedHistory = "5+ owners, Imported";
	String actualHistory= homepage.verifyCarKeydetails().get(7);
	Assert.assertEquals(actualHistory, expectedHistory);
	WebUIUtilty.timeOUt(2);
	String expectedRegoExpires = "Sep 2021";
	String actualRegoExpires= homepage.verifyCarKeydetails().get(8);
	Assert.assertEquals(actualRegoExpires, expectedRegoExpires);
	WebUIUtilty.timeOUt(2);
	String expectedWOFExpires = "Jan 2021";
	String actualWOFExpires= homepage.verifyCarKeydetails().get(9);
	Assert.assertEquals(actualWOFExpires, expectedWOFExpires);
	WebUIUtilty.timeOUt(2);
	String expectedStereoDesp = "Japan frequency type";
	String actualStereoDesp= homepage.verifyCarKeydetails().get(10);
	Assert.assertEquals(actualStereoDesp, expectedStereoDesp);
	WebUIUtilty.timeOUt(2);
	String expectedModelDetails = "E46";
	String actualModelDetails= homepage.verifyCarKeydetails().get(11);
	Assert.assertEquals(actualModelDetails, expectedModelDetails);
	
	
	
	driver.close();
}	
}
