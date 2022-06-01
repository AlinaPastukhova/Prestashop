package pages;

import blocks.TopBarBlock;
import blocks.NewsLetterBlock;
import blocks.MainMenuBlock;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

@Getter
@Setter
public abstract class BasePage {

  private static final By pricesDropButton = By.id("link-product-page-prices-drop-1");
  private static final By searchInput = By.xpath("//input[@aria-label='Search']");

  Actions actions = new Actions(driver);
  private static WebDriver driver;
  public static WebDriver getDriver() {
    return driver;
  }
  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  NewsLetterBlock newsLetterBlock = new NewsLetterBlock(getDriver());
  TopBarBlock topBarBlockBlock = new TopBarBlock(getDriver());
  MainMenuBlock mainMenuBlock = new MainMenuBlock(getDriver());

  public PricesDrop clickOnPricesDropButton(){
    Utils.waitUntilPresents(pricesDropButton, 10);
    Utils.scrollToElement(driver, pricesDropButton);
    Utils.find(pricesDropButton).click();
    return new PricesDrop();
  }

  public SearchResultPage enterSearchName(String searchName){
    Utils.waitUntilVisible(searchInput, 20);
    getDriver().findElement(searchInput).sendKeys(searchName);
    getDriver().findElement(searchInput).sendKeys(Keys.ENTER);
    return new SearchResultPage();
  }
}