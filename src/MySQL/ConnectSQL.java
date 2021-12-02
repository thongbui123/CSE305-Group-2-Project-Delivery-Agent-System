/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import models.Account;
import models.Courier_Request;
import models.Customer;
import models.DeliveryPerson;

/**
 *
 * @author PC
 */
public class ConnectSQL {
    private Connection cn;

    public ConnectSQL() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courier_system?useUnicode=true&characterEncoding=utf8", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection failed !");
        }
    }
    public ArrayList<Account> getListAccount(){
        ArrayList<Account> listAccount = null;
        String sql;
            sql= "SELECT * FROM account WHERE level !=1";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                listAccount = new ArrayList<Account>();
                while(rs.next()){
                    Account acc = new Account(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                    listAccount.add(acc);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Can't get the account list");
        }
            return listAccount;
    }
     public boolean CheckLogin(Account acc)
    {
        boolean check = false;
        String sql;
            sql = "Select * From account Where username = '"+acc.getUsername()+"' AND password='"+acc.getPassword()+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                check = true;
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Incorrect password or account!");
        }
        return check; 
    }
      public int GetLevelAccount(Account acc)
    {
        int levelAccount =0;
        String sql;
            sql = "Select level From account Where username = '"+acc.getUsername()+"' AND password='"+acc.getPassword()+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                levelAccount = rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "wrong account!");
        }
        return levelAccount; 
    }    
    public Account getAccountByID(int id){
        Account acc = null;
        String sql;
            sql= "SELECT * FROM account WHERE accountID ='"+id+"'";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    acc = new Account(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Account not found");
        }
            return acc;
    }
    public Account getAccountByPhone(String phone){
        Account acc = null;
        String sql;
            sql= "SELECT * FROM account WHERE phoneNumber ='"+phone+"'";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    acc = new Account(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Account not found");
        }
            return acc;
    }
    public Account getAccountByUserPass(String user,String pass){
         Account acc = null;
        String sql;
            sql= "SELECT * FROM account WHERE username ='"+user+"' AND password ='"+pass+"'";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    acc = new Account(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Account not found");
        }
            return acc;
    }
    public int InsertAccount(Account b){
        int insert =0;
        String sql ="Insert into account (username, password,phoneNumber,level)values('"+b.getUsername()+"','"+b.getPassword()+"','"+b.getPhoneNumber()+"','"+b.getLevel()+"')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Save successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Save failed");
        }
        return insert;
    }
    public int InsertAccountDeliveryPerson (DeliveryPerson b){
        int insert =0;
        String sql ="Insert into account (username, password,phoneNumber,level)values('"+b.getUsernameP()+"','"+b.getPasswordP()+"','"+b.getPhoneNumberP()+"','"+2+"')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Save failed");
        }
        return insert;
    }
    public int InsertAccountCustomer(Customer b){
        int insert =0;
        String sql ="Insert into account (username, password,phoneNumber,level)values('"+b.getUsernameC()+"','"+b.getPasswordC()+"','"+b.getPhoneNumberC()+"','"+3+"')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Save failed");
        }
        return insert;
    }
    public  int UpdateAccount(Account b){
        int update =0;
        String sql ="UPDATE account SET username ='"+b.getUsername()+"', password ='"+b.getPassword()+"',level ='"+b.getLevel()+"',phoneNumber='"+b.getPhoneNumber()+"'WHERE accountID ='"+b.getAccountID()+"'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Update successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Update failed");
        }
        return update;
    }
    public int UpdatePasswordDelivery(DeliveryPerson b){
        int update =0;
        String sql="UPDATE account SET password='"+b.getPasswordP()+"'WHERE phoneNumber='"+b.getPhoneNumberP()+"'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Update successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Update failed");
        }
        return update;
    }
    public int UpdatePasswordCustomer(Customer b){
        int update =0;
        String sql="UPDATE account SET password='"+b.getPasswordC()+"'WHERE phoneNumber='"+b.getPhoneNumberC()+"'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Update successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Update failed");
        }
        return update;
    }
    
    public void DeleteAccount(int id){
        String sql ="DELETE FROM account WHERE accountID = '"+id+"'";
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Delete successfull");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Can not delete");
        }
    }
    public ArrayList<DeliveryPerson> getListDeliveryPerson(){
        ArrayList<DeliveryPerson> listDeliveryPerson = null;
        String sql;
            sql= "SELECT * FROM delivery_person";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                listDeliveryPerson = new ArrayList<DeliveryPerson>();
                while(rs.next()){
                    DeliveryPerson dp = new DeliveryPerson(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                    listDeliveryPerson.add(dp);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Can't get the DeliveryPerson list");
        }
            return listDeliveryPerson;
    }
    public DeliveryPerson getDeliveryPersonByID(int id){
        DeliveryPerson dp = null;
        String sql;
            sql= "SELECT * FROM delivery_person WHERE deliveryPersonID ='"+id+"'";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dp = new DeliveryPerson(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! DeliveryPerson not found");
        }
            return dp;
    }
    public int InsertDeliveryPerson(DeliveryPerson b){
        int insert =0;
        String sql ="Insert into delivery_person (usernameP, passwordP,dateOfBirthP,emailP,genderP,addressP,phoneNumberP)values('"+b.getUsernameP()+"', '"+b.getPasswordP()+"','"+b.getDateOfBirthP()+"','"+b.getEmailP()+"','"+b.getGenderP()+"','"+b.getAddressP()+"','"+b.getPhoneNumberP()+"')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Save successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Save failed");
        }
        return insert;
    }
    public  int UpdateDeliveryPerson(DeliveryPerson b){
        int update =0;
        String sql ="UPDATE delivery_person SET usernameP ='"+b.getUsernameP()+"', passwordP ='"+b.getPasswordP()+"',dateOfBirthP ='"+b.getDateOfBirthP()+"',emailP='"+b.getEmailP()+"',genderP='"+b.getGenderP()+"',addressP='"+b.getAddressP()+"',phoneNumberP='"+b.getPhoneNumberP()+"'WHERE deliveryPersonID ='"+b.getDeliveryPersonID()+"'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Update successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Update failed");
        }
        return update;
    }
    public void DeleteDeliveryPerson(int id){
        String sql ="DELETE FROM delivery_person WHERE deliveryPersonID = '"+id+"'";
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Delete successfull");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Can not delete");
        }
    }
     public ArrayList<Courier_Request> getListCourier_Request(){
        ArrayList<Courier_Request> listCourier_Request = null;
        String sql;
            sql= "SELECT * FROM courier_request";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                listCourier_Request = new ArrayList<Courier_Request>();
                while(rs.next()){
                    Courier_Request cr = new Courier_Request(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13));
                    listCourier_Request.add(cr);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Can't get the Courier_Request list");
        }
            return listCourier_Request;
    }
      public Courier_Request getCourier_RequestByID(int id){
        Courier_Request cr = null;
        String sql;
            sql= "SELECT * FROM courier_request WHERE courierRequestID ='"+id+"'";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    cr = new Courier_Request(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! courier_request not found");
        }
            return cr;
    }
    public  int UpdateCourier_request(Courier_Request b){
        int update =0;
        String sql ="UPDATE courier_request SET usernameR ='"+b.getUsernameR()+"', description ='"+b.getDesciptionR()+"',approxWeight ='"+b.getApproxWeightR()+"',destination='"+b.getDestinationR()+"',fromAddressR='"+b.getAddressR()+"',phoneNumberR='"+b.getPhoneNumberR()+"',shippingService='"+b.getShippingServiceR()+"',cost ='"+b.getCostR()+"',status='"+b.getStatusR()+"',currentLocation='"+b.getCurrentLocationR()+"',personName='"+b.getPersonNameR()+"' WHERE courierRequestID ='"+b.getCourierReqestID()+"'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Update successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Update failed");
        }
        return update;
    }  
     public void DeleteCourier_Request(int id){
        String sql ="DELETE FROM courier_request WHERE courierRequestID = '"+id+"'";
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Delete successfull");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Can not delete");
        }
    }
     public int InsertCourier_Request(Courier_Request b){
        int insert =0;
        String sql ="Insert into courier_request (usernameR,emailR,description,approxWeight,destination,fromAddressR,phoneNumberR,shippingService,cost,status,currentLocation,personName)values('"+b.getUsernameR()+"','"+b.getEmailR()+"', '"+b.getDesciptionR()+"','"+b.getApproxWeightR()+"','"+b.getDestinationR()+"','"+b.getAddressR()+"','"+b.getPhoneNumberR()+"','"+b.getShippingServiceR()+"','"+b.getCostR()+"','"+b.getStatusR()+"','"+b.getCurrentLocationR()+"','"+b.getPersonNameR()+"')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Save successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Save failed");
        }
        return insert;
    }
    public int InsertCustomer(Customer b){
        int insert =0;
        String sql ="Insert into customer (customerName, passwordC,emailC,dateOfBirthC,genderC,addressC,phoneNumberC)values('"+b.getUsernameC()+"','"+b.getPasswordC()+"','"+b.getEmailC()+"','"+b.getDateOfBirthC()+"','"+b.getGenderC()+"','"+b.getAddressC()+"','"+b.getPhoneNumberC()+"')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Save successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error! Save failed");
        }
        return insert;
    }
}

