/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterFace;

import AppStart.Run;
import MySQL.ConnectSQL;
import TableModels.AccountTableModel;
import TableModels.AdminViewRequestTableModel;
import TableModels.CourierRequestTableModel;
import TableModels.DeliveryTableModel;
import TableModels.DeliveryViewRQAdminTableModel;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import models.Account;
import models.Courier_Request;
import models.DeliveryPerson;



/**
 *
 * @author PC
 */
public final class JFMainAPP extends javax.swing.JFrame {
    ConnectSQL cn = new ConnectSQL();
    ArrayList<DeliveryPerson> listDeliveryPersons= cn.getListDeliveryPerson();
    ArrayList<Courier_Request> listCourierRequest= cn.getListCourier_Request();
    ArrayList<Courier_Request> listViewRequestAdmin = new ArrayList<Courier_Request>();
    public Account LoadAccount(String username, String password){
        return cn.getAccountByUserPass(username, password);
    }
    
    public JFMainAPP() {
        initComponents();
        fill();
        lbl_Show_AccountName.setText(Run.acc.getUsername());
        if(Run.acc.getLevel()==1){
            btnUser.setEnabled(false);
            btn_DeliveryPerson.setEnabled(false);
        }
        if(Run.acc.getLevel()==2){
            btn_Admin.setEnabled(false);
            btnUser.setEnabled(false);
        }
        if(Run.acc.getLevel()==3){
            btn_Admin.setEnabled(false);
            btn_DeliveryPerson.setEnabled(false);
        }
        refreshTableDeliveryPerson();
        refreshTableCourier_Request();
        refreshTableViewUserRequest();
        refreshTableViewAdminRequest();
        
    }
    public void refreshTableDeliveryPerson(){
        DeliveryTableModel tableModel = new DeliveryTableModel(listDeliveryPersons);
        this.Table_ViewDelivery.setModel(tableModel);
    }
    public void refreshTableCourier_Request(){
        CourierRequestTableModel tableModel = new CourierRequestTableModel(listCourierRequest);
        this.Table_ViewCourierStatus.setModel(tableModel);
    }
    public void refreshTableViewUserRequest(){
        AdminViewRequestTableModel tableModel = new AdminViewRequestTableModel(listCourierRequest);
        this.Table_ViewUserRequest.setModel(tableModel);
    }
     public void refreshTableViewAdminRequest(){
        DeliveryViewRQAdminTableModel tableModel = new DeliveryViewRQAdminTableModel(listCourierRequest);
        this.table_ViewRequestAdmin.setModel(tableModel);
    }
    MP3 mp3;
 
    public void fill(){
 
        JplayoutHomeAccount.add(Home);
        JplayoutHomeAccount.updateUI();
        mp3 = new MP3 ("src/Sound/Ai la trieu phu - ai la trieu phu.MP3");
        mp3.play();
        btn_mute.setVisible(false);
 
    }
     public void reloadPanel(int i) {
        JplayoutHomeAccount.removeAll();
        switch(i){
            case 1:
                mp3 = new MP3 ("src/Sound/kasya.MP3");
                mp3.play();
                JplayoutHomeAccount.add(JpHome);
                break;
            case 2:
                mp3 = new MP3 ("src/Sound/kasya.MP3");
                mp3.play();
                JplayoutHomeAccount.add(JPAdmin);
                break;
            case 3:
                mp3 = new MP3 ("src/Sound/kasya.MP3");
                mp3.play();
                JplayoutHomeAccount.add(JPDeliveryPerson);
                break; 
            case 4:
                mp3 = new MP3 ("src/Sound/kasya.MP3");
                mp3.play();
                JplayoutHomeAccount.add(JPUser);
                break;
            default:
                break;
        }
        JplayoutHomeAccount.updateUI();
     }
 class MP3 {
    private Player player;
    private String filename;
    
    public MP3(String filename) {
        this.filename = filename;
    }
    
    public void stop() {
        if (player != null)
            player.close();
    }
    
    public void play() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(bis);
        } catch (FileNotFoundException | JavaLayerException ex) {
            System.out.println(ex);
        }
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }).start();
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupMenu_Delivery = new javax.swing.JPopupMenu();
        EditDelivery = new javax.swing.JMenuItem();
        DeleteDelivery = new javax.swing.JMenuItem();
        jLabel31 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        PopupMenu_ViewUserRequest = new javax.swing.JPopupMenu();
        SendToDelivery = new javax.swing.JMenuItem();
        lbl_Name_Account = new javax.swing.JPanel();
        btn_Home = new javax.swing.JButton();
        btn_Admin = new javax.swing.JButton();
        btn_DeliveryPerson = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btn_Logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_mute = new javax.swing.JButton();
        btn_sound = new javax.swing.JButton();
        lbl_Show_AccountName = new javax.swing.JLabel();
        JplayoutHomeAccount = new javax.swing.JPanel();
        JpHome = new javax.swing.JPanel();
        JPAdmin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_Add_DPerson = new javax.swing.JButton();
        btn_View_DPerson = new javax.swing.JButton();
        btn_ViewRequest = new javax.swing.JButton();
        JPlayoutAmin = new javax.swing.JPanel();
        JP_HomeAdmin = new javax.swing.JPanel();
        JP_ViewAddDeliveryP = new javax.swing.JPanel();
        btn_AddDeliveryPerson = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_UserNamP = new javax.swing.JTextField();
        txt_PasswordP = new javax.swing.JTextField();
        Cbx_GenderP = new javax.swing.JComboBox<>();
        txt_EmailP = new javax.swing.JTextField();
        txt_LocationP = new javax.swing.JTextField();
        txt_MobileNumberP = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jDate_DateOfBirthP = new com.toedter.calendar.JDateChooser();
        JP_ViewDeliveryP = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_ViewDelivery = new javax.swing.JTable();
        jplayoutEditDelivery = new javax.swing.JPanel();
        JPInformationDelivery = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lbl_code_viewDP = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_UserNameDP = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_EmailDP = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lbl_GenderDP = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_LocationDP = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbl_mobileDP = new javax.swing.JLabel();
        JP_Edit_Delivery = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_code_editDP = new javax.swing.JTextField();
        txt_username_editDP = new javax.swing.JTextField();
        txt_Email_editDP = new javax.swing.JTextField();
        cbx_EDitGenderDP = new javax.swing.JComboBox<>();
        txt_Location_editDP = new javax.swing.JTextField();
        txt_Mobile_editDP = new javax.swing.JTextField();
        btn_EditDP = new javax.swing.JButton();
        JP_ViewRequest = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_ViewUserRequest = new javax.swing.JTable();
        JPDeliveryPerson = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_ViewAdminRequest = new javax.swing.JButton();
        JplayoutDeliveryperson = new javax.swing.JPanel();
        JP_ViewAdminRequest = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        lbl_UserName_RequestAdmin = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        Description = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        bl_Email_RequestAdmin = new javax.swing.JLabel();
        bl_description_RequestAdmin = new javax.swing.JLabel();
        bl_weight_RequestAdmin = new javax.swing.JLabel();
        bl_destination_RequestAdmin = new javax.swing.JLabel();
        bl_UseLocation_RequestAdmin = new javax.swing.JLabel();
        bl_mobile_RequestAdmin = new javax.swing.JLabel();
        bl_cost_RequestAdmin = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtCurrentLocation_RAdmin = new javax.swing.JTextField();
        btnApprove = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_ViewRequestAdmin = new javax.swing.JTable();
        JP_HomeDelivery = new javax.swing.JPanel();
        JPUser = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_SendCourierRequest = new javax.swing.JButton();
        btn_ViewStatus = new javax.swing.JButton();
        JpLayoutUser = new javax.swing.JPanel();
        JP_ViewStatus = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_ViewCourierStatus = new javax.swing.JTable();
        JP_HomeUser = new javax.swing.JPanel();
        JP_ViewSendcourierRequest = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_UsernameR = new javax.swing.JTextField();
        txt_EmailR = new javax.swing.JTextField();
        txt_DescriptionR = new javax.swing.JTextField();
        txt_ApproxWeightR = new javax.swing.JTextField();
        txt_DestinationR = new javax.swing.JTextField();
        txt_AddressR = new javax.swing.JTextField();
        txt_PhoneR = new javax.swing.JTextField();
        btn_SendRequest = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        JRB_PREMIUM = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        JRB_GOLD = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        JRB_SILVER = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Home = new javax.swing.JPanel();

        EditDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document_edit.png"))); // NOI18N
        EditDelivery.setText("Edit");
        EditDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDeliveryActionPerformed(evt);
            }
        });
        PopupMenu_Delivery.add(EditDelivery);

        DeleteDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_delete.png"))); // NOI18N
        DeleteDelivery.setText("Delete");
        DeleteDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDeliveryActionPerformed(evt);
            }
        });
        PopupMenu_Delivery.add(DeleteDelivery);

        jLabel31.setText("jLabel31");

        SendToDelivery.setText("Send To Delivery");
        SendToDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendToDeliveryActionPerformed(evt);
            }
        });
        PopupMenu_ViewUserRequest.add(SendToDelivery);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_Name_Account.setBackground(new java.awt.Color(51, 51, 255));

        btn_Home.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HOME.png"))); // NOI18N
        btn_Home.setText("Home");
        btn_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HomeActionPerformed(evt);
            }
        });

        btn_Admin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Admin.setText("Admin");
        btn_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdminActionPerformed(evt);
            }
        });

        btn_DeliveryPerson.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_DeliveryPerson.setText("Delivery Person");
        btn_DeliveryPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeliveryPersonActionPerformed(evt);
            }
        });

        btnUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUser.setText("User");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btn_Logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout.png"))); // NOI18N
        btn_Logout.setText("Logout");
        btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogoutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Account name:");

        btn_mute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mute.png"))); // NOI18N
        btn_mute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_muteActionPerformed(evt);
            }
        });

        btn_sound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sound.png"))); // NOI18N
        btn_sound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_soundActionPerformed(evt);
            }
        });

        lbl_Show_AccountName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout lbl_Name_AccountLayout = new javax.swing.GroupLayout(lbl_Name_Account);
        lbl_Name_Account.setLayout(lbl_Name_AccountLayout);
        lbl_Name_AccountLayout.setHorizontalGroup(
            lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_Name_AccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Home)
                .addGap(45, 45, 45)
                .addComponent(btn_Admin)
                .addGap(27, 27, 27)
                .addComponent(btn_DeliveryPerson)
                .addGap(24, 24, 24)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(lbl_Name_AccountLayout.createSequentialGroup()
                        .addComponent(btn_mute, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sound, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Logout, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lbl_Name_AccountLayout.createSequentialGroup()
                        .addComponent(lbl_Show_AccountName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        lbl_Name_AccountLayout.setVerticalGroup(
            lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbl_Name_AccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbl_Show_AccountName))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbl_Name_AccountLayout.createSequentialGroup()
                        .addGroup(lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_mute)
                            .addComponent(btn_sound))
                        .addGap(23, 23, 23))
                    .addComponent(btn_Logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(lbl_Name_AccountLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(lbl_Name_AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Home)
                    .addComponent(btn_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_DeliveryPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        JplayoutHomeAccount.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout JpHomeLayout = new javax.swing.GroupLayout(JpHome);
        JpHome.setLayout(JpHomeLayout);
        JpHomeLayout.setHorizontalGroup(
            JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1423, Short.MAX_VALUE)
        );
        JpHomeLayout.setVerticalGroup(
            JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        JplayoutHomeAccount.add(JpHome, "card2");

        jPanel1.setBackground(new java.awt.Color(102, 255, 0));

        btn_Add_DPerson.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Add_DPerson.setText("Add Delivery Person");
        btn_Add_DPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Add_DPersonActionPerformed(evt);
            }
        });

        btn_View_DPerson.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_View_DPerson.setText("View Delivery Persons");
        btn_View_DPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_View_DPersonActionPerformed(evt);
            }
        });

        btn_ViewRequest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ViewRequest.setText("View Request");
        btn_ViewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_View_DPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Add_DPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_ViewRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_Add_DPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_View_DPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_ViewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPlayoutAmin.setLayout(new java.awt.CardLayout());

        JP_HomeAdmin.setBackground(new java.awt.Color(102, 255, 255));

        javax.swing.GroupLayout JP_HomeAdminLayout = new javax.swing.GroupLayout(JP_HomeAdmin);
        JP_HomeAdmin.setLayout(JP_HomeAdminLayout);
        JP_HomeAdminLayout.setHorizontalGroup(
            JP_HomeAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1224, Short.MAX_VALUE)
        );
        JP_HomeAdminLayout.setVerticalGroup(
            JP_HomeAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        JPlayoutAmin.add(JP_HomeAdmin, "card2");

        JP_ViewAddDeliveryP.setBackground(new java.awt.Color(102, 255, 255));

        btn_AddDeliveryPerson.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_AddDeliveryPerson.setText("ADD");
        btn_AddDeliveryPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddDeliveryPersonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Add Delivery Person");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("User Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Email  ID");

        jlabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlabel7.setText("Gender");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Location");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Mobile Number");

        txt_UserNamP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_PasswordP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Cbx_GenderP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Cbx_GenderP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select....", "Male", "Female", "Other" }));

        txt_EmailP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_LocationP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_MobileNumberP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Date Of Birth");

        jDate_DateOfBirthP.setDateFormatString("yyyy-MM-dd");
        jDate_DateOfBirthP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout JP_ViewAddDeliveryPLayout = new javax.swing.GroupLayout(JP_ViewAddDeliveryP);
        JP_ViewAddDeliveryP.setLayout(JP_ViewAddDeliveryPLayout);
        JP_ViewAddDeliveryPLayout.setHorizontalGroup(
            JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewAddDeliveryPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(305, 305, 305))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ViewAddDeliveryPLayout.createSequentialGroup()
                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_ViewAddDeliveryPLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_AddDeliveryPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_ViewAddDeliveryPLayout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(JP_ViewAddDeliveryPLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jlabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel20))))
                        .addGap(80, 80, 80)
                        .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_UserNamP)
                            .addComponent(txt_PasswordP)
                            .addComponent(Cbx_GenderP, 0, 389, Short.MAX_VALUE)
                            .addComponent(txt_EmailP)
                            .addComponent(txt_LocationP)
                            .addComponent(txt_MobileNumberP)
                            .addComponent(jDate_DateOfBirthP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(292, 292, 292))
        );
        JP_ViewAddDeliveryPLayout.setVerticalGroup(
            JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewAddDeliveryPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_UserNamP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txt_PasswordP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_EmailP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel7)
                    .addComponent(Cbx_GenderP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jDate_DateOfBirthP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_LocationP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(JP_ViewAddDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_MobileNumberP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btn_AddDeliveryPerson)
                .addGap(44, 44, 44))
        );

        JPlayoutAmin.add(JP_ViewAddDeliveryP, "card3");

        JP_ViewDeliveryP.setBackground(new java.awt.Color(102, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("View Delivery Person");

        Table_ViewDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_ViewDelivery.setComponentPopupMenu(PopupMenu_Delivery);
        Table_ViewDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_ViewDeliveryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_ViewDelivery);

        jplayoutEditDelivery.setLayout(new java.awt.CardLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Code");

        lbl_code_viewDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Username");

        lbl_UserNameDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Email");

        lbl_EmailDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Gender");

        lbl_GenderDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Location");

        lbl_LocationDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Mobile");

        lbl_mobileDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JPInformationDeliveryLayout = new javax.swing.GroupLayout(JPInformationDelivery);
        JPInformationDelivery.setLayout(JPInformationDeliveryLayout);
        JPInformationDeliveryLayout.setHorizontalGroup(
            JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInformationDeliveryLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInformationDeliveryLayout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lbl_EmailDP, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPInformationDeliveryLayout.createSequentialGroup()
                        .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_code_viewDP, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(lbl_UserNameDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_mobileDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JPInformationDeliveryLayout.createSequentialGroup()
                        .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_GenderDP, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(lbl_LocationDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        JPInformationDeliveryLayout.setVerticalGroup(
            JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInformationDeliveryLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lbl_code_viewDP))
                .addGap(29, 29, 29)
                .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lbl_UserNameDP))
                .addGap(36, 36, 36)
                .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lbl_EmailDP))
                .addGap(30, 30, 30)
                .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lbl_GenderDP))
                .addGap(30, 30, 30)
                .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lbl_LocationDP))
                .addGap(28, 28, 28)
                .addGroup(JPInformationDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lbl_mobileDP))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jplayoutEditDelivery.add(JPInformationDelivery, "card15");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Code");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("User name");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Email");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Gender");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Location");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Mobile");

        txt_code_editDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Email_editDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbx_EDitGenderDP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select....", "Male", "Female" }));

        txt_Location_editDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_EditDP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_EditDP.setText("Edit");
        btn_EditDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditDPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Edit_DeliveryLayout = new javax.swing.GroupLayout(JP_Edit_Delivery);
        JP_Edit_Delivery.setLayout(JP_Edit_DeliveryLayout);
        JP_Edit_DeliveryLayout.setHorizontalGroup(
            JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Edit_DeliveryLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_EditDP)
                    .addGroup(JP_Edit_DeliveryLayout.createSequentialGroup()
                        .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(24, 24, 24)
                        .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_code_editDP)
                            .addComponent(txt_username_editDP)
                            .addComponent(txt_Email_editDP)
                            .addComponent(cbx_EDitGenderDP, 0, 174, Short.MAX_VALUE)
                            .addComponent(txt_Location_editDP)
                            .addComponent(txt_Mobile_editDP))))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        JP_Edit_DeliveryLayout.setVerticalGroup(
            JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Edit_DeliveryLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_Edit_DeliveryLayout.createSequentialGroup()
                        .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JP_Edit_DeliveryLayout.createSequentialGroup()
                                .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(JP_Edit_DeliveryLayout.createSequentialGroup()
                                        .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel21)
                                            .addComponent(txt_code_editDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel22)
                                            .addComponent(txt_username_editDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel23))
                                    .addComponent(txt_Email_editDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jLabel24))
                            .addComponent(cbx_EDitGenderDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel25))
                    .addComponent(txt_Location_editDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(JP_Edit_DeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(txt_Mobile_editDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_EditDP)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jplayoutEditDelivery.add(JP_Edit_Delivery, "card16");

        javax.swing.GroupLayout JP_ViewDeliveryPLayout = new javax.swing.GroupLayout(JP_ViewDeliveryP);
        JP_ViewDeliveryP.setLayout(JP_ViewDeliveryPLayout);
        JP_ViewDeliveryPLayout.setHorizontalGroup(
            JP_ViewDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ViewDeliveryPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(298, 298, 298))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ViewDeliveryPLayout.createSequentialGroup()
                .addComponent(jplayoutEditDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_ViewDeliveryPLayout.setVerticalGroup(
            JP_ViewDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewDeliveryPLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(JP_ViewDeliveryPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jplayoutEditDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        JPlayoutAmin.add(JP_ViewDeliveryP, "card4");

        JP_ViewRequest.setBackground(new java.awt.Color(102, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("View User Request");

        Table_ViewUserRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_ViewUserRequest.setComponentPopupMenu(PopupMenu_ViewUserRequest);
        Table_ViewUserRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_ViewUserRequestMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_ViewUserRequest);

        javax.swing.GroupLayout JP_ViewRequestLayout = new javax.swing.GroupLayout(JP_ViewRequest);
        JP_ViewRequest.setLayout(JP_ViewRequestLayout);
        JP_ViewRequestLayout.setHorizontalGroup(
            JP_ViewRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ViewRequestLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(421, 421, 421))
        );
        JP_ViewRequestLayout.setVerticalGroup(
            JP_ViewRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        JPlayoutAmin.add(JP_ViewRequest, "card5");

        javax.swing.GroupLayout JPAdminLayout = new javax.swing.GroupLayout(JPAdmin);
        JPAdmin.setLayout(JPAdminLayout);
        JPAdminLayout.setHorizontalGroup(
            JPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPAdminLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPlayoutAmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPAdminLayout.setVerticalGroup(
            JPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPlayoutAmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JplayoutHomeAccount.add(JPAdmin, "card3");

        jPanel2.setBackground(new java.awt.Color(153, 255, 0));

        btn_ViewAdminRequest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ViewAdminRequest.setText("View Admin Request");
        btn_ViewAdminRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewAdminRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_ViewAdminRequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_ViewAdminRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
        );

        JplayoutDeliveryperson.setLayout(new java.awt.CardLayout());

        JP_ViewAdminRequest.setBackground(new java.awt.Color(102, 255, 255));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 0, 0));
        jLabel40.setText("View Request From Admin");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("User name");

        lbl_UserName_RequestAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Email");

        Description.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Description.setText("Description");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("Weight(kg)");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Destination");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Use Location");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Mobile No");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Cost");

        bl_Email_RequestAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bl_description_RequestAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bl_weight_RequestAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bl_destination_RequestAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bl_UseLocation_RequestAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bl_mobile_RequestAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bl_cost_RequestAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("Current Location");

        txtCurrentLocation_RAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnApprove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Description)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel47)
                            .addComponent(jLabel48)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bl_mobile_RequestAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bl_cost_RequestAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bl_UseLocation_RequestAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bl_destination_RequestAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bl_weight_RequestAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bl_description_RequestAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bl_Email_RequestAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_UserName_RequestAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(18, 18, 18)
                        .addComponent(txtCurrentLocation_RAdmin)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lbl_UserName_RequestAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(bl_Email_RequestAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bl_description_RequestAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(bl_weight_RequestAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(bl_destination_RequestAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(bl_UseLocation_RequestAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(bl_mobile_RequestAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(bl_cost_RequestAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtCurrentLocation_RAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnApprove)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table_ViewRequestAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_ViewRequestAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ViewRequestAdminMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_ViewRequestAdmin);

        javax.swing.GroupLayout JP_ViewAdminRequestLayout = new javax.swing.GroupLayout(JP_ViewAdminRequest);
        JP_ViewAdminRequest.setLayout(JP_ViewAdminRequestLayout);
        JP_ViewAdminRequestLayout.setHorizontalGroup(
            JP_ViewAdminRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewAdminRequestLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JP_ViewAdminRequestLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_ViewAdminRequestLayout.setVerticalGroup(
            JP_ViewAdminRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewAdminRequestLayout.createSequentialGroup()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_ViewAdminRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)))
        );

        JplayoutDeliveryperson.add(JP_ViewAdminRequest, "card2");

        JP_HomeDelivery.setBackground(new java.awt.Color(102, 255, 255));

        javax.swing.GroupLayout JP_HomeDeliveryLayout = new javax.swing.GroupLayout(JP_HomeDelivery);
        JP_HomeDelivery.setLayout(JP_HomeDeliveryLayout);
        JP_HomeDeliveryLayout.setHorizontalGroup(
            JP_HomeDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1224, Short.MAX_VALUE)
        );
        JP_HomeDeliveryLayout.setVerticalGroup(
            JP_HomeDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        JplayoutDeliveryperson.add(JP_HomeDelivery, "card4");

        javax.swing.GroupLayout JPDeliveryPersonLayout = new javax.swing.GroupLayout(JPDeliveryPerson);
        JPDeliveryPerson.setLayout(JPDeliveryPersonLayout);
        JPDeliveryPersonLayout.setHorizontalGroup(
            JPDeliveryPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPDeliveryPersonLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JplayoutDeliveryperson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPDeliveryPersonLayout.setVerticalGroup(
            JPDeliveryPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JplayoutDeliveryperson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JplayoutHomeAccount.add(JPDeliveryPerson, "card4");

        jPanel3.setBackground(new java.awt.Color(153, 255, 0));

        btn_SendCourierRequest.setText("Send Courier Request");
        btn_SendCourierRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SendCourierRequestActionPerformed(evt);
            }
        });

        btn_ViewStatus.setText("View Status");
        btn_ViewStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_SendCourierRequest, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
            .addComponent(btn_ViewStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn_SendCourierRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_ViewStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JpLayoutUser.setLayout(new java.awt.CardLayout());

        JP_ViewStatus.setBackground(new java.awt.Color(102, 255, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("View Courier Status");

        Table_ViewCourierStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(Table_ViewCourierStatus);

        javax.swing.GroupLayout JP_ViewStatusLayout = new javax.swing.GroupLayout(JP_ViewStatus);
        JP_ViewStatus.setLayout(JP_ViewStatusLayout);
        JP_ViewStatusLayout.setHorizontalGroup(
            JP_ViewStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewStatusLayout.createSequentialGroup()
                .addContainerGap(528, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        JP_ViewStatusLayout.setVerticalGroup(
            JP_ViewStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewStatusLayout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
        );

        JpLayoutUser.add(JP_ViewStatus, "card3");

        JP_HomeUser.setBackground(new java.awt.Color(102, 255, 255));

        javax.swing.GroupLayout JP_HomeUserLayout = new javax.swing.GroupLayout(JP_HomeUser);
        JP_HomeUser.setLayout(JP_HomeUserLayout);
        JP_HomeUserLayout.setHorizontalGroup(
            JP_HomeUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1218, Short.MAX_VALUE)
        );
        JP_HomeUserLayout.setVerticalGroup(
            JP_HomeUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        JpLayoutUser.add(JP_HomeUser, "card4");

        JP_ViewSendcourierRequest.setBackground(new java.awt.Color(102, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Send Courier Request");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("User Name");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Email ID");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Description");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Approx Weight");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Destination");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("From Address");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Mobile Number");

        txt_UsernameR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_EmailR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_DescriptionR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_ApproxWeightR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_DestinationR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_AddressR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_PhoneR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_SendRequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_SendRequest.setText("Send Request");
        btn_SendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SendRequestActionPerformed(evt);
            }
        });

        buttonGroup1.add(JRB_PREMIUM);
        JRB_PREMIUM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JRB_PREMIUM.setText("Service Type: PREMIUM");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Delivery Time: 2days");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("240");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JRB_PREMIUM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JRB_PREMIUM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addContainerGap())
        );

        buttonGroup1.add(JRB_GOLD);
        JRB_GOLD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JRB_GOLD.setText("Service Type: GOLD");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Delivery Time: 3days");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("220");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JRB_GOLD, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(JRB_GOLD)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addContainerGap())
        );

        buttonGroup1.add(JRB_SILVER);
        JRB_SILVER.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JRB_SILVER.setText("Service Type: SILVER");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Delivery Time: 4days");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("200");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JRB_SILVER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(JRB_SILVER)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addContainerGap())
        );

        javax.swing.GroupLayout JP_ViewSendcourierRequestLayout = new javax.swing.GroupLayout(JP_ViewSendcourierRequest);
        JP_ViewSendcourierRequest.setLayout(JP_ViewSendcourierRequestLayout);
        JP_ViewSendcourierRequestLayout.setHorizontalGroup(
            JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ViewSendcourierRequestLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(JP_ViewSendcourierRequestLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_ViewSendcourierRequestLayout.createSequentialGroup()
                        .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_ViewSendcourierRequestLayout.createSequentialGroup()
                                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(48, 48, 48)
                                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_DescriptionR, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_DestinationR, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_AddressR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_PhoneR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_ApproxWeightR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JP_ViewSendcourierRequestLayout.createSequentialGroup()
                        .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(89, 89, 89)
                        .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_UsernameR, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_EmailR, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ViewSendcourierRequestLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_SendRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        JP_ViewSendcourierRequestLayout.setVerticalGroup(
            JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ViewSendcourierRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JP_ViewSendcourierRequestLayout.createSequentialGroup()
                        .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_UsernameR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(36, 36, 36)
                        .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(txt_EmailR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(txt_DescriptionR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(txt_ApproxWeightR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(txt_DestinationR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(txt_AddressR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(JP_ViewSendcourierRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_PhoneR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_SendRequest)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        JpLayoutUser.add(JP_ViewSendcourierRequest, "card2");

        javax.swing.GroupLayout JPUserLayout = new javax.swing.GroupLayout(JPUser);
        JPUser.setLayout(JPUserLayout);
        JPUserLayout.setHorizontalGroup(
            JPUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPUserLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpLayoutUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPUserLayout.setVerticalGroup(
            JPUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpLayoutUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JplayoutHomeAccount.add(JPUser, "card5");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1423, Short.MAX_VALUE)
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        JplayoutHomeAccount.add(Home, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Name_Account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JplayoutHomeAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_Name_Account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JplayoutHomeAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomeActionPerformed
        // TODO add your handling code here:
        reloadPanel(1);
    }//GEN-LAST:event_btn_HomeActionPerformed

    private void btn_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdminActionPerformed
        // TODO add your handling code here:
        reloadPanel(2);
        JPlayoutAmin.removeAll();
        JPlayoutAmin.add(JP_HomeAdmin);
        JPlayoutAmin.updateUI();
    }//GEN-LAST:event_btn_AdminActionPerformed

    private void btn_DeliveryPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeliveryPersonActionPerformed
        // TODO add your handling code here:
        reloadPanel(3);
        JplayoutDeliveryperson.removeAll();
        JplayoutDeliveryperson.add(JP_HomeDelivery);
        JplayoutDeliveryperson.updateUI();
    }//GEN-LAST:event_btn_DeliveryPersonActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        reloadPanel(4);
        JpLayoutUser.removeAll();
        JpLayoutUser.add(JP_HomeUser);
        JpLayoutUser.updateUI();
    }//GEN-LAST:event_btnUserActionPerformed
 MP3 nhacnen;
    private void btn_muteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_muteActionPerformed
        // TODO add your handling code here:
         nhacnen.stop();
        btn_sound.setVisible(true);
        btn_mute.setVisible(false);
    }//GEN-LAST:event_btn_muteActionPerformed

    private void btn_soundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_soundActionPerformed
        // TODO add your handling code here:
        nhacnen = new MP3 ("src/Sound/Fur Elise - Richard Clayderman.MP3");
        nhacnen.play();
        btn_sound.setVisible(false);
        btn_mute.setVisible(true);
    }//GEN-LAST:event_btn_soundActionPerformed
   
    private void btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogoutActionPerformed
        // TODO add your handling code here:
        int kq=JOptionPane.showConfirmDialog(null, "Đăng xuất khỏi tài khoản " +Run.acc.getUsername()+ "?","FBI Warning",JOptionPane.YES_NO_OPTION);
        if(kq==0)
        {
            MP3 mp3 = new MP3 ("src/Sound/tyaran.MP3");
            mp3.play();
            Run.mainApp.setVisible(true);
            Run.login.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_LogoutActionPerformed
//layoutAdmin
    private void btn_Add_DPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Add_DPersonActionPerformed
        // TODO add your handling code here:
            JPlayoutAmin.removeAll();
            JPlayoutAmin.add(JP_ViewAddDeliveryP);
            JPlayoutAmin.updateUI();
        
    }//GEN-LAST:event_btn_Add_DPersonActionPerformed

    private void btn_View_DPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_View_DPersonActionPerformed
        // TODO add your handling code here:
            JPlayoutAmin.removeAll();
            JPlayoutAmin.add(JP_ViewDeliveryP);
            JPlayoutAmin.updateUI();
    }//GEN-LAST:event_btn_View_DPersonActionPerformed

    private void btn_ViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewRequestActionPerformed
        // TODO add your handling code here:
            JPlayoutAmin.removeAll();
            JPlayoutAmin.add(JP_ViewRequest);
            JPlayoutAmin.updateUI();
    }//GEN-LAST:event_btn_ViewRequestActionPerformed
//layout DeliveryPerSon
    private void btn_ViewAdminRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewAdminRequestActionPerformed
        // TODO add your handling code here:
        JplayoutDeliveryperson.removeAll();
        JplayoutDeliveryperson.add(JP_ViewAdminRequest);
        JplayoutDeliveryperson.updateUI();
    }//GEN-LAST:event_btn_ViewAdminRequestActionPerformed
//layout User
    private void btn_SendCourierRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SendCourierRequestActionPerformed
        // TODO add your handling code here:
        JpLayoutUser.removeAll();
        JpLayoutUser.add(JP_ViewSendcourierRequest);
        JpLayoutUser.updateUI();
    }//GEN-LAST:event_btn_SendCourierRequestActionPerformed

    private void btn_ViewStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewStatusActionPerformed
        // TODO add your handling code here:
        JpLayoutUser.removeAll();
        JpLayoutUser.add(JP_ViewStatus);
        JpLayoutUser.updateUI();
    }//GEN-LAST:event_btn_ViewStatusActionPerformed

    private void btn_AddDeliveryPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddDeliveryPersonActionPerformed
        // TODO add your handling code here:
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DeliveryPerson person = new DeliveryPerson();
        person.setUsernameP(txt_UserNamP.getText());
        person.setPasswordP(txt_PasswordP.getText());
        person.setEmailP(txt_EmailP.getText());
        person.setGenderP((String)Cbx_GenderP.getSelectedItem());
        person.setDateOfBirthP(df.format(jDate_DateOfBirthP.getDate()));
        person.setAddressP(txt_LocationP.getText());
        person.setPhoneNumberP(txt_MobileNumberP.getText());
        cn.InsertAccountDeliveryPerson(person);
        int numberDelivery = cn.InsertDeliveryPerson(person);
        listDeliveryPersons =cn.getListDeliveryPerson();
        refreshTableDeliveryPerson();
        
        
    }//GEN-LAST:event_btn_AddDeliveryPersonActionPerformed

    private void btn_SendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SendRequestActionPerformed
        // TODO add your handling code here:
        Courier_Request cr = new Courier_Request();
        cr.setUsernameR(txt_UsernameR.getText());
        cr.setEmailR(txt_EmailR.getText());
        cr.setDesciptionR(txt_DescriptionR.getText());
        cr.setApproxWeightR(Float.parseFloat(txt_ApproxWeightR.getText()));
        cr.setDestinationR(txt_DestinationR.getText());
        cr.setAddressR(txt_AddressR.getText());
        cr.setPhoneNumberR(txt_PhoneR.getText());
        /*cr.setStatusR("pending");
        cr.setPersonNameR("No Name");
        cr.setCurrentLocationR("No");*/
        String shippingService ="";
        int cost =0;
        if(JRB_PREMIUM.isSelected()){
            shippingService= "PREMIUM(2days)";
            cost=240;
        }
        if(JRB_GOLD.isSelected()){
           shippingService ="GOLD(3days)";
           cost=220;
        }
        if(JRB_SILVER.isSelected()){
            shippingService ="SILVER(4days)";
            cost =200;
        }
        cr.setShippingServiceR(shippingService);
        cr.setCostR(cost);
        int request = cn.InsertCourier_Request(cr);
        listCourierRequest =cn.getListCourier_Request();
        refreshTableCourier_Request();
        refreshTableViewUserRequest();
        
    }//GEN-LAST:event_btn_SendRequestActionPerformed
    
    private void Table_ViewDeliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_ViewDeliveryMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON3) {
            PopupMenu_Delivery.show(this, evt.getX(), evt.getY());
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            jplayoutEditDelivery.removeAll();
            jplayoutEditDelivery.add(JPInformationDelivery);
            jplayoutEditDelivery.repaint();
            jplayoutEditDelivery.revalidate();
            fillInDataViewDP();
        }
    }//GEN-LAST:event_Table_ViewDeliveryMouseClicked
    
    private void fillInDataViewDP(){
        int row = this.Table_ViewDelivery.getSelectedRow();
        DeliveryTableModel model = (DeliveryTableModel) this.Table_ViewDelivery.getModel();
        DeliveryPerson selectDP = (DeliveryPerson)model.getObjectAtRow(row);
        this.lbl_code_viewDP.setText(String.valueOf(selectDP.getDeliveryPersonID()));
        this.lbl_UserNameDP.setText(selectDP.getUsernameP());
        this.lbl_EmailDP.setText(selectDP.getEmailP());
        this.lbl_GenderDP.setText(selectDP.getGenderP());
        this.lbl_LocationDP.setText(selectDP.getAddressP());
        this.lbl_mobileDP.setText(selectDP.getPhoneNumberP());
    }
    
    private void EditDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDeliveryActionPerformed
        // TODO add your handling code here:
            jplayoutEditDelivery.removeAll();
            jplayoutEditDelivery.add(JP_Edit_Delivery);
            jplayoutEditDelivery.repaint();
            jplayoutEditDelivery.revalidate();
            fillInDataViewDP_Edit();
        
    }//GEN-LAST:event_EditDeliveryActionPerformed
    private void fillInDataViewDP_Edit(){
        int row = this.Table_ViewDelivery.getSelectedRow();
        DeliveryTableModel model = (DeliveryTableModel) this.Table_ViewDelivery.getModel();
        DeliveryPerson selectDP = (DeliveryPerson)model.getObjectAtRow(row);
        this.txt_code_editDP.setText(String.valueOf(selectDP.getDeliveryPersonID()));
        this.txt_username_editDP.setText(selectDP.getUsernameP());
        this.txt_Email_editDP.setText(selectDP.getEmailP());
        this.cbx_EDitGenderDP.setSelectedItem(selectDP.getGenderP());
        this.txt_Location_editDP.setText(selectDP.getAddressP());
        this.txt_Mobile_editDP.setText(selectDP.getPhoneNumberP());
    }
    private void DeleteDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDeliveryActionPerformed
        // TODO add your handling code here:
         int row = this.Table_ViewDelivery.getSelectedRow();
         DeliveryTableModel model = (DeliveryTableModel) this.Table_ViewDelivery.getModel();
         DeliveryPerson selectDP = (DeliveryPerson)model.getObjectAtRow(row);
         cn.DeleteDeliveryPerson(selectDP.getDeliveryPersonID());
         listDeliveryPersons = cn.getListDeliveryPerson();
         refreshTableDeliveryPerson();
    }//GEN-LAST:event_DeleteDeliveryActionPerformed

    private void btn_EditDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditDPActionPerformed
        // TODO add your handling code here:
        int row = this.Table_ViewDelivery.getSelectedRow();
        DeliveryTableModel model = (DeliveryTableModel) this.Table_ViewDelivery.getModel();
        DeliveryPerson selectDP = (DeliveryPerson)model.getObjectAtRow(row);
            selectDP.setDeliveryPersonID(Integer.parseInt(txt_code_editDP.getText()));
            selectDP.setUsernameP(txt_username_editDP.getText());
            selectDP.setEmailP(txt_Email_editDP.getText());
            selectDP.setAddressP(txt_Location_editDP.getText());
            selectDP.setGenderP((String)cbx_EDitGenderDP.getSelectedItem());
            selectDP.setPhoneNumberP(txt_Mobile_editDP.getText());
            cn.UpdateDeliveryPerson(selectDP);
            cleardataDP();
            listDeliveryPersons = cn.getListDeliveryPerson();
            refreshTableDeliveryPerson(); 
    }//GEN-LAST:event_btn_EditDPActionPerformed

    private void Table_ViewUserRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_ViewUserRequestMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON3) {
            PopupMenu_Delivery.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_Table_ViewUserRequestMouseClicked

    private void SendToDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendToDeliveryActionPerformed
        // TODO add your handling code here:
       // int row = this.Table_ViewUserRequest.getSelectedRow();
       // AdminViewRequestTableModel model = (AdminViewRequestTableModel) this.Table_ViewUserRequest.getModel();
       // Courier_Request selectCR = (Courier_Request)model.getObjectAtRow(row);
        listCourierRequest =cn.getListCourier_Request();
        refreshTableViewAdminRequest();
        JOptionPane.showMessageDialog(this, "successfull");
        
            
    }//GEN-LAST:event_SendToDeliveryActionPerformed

    private void table_ViewRequestAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ViewRequestAdminMouseClicked
        // TODO add your handling code here:
             if (evt.getButton() == MouseEvent.BUTTON1) {
            fillInDataViewAdminRequest();
        }         
        
    }//GEN-LAST:event_table_ViewRequestAdminMouseClicked

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        int row = this.table_ViewRequestAdmin.getSelectedRow();
        DeliveryViewRQAdminTableModel model = (DeliveryViewRQAdminTableModel) this.table_ViewRequestAdmin.getModel();
        Courier_Request selectCR = (Courier_Request)model.getObjectAtRow(row);
            selectCR.setCurrentLocationR(txtCurrentLocation_RAdmin.getText());
            selectCR.setStatusR("Received");
            selectCR.setPersonNameR(Run.acc.getUsername());
            cn.UpdateCourier_request(selectCR);
            clearDataRQAdmin();
            listCourierRequest =cn.getListCourier_Request();
            refreshTableViewAdminRequest();
        
    }//GEN-LAST:event_btnApproveActionPerformed
    private void fillInDataViewAdminRequest() {
        int row = this.table_ViewRequestAdmin.getSelectedRow();
        DeliveryViewRQAdminTableModel model = (DeliveryViewRQAdminTableModel) this.table_ViewRequestAdmin.getModel();
        Courier_Request selectCR = (Courier_Request)model.getObjectAtRow(row);
        lbl_UserName_RequestAdmin.setText(selectCR.getUsernameR());
        bl_Email_RequestAdmin.setText(selectCR.getEmailR());
        bl_description_RequestAdmin.setText(selectCR.getDesciptionR());
        bl_weight_RequestAdmin.setText(String.valueOf(selectCR.getApproxWeightR()));
        bl_destination_RequestAdmin.setText(selectCR.getDestinationR());
        bl_UseLocation_RequestAdmin.setText(selectCR.getAddressR());
        bl_mobile_RequestAdmin.setText(selectCR.getPhoneNumberR());
        bl_cost_RequestAdmin.setText(String.valueOf(selectCR.getCostR()));
        
    }
    private void clearDataRQAdmin(){
         lbl_UserName_RequestAdmin.setText("");
        bl_Email_RequestAdmin.setText("");
        bl_description_RequestAdmin.setText("");
        bl_weight_RequestAdmin.setText("");
        bl_destination_RequestAdmin.setText("");
        bl_UseLocation_RequestAdmin.setText("");
        bl_mobile_RequestAdmin.setText("");
        bl_cost_RequestAdmin.setText("");
    }
    private void cleardataDP(){
        txt_code_editDP.setText("");
        txt_username_editDP.setText("");
        txt_Email_editDP.setText("");
        txt_Location_editDP.setText("");
        txt_Mobile_editDP.setText("");
        cbx_EDitGenderDP.setSelectedIndex(0);
    }
 
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbx_GenderP;
    private javax.swing.JMenuItem DeleteDelivery;
    private javax.swing.JLabel Description;
    private javax.swing.JMenuItem EditDelivery;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel JPAdmin;
    private javax.swing.JPanel JPDeliveryPerson;
    private javax.swing.JPanel JPInformationDelivery;
    private javax.swing.JPanel JPUser;
    private javax.swing.JPanel JP_Edit_Delivery;
    private javax.swing.JPanel JP_HomeAdmin;
    private javax.swing.JPanel JP_HomeDelivery;
    private javax.swing.JPanel JP_HomeUser;
    private javax.swing.JPanel JP_ViewAddDeliveryP;
    private javax.swing.JPanel JP_ViewAdminRequest;
    private javax.swing.JPanel JP_ViewDeliveryP;
    private javax.swing.JPanel JP_ViewRequest;
    private javax.swing.JPanel JP_ViewSendcourierRequest;
    private javax.swing.JPanel JP_ViewStatus;
    private javax.swing.JPanel JPlayoutAmin;
    private javax.swing.JRadioButton JRB_GOLD;
    private javax.swing.JRadioButton JRB_PREMIUM;
    private javax.swing.JRadioButton JRB_SILVER;
    private javax.swing.JPanel JpHome;
    private javax.swing.JPanel JpLayoutUser;
    private javax.swing.JPanel JplayoutDeliveryperson;
    private javax.swing.JPanel JplayoutHomeAccount;
    private javax.swing.JPopupMenu PopupMenu_Delivery;
    private javax.swing.JPopupMenu PopupMenu_ViewUserRequest;
    private javax.swing.JMenuItem SendToDelivery;
    private javax.swing.JTable Table_ViewCourierStatus;
    private javax.swing.JTable Table_ViewDelivery;
    private javax.swing.JTable Table_ViewUserRequest;
    private javax.swing.JLabel bl_Email_RequestAdmin;
    private javax.swing.JLabel bl_UseLocation_RequestAdmin;
    private javax.swing.JLabel bl_cost_RequestAdmin;
    private javax.swing.JLabel bl_description_RequestAdmin;
    private javax.swing.JLabel bl_destination_RequestAdmin;
    private javax.swing.JLabel bl_mobile_RequestAdmin;
    private javax.swing.JLabel bl_weight_RequestAdmin;
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton btn_AddDeliveryPerson;
    private javax.swing.JButton btn_Add_DPerson;
    private javax.swing.JButton btn_Admin;
    private javax.swing.JButton btn_DeliveryPerson;
    private javax.swing.JButton btn_EditDP;
    private javax.swing.JButton btn_Home;
    private javax.swing.JButton btn_Logout;
    private javax.swing.JButton btn_SendCourierRequest;
    private javax.swing.JButton btn_SendRequest;
    private javax.swing.JButton btn_ViewAdminRequest;
    private javax.swing.JButton btn_ViewRequest;
    private javax.swing.JButton btn_ViewStatus;
    private javax.swing.JButton btn_View_DPerson;
    private javax.swing.JButton btn_mute;
    private javax.swing.JButton btn_sound;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbx_EDitGenderDP;
    private com.toedter.calendar.JDateChooser jDate_DateOfBirthP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JPanel jplayoutEditDelivery;
    private javax.swing.JLabel lbl_EmailDP;
    private javax.swing.JLabel lbl_GenderDP;
    private javax.swing.JLabel lbl_LocationDP;
    private javax.swing.JPanel lbl_Name_Account;
    private javax.swing.JLabel lbl_Show_AccountName;
    private javax.swing.JLabel lbl_UserNameDP;
    private javax.swing.JLabel lbl_UserName_RequestAdmin;
    private javax.swing.JLabel lbl_code_viewDP;
    private javax.swing.JLabel lbl_mobileDP;
    private javax.swing.JTable table_ViewRequestAdmin;
    private javax.swing.JTextField txtCurrentLocation_RAdmin;
    private javax.swing.JTextField txt_AddressR;
    private javax.swing.JTextField txt_ApproxWeightR;
    private javax.swing.JTextField txt_DescriptionR;
    private javax.swing.JTextField txt_DestinationR;
    private javax.swing.JTextField txt_EmailP;
    private javax.swing.JTextField txt_EmailR;
    private javax.swing.JTextField txt_Email_editDP;
    private javax.swing.JTextField txt_LocationP;
    private javax.swing.JTextField txt_Location_editDP;
    private javax.swing.JTextField txt_MobileNumberP;
    private javax.swing.JTextField txt_Mobile_editDP;
    private javax.swing.JTextField txt_PasswordP;
    private javax.swing.JTextField txt_PhoneR;
    private javax.swing.JTextField txt_UserNamP;
    private javax.swing.JTextField txt_UsernameR;
    private javax.swing.JTextField txt_code_editDP;
    private javax.swing.JTextField txt_username_editDP;
    // End of variables declaration//GEN-END:variables
}
