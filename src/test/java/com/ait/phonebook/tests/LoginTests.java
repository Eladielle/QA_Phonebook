package com.ait.phonebook.tests;

import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


    public class LoginTests extends TestBase{

        //precondition: User should be logged out
        @BeforeMethod
        public void ensurePrecondition() {
            if (!app.getUser().isLoginLinkPresent()) {
                app.getUser().clickOnSignOutButton();
            }
        }

        @Test
        public void loginRegisteredUserPositiveTest() {
            app.getUser().clickOnLoginLink();

            app.getUser().fillLoginRegisterForm(new User()
                    .setEmail(UserData.EMAIL)
                    .setPassword(UserData.PASSWORD));

            app.getUser().clickOnLoginButton();
            //assert: User logged in
            Assert.assertTrue(app.getUser().isSignOutButtonPresent());
        }

        @Test
        public void loginRegisteredUserNegativeWithoutEmailTest() {
            app.getUser().clickOnLoginLink();

            app.getUser().fillLoginRegisterForm(new User()
                    .setPassword(UserData.PASSWORD));

            app.getUser().clickOnLoginButton();
            //assert: User logged in
            Assert.assertTrue(app.getUser().isAlertPresent());
        }
    }

