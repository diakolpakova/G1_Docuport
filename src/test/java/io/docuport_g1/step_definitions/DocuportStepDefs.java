package io.docuport_g1.step_definitions;

import io.cucumber.java.en.Then;
import io.docuport_g1.utilities.DocuportUtils;
import io.docuport_g1.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DocuportStepDefs {

    public static final Logger LOG = LogManager.getLogger();

    @Then("user logs out")
    public void user_logs_out() {
        DocuportUtils.logOut(Driver.getDriver());
        LOG.info("User logged out");
    }

}