
package frames;

import clases.Asignatura;
import clases.ControladorAsignatura;
import clases.ControladorMetodologia;
import clases.ControladorMetodologiaAsignatura;
import clases.ControladorUnidad;
import clases.ErrorPlanificacion;
import clases.Metodologia;
import clases.MetodologiaAsignatura;
import clases.Unidad;
import clases.imgTabla;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class frmMetodologiaAsignatura extends javax.swing.JFrame {

    private DefaultTableModel modeloAsignatura;
    private DefaultComboBoxModel modeloComboAsignatura;
    private DefaultComboBoxModel modeloComboMetodologia;
    
    
    /**
     * Creates new form frmAsignatura
     */
    public frmMetodologiaAsignatura() {
        initComponents();
        rellenoTabla();
        frmModificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.frmModificar.setLocationRelativeTo(null);
    }
     
    
    //---------------------creacion de combo--------------------------------
    public void rellenoComboAsignatura(){
         cmbAsignatura.removeAll();
         modeloComboAsignatura=new DefaultComboBoxModel();
        modeloComboAsignatura.removeAllElements();
        int seleccion=tblAsignatura.getSelectedRow();
        
        Object[] opcion=new Object[7];
            ArrayList<Asignatura> uni=new ArrayList<>();
        try {
            uni = ControladorAsignatura.Buscar();
        } catch (ErrorPlanificacion ex) {
            Logger.getLogger(frmUnidadAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
            Iterator iterador=uni.iterator();
            
            while(iterador.hasNext()){
                
                opcion[0]=iterador.next();
                
                modeloComboAsignatura.addElement(iterador.next());
                opcion[1]=iterador.next();
                opcion[2]=iterador.next();
                opcion[3]=iterador.next();
                opcion[4]=iterador.next();
                opcion[5]=iterador.next();
                
            }
            
            cmbAsignatura.setModel(modeloComboAsignatura);
            cmbAsignatura.setSelectedItem(tblAsignatura.getValueAt(seleccion, 0));
        
     }  
    
    //---------------------creacion de comboMetodlogia--------------------------------
    public void rellenoComboMetodologia(){
         cmbMetodologia.removeAll();
         modeloComboMetodologia=new DefaultComboBoxModel();
        modeloComboMetodologia.removeAllElements();
       int seleccion=tblAsignatura.getSelectedRow();
        Object[] opcion=new Object[3];
            ArrayList<Metodologia> uni=new ArrayList<>();
        try {
            uni = ControladorMetodologia.Buscar();
        } catch (ErrorPlanificacion ex) {
            Logger.getLogger(frmUnidadAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
            Iterator iterador=uni.iterator();
            
            while(iterador.hasNext()){
                
                opcion[0]=iterador.next();
                
                modeloComboMetodologia.addElement(iterador.next());
                opcion[1]=iterador.next();
                
                
            }
            
            cmbMetodologia.setModel(modeloComboMetodologia);
            cmbMetodologia.setSelectedItem(tblAsignatura.getValueAt(seleccion, 1));
        
     }  
    
    
    
    //---------------------creacion de tabla--------------------------------
    public void rellenoTabla(){
        String[] encabezadosTabla={"Asignatura","Metodologia"};
        modeloAsignatura=new DefaultTableModel();
        tblAsignatura.setDefaultRenderer(Object.class,new imgTabla() );
        tblAsignatura.setRowHeight(30);
        
        
        ArrayList<MetodologiaAsignatura> asignaturas = new ArrayList();
        Object[] fila = new Object[6];
        
        try {
           
        
            asignaturas = ControladorMetodologiaAsignatura.Buscar();
            modeloAsignatura.setColumnIdentifiers(encabezadosTabla);
            Iterator<MetodologiaAsignatura> asig = asignaturas.iterator();
            
            
            
        
            while (asig.hasNext()) {
                    
                    fila[0] = asig.next();
                    fila[1] = asig.next();
                   
                    
                    modeloAsignatura.addRow(fila);
                    
                    tblAsignatura.setModel(modeloAsignatura);
                }
            
        } catch (ErrorPlanificacion ex) {
            Logger.getLogger(frmMetodologiaAsignatura.class.getName()).log(Level.SEVERE, null, ex);
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

        frmModificar = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        lblAgregar1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        cmbAsignatura = new javax.swing.JComboBox<>();
        cmbMetodologia = new javax.swing.JComboBox<>();
        lblAgregar = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsignatura = new javax.swing.JTable();

        frmModificar.setMinimumSize(new java.awt.Dimension(600, 600));
        frmModificar.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Asignatura:");
        frmModificar.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        lblAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit.png"))); // NOI18N
        lblAgregar1.setText("Modificar");
        lblAgregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregar1MouseClicked(evt);
            }
        });
        frmModificar.getContentPane().add(lblAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        jLabel7.setText("Modificar ");
        frmModificar.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel8.setText("Metodología:");
        frmModificar.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        lblCancelar.setText("Cancelar");
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        frmModificar.getContentPane().add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        cmbAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        frmModificar.getContentPane().add(cmbAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 180, -1));

        cmbMetodologia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        frmModificar.getContentPane().add(cmbMetodologia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 180, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        lblAgregar.setText("agregar");
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        lblModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        lblModificar.setText("modificar");
        lblModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarMouseClicked(evt);
            }
        });
        getContentPane().add(lblModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        lblAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N
        lblAtras.setText("atras");
        lblAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(lblAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setText("METODOLOGIA ASIGNATURA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete.png"))); // NOI18N
        lblEliminar.setText("eliminar");
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });
        getContentPane().add(lblEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        tblAsignatura=new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        tblAsignatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Asignatura", "Metodología"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAsignatura.getTableHeader().setResizingAllowed(false);
        tblAsignatura.getTableHeader().setReorderingAllowed(false);
        tblAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsignaturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAsignatura);
        if (tblAsignatura.getColumnModel().getColumnCount() > 0) {
            tblAsignatura.getColumnModel().getColumn(0).setResizable(false);
            tblAsignatura.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 700, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseClicked
       frmMetodologiaAsignaturaAgregar add=new frmMetodologiaAsignaturaAgregar();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAgregarMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        if(tblAsignatura.getSelectedRow()!=-1){
            int seleccion; 
            frmModificar.setVisible(true);
            this.setVisible(false);
            
            seleccion = tblAsignatura.getSelectedRow();
            rellenoComboAsignatura();
            rellenoComboMetodologia();
  
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        MetodologiaAsignatura asig=new MetodologiaAsignatura();
        if(tblAsignatura.getSelectedRow()!=-1){
            try {
                int seleccion;
                seleccion = tblAsignatura.getSelectedRow();
                
                
                String asignatura=tblAsignatura.getValueAt(seleccion, 0).toString();
                String metodologia=tblAsignatura.getValueAt(seleccion, 1).toString();
                
                asig.setIdAsignatura(ControladorAsignatura.obtenerCodigo(asignatura));
                asig.setIdMetodologia(ControladorMetodologia.obtenerCodigo(metodologia));
                
                ControladorMetodologiaAsignatura.Eliminar(asig);
                JOptionPane.showMessageDialog(null, "La eliminacion fue correcta");
                modeloAsignatura.removeRow(tblAsignatura.getSelectedRow());
            } catch (ErrorPlanificacion ex) {
                JOptionPane.showMessageDialog(null, "Elija una fila de la tabla");
            }
        }
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        frmModificar.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void lblAgregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregar1MouseClicked
        

        
            try {
                MetodologiaAsignatura asig=new MetodologiaAsignatura();
                
                asig.setIdAsignatura(ControladorAsignatura.obtenerCodigo(cmbAsignatura.getSelectedItem().toString()));
                asig.setIdMetodologia(ControladorMetodologia.obtenerCodigo(cmbMetodologia.getSelectedItem().toString()));
                
                ControladorMetodologiaAsignatura.Modificar(asig);
                JOptionPane.showMessageDialog(null, "Se modifico exitosamente!!");
            } catch (ErrorPlanificacion ex) {
                Logger.getLogger(frmMetodologiaAsignatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_lblAgregar1MouseClicked

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        frmMenu mn=new frmMenu();
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void tblAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsignaturaMouseClicked
        
    }//GEN-LAST:event_tblAsignaturaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMetodologiaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMetodologiaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMetodologiaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMetodologiaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMetodologiaAsignatura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAsignatura;
    private javax.swing.JComboBox<String> cmbMetodologia;
    private javax.swing.JFrame frmModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblAgregar1;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JTable tblAsignatura;
    // End of variables declaration//GEN-END:variables
}
