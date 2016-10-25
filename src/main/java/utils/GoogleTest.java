package utils;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class GoogleTest {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        String chromeDriverPath = GoogleTest.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com.ar/";
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void testGoogle() throws Exception {
        driver.get(baseUrl);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("lst-ib")));
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("wikipedia");
        driver.findElement(By.name("btnG")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Wikipedia, la enciclopedia libre")));
        driver.findElement(By.linkText("Wikipedia, la enciclopedia libre")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Artículo destacado")));
        driver.findElement(By.linkText("Artículo destacado")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstHeading")));
        assertEquals("Wikipedia:Artículos destacados", driver.findElement(By.id("firstHeading")).getText());

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./target/screenshot.png"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
