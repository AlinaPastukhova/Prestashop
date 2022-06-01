package blocks;

import io.qameta.allure.Step;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

@Getter
public class MainMenuBlock {

  //Top Menu
  private static final By clothesButton = By.id("category-3");
  private static final By accessoriesButton = By.id("category-6");
  private static final By artButton = By.id("category-9");

  //Sub Menu
  private static final By clothesSubMenu
      = By.xpath("//li[@id='category-3']//div[contains(@id,'top_sub_menu')]//a");
  private static final By menButton = By.id("category-4");
  private static final By womenButton = By.id("category-5");

  private final By accessoriesSubMenu
      = By.xpath("//li[@id='category-6']//div[contains(@id,'top_sub_menu')]//a");
  private static final By stationeryButton = By.id("category-7");
  private static final By homeAccessoriesButton = By.id("category-8");
  private static final By home = By.xpath("//li[@id='category-6']/a");


  private static WebDriver driver;
  private static Actions actions;

  public MainMenuBlock(WebDriver webDriver) {
    driver = webDriver;
    actions = new Actions(driver);
  }

  public MainMenuBlock hoverToClothesButton() {
    Utils.hoverToButton(clothesButton);
    return this;
  }

  public MainMenuBlock hoverToAccessoriesButton() {
    Utils.hoverToButton(accessoriesButton);
    return this;
  }

  @Step("Get Text From Buttons Of [Clothes Sub Menu]")
  public List<String> geTextFromButtonsOfClothesSubMenu() {
    return Utils.getNamesFromButtons(clothesSubMenu);
  }

  @Step("Get Text From Buttons Of [Accessories Sub Menu]")
  public List<String> getTextFromButtonsOfAccessoriesSubMenu() {
    return Utils.getNamesFromButtons(accessoriesSubMenu);
  }
}