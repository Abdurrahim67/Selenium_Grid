package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridStepDefs {
    WebDriver driver;

    @Given("user is on the application_url {string}")
    public void user_is_on_the_application_url(String url) throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.178.52:4444"), new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);


    }

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {

        String actualTitle = driver.getTitle();
        Assert.assertEquals("Title uyusmadi", expectedTitle, actualTitle);


    }

    @Then("close the remote driver")
    public void close_the_remote_driver() {
        driver.quit();

    }

    @Given("user is on the application_url witj firefox {string}")
    public void userIsOnTheApplication_urlWitjFirefox(String url) throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.178.52:4444"), new FirefoxOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);



    }
}
