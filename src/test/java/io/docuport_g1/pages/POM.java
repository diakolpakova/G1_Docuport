package io.docuport_g1.pages;

public class POM {

    private LoginPage loginPage;

    public LoginPage getLoginPage() {
        if(loginPage==null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }



}
