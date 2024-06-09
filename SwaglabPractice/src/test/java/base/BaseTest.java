// basetest is common as it contains webdriver setup and capture screenshot if failed
// structure : import, actual webdriver intialize, seleniumhelper and drivermanager : i think some use of that
package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Constants;
import utilities.DriverManager;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import org.json.simple.parser.ParseException;
import java.io.IOException;


public class BaseTest {

        protected WebDriver driver;
        protected SeleniumHelpers selenium;
        private DriverManager drivermanager;

        @BeforeMethod
        @Parameters({"browser"})
        public void setUp(@Optional("chrome") String browser) {
            drivermanager = new DriverManager();
            driver = drivermanager.setUp(browser);
            selenium = new SeleniumHelpers(driver);
        }

        @AfterMethod
        public void tearDown(ITestResult result){

            try
            {
                //capturing screenshot if failed

                if (ITestResult.FAILURE == result.getStatus()) {
                    selenium.takeScreenshot(result.getName());
                }
            }
            catch (Exception e)
            {
                //ignore
            }
         //   drivermanager.tearDown();
        }
        @BeforeSuite
        public void beforeSuite() throws InterruptedException, IOException, ParseException {
            //Deletes screenshots
            new JavaHelpers().deleteAllFilesFromFolder(Constants.SCREENSHOT_LOCATION);
        }

    }


