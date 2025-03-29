package io.docuport_g1.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.docuport_g1.pages.POM;
import io.docuport_g1.utilities.BrowserUtils;
import io.docuport_g1.utilities.ConfigurationReader;
import io.docuport_g1.utilities.DB_Utility;
import io.docuport_g1.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class NewClientStepDefs {

    POM pages = new POM();
    String clientEmail;

    @When("user create a new personal client")
    public void user_create_a_new_personal_client(Map<String, String> clientInfo) {
        clientEmail = clientInfo.get("Email address");

        pages.getDocuportBasePage().clients.click();
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().createNewClient.click();
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().accountTypePersonal.click();
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().firstName.sendKeys(clientInfo.get("First name"), Keys.ENTER);
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().lastName.sendKeys(clientInfo.get("Last name"), Keys.ENTER);
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().createNewUserCheckBox.click();
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().emailAddress.sendKeys(clientInfo.get("Email address"), Keys.ENTER);
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().advisor.click();
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().advisorDropDown.click();
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().phoneNumber.sendKeys(clientInfo.get("Phone number"), Keys.ENTER);
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().password.sendKeys(clientInfo.get("Password"), Keys.ENTER);
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().confirmPassword.sendKeys(clientInfo.get("Password"), Keys.ENTER);
        BrowserUtils.waitFor(2);
        pages.getDocuportBasePage().save.click();

    }

    @When("validate the new client created")
    public void validate_the_new_client_created() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role='status']//span[contains(@class, 'body-1')]")));


        String actualText = toastMsg.getText();
        System.out.println("Toast text: " + actualText);
        Assert.assertTrue(actualText.toLowerCase().contains("successfully"));  // or a more specific phrase
    }

    @When("log out as an advisor")
    public void log_out_as_an_advisor() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-avatar primary']")));
        avatar.click();

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Log out']")));
        logout.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Login')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
    }

    @When("log as a new client")
    public void log_as_a_new_client(Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

        Driver.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Login')]")).click();
    }
    @When("user should be able to see the home for new client")
    public void user_should_be_able_to_see_the_home_for_new_client() throws InterruptedException {
        Thread.sleep(5000);

        System.out.println("pages.getLoginPage().homeButton.isDisplayed() = " + pages.getLoginPage().homeIcon.isDisplayed());


    }
    @When("log out as a new client")
    public void log_out_as_a_new_client() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(pages.getDocuportBasePage().bgbutton));
//        pages.getDocuportBasePage().bgbutton.click();
//        wait.until(ExpectedConditions.elementToBeClickable(pages.getDocuportBasePage().logOut)).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-avatar primary']")));
        BrowserUtils.clickWithJS(avatar);

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Log out']")));
        logout.click();

        // Optional: wait for login page to appear after logout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));

    }

    @Then("create Db connection")
    public void create_db_connection() {
        String url = ConfigurationReader.getProperties("docuportDbUrl");
        String username = ConfigurationReader.getProperties("docuportDbUsername");
        String password = ConfigurationReader.getProperties("docuportDbPassword");

        DB_Utility.createConnection(url, username, password);

    }
    @Then("delete newly created {string}")
    public void delete_newly_created(String client) {
        client = this.clientEmail;
        String sql = "Delete from identity.users where email_address='"+ client +"'";
        DB_Utility.runQuery(sql);

    }



}
