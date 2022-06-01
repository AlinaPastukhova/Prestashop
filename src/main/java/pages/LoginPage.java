package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Utils;

public class LoginPage extends BasePage{

  private static final By createAccountButton = By.xpath("//div[@class='no-account']/a");

  @Step("Click On [Create Account] Button")
  public CreateAnAccountPage clickOnCreateAccountButton(){
    Utils.waitUntilVisible(createAccountButton, 10);
    Utils.find(createAccountButton).click();
    return new CreateAnAccountPage();
  }

}
