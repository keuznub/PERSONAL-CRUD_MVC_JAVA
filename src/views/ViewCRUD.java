/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import externals.ChangeFonts;
import com.mysql.cj.MysqlConnection;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Breixo
 */
public class ViewCRUD extends javax.swing.JFrame {
    
    public JComponent[] arrayFieldsNeeded;
    public JComponent[] arrayFields;
    

    
    public ViewCRUD() {
        
        initComponents();
        setLocationRelativeTo(null);
        arrayFieldsNeeded = new JComponent[]{tfClaveShow,tfNombreShow,tfDomicilioShow,tfCelularShow,tfcorreoEShow,tfFechaNacimiento,jcSelector};
        arrayFields = new JComponent[]{tfIdShow,tfClaveShow,tfNombreShow,tfDomicilioShow,tfCelularShow,tfcorreoEShow,tfFechaNacimiento,jcSelector,tfSearchClave};
        ChangeFonts.changeFont(jPanel1, 14);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombreShow = new javax.swing.JLabel();
        tfNombreShow = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        tfClaveShow = new javax.swing.JTextField();
        tfDomicilioShow = new javax.swing.JTextField();
        lblDomicilio = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        tfCelularShow = new javax.swing.JTextField();
        lblCorreoE = new javax.swing.JLabel();
        tfcorreoEShow = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        tfFechaNacimiento = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        jcSelector = new javax.swing.JComboBox<>();
        btnUpgrade = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        tfSearchClave = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        tfIdShow = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(390, 450));

        jPanel1.setMinimumSize(new java.awt.Dimension(330, 50));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 120));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreShow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreShow.setText("Nombre :");
        jPanel1.add(lblNombreShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, -1));
        jPanel1.add(tfNombreShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 175, -1));
        tfNombreShow.getAccessibleContext().setAccessibleName("nombre");

        lblClave.setText("Clave :");
        jPanel1.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, -1));
        jPanel1.add(tfClaveShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 175, -1));
        tfClaveShow.getAccessibleContext().setAccessibleName("clave");

        jPanel1.add(tfDomicilioShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 175, -1));
        tfDomicilioShow.getAccessibleContext().setAccessibleName("domicilio");

        lblDomicilio.setText("Domicilio :");
        jPanel1.add(lblDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 22));

        lblCelular.setText("Celular :");
        jPanel1.add(lblCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 60, -1));
        jPanel1.add(tfCelularShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 175, -1));
        tfCelularShow.getAccessibleContext().setAccessibleName("celular");

        lblCorreoE.setText("Correo electrónico :");
        jPanel1.add(lblCorreoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 160, -1));
        jPanel1.add(tfcorreoEShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 175, -1));
        tfcorreoEShow.getAccessibleContext().setAccessibleName("email");

        lblFechaNacimiento.setText("Fecha Nacimiento :");
        jPanel1.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 160, -1));
        jPanel1.add(tfFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 175, -1));
        tfFechaNacimiento.getAccessibleContext().setAccessibleName("fechaNacimiento");

        lblGenero.setText("Genero :");
        jPanel1.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 70, -1));

        jcSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Hombre", "Mujer", "No-Binario", "Otro" }));
        jPanel1.add(jcSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 175, -1));
        jcSelector.getAccessibleContext().setAccessibleName("genero");

        btnUpgrade.setText("Modificar");
        jPanel1.add(btnUpgrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 330, -1, 30));

        btnDelete.setText("Eliminar");
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 330, -1, 30));

        btnClear.setText("Limpiar");
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 330, -1, 30));

        btnInsert.setText("Añadir");
        jPanel1.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 330, -1, 30));

        tfSearchClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchClaveActionPerformed(evt);
            }
        });
        jPanel1.add(tfSearchClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 90, -1));
        tfSearchClave.getAccessibleContext().setAccessibleName("claveBuscar");

        btnSearch.setText("Buscar");
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 100, -1));

        tfIdShow.setFocusable(false);
        jPanel1.add(tfIdShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 40, -1));
        tfIdShow.getAccessibleContext().setAccessibleName("id");

        lblId.setText("Id :");
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchClaveActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnInsert;
    public javax.swing.JButton btnSearch;
    public javax.swing.JButton btnUpgrade;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox<String> jcSelector;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblCorreoE;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombreShow;
    public javax.swing.JTextField tfCelularShow;
    public javax.swing.JTextField tfClaveShow;
    public javax.swing.JTextField tfDomicilioShow;
    public javax.swing.JTextField tfFechaNacimiento;
    public javax.swing.JTextField tfIdShow;
    public javax.swing.JTextField tfNombreShow;
    public javax.swing.JTextField tfSearchClave;
    public javax.swing.JTextField tfcorreoEShow;
    // End of variables declaration//GEN-END:variables
    
    //Establecer conexion
   


}
