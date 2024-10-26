package features;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import io.cucumber.java.BeforeAll;
import pages.TermLevelPage;

import static org.junit.Assert.assertTrue;

public class TermLevelSteps extends InitHelper {
    Playwright playwright = Playwright.create();
    BrowserType chromium = playwright.chromium();
    Browser browser = chromium.launch();
    Page page = browser.newPage();
    @BeforeAll
    public static void beforeAll() {
        initializeProperties();
    }

    @When("I select the latest Fall semester")
    public void iSelectTheLatestFallSemester() {
        TermLevelPage.selectLatestFallSemester();
    }

    @And("I select the {string} application level")
    public void iSelectTheTransferLevel(String transferLevel) {
        TermLevelPage.selectButtonByText(transferLevel);
    }
}
