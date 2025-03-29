package io.docuport_g1.step_definitions;

import io.cucumber.java.en.Then;
import io.docuport_g1.pages.CommonPage;


public class AdvisorStepDefs extends CommonPage {

    @Then("user clicks {string} button on {string} page")
    public void user_clicks_button_on_page(String button, String page) {
        advisorClicksButton(button, page);



    }
}

