package com.example.fw;


import com.example.tests.ContactsData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase{

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initContactsCreation() {
        click(By.linkText("add new"));
    }
    public void fillContactsForm(ContactsData contacts) {
        type(By.name("firstname"), contacts.getFirst_name());
        type(By.name("lastname"), contacts.getLast_name());
        type(By.name("address"), contacts.getAddress1());
        type(By.name("home"), contacts.getHomePhone());
        type(By.name("mobile"), contacts.getMobilePhone());
        type(By.name("email"), contacts.getEmail());

        //selectByText(By.name("new_group"), "group 1");
        selectByText(By.name("bday"), contacts.getBirthDay());
        selectByText(By.name("bmonth"), contacts.getBirthMonth());

        type(By.name("byear"), contacts.getBirthYear());
    }


    public void submitContactsForm() {
        click(By.name("submit"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void initDeleteEditContact(int index)  {
        click(By.xpath("(//img[@alt='Edit'])[" + (index +1) + "]"));
    }

    public void deleteContact()  {
         click(By.xpath("(//input[@name='update'])[2]"));
        }

    public void submitContactsModification() {
        click(By.xpath("(//input[@name='update'])[1]"));
        }


        public List<ContactsData> getContacts() {
        List<ContactsData> contact = new ArrayList<>();
        List<WebElement> trList = driver.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement tr : trList ) {
            ContactsData contactData = getContactsData(tr);
            contact.add(contactData);
        }
        return contact;
    }

    private ContactsData getContactsData(WebElement tr) {
        ContactsData contactData = new ContactsData();
        contactData.last_name = tr.findElement(By.xpath("./td[2]")).getText();
        contactData.first_name = tr.findElement(By.xpath("./td[3]")).getText();
        return contactData;
    }

}






