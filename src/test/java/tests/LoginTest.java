package tests;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ScreenshotUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws Exception {
        String projectPath = System.getProperty("user.dir");
        ExcelUtils.setExcelFile(projectPath + "/testdata.xlsx");
        return ExcelUtils.getTableArray("Sheet1");
    }

    @Test(dataProvider = "LoginData")
    public void testLogin(String username, String password) throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Wait up to 10 seconds for Dashboard heading
      /*  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        boolean isDashboardVisible = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']"))
        ).isDisplayed();*/

        // Capture screenshot for each scenario
        System.out.println("Capturing screenshot for: " + username + "_login");

        ScreenshotUtils.captureScreenshot(driver, username + "_login");

      //  Assert.assertTrue(isDashboardVisible, "Login failed for user: " + username);
    }
}
