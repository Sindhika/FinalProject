package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPageObjects {
    WebDriver driver;

    @FindBy(xpath ="//span[text()='Admin']")
    WebElement admin;
    @FindBy(xpath ="//label[text()='Username']//parent::div//following-sibling::div//input")
    WebElement userName;
    @FindBy(xpath ="//label[text()='User Role']//parent::div//following-sibling::div")
    WebElement userRole;
    @FindBy(xpath ="//div[contains(@class,\"oxd-select-dropdown --positon-bottom\")]//div")
    List<WebElement> userRoleList;
    @FindBy(xpath ="//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @FindBy(xpath ="//div[contains(@class,\"oxd-autocomplete-dropdown --positon-bottom\")]//div")
    List<WebElement> employeeNameList;
    @FindBy(xpath ="//label[text()='Status']//parent::div//following-sibling::div")
    WebElement status;
    @FindBy(xpath ="//div[contains(@class,\"oxd-select-dropdown --positon-bottom\")]//div")
    List<WebElement> statusList;
    @FindBy(xpath ="//button[contains(@class,\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\")]")
    WebElement search;

    public AdminPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAdmin(){
        admin.click();
    }
    public void sendUserName(){
        userName.sendKeys("admin");
    }
    public void clickUserRole(){
        userRole.click();
    }
    public void selectUserRole() {
        String userRoleValue = "Admin";
        for (int i = 0; i < userRoleList.size(); i++) {
            if (userRoleList.get(i).getText().contains(userRoleValue)) {
                userRoleList.get(i).click();
                break;
            }
        }
    }
    public void sendEmployeeName(){
        employeeName.sendKeys("pa");
    }

    public void selectEmploymentName() {
        String employeeNameValue = "Paul";
        for (int i = 0; i < employeeNameList.size(); i++) {
            if(employeeNameList.get(i).getText().contains(employeeNameValue)){
                employeeNameList.get(i).click();
                break;
            }
        }
    }
    public void clickStatus(){
        status.click();
    }

    public void selectStatus() {
        String statusValue = "Enabled";
        for (int i = 0; i < statusList.size(); i++) {
            if(statusList.get(i).getText().contains(statusValue)){
                statusList.get(i).click();
                break;
            }
        }
    }
       public void clickSearch(){
        search.click();
    }
}
