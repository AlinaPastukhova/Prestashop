import com.github.javafaker.Faker;
import core.EventDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.Utils;

public class BaseTest {

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    WebDriverListener listener = new EventDriver();
    WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);
    driver.manage().window().maximize();
    BasePage.setDriver(decorated);
    Utils.setDriver(decorated);
  }

  Faker faker = new Faker();


  @AfterMethod
  public void quite() {
    BasePage.getDriver().quit();
  }
}
