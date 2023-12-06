package com.ait.phonebook.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.ContactData;
import com.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME)
                .setLastname(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));

        app.getContact().clickOnSaveButton();
    }

    @Test
    public void removeContactPositiveTest() {

        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().removeContact();
        app.getContact().pause(1000);

        int sizeAfter = app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }
}
