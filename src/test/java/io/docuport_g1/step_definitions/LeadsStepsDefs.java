package io.docuport_g1.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.docuport_g1.pages.LeadsPage;
import io.docuport_g1.pages.LeftNavigatePage;
import io.docuport_g1.utilities.DB_Utility;
import io.docuport_g1.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeadsStepsDefs {

    LeftNavigatePage leftNavigatePage = new LeftNavigatePage();
    LeadsPage leadsPage = new LeadsPage();

    List<Map<String, String>> listUI;

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String leads) {
        leftNavigatePage.clickButton(leads);
    }

    @When("the user gets all the leads information based on {string} and {string} and {string}")
    public void the_user_gets_all_the_leads_information_based_on_and_and(String fullName, String emailAddress, String phoneNumber) {

        listUI = leadsPage.returnDataFromUI(fullName, emailAddress, phoneNumber);

    }

    @Then("verify leads information match in DB")
    public void verify_leads_information_match_in_db() throws SQLException {

        List<Map<String, String>> listDB = leadsPage.returnDataFromDB();
        leadsPage.verifyLeads(listUI, listDB);
    }
}
