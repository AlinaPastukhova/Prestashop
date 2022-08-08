package pages;

import blocks.AddingToCartBlock;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class AddingToCartPage extends BasePage{

  private static final By cartContainer = By.xpath("//div[@id='blockcart-modal']");

  @Step("Get Product Info")
  public AddingToCartBlock getProductInfo(){
    Utils.waitUntilPresents(cartContainer, 10);
    WebElement container = getDriver().findElement(cartContainer);
    return new AddingToCartBlock(container);
  }
}