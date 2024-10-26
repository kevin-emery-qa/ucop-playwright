package pages;

import features.InitHelper;

import static org.junit.Assert.assertTrue;

public class TermLevelPage extends InitHelper {
    public static class Locators {
        public static String termSelectionPageLabel
                = "//*[contains(@class,'text-headline') and contains(.,'When do you hope to start')]";
    }

    public static void selectLatestFallSemester() {
        // using the default for now, nothing to do here yet
    }

    public static void selectButtonByText(String buttonLabel) {
        assertTrue(true);
        //driver.findElement(By.xpath("//*[contains(@class,'opt-select') and contains(.,'" + buttonLabel + "')]")).click();
    }
}


// https://applyucd.ucop.edu/my-application/term-level