import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;

public class CheckSorting extends BaseTest {

  @Test(description = "Check That Sorting Is Correct Test")
  public void checkThatSortingIsCorrectTest() {

    MainPage mainPage = new MainPage();

    List<ProductBlock> allProductsFromAllProductsPageAfterSortingFromAToZ = mainPage
        .openMainPage()
        .clickOnAllProductsButton()
        .clickOnSortFromAToZButton()
        .getAllProductsFromAllProductsPage();

    AllProductsPage allProductsPage = new AllProductsPage();
    List<ProductBlock> sortedProductsFromAToZ = allProductsPage
        .getSortedProductsFromAToZ(allProductsFromAllProductsPageAfterSortingFromAToZ);

    //Check that sorting products as 'Name, A to Z' is correct
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(allProductsFromAllProductsPageAfterSortingFromAToZ)
        .as("We are waiting that: " + allProductsFromAllProductsPageAfterSortingFromAToZ +
            "is equal to " + sortedProductsFromAToZ)
        .isEqualTo(sortedProductsFromAToZ);

    List<ProductBlock> allProductsFromAllProductsPageAfterSortingFromZToA = allProductsPage
        .clickOnSortFromZToAButton()
        .getAllProductsFromAllProductsPage();

    List<ProductBlock> sortedProductsFromZToA = allProductsPage
        .getSortedProductsFromZToA(allProductsFromAllProductsPageAfterSortingFromZToA);

    //Check that sorting products as 'Name, Z to A' is correct

    softAssertions.assertThat(allProductsFromAllProductsPageAfterSortingFromZToA)
        .as("We are waiting that: " + allProductsFromAllProductsPageAfterSortingFromZToA +
            "is equal to " + sortedProductsFromZToA)
        .isEqualTo(sortedProductsFromZToA);

    List<ProductBlock> allProductsFromAllProductsPageAfterSortingFromLowToHighPriceButton = allProductsPage
        .clickOnSortFromLowToHighPriceButton()
        .getAllProductsFromAllProductsPage();

    List<ProductBlock> sortedProductsFromLowToHighPrice = allProductsPage
        .getSortedProductsFromLowToHighPrice(
            allProductsFromAllProductsPageAfterSortingFromLowToHighPriceButton);

    //Check that sorting products as 'Price, low to high' is correct

    softAssertions.assertThat(allProductsFromAllProductsPageAfterSortingFromLowToHighPriceButton)
        .as("We are waiting that: "
            + allProductsFromAllProductsPageAfterSortingFromLowToHighPriceButton +
            "is equal to " + sortedProductsFromLowToHighPrice)
        .isEqualTo(sortedProductsFromLowToHighPrice);

    List<ProductBlock> allProductsFromAllProductsPageAfterSortingFromHighToLowPriceButton = allProductsPage
        .clickOnSortFromHighToLowHighPriceButton().getAllProductsFromAllProductsPage();

    List<ProductBlock> sortedProductsFromHighToLowPrice = allProductsPage
        .getSortedProductsFromHighToLowPrice(
            allProductsFromAllProductsPageAfterSortingFromHighToLowPriceButton);

    //Check that sorting products as 'Price, high to low' is correct

    softAssertions.assertThat(allProductsFromAllProductsPageAfterSortingFromHighToLowPriceButton)
        .as("We are waiting that: "
            + allProductsFromAllProductsPageAfterSortingFromHighToLowPriceButton +
            "is equal to " + sortedProductsFromHighToLowPrice)
        .isEqualTo(sortedProductsFromHighToLowPrice);

    softAssertions.assertAll();
  }
}