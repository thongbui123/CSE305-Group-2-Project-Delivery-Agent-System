/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterFace;

import AppStart.Run;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import models.Account;
import MySQL.ConnectSQL;

/**
 *
 * @author PC
 */
public class JFLogin extends javax.swing.JFrame {

    ConnectSQL cn = new ConnectSQL();

    /**
     * Creates new form JFLogin
     */
    public JFLogin() {
        initComponents();
        JRootPane rp = this.getRootPane();
        rp.setDefaultButton(btn_Login);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_UserName = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        btn_Login = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        lbl_Call_Register = new javax.swing.JLabel();
        chbx_ShowPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password:");

        txt_UserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_Password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_Login.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Login.setText("Login");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        btn_Thoat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Thoat.setText("Cancel");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });

        lbl_Call_Register.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Call_Register.setForeground(new java.awt.Color(51, 102, 255));
        lbl_Call_Register.setText("Click here to create a new account");
        lbl_Call_Register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Call_Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_Call_RegisterMouseClicked(evt);
            }
        });

        chbx_ShowPass.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        chbx_ShowPass.setText("Show Password");
        chbx_ShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbx_ShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_Thoat)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbl_Call_Register, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_Password, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(txt_UserName))
                            .addComponent(chbx_ShowPass))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbx_ShowPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Thoat)
                    .addComponent(btn_Login))
                .addGap(18, 18, 18)
                .addComponent(lbl_Call_Register)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_Call_RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Call_RegisterMouseClicked
        // TODO add your handling code here:
        RegisterForm rg = new RegisterForm();
        rg.setVisible(true);
    }//GEN-LAST:event_lbl_Call_RegisterMouseClicked

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        // TODO add your handling code here:
        String user, pass;
        user = txt_UserName.getText();
        pass = String.valueOf(txt_Password.getPassword());

        if (user.equals("")) {
            JOptionPane.showMessageDialog(this, "Enter Username");
            return;
        }

        if (pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Enter Password");
            return;
        }

        Account acc = new Account();
        acc.setUsername(user);
        acc.setPassword(pass);
        boolean ckeck = cn.CheckLogin(acc);
        int level = cn.GetLevelAccount(acc);
        if (ckeck == true) {
            JOptionPane.showMessageDialog(this, "Successful");
            Run.acc = cn.getAccountByUserPass(user, pass);
            this.setVisible(false);
            Run.AppSystem();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect account or password?", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void chbx_ShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbx_ShowPassActionPerformed
        if (chbx_ShowPass.isSelected()) {
            txt_Password.setEchoChar((char) 0);
        } else {
            txt_Password.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_chbx_ShowPassActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JCheckBox chbx_ShowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Call_Register;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_UserName;
    // End of variables declaration//GEN-END:variables
}