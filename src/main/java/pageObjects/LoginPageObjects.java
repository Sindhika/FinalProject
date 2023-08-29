package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
    WebDriver driver;
    @FindBy(name = "username")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginButton;

    public LoginPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendUsername(){
        username.sendKeys("admin");
    }

    public void sendPassword(){
        password.sendKeys("admin123");
    }

    public void clickLogin(){
        loginButton.click();
    }

}
