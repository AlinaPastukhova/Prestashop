import com.github.javafaker.Faker;
import core.EventDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.Utils;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

public class BaseTest {

  @BeforeMethod
  public static synchronized void setUp() {
    WebDriver driver;

    String browser = System.getProperty("browser");
    Integer browserWidth = Integer.parseInt(System.getProperty("browserWidth"));
    Integer browserHeight = Integer.parseInt(System.getProperty("browserHeight"));

    // property for setup browser
     switch (browser) {
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      case "safari":
        WebDriverManager.edgedriver().setup();
        driver = new SafariDriver();
        break;
      case "chrome":
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + browser);
    }

    WebDriverManager.chromedriver().setup();
    WebDriverListener listener = new EventDriver();
    WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);
    BasePage.setDriverThreadLocal(decorated);
    Utils.setDriver(decorated);
    BasePage.getDriver().manage().window().setPosition(new Point(0, 0));
    BasePage.getDriver().manage().window().setSize(new Dimension(browserWidth, browserHeight));
  }

  Faker faker = new Faker();

  @AfterMethod(alwaysRun = true)
  public void closeDriver() {
    if (BasePage.getDriverThreadLocal() != null) {
      BasePage.getDriverThreadLocal().get().quit();
      BasePage.getDriverThreadLocal().remove();
    }
  }
}
