package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import Utils.PerformAction;

public class BeforeAfterClass {

    static String driverFolder = System.getProperty("user.dir") + File.separator + "DRIVER" + File.separator;
    protected static int BrowserAttachTimeoutMilliseconds = 10000;

    private static String driverName = "chromedriver";

    @BeforeMethod
    public void setUp() {
        File file;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            file = new File(driverFolder + driverName + ".exe");

        } else {
            file = new File(driverFolder + driverName);
        }
        HashMap<String, java.io.Serializable> chromePrefs = new HashMap<>();
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("start-maximized");

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);

        driver.navigate().to("https://www.sogeti.com/");
        driver.manage().timeouts().implicitlyWait(BrowserAttachTimeoutMilliseconds, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static WebDriver driver = new WebDriver() {
        public void get(String s) {

        }

        public String getCurrentUrl() {
            return null;
        }

        public String getTitle() {
            return null;
        }

        public List<WebElement> findElements(By by) {
            return null;
        }

        public WebElement findElement(By by) {
            return null;
        }

        public String getPageSource() {
            return null;
        }

        public void close() {

        }

        public void quit() {

        }

        public Set<String> getWindowHandles() {
            return null;
        }

        public String getWindowHandle() {
            return null;
        }

        public TargetLocator switchTo() {
            return null;
        }

        public Navigation navigate() {
            return null;
        }

        public Options manage() {
            return null;
        }
    };
}