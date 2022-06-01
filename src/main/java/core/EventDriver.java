package core;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

@Slf4j
public class EventDriver implements WebDriverListener {

  @Override
  public void beforeGet(WebDriver driver, String url) {
    log.info("Opening page with URL {}", url);
  }

  @Override
  public void afterGet(WebDriver driver, String url) {
    log.info("Page with URL {} was successfully", url);
  }

  @Override
  public void beforeClick(WebElement element) {
    log.info("Clicking on the element {}", element);
  }

  @Override
  public void afterClick(WebElement element) {
    log.info("Clicking on the element {} was successful", element);
  }

  @Override
  public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    log.info("Typing {} into field {}", keysToSend, element);
  }

  @Override
  public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    log.info("Text {} was saved at field {}", keysToSend, element);
  }

  @Override
  public void beforeGetText(WebElement element) {
    log.info("Text was get from element {}", element.getText());
  }

  @Override
  public void afterGetText(WebElement element, String result) {
    log.info("Text was receive from element {}", element.getText());
  }

  @Override
  public void beforeFindElements(WebDriver driver, By locator) {
    log.info("Find all elements with {}",locator);
  }

  @Override
  public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
    log.info("Elements was found with {}",locator);
  }

  @Override
  public void beforeGetCssValue(WebElement element, String propertyName) {
    log.info("Find element {} with {}", element, propertyName);
  }

  @Override
  public void afterGetCssValue(WebElement element, String propertyName, String result) {
    log.info("Element {} was found with {}",element, propertyName);
  }

  @Override
  public void beforeGetSize(WebElement element) {
    log.info("Size was get {}", element);
  }

  @Override
  public void afterGetSize(WebElement element, Dimension result) {
    log.info("Size was receive {}", element);
  }
}
