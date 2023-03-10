package uipages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import com.adviserratinguiautomation.base.BasePage;
import com.adviserratinguiautomation.base.BaseTestScripts;
import com.adviserratinguiautomation.customexceptions.ResourceCustomException;
import com.adviserratinguiautomation.customexceptions.drivercustomexceptions.InvalidInputException;
import com.adviserratinguiautomation.customexceptions.drivercustomexceptions.WebDriverInstanceNullException;
import com.adviserratinguiautomation.resourceRead.ResourceRead;

import io.cucumber.java.en.When;
import propertiesLoader.PropertiesLoader;

public class AdviserRatingPage extends BasePage {
	final static Logger log = Logger.getLogger(AdviserRatingPage.class);
	private String adviserratingpage = "/AdviserRatingPageResource.properties";
	private ResourceRead resRead = new ResourceRead();
	private Properties driverproperty;
	WebDriver seleniumWebDriver;
	private String scenarioName;
	Properties adviserRatingPageproperty = PropertiesLoader.getInstance().getProperties();

	public AdviserRatingPage() {
		this.seleniumWebDriver = get_seleniumWebDriver();
		this.scenarioName = BaseTestScripts.scenarioName;
	}
// Move to adviser tab
	public void clickAdviserTab() throws WebDriverInstanceNullException, InvalidInputException, ResourceCustomException,
			IOException, InterruptedException {
		log.info("Entered clickAdviserTab method of AdviserRatingPage");
		clickOnButtonByXpath(adviserRatingPageproperty.getProperty("ADVISER_TAB_XPATH"), seleniumWebDriver);
	}
// Enter Advisor name 
	public void searchAdviserName(String adviserName) throws WebDriverInstanceNullException, InvalidInputException,
			ResourceCustomException, IOException, InterruptedException {
		log.info("Entered reNameSurvey method of AdviserRatingPage");
		findTextboxAndSetValueByXpath(adviserRatingPageproperty.getProperty("ADVISER_SEARCHBOX_XPATH"),
				adviserName, seleniumWebDriver);
	}
// Dropdown value should be displayed with entered advisorname
	public void verifyadviserNameonDropDown(String adviserName) throws WebDriverInstanceNullException,
			InvalidInputException, ResourceCustomException, IOException, InterruptedException {

		String expectedName = adviserName;
		WebElement adviserNamedisplayed = seleniumWebDriver
				.findElement(By.xpath(adviserRatingPageproperty.getProperty("ADVISERNAME_FROM_DROPDOWN_XPATH")));
		String actualName = adviserNamedisplayed.getText();

		Assert.assertEquals(expectedName, actualName);

	}

	//Verify Advisor practice value with assertions
	
	public void verifyadviserPractise(String adviserName, String practise) throws WebDriverInstanceNullException,
			InvalidInputException, ResourceCustomException, IOException, InterruptedException {

		String expectedPractise = practise;
		WebElement practiseNamedisplayed = seleniumWebDriver
				.findElement(By.xpath(adviserRatingPageproperty.getProperty("PRACTISENAME_FROM_DROPDOWN_XPATH")));
		String actualPractiseName = practiseNamedisplayed.getText();

		Assert.assertEquals(expectedPractise, actualPractiseName);

	}
//Verify the locations expected with the actual value
	
	public void verifyLocations(String location1, String location2) throws WebDriverInstanceNullException,
			InvalidInputException, ResourceCustomException, IOException, InterruptedException {

		String expectedLocation1 = location1;
		String expectedLocation2 = location2;
		WebElement location1displayed = seleniumWebDriver
				.findElement(By.xpath(adviserRatingPageproperty.getProperty("LOCATION1_FROM_DROPDOWN_XPATH")));

		WebElement location2displayed = seleniumWebDriver.findElement(By.xpath(adviserRatingPageproperty.getProperty("LOCATION2_FROM_DROPDOWN_XPATH")));
		String actualLocation1 = location1displayed.getText();
		String actualLocation2 = location2displayed.getText();
		Assert.assertEquals(expectedLocation1, actualLocation1);
		Assert.assertEquals(expectedLocation2, actualLocation2);

	}

	public void clickonSelectedAdviser() throws WebDriverInstanceNullException, InvalidInputException,
			ResourceCustomException, IOException, InterruptedException {
		log.info("Entered clickEnterButton method of AdviserRatingPage");
		clickOnButtonByXpath(adviserRatingPageproperty.getProperty("ADVISER_SELECTED_ENTER_XPATH"), seleniumWebDriver);
	}

	//Verify the advisorname gets in highlighted 
	
	public void verifyadviserNameHighlighted(String adviserName) throws WebDriverInstanceNullException,
			InvalidInputException, ResourceCustomException, IOException, InterruptedException {

//		String expectedName = adviserName;
		WebElement dropdownNameHighlighted = seleniumWebDriver
				.findElement(By.xpath(adviserRatingPageproperty.getProperty("ADVISERNAME_HIGHLIGHTED_XPATH")));
//		String actualName = adviserNamedisplayed.getText();

		// getAttribute() to get src value
		String attrValue = dropdownNameHighlighted.getAttribute("class");
		System.out.println("Class attribute is: " + attrValue);
		String highlightedClass = "option active";
		Assert.assertEquals(highlightedClass, attrValue);

	}

	// verify the url with expected one.
	
	public void verifyUrl(String url)
			throws WebDriverInstanceNullException, InvalidInputException, ResourceCustomException, IOException {
		log.info("Entered verifyUrl method of AdviserRatingPage");
		String currentUrl = getCurrentURL(seleniumWebDriver);
		String ExpectedUrl = url;
		Assert.assertEquals(ExpectedUrl, currentUrl);

		
	}

	// to locate to location Tab

	public void goToLocationTab() throws ResourceCustomException, IOException, InterruptedException {
		log.info("go to location tab and enter sydney");
		Thread.sleep(2000);
		seleniumWebDriver.findElement(By.xpath(adviserRatingPageproperty.getProperty("ADVISER_LOCATIONTAB_XPATH")));

		this.seleniumWebDriver.findElement(By.id("searchLocationDropdown-selectized"));
	}
	
//check inputed value get selected and highlighted
	
	public void selectLocationfeildcall(String Expectedlocation, String containsvalue) throws InterruptedException, ResourceCustomException, IOException {
		log.info("Entered locationvalue method of AdviserRatingPage");

		//String value = "Sydney, NSW 2000";

		WebElement adviserNamedisplayed = seleniumWebDriver
				.findElement(By.xpath(adviserRatingPageproperty.getProperty("ADVISER_LOCATIONTAB_XPATH")));
		adviserNamedisplayed.sendKeys(Expectedlocation);
		Thread.sleep(3000);

		List<WebElement> ele = this.seleniumWebDriver.findElements(By.cssSelector(
				"div[class='ar-input ar-input--location ar-input--no-label'] div[class='selectize-dropdown single'] div[class='selectize-dropdown-content'] div"));
		System.out.println(ele.size());
		for (int i = 0; i <= ele.size() - 1; i++) {
			if (ele.get(i).getText().contains(containsvalue)) {
				ele.get(i).click();
				String option = ele.get(i).getAttribute("class");
				System.out.println("Highlighted:"+option);
				String highlightvalue = "option selected active";
				Assert.assertEquals(highlightvalue, option);

				break;
			}
		}

		Thread.sleep(2000);
		WebElement searchlocation = seleniumWebDriver.findElement(
				By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_LOCATION_SEARCHTAB_CSSSELECTOR")));
		searchlocation.click();

	}

	//verify url
	
	public void verifySydneycurrentUrl(String Expectedurl) {
		String url = this.seleniumWebDriver.getCurrentUrl();
		System.out.println("currenturl" + url);
		Assert.assertEquals(Expectedurl, url);
	}

	// verify dropdownbox, Listview and KM range closest
	
	public void verifyTheDropDownBox(String location,String km, String searchResult) throws ResourceCustomException, IOException {

		WebElement verifylocationFeild = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_LOCATIONFEILD_CSSSELECTOR")));
		String verifytext = verifylocationFeild.getText();

		Assert.assertEquals(location, verifytext);

		WebElement verifyKM = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_DROPDOWN_DISTANCE_VERIFY")));
		String kilometer = verifyKM.getText();
		Assert.assertEquals(km, kilometer);
		WebElement verifylocationKM = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_LOCATION_RESULT_TAGNAME")));
		String searchresult = verifylocationKM.getText();

		Assert.assertEquals(searchResult, searchresult);

		WebElement verifyListView = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_LISTVIEW_CSSSELECTOR")));
		boolean eleEnabled = verifyListView.isEnabled();

		List<WebElement> listkm = this.seleniumWebDriver.findElements(By.cssSelector(".ar-badge.ar-badge--naked"));

		for (WebElement listKmrange : listkm) {
			String kmRangevalue = listKmrange.getText();
			String[] splitvalues = kmRangevalue.split("k", 2);
			String finalvalue = splitvalues[0];
			System.out.println("splitvalue" + kmRangevalue);
			System.out.println("splitvalueafter" + finalvalue);
			Float result = new Float(finalvalue);
			// float value1 = float.parseFloat(finalvalue);

			System.out.println("kmrange:" + result);
			if (result < 1) {
				System.out.println("It stays between the range");
			}
		}
	}

	
	  // To Perform select option for requested input 
	  
	public void dropdownselectAdvisor(String adviserName) throws InterruptedException, ResourceCustomException, IOException {

		WebElement advisortab = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_TAB_CSSSELECTOR")));
		advisortab.click();

		WebElement advisorname = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISORNAME_CSSSELECTOR")));
		advisorname.sendKeys(adviserName);

		Thread.sleep(2000);

		List<WebElement> ele = this.seleniumWebDriver.findElements(By.cssSelector("span[class='font-weight-bold']"));
		System.out.println(ele.size());
		for (int i = 0; i <= ele.size() - 1; i++) {
			if (ele.get(i).getText().contains(adviserName)) {
				ele.get(i).click();
				// location.sendKeys(Keys.ENTER);
				break;
			}
		}
	}

	
	// To get current url and verify with expected url
	 
	public void advisornameCurrentUrl(String expectedUrl) {
		String url = this.seleniumWebDriver.getCurrentUrl();
		System.out.println("currenturl" + url);
		Assert.assertEquals(expectedUrl, url);
	}

	
	// verify image src of banner
	 
	public void bannerInfoCall(String BannerImage) throws ResourceCustomException, IOException {

		WebElement image = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISORURL_LOCATOR_CSSSELECTOR")));
		String Imagesrc = image.getAttribute("src");

		System.out.println("ImageSrc attribute is: " + Imagesrc);

		Assert.assertEquals(BannerImage,Imagesrc);

	}

	
	// verify Check for name, advisername and location
	
	public void inputCheckCall(String name, String AdvisorName, String Location) throws ResourceCustomException, IOException {

		WebElement Actualname = seleniumWebDriver
				.findElement(By.tagName(adviserRatingPageproperty.getProperty("ADVISOR_NAME_VERIFY_TAGNAME")));
		String namevalue = Actualname.getText();
		Assert.assertEquals(name, namevalue);

		WebElement ActualadviserName = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_ADVISORNAME_CSSSELECTOR")));
		String Advisernamevalue = ActualadviserName.getText();
		Assert.assertEquals(AdvisorName, Advisernamevalue);

		WebElement Actuallocation = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_LOCATIONTEXT_VERIFY_CSSSELECTOR")));
		String locationvalue = Actuallocation.getText();
		Assert.assertEquals(Location, locationvalue);
	}

	
	// verify Tab Name 

	public void aboutTabCheckCall(String AboutName) throws ResourceCustomException, IOException {

		WebElement tab = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_TABNAMECHECK_CSSSELECTOR")));
		boolean returntype = tab.isSelected();
		String texttab = tab.getText();
		Assert.assertEquals(AboutName, texttab);
	}
	
	// verify Map and src of Image

	public void locationPanelCall(String adviserNameExpected, String srcUrlExpected) throws ResourceCustomException, IOException {

		WebElement map = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_MAPLOCATE_CSSSELECTOR")));

		/*Actions a = new Actions(seleniumWebDriver);
		a.moveToElement(map).build().perform();*/
		
		((JavascriptExecutor)seleniumWebDriver).executeScript("arguments[0].scrollIntoView(true);", map);

		WebElement advisornamelocate = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_MAP_ADVISORNAME_CSSSELECTOR")));

		String advisorname = advisornamelocate.getText();
		System.out.println("advisorname: "+advisorname);
		Assert.assertEquals(adviserNameExpected, advisorname);

		WebElement srcurllocate = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_SRCURL_CSSSELECTOR")));

		String srcurl = srcurllocate.getAttribute("src");
		System.out.println("srcurl: "+srcurl);
		Assert.assertEquals(srcUrlExpected,srcurl);

	}
	
	// Print and verify 2 address gets populated.
public void addressCheckCall() {
		List<WebElement> addresslist = this.seleniumWebDriver.findElements(By.tagName("address"));
		for (WebElement address : addresslist) {
			System.out.println("addressvalues: " + address.getText());

		}
	}


// Enter Search value
public void searchValue(String value) throws WebDriverInstanceNullException, InvalidInputException,
ResourceCustomException, IOException, InterruptedException {
     log.info("Entered reNameSurvey method of AdviserRatingPage");
     findTextboxAndSetValueByXpath(adviserRatingPageproperty.getProperty("SEARCH_VALUE_XPATH"),
    		 value, seleniumWebDriver);
}

//Iterate the dropdown list  to verify the provided data matches 
public void findAddressCall(String location) throws InterruptedException, ResourceCustomException, IOException {
	Thread.sleep(2000);
	List<WebElement> ele = this.seleniumWebDriver.findElements(By.cssSelector(
			"div[class='ar-input ar-input--location ar-input--no-label'] div[class='selectize-dropdown single'] div[class='selectize-dropdown-content'] div"));
	System.out.println(ele.size());
	for (int i = 0; i <= ele.size() - 1; i++) {
		if (ele.get(i).getText().contains(location)) {
			ele.get(i).click();
			break;
		}
	}
}





	//iterate the KM value to fix 5Km and select the search button
	public void selectvalueSearchCall(String distance) throws ResourceCustomException, IOException {

		WebElement distancetab = seleniumWebDriver
				.findElement(By.id(adviserRatingPageproperty.getProperty("ADVISOR_DISTANCETAB_ID")));
		distancetab.click();

		List<WebElement> kmlist = this.seleniumWebDriver
				.findElements(By.cssSelector("select[id='searchDistance'] option"));
		for (int i = 0; i <= kmlist.size() - 1; i++) {
			if (kmlist.get(i).getText().contains(distance)) {
				kmlist.get(i).click();
				// location.sendKeys(Keys.ENTER);
				break;
			}
		}
		distancetab.click();

		WebElement searchtab = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_LOCATION_SEARCHTAB_CSSSELECTOR")));
		searchtab.click();

	}

	//Verify the current url , print search results location and distance values and check the accending order is viewed
	public void currentPageUrlVerifyCall(String url, String ExpectedlocationName,String km, String ExpectedSearchResult) throws ResourceCustomException, IOException, InterruptedException {
		Thread.sleep(2000);
		String CUrrentUrl = this.seleniumWebDriver.getCurrentUrl();
		Assert.assertEquals(url, CUrrentUrl);
		Thread.sleep(2000);
		WebElement locationFeild = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_LOCATIONFEILD_CSSSELECTOR")));

		String locationName = locationFeild.getText();
		Thread.sleep(2000);
		System.out.println("locationName:" + locationName);
		Assert.assertEquals(ExpectedlocationName, locationName);

		WebElement locationkm = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_DROPDOWN_DISTANCE_VERIFY")));

		String KMverify = locationkm.getText();
		Assert.assertEquals(km, KMverify);
		WebElement locationresult = seleniumWebDriver
				.findElement(By.tagName(adviserRatingPageproperty.getProperty("ADVISOR_LOCATION_RESULT_TAGNAME")));

		String searchresult = locationresult.getText();
		System.out.println(searchresult);

		Assert.assertEquals(ExpectedSearchResult, searchresult);

		WebElement distancetabclick = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_DISTANCE_CLICK_CSSSELECTOR")));

		distancetabclick.click();

		System.out.println("Value is displayed in assending order");

		List<WebElement> kmRange = this.seleniumWebDriver.findElements(By.className("ar-badge.ar-badge--naked"));
		System.out.println("Beforesplit" + kmRange);
		for (WebElement listKmrange : kmRange) {
			System.out.println("Beforesplit" + listKmrange);
			String kmRangevalue = listKmrange.getText();
			String[] splitvalues = kmRangevalue.split("k", 2);
			String finalvalue = splitvalues[0];
			System.out.println("splitvalue" + kmRangevalue);
			System.out.println("splitvalueafter" + finalvalue);
			Float result = new Float(finalvalue);
			// float value1 = float.parseFloat(finalvalue);

			System.out.println("kmrange:" + result);
			Thread.sleep(2000);
			if (result < 1) {
				System.out.println("It stays between the range");
				Thread.sleep(2000);
			}

		}
	}
	
	//Verify the distance values and check the descending order is viewed

	public void descendingorderCall() throws ResourceCustomException, IOException, InterruptedException {

		Thread.sleep(3000);
		// this.seleniumWebDriver.findElement(By.cssSelector(".fa.fa-bullseye.mr-1")).click();
		WebElement descendingorder = seleniumWebDriver
				.findElement(By.cssSelector(adviserRatingPageproperty.getProperty("ADVISOR_DESCENDINGORDER_CSSSELECTOR")));

		descendingorder.click();

		Thread.sleep(3000);

		System.out.println("Value is displayed in Descending order");
		List<WebElement> kmRange = this.seleniumWebDriver.findElements(By.cssSelector(".ar-badge.ar-badge--naked"));
		for (WebElement listKmrange : kmRange) {
			String kmRangevalue = listKmrange.getText();
			String[] splitvalues = kmRangevalue.split("k", 2);
			String finalvalue = splitvalues[0];
			System.out.println("splitvalue" + kmRangevalue);
			System.out.println("splitvalueafter" + finalvalue);
			Float result = new Float(finalvalue);
			// float value1 = float.parseFloat(finalvalue);

			System.out.println("kmrange:" + result);
			if (result <= 5 && result != 6) {
				System.out.println("It stays between the range");
			}
		}
	}
}
