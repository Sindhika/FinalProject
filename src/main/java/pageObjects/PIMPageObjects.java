package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPageObjects {
    //chnage
    WebDriver driver;

    @FindBy(xpath ="//span[text()='PIM']")
    WebElement pim;
    @FindBy(xpath ="//label[text()='Employee Name']//parent::div//following-sibling::div//input")
    WebElement employeeName;
    @FindBy(xpath ="//div[contains(@class,\"oxd-autocomplete-dropdown\")]//div")
    List<WebElement> employeeNameList;
    @FindBy(xpath ="//label[text()='Employee Id']//parent::div//following-sibling::div//input")
    WebElement employeeId;
    @FindBy(xpath ="//label[text()='Employment Status']//parent::div//following-sibling::div//i")
    WebElement employmentStatus;
    @FindBy(xpath ="//div[contains(@class,\"oxd-select-dropdown\")]//div//span")
    List<WebElement> employmentStatusList;
    @FindBy(xpath ="//label[contains(text(),'Include')]//parent::div//following-sibling::div//i")
    WebElement include;
    @FindBy(xpath ="//div[contains(@class,\"oxd-select-dropdown\")]//div//span")
    List<WebElement> includeList;

    @FindBy(xpath ="//label[contains(text(),'Supervisor Name')]//parent::div//following-sibling::div//input")
    WebElement supervisorName;
    @FindBy(xpath ="//div[contains(@class,\"oxd-autocomplete-dropdown\")]//div")
    List<WebElement> supervisorNameList;
    @FindBy(xpath ="//label[contains(text(),'Job Title')]//parent::div//following-sibling::div//i")
    WebElement jobTitle;
    @FindBy(xpath ="//div[contains(@class,\"oxd-select-dropdown\")]//div//span")
    List<WebElement> jobTitleList;
    @FindBy(xpath ="//label[contains(text(),'Sub Unit')]//parent::div//following-sibling::div//i")
    WebElement subUnit;
    @FindBy(xpath ="//div[contains(@class,\"oxd-select-dropdown\")]//div//span")
    List<WebElement> subUnitList;
    @FindBy(xpath ="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
    WebElement search;

    public PIMPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickPIM(){
        pim.click();
    }
    public void sendEmployeeName(){
        employeeName.sendKeys("al");
    }
    public void selectEmployeeName() {
        String employeeNameValue = "Alice Duval";
        for (int i = 0; i < employeeNameList.size(); i++) {
            if (employeeNameList.get(i).getText().contains(employeeNameValue)) {
                employeeNameList.get(i).click();
                break;
            }
        }
    }
    public void sendEmployeeId(){
        employeeId.sendKeys("0221");
    }

    public void clickEmploymentStatus(){
        employmentStatus.click();
    }
    public void selectEmploymentStatus() {
        String employmentStatusValue = "Full-Time Contract";
        for (int i = 0; i < employmentStatusList.size(); i++) {
            if(employmentStatusList.get(i).getText().contains(employmentStatusValue)){
                employmentStatusList.get(i).click();
                break;
            }
        }
    }
    public void clickInclude(){
        include.click();
    }

    public void selectInclude() {
        String includeValue = "Current and Past Employees";
        for (int i = 0; i < includeList.size(); i++) {
            if(includeList.get(i).getText().contains(includeValue)){
                includeList.get(i).click();
                break;
            }
        }
    }

    public void sendSupervisorName(){
        supervisorName.sendKeys("ke");
    }
    public void selectSupervisorName() {
        String supervisorNameValue = "Kevin Mathews";
        for (int i = 0; i < supervisorNameList.size(); i++) {
            if (supervisorNameList.get(i).getText().contains(supervisorNameValue)) {
                supervisorNameList.get(i).click();
                break;
            }
        }
    }
    public void clickJobTitle(){
        jobTitle.click();
    }
    public void selectJobTitle() {
        String jobTitleValue = "Account Assistant";
        for (int i = 0; i < jobTitleList.size(); i++) {
            if (jobTitleList.get(i).getText().contains(jobTitleValue)) {
                jobTitleList.get(i).click();
                break;
            }
        }
    }
    public void clickSubUnit(){
        subUnit.click();
    }
    public void selectSubUnit() {
        String subUnitValue = "Finance";
        for (int i = 0; i < subUnitList.size(); i++) {
            if (subUnitList.get(i).getText().contains(subUnitValue)) {
                subUnitList.get(i).click();
                break;
            }
        }
    }
    public void clickSearch(){
        search.click();
    }
}
