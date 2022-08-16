package blocks;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class AddingToCartBlock {

  private String productName;
  private String productStatus;
  private Integer productQuantity;
  private String paperType;
  private Double productPrice;
  private Double totalPrice;
  private WebElement continueShoppingButton;
  private WebElement proceedToCheckoutButton;

  public AddingToCartBlock(WebElement container){
    try {
      this.productName = container.findElement(By.xpath(".//h6[@class='h6 product-name']")).getText();
    } catch (NoSuchElementException e) {
      this.productName = null;
    }

    try {
      this.productStatus = container.findElement(By.xpath(".//h4[@id='myModalLabel']")).getText().substring(1);
    } catch (NoSuchElementException e) {
      this.productStatus = null;
    }

    try {
      this.productQuantity = Integer.parseInt(container.findElement(By.xpath(".//span[@class='product-quantity']/strong")).getText());
    } catch (NoSuchElementException e) {
      this.productQuantity = null;
    }

    try {
      this.paperType = container.findElement(By.xpath(".//span[@class='paper type']/strong")).getText();
    } catch (NoSuchElementException e) {
      this.paperType = null;
    }

    try {
      this.productPrice = Double.parseDouble(container.findElement(By.xpath(".//p[@class='product-price']")).getText().substring(1));
    } catch (NoSuchElementException e) {
      this.productPrice = null;
    }

    try {
      this.totalPrice = Double.parseDouble(container.findElement(By.xpath(".//span[@class='value']")).getText().substring(1));
    } catch (NoSuchElementException e) {
      this.totalPrice = null;
    }

    try {
      this.continueShoppingButton = container.findElement(By.xpath(".//button[text()='Continue shopping']"));
    } catch (NoSuchElementException e) {
      this.continueShoppingButton = null;
    }

    try {
      this.proceedToCheckoutButton = container.findElement(By.xpath(".//a[text()='Proceed to checkout']"));
    } catch (NoSuchElementException e) {
      this.proceedToCheckoutButton = null;
    }
  }
}