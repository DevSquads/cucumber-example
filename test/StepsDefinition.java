import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepsDefinition {
    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    private WebDriver driver;

    @Before
    public void browserIsOpened() {
        System.setProperty(
                "webdriver.chrome.driver",
                PATH_TO_WEBDRIVER);
        this.driver = new ChromeDriver();
    }

    @Given("I visit {string}")
    public void iVisit(String url) {
        driver.get(url);
    }

    @Then("Should find a section title containing {string}")
    public void shouldFindASectionTitleContaining(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()[contains(.,'" + text + "')]]")));

    }

    @When("I select auto detect language")
    public void iSelectAutoDetectLanguage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement autoDetectLanguageButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("button[data-language-code=\"auto\"]"))

        );
        autoDetectLanguageButton.click();
    }

    @And("choose to translate into Arabic")
    public void translateIntoArabic() {
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

    }

    @And("Type {string}")
    public void type(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
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


    @When("I select the search icon")
    public void iSelectTheSearchIcon() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement searchIcon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("navbar-search__toggle"))
        );
        searchIcon.click();
    }

    @And("I search for {string}")
    public void iSearchFor(String courseName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement searchBar = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("s"))
        );
        searchBar.sendKeys(courseName);
        searchBar.sendKeys(Keys.ENTER);
    }

    @And("I select AGILE TESTING AUTOMATION WORKSHOP course")
    public void iSelectAGILETESTINGAUTOMATIONWORKSHOPCourse() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement agileTestingAutomationCourse = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-662\"]/div/div[3]/h3/a"))
        );
        agileTestingAutomationCourse.click();
    }

    @Then("I should find {string} as course title")
    public void iShouldFindAsCourseTitle(String expectedCourseTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement courseTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("course__title"))
        );
        Assert.assertEquals(expectedCourseTitle, courseTitle.getText());
    }
}
