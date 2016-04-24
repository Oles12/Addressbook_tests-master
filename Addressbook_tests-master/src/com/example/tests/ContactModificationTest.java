package com.example.tests;


import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{
   @Test
    public void modifySomeContacts() {

        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initDeleteEditContact(1);

       ContactsData contacts = new ContactsData();
       contacts.first_name = "New first name";
       contacts.last_name = "New last name";
       contacts.address1 = "New Address1";

       app.getContactHelper().fillContactsForm(contacts);
       app.getContactHelper().submitContactsModification();
       app.getContactHelper().returnToHomePage();

    }

}
