import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PlayerSearch {
    @Test
    public void testPlayerSearch() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.pgatour.com/");
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver
                .findElement(By.cssSelector(".nav-container >ul >li a[href=\"/players.html\"]"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-banner-sdk")));
        driver
                .findElement(By.cssSelector(".onetrust-close-btn-handler.onetrust-close-btn-ui.banner-close-button.onetrust-lg.ot-close-icon"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".directory-search .input-field")));
        driver
                .findElement(By.cssSelector(".directory-search .input-field"))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".players-directory.section .directory-item")));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".directory-search .input-field")));
        driver
                .findElement(By.cssSelector(".directory-search .input-field"))
                .sendKeys("Tiger");
        driver
                .findElement(By.cssSelector(".directory-search .btn-search"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".directory-search .btn-search")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".results-title")));

        Assert.assertTrue("We have found 1 result matching \"Tiger\"", driver.findElement(By.cssSelector(".results-title")).isDisplayed());


        driver
                .findElement(By.cssSelector(".directory-search .input-field"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".directory-search .input-field")));
        driver
                .findElement(By.cssSelector(".directory-search .input-field"))
                .clear();
        driver
                .findElement(By.cssSelector(".directory-search .input-field"))
                .sendKeys("ix.co");
        driver
                .findElement(By.cssSelector(".directory-search .btn-search"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".directory-search-results")));

        Assert.assertTrue("Sorry, there are no results matching ix.co", driver.findElement(By.cssSelector(".directory-search-results")).isDisplayed());

        driver.quit();
    }
}

