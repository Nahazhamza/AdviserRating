package com.adviserratinguiautomation.driver;

import com.adviserratinguiautomation.browser.BrowserProcessFactory;
import com.adviserratinguiautomation.customexceptions.ExceptionHandeler;
import com.adviserratinguiautomation.customexceptions.ResourceCustomException;
import com.adviserratinguiautomation.resourceRead.ResourceRead;
import org.apache.log4j.Logger;
import org.jutils.jprocesses.JProcesses;
import org.jutils.jprocesses.model.ProcessInfo;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

/**
 * This is the base class for the selenium framework web driver
 */
public class ADRWebDriver {

	final static Logger log = Logger.getLogger(ADRWebDriver.class);

	private WebDriver seleniumWebDriver = null;
	private static ADRWebDriver sfWebDriver = null;

	ADRWebdriverFactory sfWebdriverFactory = new ADRWebdriverFactory();

	private String browser;

	/**
	 * Creates an instance of the web driver
	 */
	protected ADRWebDriver() {
		log.info("Entered the SFWebDriver method");
		cleanUp();
		sfWebdriverFactory.init();
		browser = sfWebdriverFactory.getBrowser();
		seleniumWebDriver = sfWebdriverFactory.getADRWebDriverInstance();
		if (seleniumWebDriver != null) {
			seleniumWebDriver.manage().window().maximize();
		}
		log.info("Exited the SFWebDriver method");
	}
	protected ADRWebDriver(String browser) {
		log.info("Entered the SFWebDriver method with browser name");
		sfWebdriverFactory.init();
		seleniumWebDriver = sfWebdriverFactory.getBrowserInstance(browser);
		seleniumWebDriver.manage().window().maximize();
		log.info("Exited the SFWebDriver method with browser name");
	}

	/**
	 * @return To get the instance of the browser
	 */
	public String Browser() {
		return browser;
	}

	/**
	 * @return To get the instance of the Framework web driver
	 */
	public static ADRWebDriver getADRWebDriverInstance() {
		log.info("Entered the getSFWebDriverInstance method");
		if (sfWebDriver == null) {
			sfWebDriver = new ADRWebDriver();
		}
		log.info("Exited the getSFWebDriverInstance method");
		return sfWebDriver;
	}

	/**
	 * @return Returns the instance of the selenium web driver
	 */

	public WebDriver getSeleniumWebDriver() {
		log.info("Entered the getSeleniumWebDriver method");
		if (sfWebDriver == null) {
			sfWebDriver = new ADRWebDriver();
		}
		log.info("Exited the getSeleniumWebDriver method");
		return seleniumWebDriver;
	}

	/**
	 * Reset the Selenium Framework Web Driver
	 */
	public void resetSFWebDriver() {
		log.info("Entered the resetSFWebDriver method");
		sfWebDriver = new ADRWebDriver();
		log.info("Exited the resetSFWebDriver method");
	}

	/**
	 * @param browser Reset the selenium Framework Web Driver with the browser Name
	 */
	public void resetNewBrowser(String browser) {
		log.info("Entered the resetNewBrowser method");
		sfWebDriver = new ADRWebDriver(browser);
		log.info("Exited the resetNewBrowser method");
	}

	/**
	 * Cleans up the web driver and related process
	 */
	public void cleanUp() {
		try {
			log.info("Entered the cleanUp method");
			String browserProcessKillSwitch = new ResourceRead().getResourceValueFromXML()
					.getProperty("browserProcessInstanceKillSwitch");
			if (browserProcessKillSwitch.equalsIgnoreCase("enable")) {
				BrowserProcessFactory browserProcessFactory = new BrowserProcessFactory();
				List<ProcessInfo> processToKillList = browserProcessFactory.getCurrentProcessInstance();
				if (processToKillList != null && !processToKillList.isEmpty()) {
					for (ProcessInfo processToKill : processToKillList) {
						JProcesses.killProcess(Integer.parseInt(processToKill.getPid()));
						if (seleniumWebDriver != null) {
							seleniumWebDriver.quit();
							seleniumWebDriver.close();
						}
					}
				}
			} else {
				if (seleniumWebDriver != null) {
					seleniumWebDriver.quit();
					seleniumWebDriver.close();
				}
			}
			log.info("Exited the cleanUp method");
		} catch (ResourceCustomException ex) {
			new ExceptionHandeler().resourceExceptionHandeler(ex);
		} catch (IOException ex) {
			new ExceptionHandeler().genricExceptionHandeler(ex);
		}

	}

}
