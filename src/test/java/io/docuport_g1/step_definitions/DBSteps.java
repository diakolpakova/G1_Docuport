package io.docuport_g1.step_definitions;

import io.cucumber.java.en.*;
import io.docuport_g1.utilities.ConfigurationReader;
import io.docuport_g1.utilities.DB_Utility;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class DBSteps {
    List <String> allColumnNames;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        String url = ConfigurationReader.getProperties("docuportDbUrl");
        String username = ConfigurationReader.getProperties("docuportDbUsername");
        String password = ConfigurationReader.getProperties("docuportDbPassword");

        DB_Utility.createConnection(url, username, password);
    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        String sql="SELECT * FROM document.users";
        DB_Utility.runQuery(sql);
        allColumnNames = DB_Utility.getAllColumnNamesAsList();
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List <String> expectedColumnNames) {
        assertEquals("Actual result does not match with expected",expectedColumnNames,allColumnNames);
    }

}
