import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepsDefinition {
    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String DEVSQUADS_URL = "https://devsquads.com/";
    public static final String GOOGLE_URL = "https://www.google.com/";
    private WebDriver driver;

    @Given("Browser is opened and on DevSquads website")
    public void openBrowserAndVisitDevSquadsWebsite() {
        System.setProperty(
                "webdriver.chrome.driver",
                PATH_TO_WEBDRIVER);
        this.driver = new ChromeDriver();
        visit(DEVSQUADS_URL);
    }

    @When("Hover over about tab")
    public void hoverOverAboutTab() {
        WebElement aboutTab = getElementByText("About");
        hoverOver(aboutTab);
    }

    @And("Click on Teams")
    public void clickOnTeams() {
        getElementByCssSelector("a[href=\"./team.html\"]").click();
    }

    @Then("Should find Amr Elssamadisy")
    public void shouldFindAmrElssamadisy() {
        getElementContains("Amr Elssamadisy");
    }

    @Given("Browser is opened and on Google")
    public void openBrowserAndVisitGoogle() {
        System.setProperty(
                "webdriver.chrome.driver",
                PATH_TO_WEBDRIVER);
        this.driver = new ChromeDriver();
        visit(GOOGLE_URL);
    }

    @When("Search for translate")
    public void searchForTranslate() {
        searchGoogleFor("translate");
    }

    @And("Type Software Engineer")
    public void typeSoftwareEngineer() {
        WebElement translationTextBox = getElementById("tw-source-text-ta");
        translationTextBox.sendKeys("software engineer");
    }

    @Then("Should translate into Arabic")
    public void shouldTranslateIntoArabic() {
        getElementContains("مهندس برمجيات");
    }

    @After
    public void cleanUp() {
        driver.close();
    }

    private void visit(String url) {
        driver.get(url);
    }

    private WebElement getElementByText(String text) {
        return waitForElementToBeVisible(By.xpath("//*[text() = '" + text + "']"));
    }

    private WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }

    private void hoverOver(WebElement aboutTab) {
        Actions a = new Actions(driver);
        a.moveToElement(aboutTab).perform();
    }

    private WebElement getElementByCssSelector(String cssSelector) {
        return waitForElementToBeVisible(By.cssSelector(cssSelector));
    }

    private WebElement getElementContains(String text) {
        return waitForElementToBeVisible(By.xpath("//*[text()[contains(.,'" + text + "')]]"));
    }

    private void searchGoogleFor(String keyword) {
        WebElement searchBox = getElementByName("q");
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.ENTER);
    }

    private WebElement getElementByName(String name) {
        return driver.findElement(By.name(name));
    }

    private WebElement getElementById(String id) {
        return waitForElementToBeVisible(By.id(id));
    }
}
