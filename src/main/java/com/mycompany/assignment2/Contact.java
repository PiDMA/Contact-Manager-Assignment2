/**
 * Mikhail Yugay 101312178
 * David Pinto 101280540
 * Yagnik Patel 101324163
 */
package com.mycompany.assignment2;

public class Contact {

    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private Address homeAddress;
    private String email;
    private MyDate birthday;
    private String notes;

    //Constructor
    public Contact(String firstName, String lastName,
            String homePhone, String workPhone,
            String email, String notes,
            String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country,
            int day, int month, int year
    ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.homeAddress = new Address(streetInfo1, streetInfo2, city, postalCode, province, country);
        this.email = email;
        this.birthday = new MyDate(day, month, year);
        this.notes = notes;
    }

    public Contact() {
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.homePhone = "homePhone";
        this.workPhone = "workPhone";
        this.homeAddress = new Address();
        this.email = "email";
        this.birthday = new MyDate();
        this.notes = "notes";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", homePhone='" + homePhone + '\''
                + ", workPhone='" + workPhone + '\''
                + ", homeAddress=" + homeAddress
                + ", email='" + email + '\''
                + ", birthday=" + birthday
                + ", notes='" + notes + '\''
                + '}';
    }
}
