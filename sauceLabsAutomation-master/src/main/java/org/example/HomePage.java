package org.example;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class HomePage extends Util {


    private By _username = By.id("txtUsername");
    private By _password = By.id("txtPassword");
    private By _Login = By.xpath("//input[@id=\"btnLogin\"]");
    private  By _Error = By.xpath("//span[@id=\"spanMessage\"]");

    public void userTypeValidUserName() {

        TypeText(_username, "Admin", 50);

        TypeText(_password, "admin123", 30);
    }
     // user click on login button
    public void clickOnLoginButton() {
        clickOnElement(_Login, 30);


    }
     // type username
    public void UserTypeUserName(String username) {
        TypeText(By.id("txtUsername"), username, 30);


    }
   // type password
    public void UserTypePassword(String password) {
        TypeText(By.id("txtPassword"), password, 40);


    }
    public void getErrorMessage() { //Method to get error message
        getTextFromElement(_Error);
        String textFromErrorMessage = getTextFromElement(_Error);
        System.out.println(textFromErrorMessage);
    }



}
