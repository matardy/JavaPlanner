/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.IIB.Project;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author StevG
 */
public class pnlTabla extends javax.swing.JPanel {
    DefaultTableModel miTabla; 
    GUICalendar guiC; 
    /**
     * Creates new form pnlTabla
     */
    public pnlTabla() {
        initComponents();

        miTabla = new DefaultTableModel();
        miTabla.addColumn("Nomre");
        miTabla.addColumn("Nomre");
        miTabla.addColumn("Nomre");
        miTabla.addColumn("Nomre");
        tblDos.setModel(miTabla);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblPnl = new javax.swing.JScrollPane();
        tblDos = new javax.swing.JTable();

        tblDos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPnl.setViewportView(tblDos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(tblPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(tblPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable tblDos;
    private javax.swing.JScrollPane tblPnl;
    // End of variables declaration//GEN-END:variables
}
