package pageObjects;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.Random;

public class AssertionRecord {
    WebDriver driver;
    public String aessetRecord() throws Exception{
        WebElement assertRec = driver.findElement(By.xpath("//div[contains(@class,\"orangehrm-horizontal-padding orangehrm-vertical-padding\")]//span"));
        String checkAsertion = assertRec.getText();
        return checkAsertion;
    }
    public AssertionRecord(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
