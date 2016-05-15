package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;


import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase{

    @Test(dataProvider = "randomValidContactGenerator")
    public void modifySomeContacts(ContactsData contacts) {

        app.getNavigationHelper().openMainPage();

       // save old state
       List<ContactsData> oldList = app.getContactHelper().getContacts();
       Random rnd = new Random();
       int index = rnd.nextInt(oldList.size()-1);

       //actions
       app.getContactHelper().initDeleteEditContact(index);
       app.getContactHelper().fillContactsForm(contacts);
       app.getContactHelper().submitContactsModification();
       app.getContactHelper().returnToHomePage();

       //save new state
       List<ContactsData> newList = app.getContactHelper().getContacts();

       //compare states
       oldList.remove(index);
       oldList.add(contacts);
       Collections.sort(oldList);
       assertEquals(newList, oldList);
    }

}
