package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AutomationPage;
import Pages.BeforeAfterClass;
import Pages.HomePage;
import Utils.PerformAction;

public class AutomationPageTests extends BeforeAfterClass {
    private HomePage homePage = new HomePage();
    private AutomationPage automationPage = new AutomationPage();
    private PerformAction performAction = new PerformAction();

    @Test
    public void UITest1Test() {
        navigateToAutomationPage();

        Assert.assertEquals(automationPage.getPageHeader().getText(), "Automation");
        performAction.moveToElement(homePage.getServicesElement());
        Assert.assertTrue(homePage.getServicesElement().getAttribute("class").contains("selected"));
        Assert.assertEquals(performAction.getParentOfElement(homePage.getAutomationLink()).getAttribute("class"), "selected  current expanded");
    }

    @Test
    public void UITest2Test() {
        navigateToAutomationPage();
        automationPage.fillContactUsForm();

        // this test will not work because of the Captcha
        automationPage.getSubmitButton().click();
        Assert.assertEquals(automationPage.getConfirmationMessage().getText(), "Thank you for contacting us.");
    }

    @Test
    public void UITest3Test() {
        homePage.getAcceptCookiesButton().click();
        homePage.getWorldwideDropdown().click();
        checkCountryLinksAreWorking();
    }

    private void navigateToAutomationPage() {
        homePage.getAcceptCookiesButton().click();
        performAction.moveToElement(homePage.getServicesElement());
        homePage.getAutomationLink().click();
    }

    private void checkCountryLinksAreWorking() {
        for (WebElement country : homePage.getCountryList()) {
            country.click();
            performAction.switchToNewTab();
            if (driver.getCurrentUrl().equals("https://www.sogeti.nl/")) {
                Assert.assertTrue(homePage.getSogetiHollandLogo().isDisplayed());
            } else {
                Assert.assertTrue(homePage.getSogetiLogo().isDisplayed());
            }
            performAction.switchToDefaultTab();
        }
    }
}