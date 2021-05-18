package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BeforeAfterClass{

    public WebElement getServicesElement() {
        return driver.findElement(By.cssSelector(".main-menu-desktop .has-children.level2"));
    }

    public WebElement getAutomationLink() {
        return driver.findElement(By.cssSelector("a[href*='automation']"));
    }

    public WebElement getAcceptCookiesButton() {
        return driver.findElement(By.cssSelector(".acceptCookie"));
    }

    public WebElement getWorldwideDropdown() {
        return driver.findElement(By.cssSelector(".navbar-global"));
    }

    public List<WebElement> getCountryList() {
        return driver.findElements(By.cssSelector(".country-list li"));
    }

    public WebElement getSogetiLogo(){
        return driver.findElement(By.cssSelector(".levellogo img"));
    }

    public WebElement getSogetiHollandLogo(){
        return driver.findElement(By.cssSelector("#block-brandingvandewebsite"));
    }
}
