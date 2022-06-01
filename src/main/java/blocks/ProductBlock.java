package blocks;


import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class ProductBlock {

  private WebElement img;
  private WebElement nameAsWebElement;
  private String nameAsString;
  private String discount;
  private Double discountAsDouble;
  private String actualPrice;
  private Double actualPriceAsDouble;
  private String oldPrice;
  private Double oldPriceAsDouble;
  private WebElement addToWishList;

  public ProductBlock(WebElement container) {

    try {
      this.img = container.findElement(By.xpath(".//div[@class='thumbnail-top']/a"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.nameAsWebElement = container.findElement(By.xpath(".//*[@class='h3 product-title']/a"));
      this.nameAsString = nameAsWebElement.getText();
    } catch (NoSuchElementException e) {
      this.nameAsWebElement = null;
      this.nameAsString = null;

    }


    try {
      this.discount = container.findElement(By.xpath(".//li[@class='product-flag discount']")).getText();
      this.discountAsDouble = Double.parseDouble(discount.substring(1,3));
    } catch (NoSuchElementException e) {
      this.discount = null;
    }

    try {
      this.actualPrice = container.findElement(By.xpath(".//span[@class='price']")).getText();
      this.actualPriceAsDouble = Double.parseDouble(actualPrice.substring(1));
    } catch (NoSuchElementException e) {
      this.actualPrice = null;
      this.actualPriceAsDouble = null;
    }

    try {
      this.oldPrice = container.findElement(By.xpath(".//span[@class='regular-price']")).getText();
      this.oldPriceAsDouble = Double.parseDouble(oldPrice.substring(1));
    } catch (NoSuchElementException e) {
      this.oldPrice = null;
      this.oldPriceAsDouble = null;
    }

    try {
      this.addToWishList = container.findElement(By.xpath(".//i[@class='material-icons']"));
    } catch (NoSuchElementException e) {
      this.addToWishList = null;
    }
  }
}
