package runTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

import java.time.Duration;


public  class RunTestOrangeHRM {
    private WebDriver driver;
    private String baseUrl;
    SoftAssert sa = new SoftAssert();
    String AssertValueExpected = "(1) Record Found";

    ExtentReports extent;
    ExtentTest test;


    LoginPageObjects loginPageObjects;
    PIMPageObjects pimPageObjects;
    ScreenShot screenShot;
    AdminPageObjects adminPageObjects;
    AssertionRecord assertionRecord;

    @BeforeSuite(enabled = true)
    public void setup() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        loginPageObjects = new LoginPageObjects(driver);
        pimPageObjects = new PIMPageObjects(driver);
        screenShot = new ScreenShot(driver);
        adminPageObjects = new AdminPageObjects(driver);
        assertionRecord = new AssertionRecord(driver);

        //Extent Report
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports/ExtentReport2.html");
        extent.attachReporter(sparkReporter);

        //Open Browser
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    @Test(priority = 1, enabled = true)
    public void login() throws Exception {
        test = extent.createTest("Login");
        loginPageObjects.sendUsername();
        loginPageObjects.sendPassword();
        loginPageObjects.clickLogin();
        Thread.sleep(3000);
    }

    @Test(priority = 2, enabled = true)
    public void pimPage() throws Exception {
        test = extent.createTest("PIM page");
        pimPageObjects.clickPIM();
        pimPageObjects.sendEmployeeName();
        Thread.sleep(3000);
        pimPageObjects.selectEmployeeName();
        pimPageObjects.sendEmployeeId();
        pimPageObjects.clickEmploymentStatus();
        pimPageObjects.selectEmploymentStatus();
        pimPageObjects.clickInclude();
        pimPageObjects.selectInclude();
        pimPageObjects.sendSupervisorName();
        Thread.sleep(3000);
        pimPageObjects.selectSupervisorName();
        pimPageObjects.clickJobTitle();
        pimPageObjects.selectJobTitle();
        pimPageObjects.clickSubUnit();
        pimPageObjects.selectSubUnit();
        pimPageObjects.clickSearch();
        Thread.sleep(3000);
        screenShot.takeScreenShot();


    }

    @Test(priority = 3, enabled = true)
    public void adminPage() throws Exception {
        test = extent.createTest("Admin Page");
        adminPageObjects.clickAdmin();
        adminPageObjects.sendUserName();
        adminPageObjects.clickUserRole();
        adminPageObjects.selectUserRole();
        adminPageObjects.sendEmployeeName();
        Thread.sleep(3000);
        adminPageObjects.selectEmploymentName();
        adminPageObjects.clickStatus();
        adminPageObjects.selectStatus();
        adminPageObjects.clickSearch();
        Thread.sleep(3000);
        screenShot.takeScreenShot();
        String value = assertionRecord.aessetRecord();
        sa.assertEquals(value, "(1) Record Found", "Record Not Found");
        sa.assertAll();
    }

    @Test(priority = 4, enabled = true)
    public void exit() throws Exception {
        extent.flush();
    }


    @AfterSuite
    public  void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(3000);

    }
}

