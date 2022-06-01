import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PricesDrop;

public class CheckPricesTest extends BaseTest {

  @Test(description = "Check That Every Product Has Old And New Price And They Are Correct Test")
  public void checkThatEveryProductHasOldAndNewPriceAndTheyAreCorrectTest() {

    MainPage mainPage = new MainPage();
    List<ProductBlock> allProductsFromPage = mainPage.openMainPage()
        .clickOnPricesDropButton()
        .getAllProductsFromPage();

    PricesDrop pricesDrop = new PricesDrop();
    List<Double> oldPricesFromProducts = pricesDrop
        .getOldPricesFromProducts(allProductsFromPage);

    //Check that every product has old price
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(oldPricesFromProducts)
        .as("We are waiting that every price from " + oldPricesFromProducts + " is not null")
        .allMatch(aDouble -> aDouble != null);

    List<Double> newPricesFromProducts = pricesDrop
        .getNewPricesFromProducts(allProductsFromPage);

    //Check that every product has new price

    softAssertions.assertThat(newPricesFromProducts)
        .as("We are waiting that every price from " + newPricesFromProducts + " is not null ")
        .allMatch(aDouble -> aDouble != null);

    List<Double> correctPricesFromProducts = pricesDrop
        .correctPricesFromProducts(allProductsFromPage);

    //Check that promo price for every product calculates correct

    softAssertions.assertThat(correctPricesFromProducts)
        .as("We are waiting that " + correctPricesFromProducts + " and "
            + newPricesFromProducts + " are equal to each other")
        .isEqualTo(newPricesFromProducts);

    softAssertions.assertAll();
  }

}
