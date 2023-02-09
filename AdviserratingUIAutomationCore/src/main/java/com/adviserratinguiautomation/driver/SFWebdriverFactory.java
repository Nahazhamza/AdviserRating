package com.adviserratinguiautomation.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.adviserratinguiautomation.base.BaseTestFixture;
import com.adviserratinguiautomation.customexceptions.ExceptionHandeler;

import java.io.IOException;

import static com.adviserratinguiautomation.browser.BrowserInstanceFactory.chromeWebDriver;
import static com.adviserratinguiautomation.browser.BrowserInstanceFactory.firefoxWebDriver;
//import static com.seleniumframework.browser.BrowserInstanceFactory.chromeWebDriver;
//import static com.seleniumframework.browser.BrowserInstanceFactory.firefoxWebDriver;
import static java.lang.Integer.parseInt;

/**
 * This Factory class is used to get the instance of the web driver
 */
public class SFWebdriverFactory {

    final static Logger log = Logger.getLogger(SFWebdriverFactory.class);
    private static String APP_SETTINGS_BROWSER = "Browser";
    private static String APP_SETTING_TEST_ENVIROMENT = "TestEnvironment";

    private boolean isInternetExplorerExecuted = false;
    private static String browserName;

    /**
     * @return Get the instance of the browser
     */
    public static String getBrowser() {
        return browserName;
    }

    /**
     * @return Get the instance of the webbrowser on based on the test browser
     */
//    public static WebDriver getSFWebDriverInstance()
//    {
//        log.info("Entered the getSFWebDriverInstance method in SFWebdriverFactory");
//        WebDriver seleniumWebDriver = null;
//        String browser = "";
//        
//        if(System.getProperty("Browser").equalsIgnoreCase("Chrome"))
//        {
//          browser ="Chrome";
//        }
//        else if(System.getProperty("Browser").equalsIgnoreCase("Firefox"))
//        {
//          browser ="Firefox";
//        }	
//       
//        switch (browser) {
//            case "Chrome": {
//                seleniumWebDriver = chromeWebDriver();
//                break;
//            }
//            case "Firefox": {
//                seleniumWebDriver = firefoxWebDriver();
//                break;
//            }
//
//            default:
//                throw new IllegalArgumentException("The suggested browser was not found");
//
//        }
//        log.info("Exited the getSFWebDriverInstance method in SFWebdriverFactory");
//        return seleniumWebDriver;
//    }

    public static WebDriver getSFWebDriverInstance()
    {
        log.info("Entered the getSFWebDriverInstance method in SFWebdriverFactory");
        WebDriver seleniumWebDriver = null;
        //Get Browser Instance
        browserName = getBrowser();
       
        switch (browserName) {
            case BaseTestFixture.Chrome: {
                seleniumWebDriver = chromeWebDriver();
                break;
            }
            case BaseTestFixture.FireFox: {
                seleniumWebDriver = firefoxWebDriver();
                break;
            }

            default:
                throw new IllegalArgumentException("The suggested browser was not found");

        }
        log.info("Exited the getSFWebDriverInstance method in SFWebdriverFactory");
        return seleniumWebDriver;
    }
    /**
     * @param browserName
     * @return Return the instance of the web driver based on the test browser
     */
    public static WebDriver getBrowserInstance(String browserName) {
        log.info("Entered the getBrowserInstance method in SFWebdriverFactory");
        WebDriver seleniumWebDriver = null;
        switch (browserName) {
            case BaseTestFixture.Chrome:{
                seleniumWebDriver = chromeWebDriver();
                break;
            }
            case BaseTestFixture.FireFox:{
                seleniumWebDriver = firefoxWebDriver();
                break;
            }
            default:
                throw new IllegalArgumentException("The suggested browser was not found");

        }
        log.info("Exited the getBrowserInstance method in SFWebdriverFactory");
        return seleniumWebDriver;

    }

    public static void init() {
        log.info("Attempting to get ENV_AUTOMATION_BROWSER");
        try {
            if (browserName == null) 
            {
                log.info("Attempting to get APP_SETTING_BROWSER");
                browserName = "Chrome";
            
            }
        } catch (Exception e) {
            new ExceptionHandeler().genricExceptionHandeler(e);
        }
    }
}