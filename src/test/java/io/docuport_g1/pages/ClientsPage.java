package io.docuport_g1.pages;

import io.docuport_g1.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {
    public ClientsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy ( xpath = "//span[contains(text(),'Create')]/ancestor::button[@type='button']")
    public WebElement createNewClientButton;
    @FindBy (xpath = "//span[contains(text(),'Personal') and preceding-sibling::i]")
    public WebElement personal;

}
