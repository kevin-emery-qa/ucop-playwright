package features;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InitHelper {
    static Properties testProperties = new Properties();
    static String appBaseUrl;
    static String baseEmailAddressText;
    static String testPassword;
    static String baseEmailDomain;
    static Page page;

    public static void initializeProperties() {
        try {
            FileReader reader = new FileReader("applyuctest.properties");
            testProperties.load(reader);
            appBaseUrl = testProperties.getProperty("appBaseUrl");
            baseEmailAddressText = testProperties.getProperty("baseEmailAddressText");
            baseEmailDomain = testProperties.getProperty("baseEmailDomain");
            testPassword = testProperties.getProperty("testPassword");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
