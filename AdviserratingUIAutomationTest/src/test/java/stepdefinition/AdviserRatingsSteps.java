package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.adviserratinguiautomation.base.BasePage;
import com.adviserratinguiautomation.base.BaseTestScripts;
import com.adviserratinguiautomation.customexceptions.ExceptionHandeler;
import com.adviserratinguiautomation.customexceptions.ResourceCustomException;
import com.adviserratinguiautomation.customexceptions.drivercustomexceptions.InvalidInputException;
import com.adviserratinguiautomation.customexceptions.drivercustomexceptions.WebDriverInstanceNullException;
import com.adviserratinguiautomation.resourceRead.ResourceRead;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uipages.AdviserRatingPage;

public class AdviserRatingsSteps extends BasePage {

	final static Logger log = Logger.getLogger(AdviserRatingsSteps.class);

	WebDriver seleniumWebDriver;
	public String scenarioName;
	private AdviserRatingPage adviserratingpage = new AdviserRatingPage();

	public AdviserRatingsSteps() {
		this.seleniumWebDriver = get_seleniumWebDriver();
		this.scenarioName = BaseTestScripts.scenarioName;
	}

	// Launching url page with driver instance is performed  
	
	@Given("Navigated to Adviserrating URL")
	public void user_opens_URL() {
		try {
			log.info("Step: Navigated to  Url");
			// loginPage.verifyLogout();
			seleniumWebDriver.manage().deleteAllCookies();
			String url = new ResourceRead().getEnvironmentConfigValue().getProperty("adviserratingurl");
			log.info("Opened URL: " + url);
			LaunchURL(url, seleniumWebDriver);
		} catch (Exception ex) {
			new ExceptionHandeler().genricExceptionHandeler(ex);
		}
	}


	@Given("User is on the Adviser Rating Page")
	public void user_opens_Adviser_URL() {
		try {
			log.info("Step: Navigated to Adviser Url");
//			loginPage.verifyLogout();
			seleniumWebDriver.manage().deleteAllCookies();
			String url=new ResourceRead().getEnvironmentConfigValue().getProperty("adviserratingurl");
			// String selectedEnvironment = System.getProperty("Environment");
//	        String envConfigXML = "../sTest/src/main/resources/" + selectedEnvironment.toLowerCase() + "-config.xml";
//	        String envConfigXML = "../sTest/src/main/resources/sit-config.xml";
			log.info("Opened URL: " + url);
			LaunchURL(url, seleniumWebDriver);
		} catch (Exception ex) {
			new ExceptionHandeler().genricExceptionHandeler(ex);
		}
	}
	
// Move to Advisortab
	
@When("Click on Adviser Tab")
public void click_on_adviser_tab() {
	try {
		log.info("Step: Click on Adviser Tab");
		Thread.sleep(2000);
		adviserratingpage.clickAdviserTab();
	} catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}


@When("Enter {string} on the Search box")
public void enter_on_the_search_box(String adviserName) {
	log.info("Step: Enter the adviser name" + adviserName + "on Search box");
	try {
		Thread.sleep(2000);
		adviserratingpage.searchAdviserName(adviserName);
	} catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}

@Then("Dropdown should be displayed with {string}")
public void dropdown_should_be_displayed_with(String adviserName) {
	try {
		Thread.sleep(2000);
		adviserratingpage.verifyadviserNameonDropDown(adviserName);
	} catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}

@Then("Dropdown should be highlighted for the {string}")
public void dropdown_should_be_highlighted_for_the(String adviserName) {
	try {
		Thread.sleep(1000);
		adviserratingpage.verifyadviserNameHighlighted(adviserName);
	} catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}
@Then("Practice under the {string} should be {string}")
public void practice_under_the_should_be(String adviserName, String practise) {
	try {
		Thread.sleep(2000);
		adviserratingpage.verifyadviserPractise(adviserName,practise);
	} catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}

@Then("Two locations should be listed next to the adviser as {string} and {string}")
public void two_locations_should_be_listed_next_to_the_and( String location1, String location2) {
	try {
		Thread.sleep(2000);
		adviserratingpage.verifyLocations(location1,location2);
	} catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}
//click enter

@When("click on Enter key")
public void click_on_enter_key() {
	try {
		log.info("Step: Click on Enter Key");
		Thread.sleep(2000);
		this.seleniumWebDriver.findElement(By.cssSelector(
				"#nameLookupDropdown-selectized")).sendKeys(Keys.ENTER);
	} catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}
//url verification 

@Then("User should be redirected to the url {string}")
public void user_should_be_redirected_to_the(String url) {
	try {
		log.info("Step: User should be redirected to the url");
		Thread.sleep(2000);
		adviserratingpage.verifyUrl(url);
	} catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}

//To go to Location Tab

@And("Go to location Tab")
public void Go_to_location_Tab() {
	try {
		Thread.sleep(2000);
	adviserratingpage.goToLocationTab();
	}
	catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}


//Step Called - Provide input value and click enter from dropdown and verify it is highlighted 


@When("clicking on enter from dropdown menu and check Highlight")
public void selectLocationFeild() throws InterruptedException, WebDriverInstanceNullException, InvalidInputException, ResourceCustomException, IOException {
	try{
		Thread.sleep(2000);
		adviserratingpage.selectLocationfeildcall();
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
		
}

// Verify the current url value with expected one

@And("verify CurrentUrl")
public void verify_CurrentUrl() {
	try{
		Thread.sleep(2000);
		adviserratingpage.verifySydneycurrentUrl();
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}

}

// Verify dropdown box values results , listview is selected and value range should be closest advisers in location Sydney, NSW 2000 are listed in the search results page on page pagination 1

@And("verify the dropdown box, listview and KMRange")
public void verify_the_dropdown_box()  {
	try{
		Thread.sleep(2000);
		adviserratingpage.verifyTheDropDownBox();
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
	
}

 
// To visit Adviser Tab and enter the "Brett Dillon" and select from dropdown 
 
@And ("Go to Adviser Tab, enter text and click enter")
public void dropdownselect() throws InterruptedException, ResourceCustomException, IOException {
	try{
		Thread.sleep(2000);
		adviserratingpage.dropdownselectAdvisor();
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
	
}


// Get the current Page URL and verify


@And("Get the current Page URL")
public void currentUrl() {
	try {
		Thread.sleep(2000);
	adviserratingpage.advisornameCurrentUrl();
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}


// Check the banner information is correct


@And("Check the banner information is correct")
public void bannerInfo() throws ResourceCustomException, IOException {
	try {
		Thread.sleep(2000);
	adviserratingpage.bannerInfoCall();
	}
	catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}


// Check the name, advisername and location


@And("Check the name, advisername and location")
public void InputCheck() throws ResourceCustomException, IOException 
{
	try {
		Thread.sleep(2000);
	adviserratingpage.inputCheckCall();
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}


// verify Tab Info 

@And("About tab check")
public void aboutTab() throws ResourceCustomException, IOException {
	
	try {
		Thread.sleep(2000);
	adviserratingpage.aboutTabCheckCall();
	}
	catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
     }

 
// Invoke Method locationPanelCall to locate map and check the image

@And("Check the location panel")
public void locationPanel() throws ResourceCustomException, IOException  {
	try{
		Thread.sleep(2000);
		adviserratingpage.locationPanelCall();
		}catch (Exception ex) {
			new ExceptionHandeler().genricExceptionHandeler(ex);
		}
	}


// Invoke Method addressCheckCall to print the address

@Then("Address check is performed")
public void addressCheck() {
	try {
		Thread.sleep(2000);
	adviserratingpage.addressCheckCall();
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
	
}

//Enter the value in location tab of dropdown window 

@And("Enter value in location field and find address of particulars")
public void findAddress() throws InterruptedException {

	try {
		Thread.sleep(2000);
		adviserratingpage.findAddressCall();
		
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}


}

@And("Check the Km value and select and search")
public void selectvalueSearch() {
	
	
	try {
		Thread.sleep(2000);
		adviserratingpage.selectvalueSearchCall();
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
	
	
}

@Then("Get CurrentPageUrl and verify")
public void currentPageurlVerify() throws InterruptedException, ResourceCustomException, IOException {
	
		Thread.sleep(2000);
		adviserratingpage.currentPageUrlVerifyCall();
	
	
	
   }


@And("check descendingorder of KMRange")
public void descendingOrder() throws InterruptedException {
	try {
		Thread.sleep(2000);
		adviserratingpage.descendingorderCall();
		
	}catch (Exception ex) {
		new ExceptionHandeler().genricExceptionHandeler(ex);
	}
}

@And("Logout the browser")
public void logout() throws InterruptedException {
	Thread.sleep(2000);
	seleniumWebDriver.quit();
}
}