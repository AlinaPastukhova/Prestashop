import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class NewsLetterTest extends BaseTest {

  @Test(description = "Check The Text On News Letter Block Test")
  public void checkTheTextOnNewsLetterBlockTest() {

    String expectedTextFromNewsLetterTitleLabel = "Get our latest news and special sales";
    String expectedTextFromUnsubscribeDescriptionLabel =
        "You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.";
    String expectedAttributeFromSubscribeButton = "uppercase";
    MainPage mainPage = new MainPage();

    String textFromNewsLetterTitleLabel = mainPage
        .openMainPage()
        .getNewsLetterBlock()
        .getTextFromNewsLetterTitleLabel();

    //Check that text near the email field equals 'Get our latest news and special sales'
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(textFromNewsLetterTitleLabel)
        .as("Text near the email field equals must be: " + expectedTextFromNewsLetterTitleLabel)
        .isEqualTo(expectedTextFromNewsLetterTitleLabel);

    String textFromUnsubscribeDescriptionLabel = mainPage.getNewsLetterBlock()
        .getTextFromUnsubscribeDescriptionLabel();

    //Check that text under email field contains 'You may unsubscribe at any moment.
    // For that purpose, please find my contact info in the legal notice.'

    softAssertions.assertThat(textFromUnsubscribeDescriptionLabel)
        .as("Text under email field must contains: " + expectedTextFromUnsubscribeDescriptionLabel)
        .contains(expectedTextFromUnsubscribeDescriptionLabel);

    String actualAttributeFromSubscribeButton = mainPage.getNewsLetterBlock().getTextFromSubscribeButton();

    //Check that all characters on 'SUBSCRIBE' button in upper case

    softAssertions.assertThat(actualAttributeFromSubscribeButton)
        .as("'SUBSCRIBE' button should have attribute 'uppercase'")
        .isEqualTo(expectedAttributeFromSubscribeButton);

    softAssertions.assertAll();

  }
}
