/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author PC
 */
public class DeliveryPerson {
    private int deliveryPersonID;
    private String usernameP, passwordP,dateOfBirthP,emailP,genderP,addressP,phoneNumberP;

    public DeliveryPerson() {
        deliveryPersonID =0;
        usernameP="";
        passwordP="";
        dateOfBirthP="";
        emailP="";
        genderP="";
        addressP="";
        phoneNumberP="";
    }

    public DeliveryPerson(int deliveryPersonID, String usernameP, String passwordP,String dateOfBirthP, String emailP, String genderP, String addressP, String phoneNumberP) {
        this.deliveryPersonID = deliveryPersonID;
        this.usernameP = usernameP;
        this.passwordP = passwordP;
        this.dateOfBirthP=dateOfBirthP;
        this.emailP = emailP;
        this.genderP = genderP;
        this.addressP = addressP;
        this.phoneNumberP = phoneNumberP;
    }

    public int getDeliveryPersonID() {
        return deliveryPersonID;
    }

    public void setDeliveryPersonID(int deliveryPersonID) {
        this.deliveryPersonID = deliveryPersonID;
    }

    public String getUsernameP() {
        return usernameP;
    }

    public void setUsernameP(String usernameP) {
        this.usernameP = usernameP;
    }

    public String getPasswordP() {
        return passwordP;
    }

    public void setPasswordP(String passwordP) {
        this.passwordP = passwordP;
    }

    public String getDateOfBirthP() {
        return dateOfBirthP;
    }

    public void setDateOfBirthP(String dateOfBirthP) {
        this.dateOfBirthP = dateOfBirthP;
    }
    
    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    public String getGenderP() {
        return genderP;
    }

    public void setGenderP(String genderP) {
        this.genderP = genderP;
    }

    public String getAddressP() {
        return addressP;
    }

    public void setAddressP(String addressP) {
        this.addressP = addressP;
    }

    public String getPhoneNumberP() {
        return phoneNumberP;
    }

    public void setPhoneNumberP(String phoneNumberP) {
        this.phoneNumberP = phoneNumberP;
    }
    
}
