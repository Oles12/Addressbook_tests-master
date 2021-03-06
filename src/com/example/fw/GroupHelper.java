package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {


    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void deleteGroup(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));
    }

    private void selectGroupByIndex(int index) {

        click(By.xpath("//input[@name='selected[]'][" + (index+1) +"]"));
    }


    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));

    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox:checkboxes) {
         GroupData group = new GroupData();
         String title = checkbox.getAttribute("title");
            group.name = title.substring("Select (".length(),title.length()- ")".length());
            groups.add(group);
        }
        return groups;
    }

}
