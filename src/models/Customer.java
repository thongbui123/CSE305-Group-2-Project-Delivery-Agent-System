/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author PC
 */
public class Customer {
    private int customerID;
    private String usernameC,passwordC,emailC,dateOfBirthC, genderC,addressC,phoneNumberC;

    public Customer() {
        customerID=0;
        usernameC="";
        passwordC="";
        emailC="";
        dateOfBirthC="";
        genderC="";
        addressC="";
        phoneNumberC="";
    }

    public Customer(int customerID, String usernameC, String passwordC, String emailC, String dateOfBirthC,String genderC, String addressC, String phoneNumberC) {
        this.customerID = customerID;
        this.usernameC = usernameC;
        this.passwordC = passwordC;
        this.emailC = emailC;
        this.dateOfBirthC = dateOfBirthC;
        this.genderC=genderC;
        this.addressC = addressC;
        this.phoneNumberC = phoneNumberC;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getUsernameC() {
        return usernameC;
    }

    public void setUsernameC(String usernameC) {
        this.usernameC = usernameC;
    }

    public String getPasswordC() {
        return passwordC;
    }

    public void setPasswordC(String passwordC) {
        this.passwordC = passwordC;
    }

    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    public String getDateOfBirthC() {
        return dateOfBirthC;
    }

    public void setDateOfBirthC(String dateOfBirthC) {
        this.dateOfBirthC = dateOfBirthC;
    }

    public String getGenderC() {
        return genderC;
    }

    public void setGenderC(String genderC) {
        this.genderC = genderC;
    }
    
    public String getAddressC() {
        return addressC;
    }

    public void setAddressC(String addressC) {
        this.addressC = addressC;
    }

    public String getPhoneNumberC() {
        return phoneNumberC;
    }

    public void setPhoneNumberC(String phoneNumberC) {
        this.phoneNumberC = phoneNumberC;
    }
    
}
