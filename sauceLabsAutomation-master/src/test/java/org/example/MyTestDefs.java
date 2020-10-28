package org.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MyTestDefs extends Util {
    HomePage homePage = new HomePage();
    private String username;



// user is already on home page;
    @Given("^User is on home page$")
    public void user_is_on_home_page() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://opensource-demo.orangehrmlive.com/" );

    }
// when user enter valid username and valid password;
    @When("^User enter valid credentials$")
    public void user_enter_valid_credentials() {
        homePage.userTypeValidUserName();

    }
// user click on login button
    @When("^User click on Login button$")
    public void user_click_on_Login_button() {
        homePage.clickOnLoginButton();

    }
// user able to login  successfully and welcome massage come
    @Then("^User should be able to login successfully$")
    public void user_should_be_able_to_login_successfully() {
        String expected = "Welcome Admin";
        String actual = getTextFromElement(By.linkText("Welcome Admin"));



    }
// type user name inscenariooutline
    @When("^user enter \"([^\"]*)\"$")
    public void user_enter(String username) {
        homePage.UserTypeUserName(username);

    }
    //type password

    @When("^user type <\"([^\"]*)\"$")
    public void user_type(String password) {
        homePage.UserTypePassword(password);

    }
//user get error massage

    @Then("^user should notable to login successfully and error message display$")
    public void user_should_notable_to_login_successfully_and_error_message_display() {
        homePage.getErrorMessage();





    }
    @When("^user click on Login$")
    public void user_click_on_Login()  {
        homePage.clickOnLoginButton();

    }



}
