import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepsDefinition {
    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String GOOGLE_TRANSLATE_URL = "https://translate.google.com/";
    private WebDriver driver;

    @Given("Browser is opened")
    public void browserIsOpened() {
        System.setProperty(
                "webdriver.chrome.driver",
                PATH_TO_WEBDRIVER);
        this.driver = new ChromeDriver();

    }
    @When("I visit {string}")
    public void iVisit(String url) {
        driver.get(url);
    }

    @Then("Should find {string}")
    public void shouldFind(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()[contains(.,'" + text + "')]]")));

    }

    @And("Type {string}")
    public void type(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement moreLanguagesButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("button[aria-label=\"More target languages\"]"))

        );
        moreLanguagesButton.click();
        WebElement arabicLanguageOption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("button[data-language-code=\"ar\"]"))
        );
        moreLanguagesButton.click();
        arabicLanguageOption.click();
        moreLanguagesButton.click();
        WebElement translationTextBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("er8xn")));
        translationTextBox.sendKeys(text);
    }

    @Then("Should translate into {string}")
    public void shouldTranslateInto(String arabicText) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[text()[contains(.,'" +  arabicText + "')]]")));

    }

    @After
    public void cleanUp() {
        driver.close();
    }

}
