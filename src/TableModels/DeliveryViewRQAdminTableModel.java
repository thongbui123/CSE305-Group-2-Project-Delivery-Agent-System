/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import models.Courier_Request;

/**
 *
 * @author PC
 */
public class DeliveryViewRQAdminTableModel extends AbstractTableModel {
    private String[] columnNames ={"Code" ,"Username","Email","Description"};
    private  ArrayList<Courier_Request> listdata;
    private ArrayList<Object[]> listRow = new ArrayList<>();
    public DeliveryViewRQAdminTableModel(ArrayList<Courier_Request> listRequest){
        this.listdata = listRequest;
        Courier_Request cr;
        for (int i = 0; i < this.listdata.size(); i++) {
            cr = this.listdata.get(i);
            Object[] row ={cr.getCourierReqestID(),cr.getUsernameR(),cr.getEmailR(),cr.getDesciptionR()};
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
