/**
 * Mikhail Yugay 101312178
 * David Pinto 101280540
 * Yagnik Patel 101324163
 */
package com.mycompany.assignment2;

public class Address {

    public String streetInfo1;
    public String streetInfo2;
    public String city;
    public String postalCode;
    public String province;
    public String country;

    public Address() {
        this.city = "Test-Toronto";
        this.streetInfo1 = "Test-StreetInfo1";
        this.streetInfo2 = "Test-StreetInfo2";
        this.postalCode = "PostalCodeTest";
        this.province = "Province";
        this.country = "Country";
    }

    public String getStreetInfo1() {
        return streetInfo1;
    }

    public String getStreetInfo2() {
        return streetInfo2;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public void setStreetInfo1(String streetInfo1) {
        this.streetInfo1 = streetInfo1;
    }

    public void setStreetInfo2(String streetInfo2) {
        this.streetInfo2 = streetInfo2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address(String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country) {
        this.streetInfo1 = streetInfo1;
        this.streetInfo2 = streetInfo2;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }
}
