package pages;

import blocks.ProductBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class AllProductsPage extends BasePage{

  private static final By socialTitleRadioButton = By.xpath("//button[@class='btn-unstyle select-title']");
  private static final By sortFromAToZButton = By.xpath("//a[contains(text(), 'Name, A to Z')]");
  private static final By sortFromZToAButton = By.xpath("//a[contains(text(), 'Name, Z to A')]");
  private static final By sortFromLowToHighPriceButton = By.xpath("//a[contains(text(), 'Price, low to high')]");
  private static final By sortFromHighToLowPriceButton = By.xpath("//a[contains(text(), 'Price, high to low')]");

  private static final By productContainer = By
      .xpath("//div[@class='thumbnail-container reviews-loaded']");

  @Step("Click On [Sort From A To Z] Button")
  public AllProductsPage clickOnSortFromAToZButton(){
    Utils.waitUntilPresents(socialTitleRadioButton, 10);
    Utils.scrollToElement(getDriver(), socialTitleRadioButton);
    Utils.find(socialTitleRadioButton).click();
    Utils.find(sortFromAToZButton).click();
    return this;
  }

  @Step("Click On [Sort From Z To A] Button")

  public AllProductsPage clickOnSortFromZToAButton(){
    Utils.waitUntilPresents(socialTitleRadioButton, 10);
    Utils.scrollToElement(getDriver(), socialTitleRadioButton);
    Utils.find(socialTitleRadioButton).click();
    Utils.find(sortFromZToAButton).click();
    return this;
  }

  @Step("Click On [Sort From Low To High Price] Button")
  public AllProductsPage clickOnSortFromLowToHighPriceButton(){
    Utils.waitUntilPresents(socialTitleRadioButton, 10);
    Utils.scrollToElement(getDriver(), socialTitleRadioButton);
    Utils.find(socialTitleRadioButton).click();
    Utils.find(sortFromLowToHighPriceButton).click();
    return this;
  }

  @Step("Click On [Sort From High To Low Price] Button")
  public AllProductsPage clickOnSortFromHighToLowHighPriceButton(){
    Utils.waitUntilPresents(socialTitleRadioButton, 10);
    Utils.scrollToElement(getDriver(), socialTitleRadioButton);
    Utils.find(socialTitleRadioButton).click();
    Utils.find(sortFromHighToLowPriceButton).click();
    return this;
  }

  @Step("Get All Products From All Products Page")
  public List<ProductBlock> getAllProductsFromAllProductsPage() {
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

  public List<ProductBlock> getSortedProductsFromAToZ(List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort(new Comparator<ProductBlock>() {
      @Override
      public int compare(ProductBlock o1, ProductBlock o2) {
        return o1.getNameAsString().compareTo(o2.getNameAsString());
      }
    });
    return products;
  }

  public List<ProductBlock> getSortedProductsFromZToA(List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort(new Comparator<ProductBlock>() {
      @Override
      public int compare(ProductBlock o1, ProductBlock o2) {
        return o2.getNameAsString().compareTo(o1.getNameAsString());
      }
    });
    return products;
  }

  public List<ProductBlock> getSortedProductsFromLowToHighPrice(List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort(new Comparator<ProductBlock>() {
      @Override
      public int compare(ProductBlock o1, ProductBlock o2) {
        return o1.getActualPriceAsDouble().compareTo(o2.getActualPriceAsDouble());
      }
    });
    return products;
  }

  public List<ProductBlock> getSortedProductsFromHighToLowPrice(List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort(new Comparator<ProductBlock>() {
      @Override
      public int compare(ProductBlock o1, ProductBlock o2) {
        return o2.getActualPriceAsDouble().compareTo(o1.getActualPriceAsDouble());
      }
    });
    return products;
  }
}