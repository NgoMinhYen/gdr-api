package dataObject;

import java.util.Date;

public class Account {
    private String yourName;
    private String title;
    private String email;
    private String dob;
    private String gender;
    private String visitCountry;
    private String country;
    private String region;
    private String city;
    private String address;
    private String phoneNumber;
    private String workPhone;

    public Account() { }

    public Account(String yourName, String title) {
        setYourName(yourName);
        setTitle(title);
    }

//    public Account(String yourName, String title, String email, String dob, String gender, String visitCountry, String country, String region, String city, String address, String phoneNumber, String workPhone) {
//        this.yourName = yourName;
//        this.title = title;
//        this.email = email;
//        this.dob = dob;
//        this.gender = gender;
//        this.visitCountry = visitCountry;
//        this.country = country;
//        this.region = region;
//        this.city = city;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.workPhone = workPhone;
//    }

    public String getYourName() {
        return yourName;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVisitCountry() {
        return visitCountry;
    }

    public void setVisitCountry(String visitCountry) {
        this.visitCountry = visitCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
}
