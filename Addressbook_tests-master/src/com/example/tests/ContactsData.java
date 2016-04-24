package com.example.tests;

public class ContactsData {
   public String first_name;
   public String last_name;
   public String address1;
   public String homePhone;
   public String mobilePhone;
   public String email;
   public String birthDay;
   public String birthMonth;
   public String birthYear;


    public ContactsData () {
    }

    public ContactsData(String first_name, String last_name, String address1,
                        String homePhone, String mobilePhone, String email,
                        String birthDay, String birthMonth, String birthYear) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address1 = address1;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress1() {
        return address1;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }
}
