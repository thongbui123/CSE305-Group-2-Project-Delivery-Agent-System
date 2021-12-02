/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import models.Account;

/**
 *
 * @author PC
 */
public class AccountTableModel  extends AbstractTableModel{
    private String[] columnNames ={"AccountID" ,"Username","Password","level"};
    private  ArrayList<Account> listdata;
    private ArrayList<Object[]> listRow = new ArrayList<>();
    
    public AccountTableModel(ArrayList<Account> listAccount){
        this.listdata = listAccount;
        Account acc;
        for (int i = 0; i < this.listdata.size(); i++) {
            acc = this.listdata.get(i);
            Object[] row ={acc.getAccountID(),acc.getUsername(),acc.getPassword(),acc.getLevel()};
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
