package utils;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCart2Test {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\german.shokida\\Desktop\\Integracion\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8081/";
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void testOpenCart2() throws Exception {
        driver.get(baseUrl + "/open23/");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='top-links']/ul/li[2]/a/span")));
        driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
        driver.findElement(By.linkText("Login")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("admin123@admin.com");
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.img-responsive")));
        driver.findElement(By.cssSelector("img.img-responsive")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[11]")));
        driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("shopping cart")));
        driver.findElement(By.linkText("shopping cart")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary")));
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        driver.findElement(By.id("button-payment-address")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        driver.findElement(By.id("button-shipping-address")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        driver.findElement(By.id("button-shipping-method")).click();

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.id("button-payment-method")).click();
        driver.findElement(By.id("boton_pago")).click();
        driver.findElement(By.id("numeroTarjetaTxt")).clear();
        driver.findElement(By.id("numeroTarjetaTxt")).sendKeys("4507990000000010");
        driver.findElement(By.id("mesTxt")).click();
        driver.findElement(By.id("mesTxt")).clear();
        driver.findElement(By.id("mesTxt")).sendKeys("09");
        driver.findElement(By.id("anioTxt")).clear();
        driver.findElement(By.id("anioTxt")).sendKeys("18");
        driver.findElement(By.id("codigoSeguridadTxt")).clear();
        driver.findElement(By.id("codigoSeguridadTxt")).sendKeys("123");
        driver.findElement(By.id("apynTxt")).clear();
        driver.findElement(By.id("apynTxt")).sendKeys("Prueba Prueba");
        driver.findElement(By.id("nroDocTxt")).clear();
        driver.findElement(By.id("nroDocTxt")).sendKeys("12123123");
        new Select(driver.findElement(By.id("promosCbx"))).selectByVisibleText("1 Cuota de $ 111.00");
        driver.findElement(By.id("btnConfirmarPago")).click();
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
