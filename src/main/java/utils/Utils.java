package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {

  private static WebDriver driver;
  private static Actions actions;

  public static void setDriver(WebDriver webdriver) {
    driver = webdriver;
    actions = new Actions(driver);
  }

  public static void scrollToElement(WebDriver driver, By element) {
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
  }

  public static WebElement find(By locator) {
    return driver.findElement(locator);
  }

  public static WebElement waitUntilVisible(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static WebElement waitUntilClickable(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.elementToBeClickable(locator));
  }

  public static WebElement waitUntilPresents(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public static boolean waitUntilInvisible(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public static boolean waitRefreshed(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.refreshed((ExpectedConditions.stalenessOf(driver.findElement(locator)))));
  }

  public static void hoverToButton(By button) {
    waitUntilPresents(button, 10);
    actions.moveToElement(Utils.find(button)).build().perform();
  }

  public static List<String> getNamesFromButtons(By container){
    List<String> buttons = new ArrayList<>();
    List<WebElement> elements = driver.findElements(container);
//    for (WebElement element : elements) {
//      buttons.add(element.getText().trim());
//    }
    elements.stream()
        .map(element -> element.getText().trim())
        .forEach(text -> buttons.add(text));
    return buttons;
  }
}
