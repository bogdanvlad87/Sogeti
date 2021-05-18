package Utils;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

import Pages.BeforeAfterClass;

public class PerformAction extends BeforeAfterClass {

    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public WebElement getParentOfElement(WebElement element){
        return element.findElement(By.xpath("./.."));
    }

    public static String generateRandomString(int length){
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        return generator.generate(length);
    }

    public static String generateRandomNumbers(int length){
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', '9').build();
        return generator.generate(length);
    }

    public void switchToNewTab(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchToDefaultTab(){
        ((JavascriptExecutor) driver).executeScript("window.close();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public static void clickElementJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
