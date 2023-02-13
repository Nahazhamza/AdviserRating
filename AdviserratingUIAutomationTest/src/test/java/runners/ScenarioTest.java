package runners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.adviserratinguiautomation.base.BasePage;
import com.adviserratinguiautomation.customReport.CustomExtendReport;
import com.adviserratinguiautomation.customexceptions.ResourceCustomException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import stepdefinition.StepHooks;

@RunWith(Cucumber.class) 
@CucumberOptions (features="src/test/resources/features/",
glue = {"stepdefinition"},//For instance, once cucumber runs I want to add 
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true, 
dryRun = false
//publish = true
//strict=true


)
						
public class ScenarioTest extends BasePage				
{	
	
}

//@RunWith(Cucumber.class) 
//@CucumberOptions (features="src/test/resources/features/",
//glue = {"stepdefinition"},//For instance, once cucumber runs I want to add 
//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//
////com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:
//monochrome = true,
//dryRun = false
////strict = true
//)						
//public class ScenarioTest extends BasePage				
//{		
//	static String folderName;
//    @BeforeClass
//    public static void createExtentReport() throws ResourceCustomException, IOException {
//    	
//    	
//    	// Create the test folder
//    	 folderName =	createLogReport();
//
//    }
//
//
//    @AfterClass
//    public static void writeExtentReport()
//    {
//    	
//        // Copy extent reports to new path
//    	CustomExtendReport.copyReport(folderName,StepHooks.passStatus);
// 
//      
//    }
//
//}

//package runners;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//
//import com.adviserratinguiautomation.base.BasePage;
//import com.adviserratinguiautomation.customReport.CustomExtendReport;
//import com.adviserratinguiautomation.customexceptions.ResourceCustomException;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import stepdefinition.StepHooks;
//
//
//@RunWith(Cucumber.class) 
//@CucumberOptions (features="src/test/resources/features/",
//glue = {"stepdefinition"},//For instance, once cucumber runs I want to add 
//  plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//  monochrome = true, 
//  dryRun = false, 
//  publish = true
////  strict=true
//  
//  
//)
// 						
//public class ScenarioTest extends BasePage				
//{	
//	

//}
