//    WandaPos  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2014 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of WandaPos
//
//    WandaPos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   WandaPos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with WandaPos.  If not, see <http://www.gnu.org/licenses/>.
//    CSV Import Panel added by JDL - February 2013
//    Additonal library required - javacsv


package com.openbravo.pos.imports;

import com.openbravo.basic.BasicException;
import com.openbravo.pos.forms.*;
import com.openbravo.pos.util.AltEncrypter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author JG uniCenta
 */
public class JPanelCSVCleardb extends JPanel implements JPanelView {    
    
    private Connection con;  
    private Statement stmt;
    private String SQL;
    private AppConfig config;

    /**
     *
     * @param oApp
     */
    public JPanelCSVCleardb(AppView oApp) {
        this(oApp.getProperties()); 
 
    }

    /**
     *
     * @param props
     */
    public JPanelCSVCleardb(AppProperties props) {  

        initComponents();
        
        config = new AppConfig(props.getConfigFile());
        config.load();

        jMessageBox.setText("Performing this action, will clear all "
                + "data in the CSVImport table. \n\n"
                + "It is recommended that this is performed before "
                + "running a new import. \n");
  
        }
    
    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.CSVReset");
    }

    /**
     *
     * @return
     */
    @Override
    public JComponent getComponent() {
        return this;
    }
     
    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
 // connect to the database
         String db_user =(config.getProperty("db.user"));
         String db_url = (config.getProperty("db.URL"));
         String db_password = (config.getProperty("db.password"));     
         
         if (db_user != null && db_password != null && db_password.startsWith("crypt:")) {
                // the password is encrypted
                AltEncrypter cypher = new AltEncrypter("cypherkey" + db_user);
                db_password = cypher.decrypt(db_password.substring(6));
         }        
         try{
            con = DriverManager.getConnection(db_url,db_user,db_password);
            stmt = (Statement) con.createStatement();           

            } catch (Exception e) {                
       }    

    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean deactivate() {        try{
            stmt.close();
            con.close();
        }catch (Exception e){}
        
        return (true);
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMessageBox = new javax.swing.JTextPane();
        jEnableButton = new javax.swing.JCheckBox();
        jButtonCleardb = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(420, 240));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        jLabel1.setText(bundle.getString("label.csvresetimport")); // NOI18N

        jMessageBox.setEditable(false);
        jMessageBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jMessageBox);

        jEnableButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jEnableButton.setText(bundle.getString("label.csvenableclear")); // NOI18N
        jEnableButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jEnableButtonStateChanged(evt);
            }
        });
        jEnableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEnableButtonActionPerformed(evt);
            }
        });

        jButtonCleardb.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCleardb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/sale_delete.png"))); // NOI18N
        jButtonCleardb.setText(bundle.getString("label.csvclearlog")); // NOI18N
        jButtonCleardb.setEnabled(false);
        jButtonCleardb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleardbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jEnableButton)
                        .addGap(74, 74, 74)
                        .addComponent(jButtonCleardb)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCleardb)
                    .addComponent(jEnableButton))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jEnableButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jEnableButtonStateChanged
        if (jEnableButton.isSelected()){
            jButtonCleardb.setEnabled(true);
        }else {
            jButtonCleardb.setEnabled(false);
        }
    }//GEN-LAST:event_jEnableButtonStateChanged

    private void jButtonCleardbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleardbActionPerformed
        SQL="DELETE FROM CSVIMPORT";
        try{
        stmt.executeUpdate(SQL);
        }catch (Exception e){
        }
    }//GEN-LAST:event_jButtonCleardbActionPerformed

    private void jEnableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEnableButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEnableButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCleardb;
    private javax.swing.JCheckBox jEnableButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextPane jMessageBox;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    

}
