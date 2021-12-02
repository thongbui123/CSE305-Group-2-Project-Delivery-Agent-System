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
public class Account {
    private int accountID,level;
    private String username,password,phoneNumber;

    public Account() {
        accountID=level =0;
        username="";
        password="";
        phoneNumber="";
    }

    public Account(int accountID, String username, String password,String phoneNumber,int level) {
        this.accountID = accountID;
        this.level = level;
        this.username = username;
        this.password = password;
        this.phoneNumber=phoneNumber;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
