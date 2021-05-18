package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.ThreadLocalRandom;

import Utils.PerformAction;

import static Utils.PerformAction.*;

public class AutomationPage extends BeforeAfterClass {
    PerformAction performAction = new PerformAction();

    public WebElement getPageHeader(){
        return driver.findElement(By.cssSelector(".page-heading h1"));
    }

    public WebElement getFirstNameInputField(){
        return driver.findElement(By.cssSelector(".row-0 input"));
    }

    public WebElement getLastNameInputField(){
        return driver.findElement(By.cssSelector(".row-1 input"));
    }

    public WebElement getEmailInputField(){
        return driver.findElement(By.cssSelector(".row-2 input"));
    }

    public WebElement getPhoneInputField(){
        return driver.findElement(By.cssSelector(".row-3 input"));
    }

    public WebElement getCountryDropdown(){
        return driver.findElement(By.cssSelector(".row-4 select"));
    }

    public WebElement getMessageDropdown(){
        return driver.findElement(By.cssSelector(".row-5 textarea"));
    }

    public WebElement getIAgreeCheckbox(){
        return driver.findElement(By.cssSelector(".row-7 input"));
    }

    public WebElement getReCaptchaIFrame(){
        return driver.findElement(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
    }

    public WebElement getNotARobotCheckbox(){
        return driver.findElement(By.cssSelector(".recaptcha-checkbox-checkmark"));
    }

    public WebElement getSubmitButton(){
        return driver.findElement(By.cssSelector(".submitbuttonelementblock img"));
    }

    public WebElement getConfirmationMessage(){
        return driver.findElement(By.cssSelector(".Form__Status__Message p"));
    }

    public void selectFromDropdown(String country){
        Select dropdown = new Select(getCountryDropdown());
        dropdown.selectByVisibleText(country);
    }

    public void fillContactUsForm(){
        getFirstNameInputField().sendKeys(generateRandomString(10));
        getLastNameInputField().sendKeys(generateRandomString(10));
        getEmailInputField().sendKeys(generateRandomString(10) + "@gmail.com");
        getPhoneInputField().sendKeys(generateRandomNumbers(11));
        selectFromDropdown("Germany");
        getMessageDropdown().sendKeys(generateRandomString(100));
        getIAgreeCheckbox().click();

        /* Click the reCaptcha. Will fail from time to time.
         Solution would be to get an test build of the app and run the test there without the reCaptcha

         */
        driver.switchTo().frame(getReCaptchaIFrame());
        PerformAction.clickElementJavaScript(getNotARobotCheckbox());
        driver.switchTo().defaultContent();
    }
}
