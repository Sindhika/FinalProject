package pageObjects;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.Random;

public class ScreenShot {
    WebDriver driver;
    public void takeScreenShot() throws Exception{
        Random rnd = new Random();
        String fileName = "Screenshot_"+randomString()+".jpg";
        String directory = "C:\\Users\\Anto\\Downloads\\FinalProjectWithPOM_WithoutDriver\\screenshots";
        File f =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File(directory+fileName));
    }
    public ScreenShot(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static String randomString(){
        return RandomStringUtils.random(6,"123456");
    }

}
