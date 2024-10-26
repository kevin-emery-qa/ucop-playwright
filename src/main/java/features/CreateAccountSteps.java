package features;

import com.microsoft.playwright.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import pages.TermLevelPage;
import helpers.StringHelper;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class CreateAccountSteps extends InitHelper {
    Playwright playwright = Playwright.create();
    BrowserType chromium = playwright.chromium();
    Browser browser = chromium.launch();
    Page page = browser.newPage();
    @BeforeAll
    public static void beforeAll() {
        initializeProperties();
    }

    @Given("The login page has loaded and I see the button to apply")
    public void iSeeTheButtonToApply() {
        page.navigate(appBaseUrl);
        Locator createAccountElement = page.locator(LandingPage.Locators.createAccountButton);
        assertTrue(createAccountElement.isEnabled());
    }

    @When("I click the button to create an account")
    public void iClickTheButtonToCreateAnAccount() {
        Locator createAccountElement = page.locator(LandingPage.Locators.createAccountButton);
        createAccountElement.click();
    }

    @Then("I see the form to create a new account")
    public void iSeeTheFormToCreateANewAccount() {
        Locator emailElement = page.locator(LandingPage.Locators.createAccountEmail);
        Locator passwordElement = page.locator(LandingPage.Locators.createAccountConfirmEmail);
        Locator confirmPasswordElement = page.locator(LandingPage.Locators.createAccountPassword);
        Locator createAccountSubmitButton = page.locator(LandingPage.Locators.createAccountSubmitButton);
        Locator termsOfUseCheckbox = page.locator(LandingPage.Locators.termsOfUseCheckbox);
        assertTrue(emailElement.isEnabled());
        assertTrue(passwordElement.isEnabled());
        assertTrue(confirmPasswordElement.isEnabled());
        assertTrue(createAccountSubmitButton.isEnabled());
        assertTrue(termsOfUseCheckbox.isEnabled());
        Assert.assertFalse(termsOfUseCheckbox.isChecked());
    }

    @When("I submit the form to create a new account")
    public void iSubmitTheFormToCreateANewAccount() {
        Locator emailElement = page.locator(LandingPage.Locators.createAccountEmail);
        Locator confirmEmailElement = page.locator(LandingPage.Locators.createAccountConfirmEmail);
        Locator passwordElement = page.locator(LandingPage.Locators.createAccountPassword);
        Locator createAccountSubmitButton = page.locator(LandingPage.Locators.createAccountSubmitButton);
        Locator termsOfUseCheckbox = page.locator(LandingPage.Locators.termsOfUseCheckbox);

        // generates a one-time email address like testaccount+202401010930@gmail.com which will go to testaccount@gmail.com
        String testUserEmail = baseEmailAddressText + "+" + StringHelper.dateTimeString() + baseEmailDomain;

        emailElement.fill(testUserEmail);
        confirmEmailElement.fill(testUserEmail);
        passwordElement.fill(testPassword);
        Assert.assertFalse(termsOfUseCheckbox.isChecked());

        termsOfUseCheckbox.click();
        assertTrue(termsOfUseCheckbox.isChecked());

        createAccountSubmitButton.click();
    }

    @Then("I am on the term level selection page")
    public void iAmOnTheTermLevelSelectionPage() {
        Locator termSelectionPageElement = page.locator(TermLevelPage.Locators.termSelectionPageLabel);
        assertTrue(termSelectionPageElement.isVisible());
        assertTrue(Objects.requireNonNull(page.url()).contains("/my-application/term-level"));
    }

    @Given("I am applying with a new account and I have reached the term selection page")
    public void iAmApplyingWithANewAccountAndIHaveReachedTheTermSelectionPage() {
        iSeeTheButtonToApply();
        iClickTheButtonToCreateAnAccount();
        iSeeTheFormToCreateANewAccount();
        iSubmitTheFormToCreateANewAccount();
        iAmOnTheTermLevelSelectionPage();
    }
}
