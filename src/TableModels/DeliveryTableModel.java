/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import models.DeliveryPerson;


/**
 *
 * @author PC
 */
public class DeliveryTableModel extends AbstractTableModel{
    private String[] columnNames ={"Code" ,"Username","Email","Gender","Location","Mobile"};
    private  ArrayList<DeliveryPerson> listdata;
    private ArrayList<Object[]> listRow = new ArrayList<>();
    
    public DeliveryTableModel(ArrayList<DeliveryPerson> listDelivery){
        this.listdata = listDelivery;
        DeliveryPerson dp;
        for (int i = 0; i < this.listdata.size(); i++) {
            dp = this.listdata.get(i);
            Object[] row ={dp.getDeliveryPersonID(),dp.getUsernameP(),dp.getEmailP(),dp.getGenderP(),dp.getAddressP(),dp.getPhoneNumberP()};
            this.listRow.add(row);
        }
    }
    public int getRowCount() {
        return this.listRow.size();
    }
    public int getColumnCount() {
        return this.columnNames.length;
    }

    public Object getValueAt(int row, int column) {
        return this.listRow.get(row)[column];
    }

    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    public java.lang.Class getColumnClass(int column) {
        return this.listRow.get(0)[column].getClass();
    }

    public Object getObjectAtRow(int row) {
        return this.listdata.get(row);
    }
}
