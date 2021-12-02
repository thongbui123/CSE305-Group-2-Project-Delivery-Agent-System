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
public class Courier_Request {
    private int courierReqestID,costR;
    private float approxWeightR;
    private String usernameR,emailR,desciptionR,destinationR,addressR,phoneNumberR,shippingServiceR,statusR,currentLocationR,personNameR;

    public Courier_Request() {
        courierReqestID=0;
        usernameR="";
        emailR ="";
        desciptionR="";
        approxWeightR=0;
        destinationR="";
        addressR="";
        phoneNumberR="";
        shippingServiceR="";
        statusR="Pending";
        costR =0;
        currentLocationR="No";
        personNameR="No name"; 
    }

    public Courier_Request(int courierReqestID, String usernameR,String emailR, String desciptionR, float approxWeightR, String destinationR, String addressR, String phoneNumberR, String shippingServiceR,int costR, String statusR, String currentLocationR, String personNameR) {
        this.courierReqestID = courierReqestID;
        this.costR = costR;
        this.usernameR = usernameR;
        this.emailR=emailR;
        this.desciptionR = desciptionR;
        this.approxWeightR = approxWeightR;
        this.destinationR = destinationR;
        this.addressR = addressR;
        this.phoneNumberR = phoneNumberR;
        this.shippingServiceR = shippingServiceR;
        this.statusR = statusR;
        this.currentLocationR = currentLocationR;
        this.personNameR = personNameR;
    }

    public int getCourierReqestID() {
        return courierReqestID;
    }

    public void setCourierReqestID(int courierReqestID) {
        this.courierReqestID = courierReqestID;
    }

    public int getCostR() {
        return costR;
    }

    public void setCostR(int costR) {
        this.costR = costR;
    }

    public String getUsernameR() {
        return usernameR;
    }

    public void setUsernameR(String usernameR) {
        this.usernameR = usernameR;
    }

    public String getEmailR() {
        return emailR;
    }

    public void setEmailR(String emailR) {
        this.emailR = emailR;
    }
    
    public String getDesciptionR() {
        return desciptionR;
    }

    public void setDesciptionR(String desciptionR) {
        this.desciptionR = desciptionR;
    }

    public float getApproxWeightR() {
        return approxWeightR;
    }

    public void setApproxWeightR(float approxWeightR) {
        this.approxWeightR = approxWeightR;
    }

    public String getDestinationR() {
        return destinationR;
    }

    public void setDestinationR(String destinationR) {
        this.destinationR = destinationR;
    }

    public String getAddressR() {
        return addressR;
    }

    public void setAddressR(String addressR) {
        this.addressR = addressR;
    }

    public String getPhoneNumberR() {
        return phoneNumberR;
    }

    public void setPhoneNumberR(String phoneNumberR) {
        this.phoneNumberR = phoneNumberR;
    }

    public String getShippingServiceR() {
        return shippingServiceR;
    }

    public void setShippingServiceR(String shippingServiceR) {
        this.shippingServiceR = shippingServiceR;
    }

    public String getStatusR() {
        return statusR;
    }

    public void setStatusR(String statusR) {
        this.statusR = statusR;
    }

    public String getCurrentLocationR() {
        return currentLocationR;
    }

    public void setCurrentLocationR(String currentLocationR) {
        this.currentLocationR = currentLocationR;
    }

    public String getPersonNameR() {
        return personNameR;
    }

    public void setPersonNameR(String personNameR) {
        this.personNameR = personNameR;
    }
    
}
