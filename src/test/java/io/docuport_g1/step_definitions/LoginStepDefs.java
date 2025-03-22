package io.docuport_g1.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import static io.docuport_g1.step_definitions.Hook.driver;

public class LoginStepDefs {

    @Given("пользователь находится на странице Docuport")
    public void the_user_is_on_the_docuport_page() {
        driver.get("https://www.docuport.com");
        // Убедитесь, что страница полностью загружена
        Assert.assertTrue(driver.getTitle().contains("Docuport"));
    }

    @When("пользователь вводит {string} в поле {string} на странице {string}")
    public void the_user_inserts_into_the_field_on_the_page(String value, String fieldName, String pageName) {
        WebElement field = driver.findElement(By.name(fieldName)); // Находим поле по имени
        field.sendKeys(value); // Вводим значение в поле
    }

    @When("пользователь нажимает на кнопку {string} на странице {string}")
    public void the_user_clicks_the_button_on_the_page(String buttonLabel, String pageName) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), '" + buttonLabel + "')]"));
        button.click(); // Нажимаем на кнопку
    }

    @Then("пользователь должен успешно войти в систему")
    public void the_user_should_be_logged_in_successfully() {
        // Проверяем, был ли пользователь перенаправлен на домашнюю страницу после входа
        WebElement homePageElement = driver.findElement(By.id("homePageElementId")); // Замените ID на актуальный
        Assert.assertTrue("Пользователь не вошел в систему успешно", homePageElement.isDisplayed());
    }
}


//package io.docuport_g1.step_definitions;
//
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.junit.Assert;
//
//import static io.docuport_g1.step_definitions.Hook.driver;

//public class LoginStepDefs {
//    @Given("the user is on the Docuport page")
//    public void the_user_is_on_the_docuport_page() {
//        driver.get("https://www.docuport.com");
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//
//    @When("the user inserts {string} into the {string} field on the {string} page")
//    public void the_user_inserts_into_the_field_on_the_page(String string, String string2, String string3) {
//        WebElement field = driver.findElement(By.name(string2)); // Найдите поле по имени
//        field.sendKeys(string); // Введите текст в поле
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//
//    @When("the user clicks the {string} button on the {string} page")
//    public void the_user_clicks_the_button_on_the_page(String string, String string2) {
//        WebElement button = driver.findElement(By.xpath("//button[contains(text(), '" + buttonLabel + "')]"));
//        button.click();
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the user should be logged in successfully")
//    public void the_user_should_be_logged_in_successfully() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//
//}


//package io.docuport_g1.step_definitions;
//
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.docuport_g1.pages.HomePage;
//import io.docuport_g1.pages.LoginPage;
//import io.docuport_g1.utilities.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import static org.junit.Assert.assertTrue;
//
//public class LoginStepDefs {
//
//    LoginPage loginPage = new LoginPage();
//    HomePage homePage = new HomePage();
//    private static final Logger LOG = LogManager.getLogger();
//
//    @Given("user is on Docuport login page")
//    public void user_is_on_Docuport_login_page() {
//        Driver.getDriver().get(ConfigurationReader.getProperties("docuportBETA"));
//        LOG.info("user is on Docuport login page");
//    }
//
//    @When("user enters username for client")
//    public void user_enters_username_for_client() {
//        BrowserUtils.waitForClickable(LoginPage.LoginButton, DocuportConstants.EXTRA_LARGE);
//        assertTrue("Login button is NOT displayed", LoginPage.LoginButton.isDisplayed());
//        LoginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
//        LOG.info("user enters username");
//
//    }
//
//
//}
