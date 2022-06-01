package pages;

import blocks.ProductBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class SearchResultPage extends BasePage {

  private static final By productContainer = By
      .xpath("//div[@class='thumbnail-container reviews-loaded']");

  @Step("Click On [SearchingProduct]")
  public ProductPage clickOnSearchingProduct(String productName){
    Utils.waitUntilVisible(productContainer, 10);
    Utils.waitRefreshed(productContainer, 10);
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> elements = getDriver().findElements(productContainer);
    for (WebElement element : elements) {
      ProductBlock productBlock = new ProductBlock(element);
      products.add(productBlock);
    }
    for (ProductBlock product : products) {
      if (product.getNameAsString().equals(productName)){
        product.getNameAsWebElement().click();
      }
    }
    return new ProductPage();
  }
}