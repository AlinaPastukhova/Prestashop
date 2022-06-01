package blocks;


import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

@Getter
@Setter
public class NewsLetterBlock {

  private static final By newsLetterTitleLabel = By.id("block-newsletter-label");
  private static final By unsubscribeDescriptionLabel = By.xpath("//div[@class='col-xs-12']/p");
  private static final By subscribeButton = By.xpath("//input[@value='Subscribe']");


  private static WebDriver driver;

  public NewsLetterBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  public String getTextFromNewsLetterTitleLabel() {
    Utils.waitUntilVisible(newsLetterTitleLabel, 10);
    Utils.scrollToElement(driver, newsLetterTitleLabel);
    return Utils.find(newsLetterTitleLabel).getText();
  }

  public String getTextFromUnsubscribeDescriptionLabel() {
    return Utils.find(unsubscribeDescriptionLabel).getText();
  }

  public String getTextFromSubscribeButton() {
    return Utils.find(subscribeButton).getCssValue("text-transform");
  }
}

