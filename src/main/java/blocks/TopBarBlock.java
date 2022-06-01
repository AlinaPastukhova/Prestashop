package blocks;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.Utils;

public class TopBarBlock {

  //Buttons
  private static final By languageButton = By.xpath("//i[@class='material-icons expand-more']");
  private static final By signInButton = By.xpath("//a[@title='Log in to your customer account']");
  private static final By userNameButton = By.xpath("//a[@class='account']//span[@class='hidden-sm-down']");

  //Attributes
  private static final By languageContainer = By.xpath("//ul[@class='dropdown-menu hidden-sm-down']/li");

  private static WebDriver driver;

  public TopBarBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  @Step("Click on [Language Button]")
  public TopBarBlock clickOnLanguageButton() {
    Utils.waitUntilVisible(languageButton, 10);
    Utils.find(languageButton).click();
    return this;
  }

  @Step("Get Names Of Languages")
  public List<String> getNamesOfLanguages() {
    List<String> languages = new ArrayList<>();
    List<WebElement> elements = driver.findElements(languageContainer);
    for (WebElement element : elements) {
      String nameOfLanguage = element.getText();
      languages.add(nameOfLanguage);
    }
    return languages;
  }
  @Step("Click On [Sign In] Button")
  public LoginPage clickOnSignInButton(){
    Utils.waitUntilVisible(signInButton, 10);
    Utils.find(signInButton).click();
    return new LoginPage();
  }

  @Step("Get Text From [UserName] Button")
  public String getTextFromUserNameButton(){
    Utils.waitUntilVisible(userNameButton, 10);
    return Utils.find(userNameButton).getText();
  }
}