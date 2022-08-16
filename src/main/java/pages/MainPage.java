package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import utils.Utils;

@Getter
public class MainPage extends BasePage {

  private static final By mainFrame = By.id("framelive");
  private static final By loadingImage = By.id("loadingMessage");
  private static final By productContainer = By
      .xpath("//div[@class='thumbnail-container reviews-loaded']");
  private static final By allProductsButton = By
      .xpath("//a[@class='all-product-link float-xs-left float-md-right h4']");

  @Step("Open [MainPage]")
  public MainPage openMainPage() {
    getDriver().get("https://demo.prestashop.com/");
    getDriver().switchTo().frame("framelive");
    Utils.waitUntilInvisible(loadingImage, 10);
    return this;
  }

  @Step("Click On [All Products Button]")
  public AllProductsPage clickOnAllProductsButton() {
    Utils.waitUntilPresents(allProductsButton, 10);
    Utils.scrollToElement(getDriver(), allProductsButton);
    Utils.find(allProductsButton).click();
    return new AllProductsPage();
  }
}
