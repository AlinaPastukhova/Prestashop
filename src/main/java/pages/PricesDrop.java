package pages;

import blocks.ProductBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class PricesDrop extends BasePage{

  private static final By productContainer = By
      .xpath("//div[@class='thumbnail-container reviews-loaded']");

  @Step("Get All Products from page")
  public List<ProductBlock> getAllProductsFromPage() {
    Utils.waitUntilVisible(productContainer, 20);
    Utils.scrollToElement(getDriver(), productContainer);
    Utils.waitRefreshed(productContainer, 20);
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      ProductBlock productBlock = new ProductBlock(container);
      products.add(productBlock);
    }
    return products;
  }
}