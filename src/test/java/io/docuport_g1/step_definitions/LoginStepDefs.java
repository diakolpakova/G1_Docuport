package io.docuport_g1.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.docuport_g1.pages.HomePage;
import io.docuport_g1.pages.LoginPage;
import io.docuport_g1.utilities.BrowserUtils;
import io.docuport_g1.utilities.ConfigurationReader;
import io.docuport_g1.utilities.DocuportConstants;
import io.docuport_g1.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


import static junit.framework.TestCase.assertTrue;


public class LoginStepDefs {
    private static final Logger LOG = LogManager.getLogger();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportUiUrl"));
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.EXTRA_LARGE);
        Assert.assertTrue("Login button is NOT displayed", loginPage.loginButton.isDisplayed());
        LOG.info("user is on docuport login page");
    }

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
        LOG.info("user enters username");

    }
    @When("user enters password for client")
    public void user_enters_password_for_client() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        LOG.info("user enters password");
    }
    @When("user click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();
        LOG.info("user clicks login button");
    }

    @Then("user should be able to see the home for client")
    public void user_should_be_able_to_see_the_home_for_client() {
        Assert.assertTrue(BrowserUtils.waitForVisibility(loginPage.homeIcon,10).isDisplayed());
        LOG.info("Home page is successfully displayed");

    }
    @Then("user should successfully logout")
    public void user_should_successfully_logout() {
        //rowserUtils.justWait(10);
        loginPage.bgDropdown.click();
        //BrowserUtils.justWait(10);
        loginPage.logOutButton.click();
        LOG.info("Log out page is successfully displayed");
    }

    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
        LOG.info("user enters username");
    }
    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        LOG.info("user enters password");
    }

    @Then("user should be able to see the home for employee")
    public void user_should_be_able_to_see_the_home_for_employee() {
        Assert.assertTrue(BrowserUtils.waitForVisibility(loginPage.form1099,10).isDisplayed());
        LOG.info("Home page is successfully displayed");

    }

    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        LOG.info("user enters username");
    }
    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        LOG.info("user enters password");

    }

    @When("user enters username and password for advisor")
    public void user_enters_username_and_password_for_advisor() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.EXTRA_LARGE);
        Assert.assertTrue("Login button is NOT displayed", loginPage.loginButton.isDisplayed());
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        BrowserUtils.takeScreenshot();
        LOG.info("user enters advisor username");
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        BrowserUtils.takeScreenshot();
        LOG.info("user enters password for advisor");
    }


    @Then("user should be able to see the home for advisor")
    public void user_should_be_able_to_see_the_home_for_advisor() {
        Assert.assertTrue(BrowserUtils.waitForVisibility(loginPage.homeIcon,10).isDisplayed());
        LOG.info("Home page is successfully displayed");

    }

    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
        LOG.info("user enters username");
    }
    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        LOG.info("user enters password");

    }

    @Then("user should be able to see the home for supervisor")
    public void user_should_be_able_to_see_the_home_for_supervisor() {
        Assert.assertTrue(BrowserUtils.waitForVisibility(loginPage.homeIcon,10).isDisplayed());
        LOG.info("Home page is successfully displayed");

    }


}
