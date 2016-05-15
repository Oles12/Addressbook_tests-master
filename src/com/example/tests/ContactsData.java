package com.example.tests;

public class ContactsData implements Comparable<ContactsData> {
   public String first_name;
   public String last_name;
   public String address1;
   public String homePhone;
   public String mobilePhone;
   public String email;
   public String birthDay;
   public String birthMonth;
   public String birthYear;


    public ContactsData (){
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


    @Override
    public String toString() {
        return "ContactsData{" +
                "address1='" + address1 + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return last_name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactsData that = (ContactsData) o;

        return last_name.equals(that.last_name);
    }


    @Override
    public int compareTo(ContactsData other) {
        return this.last_name.toLowerCase().compareTo(other.last_name.toLowerCase());
    }

}

