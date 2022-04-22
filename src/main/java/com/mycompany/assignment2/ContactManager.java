/**
 * Mikhail Yugay 101312178
 * David Pinto 101280540
 * Yagnik Patel 101324163
 */
package com.mycompany.assignment2;

import java.util.ArrayList;

public class ContactManager {

    private ArrayList<Contact> contacts;
    private int numOfContacts;

    ContactManager() {
        contacts = new ArrayList<Contact>();
        numOfContacts = 0;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public int getNumOfContacts() {
        return numOfContacts;
    }

    public boolean deleteContact(String workPhone) {
        for (int i = 0; i < numOfContacts; i++) {
            if (contacts.get(i).getWorkPhone().equals(workPhone)) {
                contacts.remove(i);
                numOfContacts--;
                return true;
            }
        }
        return false;
    }

    public Contact getContactByPhone(String workPhone) {
        for (int i = 0; i < numOfContacts; i++) {
            if (contacts.get(i).getWorkPhone().equals(workPhone)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public boolean addContact(String firstName, String lastName,
            String homePhone, String workPhone,
            String email, String notes,
            String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country,
            int day, int month, int year) {
        
        for (int i = 0; i < numOfContacts; i++) {
            if (contacts.get(i).getWorkPhone().equals(workPhone)) {
                return false;
            }
        }
        contacts.add(new Contact(firstName, lastName, homePhone, workPhone, email, notes, streetInfo1, streetInfo2, city, postalCode, province, country, day, month, year));
        numOfContacts++;
        return true;
    }

    public boolean addContact() {
        contacts.add(new Contact());
        numOfContacts++;
        return true;
    }

    public boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
