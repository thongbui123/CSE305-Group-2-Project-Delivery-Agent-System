/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppStart;

import InterFace.JFLogin;
import InterFace.JFMainAPP;
import models.Account;

/**
 *
 * @author PC
 */
public class Run {
    public static JFLogin login;
    public static Account acc;
    public static JFMainAPP mainApp;
    public static void main(String[] args) {
        loginAPP();
    }
     public static void loginAPP(){
        login = new JFLogin();
        login.setVisible(true);
    }
     public static void AppSystem(){
        mainApp = new JFMainAPP();
        mainApp.setVisible(true);
    }
}
