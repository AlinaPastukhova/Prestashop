package blocks;


import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class CartBlock {

  private String productName;
  private Double productPrice;
  private Integer productQuantity;
  private Double productTotalPrice;

  public CartBlock(WebElement container) {
    try {
      this.productName = container.findElement(By.xpath(".//a[@class='label']")).getText();
    } catch (NoSuchElementException e) {
      this.productName = null;
    }

    try {
      this.productPrice = Double.parseDouble(
          container.findElement(By.xpath(".//div[@class='current-price']/span")).getText()
              .substring(1));
    } catch (NoSuchElementException e) {
      this.productPrice = null;
    }

    try {
      this.productQuantity = Integer.parseInt(
          container.findElement(By.xpath(".//input")).getText());
    } catch (NoSuchElementException e) {
      this.productQuantity = null;
    }

    try {
      this.productTotalPrice = Double.parseDouble(
          container.findElement(By.xpath(".//div[@class='cart-summary-line cart-total']")).getText()
              .substring(1));
    } catch (NoSuchElementException e) {
      this.productTotalPrice = null;
    }

  }
}